package com.uzcosmos.backenddemo.model;

import jakarta.persistence.*;

@Entity
public class Message {
    private String text;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
}

