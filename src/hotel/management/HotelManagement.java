/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management;

import database.DatabaseConnector;
import database.DatabaseQuerier;
import database.InitialScripterDB;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import pojos.BookingPOJO;
import pojos.CustomerDetailsPOJO;
import pojos.FeedBackPOJO;
import pojos.PaymentPOJO;
import pojos.RoomsPOJO;

/**
 *
 * @author Quraishi
 */
public class HotelManagement {
        
        private InitialScripterDB initialScripterDB;
        private DatabaseQuerier databaseQuerier;
        private DatabaseConnector databaseConnector;

        public HotelManagement () {
                databaseConnector = new DatabaseConnector();
                initialScripterDB = new InitialScripterDB(databaseConnector);
                databaseQuerier = new DatabaseQuerier(databaseConnector);
        }
        
        private String getEncryptedHashed(String text){
                try { 
                        MessageDigest md = MessageDigest.getInstance("SHA-1"); 
                        byte[] messageDigest = md.digest(text.getBytes()); 
                        BigInteger no = new BigInteger(1, messageDigest); 
                        String hashtext = no.toString(16); 
                        while (hashtext.length() < 32) { 
                            hashtext = "0" + hashtext; 
                        } 
                        return hashtext; 
                } catch (Exception e) { 
                        return text; 
                } 
        }

        public boolean insertCredentialsforRegister(String username, String password,
                String firstname, String surname, String email, String hotelname, String ownername,
                String address, long phno, Set<String> rooType, Map<String, String> roomDetails) {
                try{
                        initialScripterDB.insertAdminTable(username, getEncryptedHashed(password), firstname, surname, email);
                        initialScripterDB.insertHotelTable(hotelname, ownername, address, phno);
                        initialScripterDB.insertRooms(rooType, roomDetails);
                        return true;
                } catch (Exception e){
                        return false;
                }
        }
        
        public boolean isDatabaseCreated(){
                if(!initialScripterDB.checkDB()){
                        initialScripterDB.initializerScripts();
                        return false;
                }
                return true;
        }
        
        public boolean isRegisterAllowed(){
                if(initialScripterDB.getUserAdmin().size() >= 1){
                        return false;
                }
                return true;
        }
        
        public boolean isValidAdmin(String username, String password){
                Map<String,String> map = initialScripterDB.getUserAdmin();
                if(map.get(username).equals(getEncryptedHashed(password))){
                        return true;
                }
                return false;
        }
        
        public ArrayList<RoomsPOJO> getRoomList(){
                try{
                        return databaseQuerier.getAllRooms();
                } catch(Exception e){
                        return new ArrayList<>();
                }
        }
        
        public String getReadableDateTime(){
                LocalDateTime ldt = LocalDateTime.now();
                return ldt.getDayOfMonth() + "-" + ldt.getMonth().name().substring(0,3) + "-" + ldt.getYear()%100
                        + " " + initialScripterDB.getPaddedNo(ldt.getHour(), 2) + ":" 
                        + initialScripterDB.getPaddedNo(ldt.getMinute(), 2);
        }
        
        public void bookARoomForCustomer(String c_name, String c_email, long c_mob, 
                int c_age, char gen, String room_id){
                CustomerDetailsPOJO customer = new CustomerDetailsPOJO();
                customer.customer_name = c_name;
                customer.customer_email = c_email;
                customer.customer_mobile = c_mob;
                customer.customer_age = c_age;
                customer.gender = gen;
                customer.customer_id = initialScripterDB.insertCustomer(customer);
                BookingPOJO bookingPOJO = new BookingPOJO();
                RoomsPOJO room = new RoomsPOJO();
                room.room_id = room_id;
                bookingPOJO.customer = customer;
                bookingPOJO.room = room;
                bookingPOJO.date_time = getReadableDateTime();
                initialScripterDB.insertBooking(bookingPOJO);
                initialScripterDB.bookRoom(room);
        }
        
        public ArrayList<BookingPOJO> getAllBookings(){
                return databaseQuerier.getAllBookings();
        }
        
        public void checkOutForACustomer(PaymentPOJO payment, FeedBackPOJO feedback){
                payment.date_time = getReadableDateTime();
                String id = initialScripterDB.insertPayment(payment);
                initialScripterDB.releaseRoom(payment.book.room);
                initialScripterDB.updateCheckOutBookingTime(payment.book);
                if(!feedback.feedback_ct.equalsIgnoreCase("")){
                        feedback.bill_id = id;
                        feedback.date_time = getReadableDateTime();
                        initialScripterDB.insertFeedback(feedback);
                }
        }
        
        public ArrayList<FeedBackPOJO> getAllFeedbacks(){
                return databaseQuerier.getAllFeedbacks();
        }
        
        public ArrayList<PaymentPOJO> getAllPaymentsBills(){
                return databaseQuerier.getAllBillPayment();
        }
        
        public PaymentPOJO getPaymentForBillCust(String cust_id, String bill_id){
                return databaseQuerier.getBillPaymentsFullFor(cust_id, bill_id);
        }
        
        public FeedBackPOJO getFeedbackForBillCust(String bill_id, String cust_id){
                return databaseQuerier.getFeedbackByCusomerForBill(bill_id, cust_id);
        }
        
        
        public void logout(){
                databaseQuerier = null;
                initialScripterDB = null;
                databaseConnector.terminateConnection();
                
        }
        
//        public static void main (String[] args) {
//                DatabaseQuerier dq= new DatabaseQuerier(new DatabaseConnector());
//                dq.getFeedbackByCusomerForBill("bill_0000000000", "cust_0000000001");
//        }
        
}
