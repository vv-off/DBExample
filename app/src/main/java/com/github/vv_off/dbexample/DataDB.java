package com.github.vv_off.dbexample;

public class DataDB {

    private int _id;
    private String header;
    private String message;

    public DataDB(){
    }

    public DataDB(int _id, String header, String message){
        this._id = _id;
        this.header = header;
        this.message = message;
    }

    public DataDB(String header, String message){
        this.header = header;
        this.message = message;
    }

    public int getID(){
        return _id;
    }

    public void setID(int _id){
        this._id = _id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
