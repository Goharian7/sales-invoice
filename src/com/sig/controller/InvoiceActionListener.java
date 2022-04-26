/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sig.controller;

import com.sig.model.InvoiceHeader;
import com.sig.view.InvoiceFrame;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.shape.Line;
import javafx.scene.shape.Path;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author gohar
 */
public class InvoiceActionListener implements ActionListener {
    private InvoiceFrame frame;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private Object files;
    
    
    public InvoiceActionListener(InvoiceFrame frame){
        this.frame = frame;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       switch (e.getActionCommand()){
           case "Save file":
               savefile();
           break;
           
           case "Load file":
           {
               try {
                   loadfile();
               } catch (ParseException ex) {
                   Logger.getLogger(InvoiceActionListener.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
               break;

               
           case "Create New Invoice":
               createnewinvoice();
               break;
               
           case "Delete Invoice":
               deleteinvoice();
               break;
               
           case "Save":
               save();
               break;
               
           case "Cancel":
               cancel();
               break;
       }
        
    }

    private void cancel() {
    }

    private void save() {
    }

    private void deleteinvoice() {
    }

    private void createnewinvoice() {
    }

    private void loadfile() throws ParseException {
        JFileChooser fileChooser = new JFileChooser();
        try {
            int result = fileChooser.showOpenDialog(frame);
            if(result == JFileChooser.APPROVE_OPTION){
            File headerfile = fileChooser.getSelectedFile();
                java.nio.file.Path headerPath = Paths.get(headerfile.getAbsolutePath());
                java.util.List<String> headerLines = Files.readAllLines((java.nio.file.Path)headerPath);
                ArrayList<InvoiceHeader> InvoiceHeaders = new ArrayList<>();
            for(String headerLine : headerLines){
                String[] arr = headerLine.split(",");
                String str1 = arr[0];
                String str2 = arr[1];
                String str3 = arr[2];
                int code = Integer.parseInt(str1);
               Date invoiceDate = dateFormat.parse(str2);
               InvoiceHeader header = new InvoiceHeader(code, str3, invoiceDate);
               InvoiceHeaders.add(header);
                          }
           }
            ArrayList<InvoiceHeader> invoiceheaders = null;
            frame.setInvoicesArray(invoiceheaders);
            result = fileChooser.showOpenDialog(frame);
                        if(result == JFileChooser.APPROVE_OPTION){
                            File lineFile = fileChooser.getSelectedFile();
                            java.nio.file.Path linePath = Paths.get(lineFile.getAbsolutePath());
                            java.util.List<String> lineLines = Files.readAllLines((java.nio.file.Path) linePath);
                            ArrayList<InvoiceLine> invoiceLines = new ArrayList<>();
                            for (String lineLine : lineLines){
                                String[] arr = lineLine.split(",");
                                 String str1 = arr[0];
                                 String str2 = arr[1];
                                 String str3 = arr[2];
                                 String str4 = arr[3];
                int invcode = Integer.parseInt(str1);
                double price = Double.parseDouble(str3);
                int count = Integer.parseInt(str4);
                InvoiceHeader inv = frame.getInvObject(invcode);
                InvoiceLine line = new InvoiceLine(str4, price, count, inv);
                                com.sig.model.InvoiceLine Line = null;
                inv.getLines().add(Line);
                
                
                 }
                          
                                                }
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
         
        } catch (ParseException ex){
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
  
        }
        
    }

    private void savefile() {
    }

    private static class InvoiceLine {

        public InvoiceLine() {
        }

        private InvoiceLine(String str4, double price, int count, InvoiceHeader inv) {
        }
    }
    
    
    
}
