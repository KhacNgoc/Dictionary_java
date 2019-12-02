/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dictionary.JFrame;

/**
 *
 * @author Khac Ngoc
 */
public class Data {
    private String text;
    private String dict;

    public String getText() {
        return text;
    }

    public String getDict() {
        return dict;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDict(String dict) {
        this.dict = dict;
    }

    public Data(String text, String dict) {
        this.text = text;
        this.dict = dict;
    }
    
}
