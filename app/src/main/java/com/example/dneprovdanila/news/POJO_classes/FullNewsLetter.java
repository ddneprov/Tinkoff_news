package com.example.dneprovdanila.news.POJO_classes;

import java.util.ArrayList;
import java.util.List;




/// извиняюсь за названия, у меня плохо с названиями когда я нервничаю
/// очень плохо

/// POJO класс всей новости
/// https://api.tinkoff.ru/v1/news_content?id=10024
public class FullNewsLetter {
    private String resultCode;
    private NewsLetterContent payload;
    private String trackingId;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public NewsLetterContent getPayload() {
        return payload;
    }

    public void setPayload(NewsLetterContent payload) {
        this.payload = payload;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }
}


