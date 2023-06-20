package com.example.restapi;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NameDateFormat {
    private String date;
    private String name;

    public NameDateFormat(String name, String date) {
        this.name = name;
        this.date = date;
    }
}
