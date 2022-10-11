/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmqzforms;

import hotel.management.HotelManagement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import pojos.BookingPOJO;
import pojos.CustomerDetailsPOJO;
import pojos.FeedBackPOJO;
import pojos.PaymentPOJO;
import pojos.RoomsPOJO;

/**
 *
 * @author Quraishi
 */
public class HotelManagerPage extends javax.swing.JFrame {

        /**
         * Creates new form HotelManagerDesk
         */
        
        HotelManagement hotelManagement;
        ArrayList<RoomsPOJO> roomList;
        ArrayList<BookingPOJO> custBookingList;
        ArrayList<BookingPOJO> tmpcustBookingList;
        ArrayList<FeedBackPOJO> feedbackList;
        ArrayList<PaymentPOJO> paymentBillList;
        
        public HotelManagerPage () {
                initComponents();
                hotelManagement = new HotelManagement();
                setCustomerBookingTable();
                setBillingTable();
                setRoomTable();
                setFeedbackTable();
        }
        
        private void addCustomerBookingRow(String cust_id, String name, long phno,int age, String gender,
                                                String room_id, String date_time){
                DefaultTableModel defaultTableModel = (DefaultTableModel) customerTable.getModel();
                defaultTableModel.addRow(new Object[]{cust_id, name, phno,
                        age, gender, room_id, date_time});
        }
        private void remCustomerBookingRow(int x){
                DefaultTableModel defaultTableModel = (DefaultTableModel) customerTable.getModel();
                defaultTableModel.removeRow(x);
        }
//        private void setCustomerBookingTableColWidth(){
//                customerTable.getColumnModel().getColumn(2).setMaxWidth(100);
//                customerTable.getColumnModel().getColumn(2).setMinWidth(100);
//                customerTable.getColumnModel().getColumn(3).setMaxWidth(50);
//                customerTable.getColumnModel().getColumn(3).setMinWidth(50);
//                customerTable.getColumnModel().getColumn(4).setMaxWidth(70);
//                customerTable.getColumnModel().getColumn(4).setMinWidth(70);
//        }
        public void setCustomerBookingTable(){
                remCustomerBookingRow(0);
//                setCustomerBookingTableColWidth();
                custBookingList = hotelManagement.getAllBookings();
                tmpcustBookingList = new ArrayList<>();
                for(BookingPOJO booking: custBookingList){
                        if (booking.check_out.equalsIgnoreCase("null")) {
                                addCustomerBookingRow(booking.customer.customer_id,
                                        booking.customer.customer_name, booking.customer.customer_mobile,
                                        booking.customer.customer_age, booking.customer.getGender(), 
                                        booking.room.room_id, booking.date_time);
                                tmpcustBookingList.add(booking);
                        }
                }
        }
        
