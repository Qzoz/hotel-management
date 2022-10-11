/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import pojos.BookingPOJO;
import pojos.CustomerDetailsPOJO;
import pojos.FeedBackPOJO;
import pojos.PaymentPOJO;
import pojos.RoomsPOJO;

/**
 *
 * @author Quraishi
 */
public class DatabaseQuerier {
        
        private DatabaseConnector databaseConnector;

        private static final String CUSOMTOMER_DETAILS = "customer_details";
        private static final String ROOM_DETAILS = "rooms";
        private static final String FEEDBACK_DETAILS = "feedback";
        private static final String BOOKING_DETAILS = "booking";
        private static final String PAYMENT_DETAILS = "payment";
        private static final String SEQUENCE = "sequence";

        
        public DatabaseQuerier (DatabaseConnector dbc) {
                this.databaseConnector = dbc;
        }
        
        public ArrayList<RoomsPOJO> getAllRooms(){
                try{
                        Statement st = databaseConnector.getConn().createStatement();
                        ResultSet rs = st.executeQuery("select * from " + ROOM_DETAILS +";");
                        ArrayList<RoomsPOJO> rooms = new ArrayList<>();
                        while(rs.next()){
                                RoomsPOJO room = new RoomsPOJO();
                                room.room_id = rs.getString("room_id");
                                room.type = rs.getString("room_type");
                                room.occupancy = rs.getString("room_occu");
                                room.rate = Double.parseDouble(rs.getString("room_rate"));
                                rooms.add(room);
                        }
                        rs.close();
                        st.close();
                        return rooms;
                } catch (Exception e){
                        return new ArrayList<>();
                }
        }
        
        public ArrayList<BookingPOJO> getAllBookings(){
                try{
                        Statement st = databaseConnector.getConn().createStatement();
                        ResultSet rs = st.executeQuery("select bk.book_id, cd.cust_id, bk.book_room_id, "
                                + "bk.book_date_time, bk.book_check_out, cd.cust_name, cd.cust_mobile, cd.cust_email, cd.cust_age, "
                                + "cd.cust_gender, rm.room_type, rm.room_rate, rm.room_occu " +
                                "from "+ BOOKING_DETAILS +" bk, " + CUSOMTOMER_DETAILS + " cd, " + ROOM_DETAILS + " rm "
                                        + " where(bk.book_cust_id = cd.cust_id and rm.room_id=bk.book_room_id)");
                        ArrayList<BookingPOJO> bookings = new ArrayList<>();
                        while(rs.next()){
                                BookingPOJO booking = new BookingPOJO();
                                CustomerDetailsPOJO customer = new CustomerDetailsPOJO();
                                customer.customer_id  = rs.getString(2);
                                customer.customer_name = rs.getString(6);
                                customer.customer_email = rs.getString(8);
                                customer.customer_mobile = rs.getLong(7);
                                customer.customer_age = rs.getInt(9);
                                customer.gender  = rs.getString(10).charAt(0);
                                booking.booking_id = rs.getString(1);
                                booking.room = new RoomsPOJO();
                                booking.room.room_id = rs.getString(3);
                                booking.room.type = rs.getString(11);
                                booking.room.rate = rs.getDouble(12);
                                booking.room.occupancy = rs.getString(13);
                                booking.date_time = rs.getString(4);
                                booking.check_out = rs.getString(5);
                                booking.customer = customer;
                                bookings.add(booking);
                        }
                        
                        rs.close();
                        st.close();
                        return bookings;
                } catch (Exception e){
                        return new ArrayList<>();
                }
        }
        
        public ArrayList<FeedBackPOJO> getAllFeedbacks(){
                try{
                        Statement st = databaseConnector.getConn().createStatement();
                        ResultSet rs = st.executeQuery("select fb.feed_id, cd.cust_name, cd.cust_id,"
                                + " fb.feed_content, fb.feed_date_time" 
                                + " FROM " + FEEDBACK_DETAILS + " fb, " + CUSOMTOMER_DETAILS + " cd" 
                                + " where(fb.feed_cust_id=cd.cust_id)");
                        ArrayList<FeedBackPOJO> feedbacks = new ArrayList<>();
                        while(rs.next()){
                                FeedBackPOJO feedback = new FeedBackPOJO();
                                feedback.customer = new CustomerDetailsPOJO();
                                feedback.feedback_id = rs.getString(1);
                                feedback.customer.customer_id = rs.getString(3);
                                feedback.customer.customer_name = rs.getString(2);
                                feedback.feedback_ct = rs.getString(4);
                                feedback.date_time = rs.getString(5);
                                feedbacks.add(feedback);
                        }
                        
                        
                        rs.close();
                        st.close();
                        return feedbacks;
                } catch (Exception e){
                        return new ArrayList<>();
                }
        }
        
        
        public ArrayList<PaymentPOJO> getAllBillPayment(){
                try{
                        Statement st = databaseConnector.getConn().createStatement();
                        ResultSet rs = st.executeQuery("select p.bill_id, c.cust_id, c.cust_name,"
                                + " p.bill_date_time, p.bill_pay_amt, b.book_room_id, p.bill_pay_mode, b.book_date_time " 
                                + " FROM " + PAYMENT_DETAILS + " p, " + BOOKING_DETAILS + " b, " + CUSOMTOMER_DETAILS + " c " 
                                + " where(p.bill_book_id=b.book_id and b.book_cust_id=c.cust_id)");
                        ArrayList<PaymentPOJO> payments = new ArrayList<>();
                        while(rs.next()){
                                PaymentPOJO payment = new PaymentPOJO();
                                BookingPOJO booking = new BookingPOJO();
                                payment.bill_id = rs.getString(1);
                                
                                payment.book = booking;
                                booking.customer = new CustomerDetailsPOJO();
                                booking.customer.customer_id = rs.getString(2);
                                booking.customer.customer_name = rs.getString(3);
                                booking.date_time = rs.getString(8);
                                
                                payment.date_time = rs.getString(4);
                                payment.amount = rs.getDouble(5);
                                
                                booking.room = new RoomsPOJO();
                                booking.room.room_id = rs.getString(6);
                                
                                payment.payment_mode = rs.getString(7);
                                payments.add(payment);
                        }
                        
                        
                        rs.close();
                        st.close();
                        return payments;
                } catch (Exception e){
                        return new ArrayList<>();
                }
        }
        
