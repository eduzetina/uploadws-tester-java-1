/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demowsdos;

import Models.ProductLine;
import com.company.wsdl.BasicHttpBinding_IServiceStub;
import com.company.wsdl.Filestatusrequest;
import com.company.wsdl.Filestatusresponse;
import com.company.wsdl.FilestatusresponseImportmessage;
import com.company.wsdl.Getfiletypesresponse;
import com.company.wsdl.Getproductfilesresponse;
import com.company.wsdl.GetproductfilesresponseProductline;
import com.company.wsdl.GetproductfilesresponseProductlineProductfile;
import com.company.wsdl.Saveuploadrequest;
import com.company.wsdl.Saveuploadresponse;
import com.company.wsdl.ServiceLocator;
import java.io.BufferedInputStream;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.swing.*;
import javax.xml.rpc.ServiceException;
import org.apache.axis.client.Stub;
//import javax.xml.rpc.ServiceFactory;

/**
 *
 * @author EduardoZetina
 */
public class panUploadFiles extends javax.swing.JPanel {
    private static final int GETFILETYPES = 1;
    private static final int UPLOADCHUNKS = 2;
    private static final int GETSTATUS = 3;
    //global vaiables
    File selectFile;
    List<ProductLine> lstProducts = new ArrayList<>();
    boolean lastChunk = false;

    //String[] strProLines = new String[100];
    //String[] strProFiles = new String[100];
    
    /**
     * Creates new form panUploadFiles
     */
    public panUploadFiles() {
        initComponents();
        //lstFilTyp.setModel(model);
        this.btnChoFile.setEnabled(false);
        this.btnGetStatus.setEnabled(false);
        this.txtFile.setEditable(false);
        this.btnSave.setEnabled(false);
        ImageIcon icon=new ImageIcon("src\\main\\java\\Miselaneous\\jaguar2.jpg");
        lblBacGro.setIcon(icon);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtApiKey = new javax.swing.JTextField();
        btnSenGetFil = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResp = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txtFile = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbFilTyp = new javax.swing.JComboBox<>();
        btnChoFile = new javax.swing.JButton();
        btnGetStatus = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbLines = new javax.swing.JComboBox<>();
        cmbProduct = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCheAlg = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCheHex = new javax.swing.JTextField();
        lblBacGro = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(228, 239, 22));
        jLabel1.setText("ApiKey:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 0, 50, -1));

        txtApiKey.setBackground(new java.awt.Color(102, 102, 102));
        txtApiKey.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtApiKey.setForeground(new java.awt.Color(228, 239, 22));
        txtApiKey.setToolTipText("Enter your Api Key");
        add(txtApiKey, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 16, 280, -1));