        private void addBillingRow(String cust_id, String cust_name, String dated, double amount, 
                                         String mode, String room_id, String checkedOut){
                DefaultTableModel defaultTableModel = (DefaultTableModel) billTable.getModel();
                defaultTableModel.addRow(new Object[]{cust_id, cust_name, dated, amount, mode, room_id, checkedOut});
        }
        private void remBillingRow(int x){
                DefaultTableModel defaultTableModel = (DefaultTableModel) billTable.getModel();
                defaultTableModel.removeRow(x);
        }
//        private void setBillingTableColWidth(){
//                billTable.getColumnModel().getColumn(3).setMinWidth(70);
//        }
        public void setBillingTable(){
                remBillingRow(0);
//                setBillingTableColWidth();
                paymentBillList = hotelManagement.getAllPaymentsBills();
                for(PaymentPOJO payment:paymentBillList){
                        addBillingRow(payment.book.customer.customer_id, payment.book.customer.customer_name, 
                                payment.date_time, payment.amount, payment.payment_mode, 
                                payment.book.room.room_id, payment.book.date_time);
                }
        }
        
        
        private void addRoomRow(String room_id, String type, String status, double rate){
                DefaultTableModel defaultTableModel = (DefaultTableModel) roomTable.getModel();
                defaultTableModel.addRow(new Object[]{room_id, type, status, rate});
        }
        private void remRoomRow(int x){
                DefaultTableModel defaultTableModel = (DefaultTableModel) roomTable.getModel();
                defaultTableModel.removeRow(x);
        }
//        private void setRoomTableColWidth(){
//                roomTable.getColumnModel().getColumn(0).setMinWidth(110);
//                roomTable.getColumnModel().getColumn(1).setMinWidth(150);
//                roomTable.getColumnModel().getColumn(2).setMinWidth(40);
//                roomTable.getColumnModel().getColumn(3).setMinWidth(50);
//                roomTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
//        }
        public void setRoomTable(){
                remRoomRow(0);
//                setRoomTableColWidth();
                roomList = hotelManagement.getRoomList();
                for(RoomsPOJO room: roomList){
                        if(room.occupancy.equals("E")){
                                addRoomRow(room.room_id, room.type, "Empty", room.rate);
                        }
                        else{
                                addRoomRow(room.room_id, room.type, " ", room.rate);
                        }
                }
        }
        
        private void addFeedBackRow(String cust_name, String cust_id, String content, String date_time){
                DefaultTableModel defaultTableModel = (DefaultTableModel) feedTable.getModel();
                defaultTableModel.addRow(new Object[]{cust_name, cust_id, content, date_time});
        }
        private void remFeedBackRow(int x){
                DefaultTableModel defaultTableModel = (DefaultTableModel) feedTable.getModel();
                defaultTableModel.removeRow(x);
        }
        public void setFeedbackTable(){
                remFeedBackRow(0);
                feedbackList = hotelManagement.getAllFeedbacks();
                for(FeedBackPOJO feedback: feedbackList){
                        addFeedBackRow(feedback.customer.customer_name,
                                feedback.customer.customer_id, feedback.feedback_ct, feedback.date_time);
                }
        }

        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                errorLabel = new javax.swing.JLabel();
                jPanel1 = new javax.swing.JPanel();
                jScrollPane2 = new javax.swing.JScrollPane();
                roomTable = new javax.swing.JTable();
                jScrollPane3 = new javax.swing.JScrollPane();
                feedTable = new javax.swing.JTable();
                jPanel3 = new javax.swing.JPanel();
                logoutBtn = new javax.swing.JButton();
                jScrollPane1 = new javax.swing.JScrollPane();
                customerTable = new javax.swing.JTable();
                jScrollPane4 = new javax.swing.JScrollPane();
                billTable = new javax.swing.JTable();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setLocation(new java.awt.Point(50, 50));
                setResizable(false);

                errorLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
                errorLabel.setForeground(new java.awt.Color(255, 51, 51));
                errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

