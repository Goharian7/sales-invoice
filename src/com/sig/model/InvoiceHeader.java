/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sig.model;

import java.util.ArrayList;
import java.util.Date;
import javafx.scene.shape.Line;

/**
 *
 * @author gohar
 */
public class InvoiceHeader {
    private int num;
    private String customer;
    private Date invdate;
    private ArrayList<InvoiceLine> lines;
    

    public InvoiceHeader() {
    }

    public InvoiceHeader(int num, String customer, Date invdate) {
        this.num = num;
        this.customer = customer;
        this.invdate = invdate;
        this.lines = new ArrayList<>();
        
    }

    public Date getInvdate() {
        return invdate;
    }

    public void setInvdate(Date invdate) {
        this.invdate = invdate;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public ArrayList<InvoiceLine> getLines() {
        if (lines == null){
            lines = new ArrayList<>();
        }
        return lines;
    }

    public void setLines(ArrayList<InvoiceLine> lines) {
        this.lines = lines;
    }
    
    
    public double getInvoiveTotal(){
         double total = 0.0;
         
         for (int i = 0; i < lines.size(); i++){
             total += lines.get(i).getLineTotal();
             
         }
        return total;
        
    
    }

    @Override
    public String toString() {
        return "InvoiceHeader{" + "num=" + num + ", customer=" + customer + ", invdate=" + invdate + '}';
    }


}
   
   

 
       
    

