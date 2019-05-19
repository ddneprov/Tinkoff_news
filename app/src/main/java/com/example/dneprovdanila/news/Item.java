package com.example.dneprovdanila.news;


public class Item {


    // TODO: возможно лучше использовать другой тип данных
    private Integer id;
    private String name;
    private String text;
    private PublicationDate publicationDate;
    private Integer bankInfoTypeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public PublicationDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(PublicationDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Integer getBankInfoTypeId() {
        return bankInfoTypeId;
    }

    public void setBankInfoTypeId(Integer bankInfoTypeId) {
        this.bankInfoTypeId = bankInfoTypeId;
    }
/* public Item(Integer id, String name, String text, PublicationDate date, Integer bankInfoTypeId) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.date = date;
        this.bankInfoTypeId = bankInfoTypeId;
    }*/



}
