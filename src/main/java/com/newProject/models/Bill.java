package com.newProject.models;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "billing_master")
public class Bill {

    @Id
    @Column(name = "bill_id")
    private Long billId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "total_amount")
    private float billAmt;
    // @Column(name = "products")
    // private Map<String, Integer> billProduct;    
    @Temporal(TemporalType.DATE)
    @Column(name = "bill_date")
    private Date billDate;

    public Long getBillId() {
        return this.billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public float getBillAmt() {
        return this.billAmt;
    }

    public void setBillAmt(float billAmt) {
        this.billAmt = billAmt;
    }

    // public Map<String, Integer> getBillProduct() {
    //     return this.billProduct;
    // }

    // public void setBillProduct(Map<String, Integer> billProduct) {
    //     this.billProduct = billProduct;
    // }

    public Date getBillDate() {
        return this.billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

}
