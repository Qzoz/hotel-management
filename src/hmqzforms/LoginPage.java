/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmqzforms;

import hotel.management.HotelManagement;

/**
 *
 * @author Quraishi
 */
public class LoginPage extends javax.swing.JFrame {

        /**
         * Creates new form LoginPage
         */
        HotelManagement hotelManagement;
        
        public LoginPage () {
                initComponents();
                hotelManagement = new HotelManagement();
        }

        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jPanel2 = new javax.swing.JPanel();
                jLabel2 = new javax.swing.JLabel();
                username = new javax.swing.JTextField();
                jPanel3 = new javax.swing.JPanel();
                jLabel3 = new javax.swing.JLabel();
                password = new javax.swing.JPasswordField();
                login = new javax.swing.JButton();
                resister = new javax.swing.JButton();
                errorLabel = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setLocation(new java.awt.Point(50, 50));
                setResizable(false);

                jLabel2.setFont(new java.awt.Font("Tekton Pro Ext", 1, 24)); // NOI18N
                jLabel2.setText("Username");

                username.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(163, Short.MAX_VALUE)
                                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                );
                jPanel2Layout.setVerticalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                .addContainerGap())
                );

                jLabel3.setFont(new java.awt.Font("Tekton Pro Ext", 1, 24)); // NOI18N
                jLabel3.setText("Password");
                jLabel3.setMaximumSize(new java.awt.Dimension(58, 16));
                jLabel3.setPreferredSize(new java.awt.Dimension(58, 16));

                password.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                );
                jPanel3Layout.setVerticalGroup(
                        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                .addContainerGap())
                );

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                login.setFont(new java.awt.Font("Tekton Pro Ext", 1, 25)); // NOI18N
                login.setText("Login");
                login.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                loginActionPerformed(evt);
                        }
                });

                resister.setFont(new java.awt.Font("Tekton Pro Ext", 1, 25)); // NOI18N
                resister.setText("Register");
                resister.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                resisterActionPerformed(evt);
                        }
                });

                errorLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
                errorLabel.setForeground(new java.awt.Color(255, 0, 51));
                errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(resister, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(login, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                        .addComponent(resister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                                .addContainerGap())
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
                try{
                        String usernameString = username.getText();
                        String passwordString = password.getText();
                        
                        if(!usernameString.equals("") && !passwordString.equals("")){
                                if(hotelManagement.isValidAdmin(usernameString, passwordString)){
                                        HotelManagerPage hotelManagerPage = new HotelManagerPage();
                                        hotelManagerPage.setVisible(true);
                                        this.setVisible(false);
                                        this.dispose();
                                }
                                else{
                                        errorLabel.setText("Invalid Credentials");
                                }
                        }
                        else{
                                errorLabel.setText("Credentials Missing");
                        }
                        
                } catch(Exception e){
                        errorLabel.setText("Some Error Occurred");
                }

        }//GEN-LAST:event_loginActionPerformed

        private void resisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resisterActionPerformed
                if(hotelManagement.isRegisterAllowed()){
                        RegistrationPage registrationPage = new RegistrationPage();
                        registrationPage.setVisible(true);
                        this.setVisible(false);
                        this.dispose();
                }
                else{
                        errorLabel.setText("Only One Registration is Allowed");
                }
        }//GEN-LAST:event_resisterActionPerformed

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
                        java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run () {
                                new LoginPage().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel errorLabel;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JButton login;
        private javax.swing.JPasswordField password;
        private javax.swing.JButton resister;
        private javax.swing.JTextField username;
        // End of variables declaration//GEN-END:variables
}