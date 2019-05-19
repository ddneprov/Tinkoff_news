package com.example.dneprovdanila.news;

import java.util.List;

public class File {
    private String resultCode;
    private List<Item> payload;
    private String trackingId;





    public List<Item> getPayload() {
        return payload;
    }

    public void setPayload(List<Item> payload) {
        this.payload = payload;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public File(String resultCode, List<Item> items, String trackingId) {
        this.resultCode = resultCode;
        this.payload = items;
        this.trackingId = trackingId;
    }

}