                jScrollPane2.setToolTipText("Room Details");
                jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jScrollPane2MouseClicked(evt);
                        }
                });

                roomTable.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                                {null, null, null, null}
                        },
                        new String [] {
                                "Room ID", "Type", "Status", "Rate"
                        }
                ) {
                        Class[] types = new Class [] {
                                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
                        };
                        boolean[] canEdit = new boolean [] {
                                false, false, false, false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types [columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                        }
                });
                roomTable.setToolTipText("Room Details");
                roomTable.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                roomTableMouseClicked(evt);
                        }
                });
                jScrollPane2.setViewportView(roomTable);

                feedTable.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
                feedTable.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                                {null, null, null, null}
                        },
                        new String [] {
                                "Cust Name", "Cust ID", "Content", "Dated"
                        }
                ) {
                        Class[] types = new Class [] {
                                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                        };
                        boolean[] canEdit = new boolean [] {
                                false, false, false, false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types [columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                        }
                });
                feedTable.setToolTipText("Feedback Details");
                jScrollPane3.setViewportView(feedTable);

                logoutBtn.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
                logoutBtn.setText("Logout");
                logoutBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                logoutBtnActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(logoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                );
                jPanel3Layout.setVerticalGroup(
                        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                );

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                                        .addComponent(jScrollPane3))
                                .addContainerGap())
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                );

                jScrollPane1.setToolTipText("Customer Details");
                jScrollPane1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

                customerTable.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                                {null, null, null, null, null, null, null}
                        },
                        new String [] {
                                "Customer ID", "Name", "Mobile No", "Age", "Gender", "Room", "Check-In"
                        }
                ) {
                        Class[] types = new Class [] {
                                java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                        };
                        boolean[] canEdit = new boolean [] {
                                false, false, false, false, false, false, false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types [columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                        }
                });
                customerTable.setToolTipText("Customer_Details");
                customerTable.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                customerTableMouseClicked(evt);
                        }
                });
                jScrollPane1.setViewportView(customerTable);

                billTable.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
                billTable.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                                {null, null, null, null, null, null, null}
                        },
                        new String [] {
                                "Cust ID", "Cust Name", "Dated", "Amount", "Mode", "Room ID", "Checked-In"
                        }
                ) {
                        Class[] types = new Class [] {
                                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                        };
                        boolean[] canEdit = new boolean [] {
                                false, false, false, false, false, false, false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types [columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                        }
                });
                billTable.setToolTipText("Billing Details");
                billTable.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                billTableMouseClicked(evt);
                        }
                });
                jScrollPane4.setViewportView(billTable);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane4)))
                                        .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void customerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerTableMouseClicked
                BookingPOJO booking = tmpcustBookingList.get(customerTable.getSelectedRow());
                if(booking.check_out.equalsIgnoreCase("null")){
                        CheckOutPage checkOutPage = new CheckOutPage();
                        checkOutPage.initializeForCheckOut(booking);
                        checkOutPage.setVisible(true);
                        this.setVisible(false);
                        this.dispose();
                }
        }//GEN-LAST:event_customerTableMouseClicked

        private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
                // TODO add your handling code here:
        }//GEN-LAST:event_jScrollPane2MouseClicked

        private void roomTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomTableMouseClicked
                RoomsPOJO room = roomList.get(roomTable.getSelectedRow());
                if(room.occupancy.equals("E")){
                        CheckInPage checkInPage = new CheckInPage(room.room_id, room.type, room.rate);
                        checkInPage.setVisible(true);
                        this.setVisible(false);
                        this.dispose();
                }
        }//GEN-LAST:event_roomTableMouseClicked

        private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
                //hotelManagement.logout();
                LandingPage landingPage  = new LandingPage();
                landingPage.setVisible(true);
                this.setVisible(false);
                this.dispose();
        }//GEN-LAST:event_logoutBtnActionPerformed

        private void billTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billTableMouseClicked
                PaymentPOJO payment = paymentBillList.get(billTable.getSelectedRow());
                CheckOutPage checkOutPage = new CheckOutPage();
                checkOutPage.initializeForCheckedOut(payment.book.customer.customer_id, payment.bill_id);
                checkOutPage.setVisible(true);
                this.setVisible(false);
                this.dispose();
        }//GEN-LAST:event_billTableMouseClicked

        
        /**
         * @param args the command line arguments
         */
        public static void main (String args[]) {
                /* Set the Nimbus look and feel */
                //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
                /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
                 */
                try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(HotelManagerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(HotelManagerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(HotelManagerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(HotelManagerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>
                //</editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run () {
                                new HotelManagerPage().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JTable billTable;
        private javax.swing.JTable customerTable;
        private javax.swing.JLabel errorLabel;
        private javax.swing.JTable feedTable;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JScrollPane jScrollPane3;
        private javax.swing.JScrollPane jScrollPane4;
        private javax.swing.JButton logoutBtn;
        private javax.swing.JTable roomTable;
        // End of variables declaration//GEN-END:variables
}