        public PaymentPOJO getBillPaymentsFullFor(String cust_id, String bill_id){
                String sqlQuery = "select p.bill_id, p.bill_date_time, p.bill_pay_mode, p.bill_pay_amt, "
                        + " b.book_id, b.book_date_time, b.book_check_out, "
                        + " c.cust_id, c.cust_name, c.cust_mobile, c.cust_email, c.cust_age, c.cust_gender, " 
                        + " r.room_id, r.room_type, r.room_rate " 
                        + " FROM "+ PAYMENT_DETAILS +" p, "+ BOOKING_DETAILS +" b, "+ CUSOMTOMER_DETAILS +" c, "
                        + ROOM_DETAILS +" r " 
                        + " where(p.bill_book_id=b.book_id and b.book_cust_id=c.cust_id and r.room_id=b.book_room_id "
                        + " and c.cust_id=\'" + cust_id + "\' and p.bill_id=\'" + bill_id + "\' )";
                try{    
                        Statement st = databaseConnector.getConn().createStatement();
                        ResultSet rs = st.executeQuery(sqlQuery);
                        PaymentPOJO payment = new PaymentPOJO();
                        while(rs.next()){
                                payment.bill_id = rs.getString(1);
                                payment.date_time = rs.getString(2);
                                payment.payment_mode = rs.getString(3);
                                payment.amount = rs.getDouble(4);
                                
                                RoomsPOJO room = new RoomsPOJO();
                                room.room_id = rs.getString(14);
                                room.type = rs.getString(15);
                                room.rate = rs.getDouble(16);
                                
                                CustomerDetailsPOJO customer = new CustomerDetailsPOJO();
                                customer.customer_id = rs.getString(8);
                                customer.customer_name = rs.getString(9);
                                customer.customer_mobile = rs.getShort(10);
                                customer.customer_email = rs.getString(11);
                                customer.customer_age = rs.getInt(12);
                                customer.gender = rs.getString(13).charAt(0);
                                
                                BookingPOJO booking = new BookingPOJO();
                                booking.booking_id = rs.getString(5);
                                booking.date_time = rs.getString(6);
                                booking.check_out = rs.getString(7);
                                
                                booking.customer = customer;
                                booking.room = room;
                                payment.book = booking;
                              
                        }
                        
                        
                        rs.close();
                        st.close();
                        return payment;
                } catch (Exception e){
                        e.printStackTrace();
                        return new PaymentPOJO();
                }
        }
        
        public FeedBackPOJO getFeedbackByCusomerForBill(String bill_id, String cust_id){
                String sqlQuery = "select * from " + FEEDBACK_DETAILS + " where feed_cust_id=\'"+ cust_id 
                        + "\' and feed_bill_id=\'"+bill_id+"\';";
                try{    
                        Statement st = databaseConnector.getConn().createStatement();
                        ResultSet rs = st.executeQuery(sqlQuery);
                        FeedBackPOJO feedbackPOJO = null;
                        while(rs.next()){
                                feedbackPOJO = new FeedBackPOJO();
                                feedbackPOJO.feedback_id = rs.getString(1);
                                feedbackPOJO.customer = new CustomerDetailsPOJO();
                                feedbackPOJO.customer.customer_id = rs.getString(2);
                                feedbackPOJO.bill_id = rs.getString(3);
                                feedbackPOJO.feedback_ct = rs.getString(4);
                                feedbackPOJO.date_time = rs.getString(5);
                        }
                        
                        rs.close();
                        st.close();
                        
                        return feedbackPOJO;
                } catch (Exception e){
                        e.printStackTrace();
                        return new FeedBackPOJO();
                }
        }
        
}
