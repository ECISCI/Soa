package com.deepinto.pojo;

public class DpManager {
    private Integer id;

    private String maUname;

    private String maPwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaUname() {
        return maUname;
    }

    public void setMaUname(String maUname) {
        this.maUname = maUname == null ? null : maUname.trim();
    }

    public String getMaPwd() {
        return maPwd;
    }

    public void setMaPwd(String maPwd) {
        this.maPwd = maPwd == null ? null : maPwd.trim();
    }
}