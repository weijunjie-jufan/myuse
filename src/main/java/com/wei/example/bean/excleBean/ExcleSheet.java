package com.wei.example.bean.excleBean;

import java.io.Serializable;

/**
 * @ProjectName: all_my_use
 * @Package: com.wei.example.bean.excleBean
 * @Description: java类作用描述
 * @Author: 魏俊杰
 * @CreateDate: 2018/5/3 11:41
 * @UpdateUser: 魏俊杰
 * @Version: 1.0
 * Copyright: Copyright (c) 2018
 */
public class ExcleSheet implements Serializable {

    private static final long serialVersionUID = -8736731367228394266L;
    private Integer id;
    private String applyNumber;
    private String orderNumber;
    private String cardUrl;
    private String backUrl;
    private String faceUrl;
    private String totalUrl;
    private String hetongUrl;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHetongUrl() {
        return hetongUrl;
    }

    public void setHetongUrl(String hetongUrl) {
        this.hetongUrl = hetongUrl;
    }

    public String getApplyNumber() {
        return applyNumber;
    }

    public void setApplyNumber(String applyNumber) {
        this.applyNumber = applyNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCardUrl() {
        return cardUrl;
    }

    public void setCardUrl(String cardUrl) {
        this.cardUrl = cardUrl;
    }

    public String getBackUrl() {
        return backUrl;
    }

    public void setBackUrl(String backUrl) {
        this.backUrl = backUrl;
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    public String getTotalUrl() {
        return totalUrl;
    }

    public void setTotalUrl(String totalUrl) {
        this.totalUrl = totalUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
