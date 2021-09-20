/**
 * @author: Diego Marcelo Choque Ramirez
 */

package com.sales.market.dto.purchaseDto;

import com.sales.market.dto.DtoBase;
import com.sales.market.model.purchases.*;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurchaseOrderDto extends DtoBase<PurchaseOrder> {
    private String orderNumber;
    private Date date;
    private PurchaseOrderState state;
    private PurchaseOrderReceivedType receivedType;
    private String providerCode;
    private String gloss;
    private Date receptionDate;
    private BigDecimal totalAmount = BigDecimal.ZERO;
    private PurchaseOrderDetailDto defaultDetail = new PurchaseOrderDetailDto();
    private ProviderDto provider;
    private List<PurchaseOrderDetailDto> purchaseOrderDetailList = new ArrayList<PurchaseOrderDetailDto>(0);

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public PurchaseOrderState getState() {
        return state;
    }

    public void setState(PurchaseOrderState state) {
        this.state = state;
    }

    public PurchaseOrderReceivedType getReceivedType() {
        return receivedType;
    }

    public void setReceivedType(PurchaseOrderReceivedType receivedType) {
        this.receivedType = receivedType;
    }

    public String getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }

    public String getGloss() {
        return gloss;
    }

    public void setGloss(String gloss) {
        this.gloss = gloss;
    }

    public Date getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(Date receptionDate) {
        this.receptionDate = receptionDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public PurchaseOrderDetailDto getDefaultDetail() {
        return defaultDetail;
    }

    public void setDefaultDetail(PurchaseOrderDetailDto defaultDetail) {
        this.defaultDetail = defaultDetail;
    }

    public ProviderDto getProvider() {
        return provider;
    }

    public void setProvider(ProviderDto provider) {
        this.provider = provider;
    }

    public List<PurchaseOrderDetailDto> getPurchaseOrderDetailList() {
        return purchaseOrderDetailList;
    }

    public void setPurchaseOrderDetailList(List<PurchaseOrderDetailDto> purchaseOrderDetailList) {
        this.purchaseOrderDetailList = purchaseOrderDetailList;
    }
}