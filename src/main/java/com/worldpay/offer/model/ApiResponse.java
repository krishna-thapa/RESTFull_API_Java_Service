package com.worldpay.offer.model;

import java.util.List;

public class ApiResponse {
    private Integer responseCode;
    private String responseMsg;
    private Object respObj;
    private List<? extends Object> lstRespObj;

    public ApiResponse(){

    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public Object getRespObj() {
        return respObj;
    }

    public void setRespObj(Object respObj) {
        this.respObj = respObj;
    }

    public List<? extends Object> getLstRespObj() {
        return lstRespObj;
    }

    public void setLstRespObj(List<? extends Object> lstRespObj) {
        this.lstRespObj = lstRespObj;
    }
}