        btnSenGetFil.setBackground(new java.awt.Color(0, 0, 0));
        btnSenGetFil.setForeground(new java.awt.Color(228, 239, 22));
        btnSenGetFil.setText("Get Files Type");
        btnSenGetFil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSenGetFil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSenGetFilActionPerformed(evt);
            }
        });
        add(btnSenGetFil, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 120, 20));

        txtResp.setBackground(new java.awt.Color(102, 102, 102));
        txtResp.setColumns(20);
        txtResp.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtResp.setForeground(new java.awt.Color(228, 239, 22));
        txtResp.setRows(5);
        jScrollPane1.setViewportView(txtResp);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 600, 190));

        jLabel4.setForeground(new java.awt.Color(228, 239, 22));
        jLabel4.setText("Response:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txtFile.setBackground(new java.awt.Color(102, 102, 102));
        txtFile.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtFile.setForeground(new java.awt.Color(228, 239, 22));
        add(txtFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 277, 488, -1));

        jLabel2.setForeground(new java.awt.Color(228, 239, 22));
        jLabel2.setText("File Type:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 60, -1));

        cmbFilTyp.setBackground(new java.awt.Color(102, 102, 102));
        cmbFilTyp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmbFilTyp.setForeground(new java.awt.Color(255, 255, 255));
        cmbFilTyp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbFilTyp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFilTypActionPerformed(evt);
            }
        });
        add(cmbFilTyp, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 160, -1));

        btnChoFile.setBackground(new java.awt.Color(0, 0, 0));
        btnChoFile.setForeground(new java.awt.Color(228, 239, 22));
        btnChoFile.setText("File ...");
        btnChoFile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChoFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoFileActionPerformed(evt);
            }
        });
        add(btnChoFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 276, 69, -1));

        btnGetStatus.setBackground(new java.awt.Color(0, 0, 0));
        btnGetStatus.setForeground(new java.awt.Color(228, 239, 22));
        btnGetStatus.setText("Get Status");
        btnGetStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGetStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetStatusActionPerformed(evt);
            }
        });
        add(btnGetStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 90, -1));

        jLabel5.setForeground(new java.awt.Color(228, 239, 22));
        jLabel5.setText("Product  lines:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 80, -1));

        jLabel6.setForeground(new java.awt.Color(228, 239, 22));
        jLabel6.setText("Product files:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 71, -1));

        cmbLines.setBackground(new java.awt.Color(102, 102, 102));
        cmbLines.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmbLines.setForeground(new java.awt.Color(255, 255, 255));
        cmbLines.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbLines.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLinesActionPerformed(evt);
            }
        });
        add(cmbLines, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 310, 180, -1));

        cmbProduct.setBackground(new java.awt.Color(102, 102, 102));
        cmbProduct.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmbProduct.setForeground(new java.awt.Color(255, 255, 255));
        cmbProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(cmbProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 202, -1));

        btnSave.setBackground(new java.awt.Color(0, 0, 0));
        btnSave.setForeground(new java.awt.Color(228, 239, 22));
        btnSave.setText("Upload file ..");
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, -1, -1));

        jLabel3.setForeground(new java.awt.Color(228, 239, 22));
        jLabel3.setText("Checksum algo:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 90, -1));

        txtCheAlg.setBackground(new java.awt.Color(102, 102, 102));
        txtCheAlg.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtCheAlg.setForeground(new java.awt.Color(228, 239, 22));
        add(txtCheAlg, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 340, 80, -1));

        jLabel7.setForeground(new java.awt.Color(228, 239, 22));
        jLabel7.setText("Checksum Hex:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 100, -1));

        txtCheHex.setBackground(new java.awt.Color(102, 102, 102));
        txtCheHex.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtCheHex.setForeground(new java.awt.Color(228, 239, 22));
        add(txtCheHex, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 348, -1));
        add(lblBacGro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 420));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSenGetFilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSenGetFilActionPerformed
        if(txtApiKey.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "The Api Key is missing");        
        }else{
           this.txtResp.setText("Getting types... \n" );
            try {
                connectToService(GETFILETYPES);
            } catch (IOException ex) {
                Logger.getLogger(panUploadFiles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSenGetFilActionPerformed

    private void btnChoFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoFileActionPerformed
        JFileChooser choFiler = new JFileChooser();
        int selection=choFiler.showOpenDialog(this);
        if(selection==choFiler.APPROVE_OPTION){
            try {
                selectFile= choFiler.getSelectedFile();
                this.txtFile.setText(selectFile.getAbsolutePath());
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                try {
                    if(selectFile.length() < 2147483647){
                        String hex = checksum(selectFile.getAbsolutePath().toString(), md);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(panUploadFiles.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.btnSave.setEnabled(true);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(panUploadFiles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            this.txtFile.setText("");
            this.btnSave.setEnabled(false);

        }
    }//GEN-LAST:event_btnChoFileActionPerformed

    private void cmbFilTypActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFilTypActionPerformed
        if(this.cmbFilTyp.getSelectedIndex() >0)
        {
            this.btnChoFile.setEnabled(true);
        }
        else
        {
            this.btnChoFile.setEnabled(false);
        } 
    }//GEN-LAST:event_cmbFilTypActionPerformed

    private void btnGetStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetStatusActionPerformed
        if (selectFile.isFile())
        {
            try {
                this.txtResp.setText(this.txtResp.getText() + "Getting status file, please wait ... \n" );
                connectToService(GETSTATUS);
                btnGetStatus.setEnabled(true);
            } catch (IOException ex) {
                Logger.getLogger(panUploadFiles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnGetStatusActionPerformed

    private void cmbLinesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLinesActionPerformed
        cmbProduct.removeAllItems();
        cmbProduct.addItem("-- Select product file --");
        int intCount =0;
        for(ProductLine prod: lstProducts){        
            if (prod.getstrLine()==cmbLines.getSelectedItem())
            {
                cmbProduct.addItem(prod.getstrFile());
                if (intCount==0)
                    cmbFilTyp.setSelectedItem(prod.getstrFileTyp());
                intCount++;
            }
        } 
    }//GEN-LAST:event_cmbLinesActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (selectFile.isFile())
        {
            this.txtResp.setText(this.txtResp.getText() + "Uploading file (UploadFileChunk), please wait ... \n" );
            //size for 4MB  
            int bufferSize = 4194304;
            byte[]  byteArray = new byte[bufferSize];
            //set current position
            long intCurrPos = 0;
            //set position after read
            long intPos =0;
            lastChunk =  false;
            try
            {        
                InputStream fr = new BufferedInputStream(new FileInputStream(selectFile));
                //get file size  
                //int intLen = fr.available();
                long intLen = selectFile.length();
                while (intCurrPos<intLen) {
                    if (intLen<=bufferSize){
                        bufferSize = (int)intLen;
                        byteArray = new byte[bufferSize];
                        lastChunk =  true;
                    }
                    
                    //int intInp = fr.read();
                    intPos = fr.read(byteArray, 0, byteArray.length);
                    if (intPos<0)
                        break;
                                       
                    uploadFile(byteArray, intCurrPos);       
                    long newLen = intLen - (intPos + intCurrPos);
                    if (newLen < bufferSize){
                        bufferSize = (int)newLen; 
                        byteArray = new byte[bufferSize];
                        lastChunk =  true;
                    }
                    intCurrPos +=  intPos;
                }
                fr.close();
                // JOptionPane.showMessageDialog(this, "el numero de vueltas que dio es: " + lnCount);
             } catch(IOException ex){
                txtResp.setText(this.txtResp.getText() + ex.getMessage() + ".\n");
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

private void connectToService (int intServ) throws IOException{
    try {
        try {
            URL url = new URL("https://opticat1.net/OBWS/Service.svc");
            ServiceLocator sl = new ServiceLocator();
            sl.getBasicHttpBinding_IService(url);
            BasicHttpBinding_IServiceStub stub = (BasicHttpBinding_IServiceStub) sl.getBasicHttpBinding_IService(url);
            
               switch (intServ)
               {
                   case 1:
                        Getfiletypesresponse response;
                        try {
                            response = stub.getFileTypes(this.txtApiKey.getText());
                            String status = response.getStatus() + ", " + response.getErrormessage();
                            this.txtResp.setText(this.txtResp.getText() + "Status: " + status + "\n");
                            //JOptionPane.showMessageDialog(this, "Status: " + status);
                            String[] strFilTyp = response.getFiletypes();
                            cmbFilTyp.removeAllItems();
                            cmbFilTyp.addItem("-- Select Type --");
                            for (String strType : strFilTyp) {
                                //fill cmbFilTyp
                                cmbFilTyp.addItem(strType);
                            }                   
                            //managing controls
                            txtApiKey.setEditable(false);
                            btnSenGetFil.setEnabled(false);
                            btnChoFile.setEnabled(true);
                        }
                        catch (RemoteException ex) {
                            Logger.getLogger(mainForm.class.getName()).log(Level.SEVERE, null, ex);
                            this.txtResp.setText(this.txtResp.getText() + "Service error: " + ex.getMessage() + "\n" );
                        }
                        //fill lines
                       this.txtResp.setText(this.txtResp.getText() + "Gettin Lines ...\n");
                       Getproductfilesresponse responsePL;
                       try {
                            responsePL = stub.getProductFiles(this.txtApiKey.getText());
                            String status = responsePL.getStatus() + ", " + responsePL.getErrormessage();
                            this.txtResp.setText(this.txtResp.getText() + "Status: " + status + "\n");
                            cmbLines.removeAllItems();
                            cmbLines.addItem("-- Select Line --"); 
                            cmbProduct.removeAllItems();
                            cmbProduct.addItem("-- Select product file --");
                           // JOptionPane.showMessageDialog(this, strName);
                            for (GetproductfilesresponseProductline strLine : responsePL.getProductlines()) {
                                //fill cmbLines
                                cmbLines.addItem(strLine.getName());
                                //strProLines[intLine]  =strLine.getName();
                                for(GetproductfilesresponseProductlineProductfile strProd: strLine.getProductfiles()){
                                    //fill cmbProduct
                                    //strProFiles[intFile][2] = [strLine.getName()],[strProd.getValue()];
                                    ProductLine product = new ProductLine(strLine.getName(), strProd.getValue(), strProd.getFiletype());
                                    lstProducts.add(product);
                                    cmbProduct.addItem(strProd.getValue());
                                    //intFile++;
                                }                                
                            }       
                            this.txtResp.setText(this.txtResp.getText() + "To upload a file:\n");
                            this.txtResp.setText(this.txtResp.getText() + "  * Search and select the desired file\n");
                            this.txtResp.setText(this.txtResp.getText() + "  * Select the line and file of product\n");
                            this.txtResp.setText(this.txtResp.getText() + "  * Click on the \"Upload File\" button \n");
                            //managing controls
                            txtApiKey.setEditable(false);
                            btnSenGetFil.setEnabled(false);
                            btnChoFile.setEnabled(true);
                        }catch (RemoteException ex) {
                            Logger.getLogger(mainForm.class.getName()).log(Level.SEVERE, null, ex);
                            this.txtResp.setText(this.txtResp.getText() + "Service error: " + ex.getMessage() + "\n");
                        }
                        break;
                   case 2:
                        //JOptionPane.showMessageDialog(this, this.cmbFilTyp.getSelectedItem().toString() + " ," + selectFile.getAbsoluteFile().toString());                  
                       // JOptionPane.showMessageDialog(this, selectFile.getAbsoluteFile().toString() + " ," + selectFile.getName().toString());
                       if (! this.txtFile.getText().isEmpty()) 
                       {
                        Saveuploadresponse responseUp;
                        try {
                            Saveuploadrequest params = new  Saveuploadrequest();
                            params.setApikey(this.txtApiKey.getText());
                            params.setFiletype(this.cmbFilTyp.getSelectedItem().toString());
                            params.setFilename(selectFile.getName().toString());
                            params.setProductfile(this.cmbProduct.getSelectedItem().toString());
                            params.setProductline(this.cmbLines.getSelectedItem().toString());
                            if (txtCheAlg.getText().isEmpty())
                                params.setChecksumalgo("");
                            else
                                params.setChecksumalgo(txtCheAlg.getText());
                           
                            if (txtCheHex.getText().isEmpty())
                                    params.setChecksumhex("");
                            else
                                params.setChecksumhex(txtCheHex.getText());
                            
                            responseUp = stub.saveUpload(params);
                            String status = responseUp.getStatus() + ", " + responseUp.getErrormessage();
                            this.txtResp.setText(this.txtResp.getText() + "Status: " + status + "\n");
                            if(status.contains("Ok"))
                                btnGetStatus.setEnabled(true);

                        }
                        catch (RemoteException ex) {
                            Logger.getLogger(mainForm.class.getName()).log(Level.SEVERE, null, ex);
                            this.txtResp.setText(this.txtResp.getText() + "Service error: " + ex.getMessage() + "\n");
                        }
                       }
                       break;
                   case 3:
                       if (! this.txtFile.getText().isEmpty()) 
                       {
                        Filestatusresponse responseSatatus;
                        //FilestatusresponseImportmessage responseMessage;
                        try {
                            Filestatusrequest params = new  Filestatusrequest();
                            params.setApikey(this.txtApiKey.getText());
                            params.setProductfile(this.cmbProduct.getSelectedItem().toString());
                            params.setProductline(this.cmbLines.getSelectedItem().toString());

                            responseSatatus = stub.getFileImportStatus(params);                          
                            String status = responseSatatus.getStatus() + ", " + responseSatatus.getErrormessage();
                            if(status.indexOf("Error")>=0)
                                this.txtResp.setText(this.txtResp.getText() + "Status: " + status + "\n");
                            else if(status.indexOf("Ok")>=0){
                                this.txtResp.setText(this.txtResp.getText() + "File uploaded successfully, please check the status tab\n");
                               
                            panFileStatus panStatus = new panFileStatus();
                            panStatus.fillStatus(responseSatatus);
                           }
                        }
                        catch (RemoteException ex) {
                            Logger.getLogger(mainForm.class.getName()).log(Level.SEVERE, null, ex);
                            this.txtResp.setText(this.txtResp.getText() + "Service error: " + ex.getMessage() + "\n");
                        }
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
 
private void uploadFile (byte[]  byteArray, long intPos)
{
    try{   
        try{
            ServiceLocator sl = new ServiceLocator();
            URL url = new URL("https://opticat1.net/OBWS/Service.svc");
            sl.getBasicHttpBinding_IService(url);
            BasicHttpBinding_IServiceStub stub = (BasicHttpBinding_IServiceStub) sl.getBasicHttpBinding_IService(url);
            if (! this.txtFile.getText().isEmpty()) 
            {
                try {
                    String strResp = stub.uploadFileChunk(this.txtApiKey.getText(), selectFile.getName().toString(),  byteArray, intPos);
                    if (strResp.indexOf("Error") <0){
                        if(lastChunk){
                            try {
                                connectToService(UPLOADCHUNKS);
                            } catch (IOException ex) {
                                Logger.getLogger(panUploadFiles.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            this.txtResp.setText(this.txtResp.getText() + "UploadFile: File " + selectFile.getName().toString() + " was uploaded. \n");
                        }
                    }
                }
                catch (RemoteException ex) {
                    Logger.getLogger(mainForm.class.getName()).log(Level.SEVERE, null, ex);
                    this.txtResp.setText("Service error: " + ex.getMessage() );
                }
            }
        }
            catch (MalformedURLException ex) {
                Logger.getLogger(mainForm.class.getName()).log(Level.SEVERE, null, ex);
                this.txtResp.setText("Service error: " + ex.getMessage() );
            }
        }catch (ServiceException  ex){
            this.txtResp.setText("Service error: " + ex.getMessage() );
    }
}

private  String checksum(final String filepath, MessageDigest md) throws IOException {

      // file hashing with DigestInputStream
      try (DigestInputStream dis = new DigestInputStream(new FileInputStream(filepath), md)) {
          while (dis.read() != -1)
			 {
				; //empty loop to clear the data
			}
          md = dis.getMessageDigest();
      }
      // bytes to hex
      final StringBuilder result = new StringBuilder();
      for (final byte b : md.digest()) {
          result.append(String.format("%02x", b));
      }
      this.txtResp.setText(this.txtResp.getText() + "Getting checksum hex \n");
      this.txtResp.setText(this.txtResp.getText() + "Hex value: " + result.toString() + " \n");
      this.txtResp.setText(this.txtResp.getText() + "Please, copy and paste it into the checksum hex field, if you want to use the checksum algorithm \n");
      return result.toString();
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChoFile;
    private javax.swing.JButton btnGetStatus;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSenGetFil;
    private javax.swing.JComboBox<String> cmbFilTyp;
    private javax.swing.JComboBox<String> cmbLines;
    private javax.swing.JComboBox<String> cmbProduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBacGro;
    private javax.swing.JTextField txtApiKey;
    private javax.swing.JTextField txtCheAlg;
    private javax.swing.JTextField txtCheHex;
    private javax.swing.JTextField txtFile;
    private javax.swing.JTextArea txtResp;
    // End of variables declaration//GEN-END:variables
}
