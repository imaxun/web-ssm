package com.aly.ssm.model;

import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 发标时需要的字段
 * Created by tumin on 2017/4/28.
 */
public class BorrowInfoExt implements Serializable {
    private String borrowNid;//标的id
    private String borrowShotNid;//简写标id
    private Integer borrowUserId;//借款人id
    private String productId;//产品id
    private String borrowName;//产品名称
    private Integer type;//借款类型
    private Integer borrowType;//还款类型
    private BigDecimal borrowAmount;//产品金额
    private Float rate;//产品利率
    private Float extraRate;//加息利率
    private Date startInverstTime;//发布时间
    private Integer interestDay;//起息日
    private Integer repaymentDate;//还款日
    private Integer expireDay;//募集期限
    private String investRange;//投资范围
    private Integer agreementType;//协议类型
    private Integer termTime;//时间期限
    private Integer timeType;//时间期限类型
    private BigDecimal minInvestAmount;//起投金额
    private BigDecimal degrees;//递增金额
    private BigDecimal maxInventAmount;//加入上限
    private String companyName;//公司名称
    private String planInfo;//计划描述
    private String introduction;//项目描述
    private String repaySource;//还款来源
    private String creditInfo;//征信信息
    private Float investProgress;
    private BigDecimal remainAmount;
    private Integer expiryDate;
    private String orderSource;
    private String platformUserNo;
    private BigDecimal subscriptionAmount;  //认购费
    private BigDecimal serviceFee; //借款服务费
    private BigDecimal riskMoney;   //保证金
    @Transient
    private Date endInverstTime;    //募集满标时间
    private BigDecimal borrowFee; //管理费用
    private String thirdBorrowId;//第三方标号

    public String getThirdBorrowId() {
        return thirdBorrowId;
    }

    public void setThirdBorrowId(String thirdBorrowId) {
        this.thirdBorrowId = thirdBorrowId;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public String getPlatformUserNo() {
        return platformUserNo;
    }

    public void setPlatformUserNo(String platformUserNo) {
        this.platformUserNo = platformUserNo;
    }

    public Integer getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Integer expiryDate) {
        this.expiryDate = expiryDate;
    }

    public BigDecimal getRemainAmount() {
        return remainAmount;
    }

    public void setRemainAmount(BigDecimal remainAmount) {
        this.remainAmount = remainAmount;
    }

    public Float getInvestProgress() {
        return investProgress;
    }

    public void setInvestProgress(Float investProgress) {
        this.investProgress = investProgress;
    }

    private String borrowUse;//借款用途
    private Date createTime;
    private String duration;//借款期限
    private String durationType;//借款期限类型
    private String financeProductId;
    private String id;
    private String packNid;
    private String period;//期数
    private String remark;//征信信息
    private String repaymentType;//还款方式
    private String riskLevel;//标的风险等级
    private Integer status;
    private Date updateTime;
    private String collectDay;//募集天数

    public String getCollectDay() {
        return collectDay;
    }

    public void setCollectDay(String collectDay) {
        this.collectDay = collectDay;
    }

    public String getBorrowUse() {
        return borrowUse;
    }

