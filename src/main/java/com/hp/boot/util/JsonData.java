package com.hp.boot.util;

public class JsonData {
    private Integer code;
    private String msg;
    private  Integer count;
    private Object data;

    public JsonData() {
        super();
    }


    //用来描述成功信息
    public static JsonData buildSuccess(String msg){
        return new JsonData(0,msg,0,null);
    }

    //用来描述成功信息
    public static JsonData buildSuccess(Object obj){
        return new JsonData(0,"success",0,obj);
    }

    //用来描述失败信息
    public static JsonData buildError(String msg){
        return new JsonData(1,msg,0,null);
    }

    public JsonData(Integer code, String msg, Integer count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonData{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
