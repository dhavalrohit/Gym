/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.model;

/**
 *
 * @author DELL
 */
public class RawPunchDetail {
       private int ID; // private = restricted access
      private String EmpCode; // private = restricted access
       private String CardNo; // private = restricted access
        private String Datetrn; // private = restricted access
         private String InTime; // private = restricted access
          private String OutTime; // private = restricted access
           private String McNo; // private = restricted access

           
    //public RawPunchDetail (int id, String Empcode , String CardNo , String Datetrn , String InTime , String OutTime ,String McNo )
    //{
    
    //}       
           
           
           
    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the EmpCode
     */
    public String getEmpCode() {
        return EmpCode;
    }

    /**
     * @param EmpCode the EmpCode to set
     */
    public void setEmpCode(String EmpCode) {
        this.EmpCode = EmpCode;
    }

    /**
     * @return the CardNo
     */
    public String getCardNo() {
        return CardNo;
    }

    /**
     * @param CardNo the CardNo to set
     */
    public void setCardNo(String CardNo) {
        this.CardNo = CardNo;
    }

    /**
     * @return the Datetrn
     */
    public String getDatetrn() {
        return Datetrn;
    }

    /**
     * @param Datetrn the Datetrn to set
     */
    public void setDatetrn(String Datetrn) {
        this.Datetrn = Datetrn;
    }

    /**
     * @return the InTime
     */
    public String getInTime() {
        return InTime;
    }

    /**
     * @param InTime the InTime to set
     */
    public void setInTime(String InTime) {
        this.InTime = InTime;
    }

    /**
     * @return the OutTime
     */
    public String getOutTime() {
        return OutTime;
    }

    /**
     * @param OutTime the OutTime to set
     */
    public void setOutTime(String OutTime) {
        this.OutTime = OutTime;
    }

    /**
     * @return the McNo
     */
    public String getMcNo() {
        return McNo;
    }

    /**
     * @param McNo the McNo to set
     */
    public void setMcNo(String McNo) {
        this.McNo = McNo;
    }
    
}
