package com.example.dneprovdanila.news.POJO_classes;





/// payload новости
public class NewsLetterContent {
    private Item title;
    private PublicationDate creationDate;
    private PublicationDate lastModificationDate;
    private String content;
    private Integer bankInfoTypeId;
    private String typeId;

    public Item getTitle() {
        return title;
    }

    public void setTitle(Item title) {
        this.title = title;
    }

    public PublicationDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(PublicationDate creationDate) {
        this.creationDate = creationDate;
    }

    public PublicationDate getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(PublicationDate lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getBankInfoTypeId() {
        return bankInfoTypeId;
    }

    public void setBankInfoTypeId(Integer bankInfoTypeId) {
        this.bankInfoTypeId = bankInfoTypeId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
}