    public void setBorrowUse(String borrowUse) {
        this.borrowUse = borrowUse;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDurationType() {
        return durationType;
    }

    public void setDurationType(String durationType) {
        this.durationType = durationType;
    }

    public String getFinanceProductId() {
        return financeProductId;
    }

    public void setFinanceProductId(String financeProductId) {
        this.financeProductId = financeProductId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPackNid() {
        return packNid;
    }

    public void setPackNid(String packNid) {
        this.packNid = packNid;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRepaymentType() {
        return repaymentType;
    }

    public void setRepaymentType(String repaymentType) {
        this.repaymentType = repaymentType;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getBorrowNid() {
        return borrowNid;
    }

    public void setBorrowNid(String borrowNid) {
        this.borrowNid = borrowNid;
    }

    public String getBorrowShotNid() {
        return borrowShotNid;
    }

    public void setBorrowShotNid(String borrowShotNid) {
        this.borrowShotNid = borrowShotNid;
    }

    public Integer getTimeType() {
        return timeType;
    }

    public void setTimeType(Integer timeType) {
        this.timeType = timeType;
    }

    public Integer getBorrowUserId() {
        return borrowUserId;
    }

    public void setBorrowUserId(Integer borrowUserId) {
        this.borrowUserId = borrowUserId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getBorrowName() {
        return borrowName;
    }

    public void setBorrowName(String borrowName) {
        this.borrowName = borrowName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getBorrowType() {
        return borrowType;
    }

    public void setBorrowType(Integer borrowType) {
        this.borrowType = borrowType;
    }

    public BigDecimal getBorrowAmount() {
        return borrowAmount;
    }

    public void setBorrowAmount(BigDecimal borrowAmount) {
        this.borrowAmount = borrowAmount;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Float getExtraRate() {
        return extraRate;
    }

    public void setExtraRate(Float extraRate) {
        this.extraRate = extraRate;
    }

    public Date getStartInverstTime() {
        return startInverstTime;
    }

    public void setStartInverstTime(Date startInverstTime) {
        this.startInverstTime = startInverstTime;
    }

    public Integer getInterestDay() {
        return interestDay;
    }

    public void setInterestDay(Integer interestDay) {
        this.interestDay = interestDay;
    }

    public Integer getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(Integer repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public Integer getExpireDay() {
        return expireDay;
    }

    public void setExpireDay(Integer expireDay) {
        this.expireDay = expireDay;
    }

    public String getInvestRange() {
        return investRange;
    }

    public void setInvestRange(String investRange) {
        this.investRange = investRange;
    }

    public Integer getAgreementType() {
        return agreementType;
    }

    public void setAgreementType(Integer agreementType) {
        this.agreementType = agreementType;
    }

    public Integer getTermTime() {
        return termTime;
    }

    public void setTermTime(Integer termTime) {
        this.termTime = termTime;
    }

    public Integer getTermType() {
        return timeType;
    }

    public void setTermType(Integer timeType) {
        this.timeType = timeType;
    }

    public BigDecimal getMinInvestAmount() {
        return minInvestAmount;
    }

    public void setMinInvestAmount(BigDecimal minInvestAmount) {
        this.minInvestAmount = minInvestAmount;
    }

    public BigDecimal getDegrees() {
        return degrees;
    }

    public void setDegrees(BigDecimal degrees) {
        this.degrees = degrees;
    }

    public BigDecimal getMaxInventAmount() {
        return maxInventAmount;
    }

    public void setMaxInventAmount(BigDecimal maxInventAmount) {
        this.maxInventAmount = maxInventAmount;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPlanInfo() {
        return planInfo;
    }

    public void setPlanInfo(String planInfo) {
        this.planInfo = planInfo;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getRepaySource() {
        return repaySource;
    }

    public void setRepaySource(String repaySource) {
        this.repaySource = repaySource;
    }

    public String getCreditInfo() {
        return creditInfo;
    }

    public void setCreditInfo(String creditInfo) {
        this.creditInfo = creditInfo;
    }

    public BigDecimal getSubscriptionAmount() {
        return subscriptionAmount;
    }

    public void setSubscriptionAmount(BigDecimal subscriptionAmount) {
        this.subscriptionAmount = subscriptionAmount;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public BigDecimal getRiskMoney() {
        return riskMoney;
    }

    public void setRiskMoney(BigDecimal riskMoney) {
        this.riskMoney = riskMoney;
    }

    public Date getEndInverstTime() {
        return endInverstTime;
    }

    public void setEndInverstTime(Date endInverstTime) {
        this.endInverstTime = endInverstTime;
    }

    public BigDecimal getBorrowFee() {
        return borrowFee;
    }

    public void setBorrowFee(BigDecimal borrowFee) {
        this.borrowFee = borrowFee;
    }

    @Override
    public String toString() {
        return "BorrowInfoExt{" +
                "borrowNid='" + borrowNid + '\'' +
                ", borrowShotNid='" + borrowShotNid + '\'' +
                ", borrowUserId=" + borrowUserId +
                ", productId='" + productId + '\'' +
                ", borrowName='" + borrowName + '\'' +
                ", type=" + type +
                ", borrowType=" + borrowType +
                ", borrowAmount=" + borrowAmount +
                ", rate=" + rate +
                ", extraRate=" + extraRate +
                ", startInverstTime=" + startInverstTime +
                ", interestDay=" + interestDay +
                ", repaymentDate=" + repaymentDate +
                ", expireDay=" + expireDay +
                ", investRange='" + investRange + '\'' +
                ", agreementType=" + agreementType +
                ", termTime=" + termTime +
                ", timeType=" + timeType +
                ", minInvestAmount=" + minInvestAmount +
                ", degrees=" + degrees +
                ", maxInventAmount=" + maxInventAmount +
                ", companyName='" + companyName + '\'' +
                ", planInfo='" + planInfo + '\'' +
                ", introduction='" + introduction + '\'' +
                ", repaySource='" + repaySource + '\'' +
                ", creditInfo='" + creditInfo + '\'' +
                ", investProgress=" + investProgress +
                ", remainAmount=" + remainAmount +
                ", expiryDate=" + expiryDate +
                ", orderSource='" + orderSource + '\'' +
                ", platformUserNo='" + platformUserNo + '\'' +
                ", subscriptionAmount=" + subscriptionAmount +
                ", serviceFee=" + serviceFee +
                ", riskMoney=" + riskMoney +
                ", endInverstTime=" + endInverstTime +
                ", borrowFee=" + borrowFee +
                ", thirdBorrowId='" + thirdBorrowId + '\'' +
                ", borrowUse='" + borrowUse + '\'' +
                ", createTime=" + createTime +
                ", duration='" + duration + '\'' +
                ", durationType='" + durationType + '\'' +
                ", financeProductId='" + financeProductId + '\'' +
                ", id='" + id + '\'' +
                ", packNid='" + packNid + '\'' +
                ", period='" + period + '\'' +
                ", remark='" + remark + '\'' +
                ", repaymentType='" + repaymentType + '\'' +
                ", riskLevel='" + riskLevel + '\'' +
                ", status=" + status +
                ", updateTime=" + updateTime +
                ", collectDay='" + collectDay + '\'' +
                '}';
    }
}
