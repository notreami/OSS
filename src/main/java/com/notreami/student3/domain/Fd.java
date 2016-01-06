package com.notreami.student3.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by notreami on 16/1/5.
 */
public class Fd implements Serializable {
    private Long id;
    private Long fdId;
    private Integer version;
    private Date createTime;
    private Date updateTime;
    private String operator;
    private String operatorName;
    private String org;
    private String dst;
    private String carrier;
    private String cabin;
    private String cabinType;
    private String airlineType;
    private Double distance;
    private Double fuel_tax;
    private Double price;
    private Double discount;
    private String currency;
    private Date startDate;
    private Date endDate;
    private Long startDate2;
    private Long endDate2;
    private String source;
    private Date verifyTime;
    private String remar;
    private Integer status;
    private String opid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFdId() {
        return fdId;
    }

    public void setFdId(Long fdId) {
        this.fdId = fdId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public String getCabinType() {
        return cabinType;
    }

    public void setCabinType(String cabinType) {
        this.cabinType = cabinType;
    }

    public String getAirlineType() {
        return airlineType;
    }

    public void setAirlineType(String airlineType) {
        this.airlineType = airlineType;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getFuel_tax() {
        return fuel_tax;
    }

    public void setFuel_tax(Double fuel_tax) {
        this.fuel_tax = fuel_tax;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getStartDate2() {
        return startDate2;
    }

    public void setStartDate2(Long startDate2) {
        this.startDate2 = startDate2;
    }

    public Long getEndDate2() {
        return endDate2;
    }

    public void setEndDate2(Long endDate2) {
        this.endDate2 = endDate2;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(Date verifyTime) {
        this.verifyTime = verifyTime;
    }

    public String getRemar() {
        return remar;
    }

    public void setRemar(String remar) {
        this.remar = remar;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOpid() {
        return opid;
    }

    public void setOpid(String opid) {
        this.opid = opid;
    }

    @Override
    public String toString() {
        return "Fd{" +
                "id=" + id +
                ", fdId=" + fdId +
                ", version=" + version +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", operator='" + operator + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", org='" + org + '\'' +
                ", dst='" + dst + '\'' +
                ", carrier='" + carrier + '\'' +
                ", cabin='" + cabin + '\'' +
                ", cabinType='" + cabinType + '\'' +
                ", airlineType='" + airlineType + '\'' +
                ", distance=" + distance +
                ", fuel_tax=" + fuel_tax +
                ", price=" + price +
                ", discount=" + discount +
                ", currency='" + currency + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", startDate2=" + startDate2 +
                ", endDate2=" + endDate2 +
                ", source='" + source + '\'' +
                ", verifyTime=" + verifyTime +
                ", remar='" + remar + '\'' +
                ", status=" + status +
                ", opid='" + opid + '\'' +
                '}';
    }
}
