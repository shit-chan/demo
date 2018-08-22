package com.shit.demo.bean;

import net.sf.json.JSONObject;

public class Result {
    private String resultCode;
    private String resultMsg;
    private Object resultDetail;

    public Result(String resultCode,String resultMsg){
        this.resultCode=resultCode;
        this.resultMsg=resultMsg;
    }
    public Result(String resultCode,String resultMsg,Object resultDetail){
        this.resultCode=resultCode;
        this.resultMsg=resultMsg;
        this.resultDetail=resultDetail;
    }

    public String toString(){
        return JSONObject.fromObject(this).toString();
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getResultDetail() {
        return resultDetail;
    }

    public void setResultDetail(Object resultDetail) {
        this.resultDetail = resultDetail;
    }
}
