/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demowsdos;
import java.net.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author EduardoZetina
 */
public class panIntro extends javax.swing.JPanel {

    /**
     * Creates new form panIntro
     */
    public panIntro() {
        initComponents();
        textIntro();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtIntro = new javax.swing.JTextArea();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(".");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 310, 100));

        txtIntro.setColumns(20);
        txtIntro.setRows(5);
        jScrollPane1.setViewportView(txtIntro);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 660, 170));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtIntro;
    // End of variables declaration//GEN-END:variables

    private void textIntro() {
        try{

          // String strRuta= System.getProperty("user.dir");
          // JOptionPane.showMessageDialog(this, strRuta);
          ImageIcon icon=new ImageIcon("src\\main\\java\\Miselaneous\\optiCat.png");
          jLabel2.setIcon(icon);
         
          this.txtIntro.setText("UploadWs-Tester-Java (ver:1.1): This app aims to consume Opticat webservices\n");
          this.txtIntro.setText(this.txtIntro.getText() + "using a Java client\n\n");
          this.txtIntro.setText(this.txtIntro.getText() + "Functionallity:\n\n");
          this.txtIntro.setText(this.txtIntro.getText() + "* Get type Files using your Api Key\n");
          this.txtIntro.setText(this.txtIntro.getText() + "* Upload a file for a Product and Product Line\n\n");
          this.txtIntro.setText(this.txtIntro.getText() + "Note: For both is necessary enter your Api Key\n");
          
          this.txtIntro.setEditable(false);         
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Ocurrio el siguiente error: " + ex.getMessage());
        }
        

    }
}