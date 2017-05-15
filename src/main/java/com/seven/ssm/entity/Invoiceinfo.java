package com.seven.ssm.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by douqi on 2017/4/27.
 */
@Entity
public class Invoiceinfo {
    private int id;
    private Date createtime;
    private String payName;
    private Integer payCode;
    private Byte type;
    private Integer invoiceCode;
    private Integer invoiceNumber;
    private String qrCode;
    private String securityCode;
    private String productName;
    private String productType;
    private String productPrice;
    private String productMoney;
    private String productMoneyA;
    private String collectionName;
    private Integer collectionCode;
    private Integer networkCode;
    private String serviceName;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "createtime", nullable = true)
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Basic
    @Column(name = "pay_name", nullable = true, length = 32)
    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    @Basic
    @Column(name = "pay_code", nullable = true)
    public Integer getPayCode() {
        return payCode;
    }

    public void setPayCode(Integer payCode) {
        this.payCode = payCode;
    }

    @Basic
    @Column(name = "type", nullable = true)
    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    @Basic
    @Column(name = "invoice_code", nullable = true)
    public Integer getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(Integer invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    @Basic
    @Column(name = "invoice_number", nullable = true)
    public Integer getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Integer invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @Basic
    @Column(name = "qr_code", nullable = true, length = 64)
    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    @Basic
    @Column(name = "security_code", nullable = true, length = 32)
    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    @Basic
    @Column(name = "product_name", nullable = true, length = 64)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "product_type", nullable = true, length = 32)
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Basic
    @Column(name = "product_price", nullable = true, length = 32)
    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    @Basic
    @Column(name = "product_money", nullable = true, length = 32)
    public String getProductMoney() {
        return productMoney;
    }

    public void setProductMoney(String productMoney) {
        this.productMoney = productMoney;
    }

    @Basic
    @Column(name = "product_moneyA", nullable = true, length = 32)
    public String getProductMoneyA() {
        return productMoneyA;
    }

    public void setProductMoneyA(String productMoneyA) {
        this.productMoneyA = productMoneyA;
    }

    @Basic
    @Column(name = "collection_name", nullable = true, length = 32)
    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    @Basic
    @Column(name = "collection_code", nullable = true)
    public Integer getCollectionCode() {
        return collectionCode;
    }

    public void setCollectionCode(Integer collectionCode) {
        this.collectionCode = collectionCode;
    }

    @Basic
    @Column(name = "network_code", nullable = true)
    public Integer getNetworkCode() {
        return networkCode;
    }

    public void setNetworkCode(Integer networkCode) {
        this.networkCode = networkCode;
    }

    @Basic
    @Column(name = "service_name", nullable = true, length = 32)
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoiceinfo that = (Invoiceinfo) o;

        if (id != that.id) return false;
        if (createtime != null ? !createtime.equals(that.createtime) : that.createtime != null) return false;
        if (payName != null ? !payName.equals(that.payName) : that.payName != null) return false;
        if (payCode != null ? !payCode.equals(that.payCode) : that.payCode != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (invoiceCode != null ? !invoiceCode.equals(that.invoiceCode) : that.invoiceCode != null) return false;
        if (invoiceNumber != null ? !invoiceNumber.equals(that.invoiceNumber) : that.invoiceNumber != null)
            return false;
        if (qrCode != null ? !qrCode.equals(that.qrCode) : that.qrCode != null) return false;
        if (securityCode != null ? !securityCode.equals(that.securityCode) : that.securityCode != null) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (productType != null ? !productType.equals(that.productType) : that.productType != null) return false;
        if (productPrice != null ? !productPrice.equals(that.productPrice) : that.productPrice != null) return false;
        if (productMoney != null ? !productMoney.equals(that.productMoney) : that.productMoney != null) return false;
        if (productMoneyA != null ? !productMoneyA.equals(that.productMoneyA) : that.productMoneyA != null)
            return false;
        if (collectionName != null ? !collectionName.equals(that.collectionName) : that.collectionName != null)
            return false;
        if (collectionCode != null ? !collectionCode.equals(that.collectionCode) : that.collectionCode != null)
            return false;
        if (networkCode != null ? !networkCode.equals(that.networkCode) : that.networkCode != null) return false;
        if (serviceName != null ? !serviceName.equals(that.serviceName) : that.serviceName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        result = 31 * result + (payName != null ? payName.hashCode() : 0);
        result = 31 * result + (payCode != null ? payCode.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (invoiceCode != null ? invoiceCode.hashCode() : 0);
        result = 31 * result + (invoiceNumber != null ? invoiceNumber.hashCode() : 0);
        result = 31 * result + (qrCode != null ? qrCode.hashCode() : 0);
        result = 31 * result + (securityCode != null ? securityCode.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productType != null ? productType.hashCode() : 0);
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        result = 31 * result + (productMoney != null ? productMoney.hashCode() : 0);
        result = 31 * result + (productMoneyA != null ? productMoneyA.hashCode() : 0);
        result = 31 * result + (collectionName != null ? collectionName.hashCode() : 0);
        result = 31 * result + (collectionCode != null ? collectionCode.hashCode() : 0);
        result = 31 * result + (networkCode != null ? networkCode.hashCode() : 0);
        result = 31 * result + (serviceName != null ? serviceName.hashCode() : 0);
        return result;
    }
}
