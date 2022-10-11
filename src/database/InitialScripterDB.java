/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
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

public class InitialScripterDB {
        
        private DatabaseConnector databaseConnector;
        
        private static final String CUSOMTOMER_DETAILS = "customer_details";
        private static final String ROOM_DETAILS = "rooms";
        private static final String FEEDBACK_DETAILS = "feedback";
        private static final String BOOKING_DETAILS = "booking";
        private static final String PAYMENT_DETAILS = "payment";
        private static final String SEQUENCE = "sequence";

        public InitialScripterDB (DatabaseConnector dbc) {
                this.databaseConnector = dbc;
        }
        
        public boolean checkDB(){
                try{
                        Statement st = databaseConnector.getConn().createStatement();
                        ResultSet rs = st.executeQuery("select * from admin");
                        rs.close();
                        st.close();
                        return true;
                } catch(Exception e) {
                        return false;
                }
        }
        
        public void initializerScripts(){
                if(!checkDB()){
                        this.createAdminTable();
                        this.createHotelTable();
                        this.createSchema();
                        this.initializeSchema();
                }
        }
        
        private boolean createAdminTable(){
                try{
                        Statement st = databaseConnector.getConn().createStatement();
                        boolean res = st.execute("create table admin(username varchar(15) primary key, password varchar(45), "
                                + "firstname varchar(40), "
                                + "surname varchar(40), "
                                + "email varchar(25));");
                        
                        st.close();
                        return true;
                } catch (Exception e) {
                        return false;
                }
        }
        
        public boolean insertAdminTable(String username, String password, String firstname, String surname, String email){
                try{
                        Statement st = databaseConnector.getConn().createStatement();
                        boolean res = st.execute("insert into admin values("
                                + " \'"+ username + "\', "
                                + " \'"+ password + "\', "
                                + " \'"+ firstname + "\', "
                                + " \'"+ surname + "\', "
                                + " \'"+ email + "\');");
                        st.close();
                        return true;
                } catch (Exception e) {
                        return false;
                }
        }
        
        private boolean createHotelTable(){
                try{
                        Statement st = databaseConnector.getConn().createStatement();
                        boolean res = st.execute("create table hotel("
                                + "hotelname varchar(15), "
                                + "ownername varchar(45), "
                                + "address varchar(75), "
                                + "phoneno number);");
                        st.close();
                        return true;
                } catch (Exception e) {
                        return false;
                }
        }
        
        public boolean insertHotelTable(String hotelname, String ownername, String address, long phno){
                try{
                        Statement st = databaseConnector.getConn().createStatement();
                        boolean res = st.execute("insert into hotel values("
                                + " \'"+ hotelname + "\', "
                                + " \'"+ ownername + "\', "
                                + " \'"+ address + "\', "
                                + " "+ phno + ");");
                        st.close();
                        return true;
                } catch (Exception e) {
                        return false;
                }
        }
        
        
        private boolean createSchema(){
                try{
                        Statement st = databaseConnector.getConn().createStatement();
                        st.execute("create table " + CUSOMTOMER_DETAILS 
                                +"(cust_id varchar(15), "
                                + "cust_name varchar(45), "
                                + "cust_mobile number, "
                                + "cust_email varchar(25),"
                                + "cust_age number,"
                                + "cust_gender varchar(1) );");
                        st.execute("create table " + ROOM_DETAILS 
                                +"(room_id varchar(15), "
                                + "room_type varchar(25), "
                                + "room_occu varchar(1), "
                                + "room_rate double);");
                        st.execute("create table " + FEEDBACK_DETAILS 
                                +"(feed_id varchar(15), "
                                + "feed_cust_id varchar(15), "
                                + "feed_bill_id varchar(15), "
                                + "feed_content varchar(75), "
                                + "feed_date_time varchar(40));");
                        st.execute("create table " + PAYMENT_DETAILS 
                                +"(bill_id varchar(15), "
                                + "bill_book_id varchar(15), "
                                + "bill_date_time varchar(40), "
                                + "bill_pay_mode varchar(10),"
                                + "bill_pay_amt double);");
                        st.execute("create table " + BOOKING_DETAILS 
                                +"(book_id varchar(15), "
                                + "book_cust_id varchar(15), "
                                + "book_room_id varchar(15), "
                                + "book_date_time varchar(40), "
                                + "book_check_out varchar(40));");
                        st.execute("create table " + SEQUENCE 
                                +"(seq_id varchar(15), "
                                + "seq_no number);");
                        st.close();
                        return true;
                } catch (Exception e) {
                        return false;
                }
        }
        
        private boolean initializeSchema(){
                try{
                        Statement st = databaseConnector.getConn().createStatement();
                        st.execute("insert into "+ SEQUENCE + " values("
                                + " \'cust_id\', "
                                + " "+ 0 + ");");
                        st.execute("insert into "+ SEQUENCE + " values("
                                + " \'room_id\', "
                                + " "+ 0 + ");");
                        st.execute("insert into "+ SEQUENCE + " values("
                                + " \'book_id\', "
                                + " "+ 0 + ");");
                        st.execute("insert into "+ SEQUENCE + " values("
                                + " \'feed_id\', "
                                + " "+ 0 + ");");
                        st.execute("insert into "+ SEQUENCE + " values("
                                + " \'bill_id\', "
                                + " "+ 0 + ");");
                        st.close();
                        return true;
                } catch (Exception e) {
                        return false;
                }
        }
        
        
        
        public void insertAroom(String rid, String type, char occu, double rate){
                try{
                        Statement st = databaseConnector.getConn().createStatement();
                        st.execute("insert into rooms values("
                                + "\'" + rid + "\',"
                                + "\'" + type + "\',"
                                + "\'" + occu + "\',"
                                + "" + rate + ")");
                        st.close();
                } catch(Exception e){
                        
                }
        }
        
