package com.example.dneprovdanila.news.Interfaces;

import com.example.dneprovdanila.news.POJO_classes.File;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface APiService {
    @GET("/v1/news/")
    Observable<File> getproductdata();
}
