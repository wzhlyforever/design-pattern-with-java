package com.wx.singleton.enumSingle;

public enum EnumSingleton {
    INSTNACE;
    private Object data;


    public Object getData(){
        return data;
    }

    public void setData(Object data){
        this.data = data;
    }

    public static EnumSingleton getInstance(){
        return INSTNACE;
    }
}
