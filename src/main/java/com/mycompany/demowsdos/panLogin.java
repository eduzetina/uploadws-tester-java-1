/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demowsdos;

import com.company.wsdl.BasicHttpBinding_IServiceStub;
import com.company.wsdl.Loginresponse;
import com.company.wsdl.Logoutresponse;
import com.company.wsdl.ServiceLocator;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.xml.rpc.ServiceException;

/**
 *
 * @author EduardoZetina
 */
public class panLogin extends javax.swing.JPanel {
    private static final int LOGIN = 1;
    private static final int LOGOUT = 2;
   

    /**
     * Creates new form panLogin
     */
    public panLogin() {
        initComponents();
        ImageIcon icon=new ImageIcon("src\\main\\java\\Miselaneous\\jaguar2.jpg");
        lblBacGro.setIcon(icon);
        this.txtResp.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUser = new javax.swing.JTextField();
        txtApiKey = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pwdPass = new javax.swing.JPasswordField();
        btnLogIn = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResp = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        lblBacGro = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUser.setBackground(new java.awt.Color(102, 102, 102));
        txtUser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtUser.setForeground(new java.awt.Color(228, 239, 22));
        txtUser.setToolTipText("Enter your User Name");
        add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 120, -1));

        txtApiKey.setBackground(new java.awt.Color(102, 102, 102));
        txtApiKey.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtApiKey.setForeground(new java.awt.Color(228, 239, 22));
        add(txtApiKey, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 610, -1));

        jLabel1.setForeground(new java.awt.Color(228, 239, 22));
        jLabel1.setText("User name:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 26, 65, -1));

        jLabel2.setForeground(new java.awt.Color(228, 239, 22));
        jLabel2.setText("Password:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 64, 65, -1));

        jLabel3.setForeground(new java.awt.Color(228, 239, 22));
        jLabel3.setText("New Api Key:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 105, 80, -1));

        pwdPass.setBackground(new java.awt.Color(102, 102, 102));
        pwdPass.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        pwdPass.setForeground(new java.awt.Color(228, 239, 22));
        pwdPass.setToolTipText("Enter you Password");
        add(pwdPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 120, -1));

        btnLogIn.setBackground(new java.awt.Color(0, 0, 0));
        btnLogIn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLogIn.setForeground(new java.awt.Color(228, 239, 22));
        btnLogIn.setText("Login");
        btnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogInActionPerformed(evt);
            }
        });
        add(btnLogIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 70, -1));

        btnLogOut.setBackground(new java.awt.Color(0, 0, 0));
        btnLogOut.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLogOut.setForeground(new java.awt.Color(228, 239, 22));
        btnLogOut.setText("Logout");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });
        add(btnLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 80, -1));

        txtResp.setBackground(new java.awt.Color(102, 102, 102));
        txtResp.setColumns(20);
        txtResp.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtResp.setForeground(new java.awt.Color(228, 239, 22));
        txtResp.setRows(5);
        jScrollPane1.setViewportView(txtResp);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 181, 610, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setForeground(new java.awt.Color(228, 239, 22));
        jLabel4.setText("Response:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 70, -1));

        lblBacGro.setBackground(new java.awt.Color(0, 0, 0));
        lblBacGro.setForeground(new java.awt.Color(228, 239, 22));
        add(lblBacGro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 430));
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogInActionPerformed
        if((this.txtUser.getText().isEmpty())  || (this.pwdPass.getPassword().length==0)){
            JOptionPane.showMessageDialog(this, "Please, enter your User Name and Password", "Missing values", JOptionPane.ERROR_MESSAGE);
        }else{
            int intIntRes = JOptionPane.showConfirmDialog(this, "You will loose your current Api Key, and must use the new generated. Do you want continue?" ,"¡¡¡WARNING!!!",JOptionPane.OK_CANCEL_OPTION);
            if(intIntRes==JOptionPane.OK_OPTION)
                connectToService(LOGIN);
            }
        
    }//GEN-LAST:event_btnLogInActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        if(this.txtApiKey.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please, enter your Api Key.", "Missing values", JOptionPane.ERROR_MESSAGE);
        }else{
            int intIntRes = JOptionPane.showConfirmDialog(this, "You will loose your current Api Key, you'll have generate a new one to access the services. Do you want continue?" , "¡¡¡WARNING!!!", JOptionPane.OK_CANCEL_OPTION);
            if(intIntRes==JOptionPane.OK_OPTION)
                connectToService(LOGOUT);
            }
    }//GEN-LAST:event_btnLogOutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogIn;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBacGro;
    private javax.swing.JPasswordField pwdPass;
    private javax.swing.JTextField txtApiKey;
    private javax.swing.JTextArea txtResp;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

    private void connectToService(int intServ) {
        try {
            try {

                //URL url = new URL("https://opticat1.net/OBWS/Service.svc");
                URL url = new URL("https://opticatnetwork.com/OBAPI_1_2/Service.svc");
                ServiceLocator sl = new ServiceLocator();
                sl.getBasicHttpBinding_IService(url);
                BasicHttpBinding_IServiceStub stub = (BasicHttpBinding_IServiceStub) sl.getBasicHttpBinding_IService(url);

                   switch (intServ)
                   {
                       case 1:
                           //create a new Api Key
                            Loginresponse response;
                            char passArray[] = this.pwdPass.getPassword();
                            String StrPass = new String(passArray);
                           
                            try {

                                response = stub.login(this.txtUser.getText(), StrPass);
                                String status = response.getStatus() + ", " + response.getErrormessage();
                                this.txtResp.setText(this.txtResp.getText() + "Status: " + status + "\n");
                                this.txtApiKey.setText(response.getApikey());
                                int intRes = status.indexOf("Error");
                                if (intRes < 0)
                                    this.txtResp.setText(this.txtResp.getText() + "Please, copy your new Api Key, now you can access the services with it, no need to generate another\n" );
                                //JOptionPane.showMessageDialog(this, "Status: " + status);
                            }
                            catch (RemoteException ex) {
                                Logger.getLogger(mainForm.class.getName()).log(Level.SEVERE, null, ex);
                                this.txtResp.setText(this.txtResp.getText() + "Service error: " + ex.getMessage() + "\n" );
                            }

                            break;
                       case 2:

                            Logoutresponse responseLO;
                            try {
                               responseLO = stub.logout(txtApiKey.getText());

                               String status = responseLO.getStatus() + ", " + responseLO.getErrormessage();
                               this.txtResp.setText(this.txtResp.getText() + "Status: " + status + "\n");
                               int intRes = status.indexOf("Error");
                               if (intRes < 0)
                                   this.txtResp.setText(this.txtResp.getText() + "Api Key disabled, to access the services you will have to generate another one.\n" );
                            }
                            catch (RemoteException ex) {
                                Logger.getLogger(mainForm.class.getName()).log(Level.SEVERE, null, ex);
                                this.txtResp.setText(this.txtResp.getText() + "Service error: " + ex.getMessage() + "\n");
                            }
                           break;
                       default:
                            this.txtResp.setText(this.txtResp.getText() + "Processing ...\n" );
                            break;
                   }            
                }catch (MalformedURLException ex) {
                    Logger.getLogger(mainForm.class.getName()).log(Level.SEVERE, null, ex);
                    this.txtResp.setText(this.txtResp.getText() + "Service error: " + ex.getMessage() +"\n");
                }
            }catch (ServiceException  ex){
                this.txtResp.setText(this.txtResp.getText() + "Service error: " + ex.getMessage() + "\n");
         }
    }
}
