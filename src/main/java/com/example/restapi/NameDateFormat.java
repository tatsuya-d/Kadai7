package com.example.restapi;

public class NameDateFormat {
    private String date;
    private String name;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public NameDateFormat(String name, String date) {
        this.name = name;
        this.date = date;
    }


}