        public boolean insertRooms(Set<String> roomTypeName, Map<String, String> roomDetails){
                try{
                        for(String room:roomTypeName){
                                double roomRate = Double.parseDouble(roomDetails.get(room + "-rate"));
                                for(int i = 1; i <= Integer.parseInt(roomDetails.get(room+"-no")); i++){
                                        insertAroom(getID("room"), room, 'E', roomRate);
                                }
                        }
                } catch (Exception e){
                        
                }
                return false;
        }
        
        public Map<String,String> getUserAdmin(){
                try{
                        Map<String, String> map = new HashMap<>();
                        Statement st = databaseConnector.getConn().createStatement();
                        ResultSet rs = st.executeQuery("select * from admin");
                        while(rs.next()){
                                map.put(rs.getString("username"), rs.getString("password"));
                        }
                        rs.close();
                        st.close();
                        return map;
                }catch (Exception e){
                        return new HashMap<>();
                }
        }
        
        private int getNo(String whatTable){
                try{
                        Statement st = databaseConnector.getConn().createStatement();
                        ResultSet rs = st.executeQuery("select * from " + SEQUENCE + " where seq_id=\'" + whatTable+"\'");
                        int x = 0;
                        while(rs.next()){
                                x = rs.getInt("seq_no");
                        }
                        st.execute("update "+ SEQUENCE + " set seq_no="+(x+1)+" where seq_id=\'"+whatTable+"\'");
                        rs.close();
                        st.close();
                        return x;
                }catch(Exception e){
                        return -1;
                }
        }
        
        public String getPaddedNo(int n, int len){
                String outPaddedStr = "" + n;
                int size = len-outPaddedStr.length(); 
                for(int i=0; i<size; i++){
                        outPaddedStr = "0" + outPaddedStr;
                }
                return outPaddedStr;
        }
        
        public String getID(String whatTable){
                return whatTable + "_" + getPaddedNo(getNo(whatTable+"_id"), 10);
        }
        
        public String insertCustomer(CustomerDetailsPOJO customer){
                try{
                        Statement st = databaseConnector.getConn().createStatement();
                        String id = getID("cust");
                        boolean res = st.execute("insert into " + CUSOMTOMER_DETAILS + " values("
                                + "\'" + id + "\',"
                                + "\'" + customer.customer_name + "\',"
                                + "" + customer.customer_mobile + ","
                                + "\'" + customer.customer_email + "\',"
                                + "" + customer.customer_age + ","
                                + "\'" + customer.gender + "\'"
                                        + ")");
                        st.close();
                        return id;
                }catch(Exception e){
                        return null;
                }
        }
        
        public boolean insertBooking(BookingPOJO booking){
                try{
                        Statement st = databaseConnector.getConn().createStatement();
                        boolean res = st.execute("insert into " + BOOKING_DETAILS + " values("
                                + "\'" + getID("book") + "\',"
                                + "\'" + booking.customer.customer_id + "\',"
                                + "\'" + booking.room.room_id + "\',"
                                + "\'" + booking.date_time + "\',"
                                + "\'" + booking.check_out + "\'"
                                        + ")");
                        st.close();
                        return res;
                }catch(Exception e){
                        return false;
                }
        }
        
        public boolean insertFeedback(FeedBackPOJO feedback){
                try{
                        Statement st = databaseConnector.getConn().createStatement();
                        boolean res = st.execute("insert into " + FEEDBACK_DETAILS + " values("
                                + "\'" + getID("feed") + "\',"
                                + "\'" + feedback.customer.customer_id + "\',"
                                + "\'" + feedback.bill_id + "\',"
                                + "\'" + feedback.feedback_ct + "\',"
                                + "\'" + feedback.date_time + "\'"
                                        + ")");
                        st.close();
                        return res;
                } catch(Exception e) {
                        return false;
                }
        }
        
        public String insertPayment(PaymentPOJO payment){
                try{
                        String id = getID("bill");
                        Statement st = databaseConnector.getConn().createStatement();
                        boolean res = st.execute("insert into " + PAYMENT_DETAILS + " values("
                                + "\'" + id + "\',"
                                + "\'" + payment.book.booking_id + "\',"
                                + "\'" + payment.date_time + "\',"
                                + "\'" + payment.payment_mode + "\',"
                                + "" + payment.amount + ")");
                        st.close();
                        return id;
                } catch(Exception e) {
                        return "";
                }
        }
        
        public boolean bookRoom(RoomsPOJO room){
                try{
                        Statement st = databaseConnector.getConn().createStatement();
                        boolean res = st.execute("update " + ROOM_DETAILS + " set room_occu=\'"+'F'
                                +"\' where room_id=\'"+room.room_id + "\'");
                        st.close();
                        return res;
                } catch(Exception e) {
                        return false;
                }
        }
        
        public boolean releaseRoom(RoomsPOJO room){
                try{
                        Statement st = databaseConnector.getConn().createStatement();
                        boolean res = st.execute("update " + ROOM_DETAILS + " set room_occu=\'"+'E'
                                +"\' where room_id=\'"+room.room_id+"\'");
                        st.close();
                        return res;
                } catch(Exception e) {
                        return false;
                }
        }
        
        public boolean updateCheckOutBookingTime(BookingPOJO booking){
                try{
                        Statement st = databaseConnector.getConn().createStatement();
                        boolean res = st.execute("update " + BOOKING_DETAILS + " set book_check_out=\'" + booking.check_out
                                +"\' where book_id=\'"+booking.booking_id + "\'");
                        st.close();
                        return res;
                } catch(Exception e) {
                        return false;
                }
        }
        
        
        
        
}
