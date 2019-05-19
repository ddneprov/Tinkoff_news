package com.example.dneprovdanila.news;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface APiService {
    @GET("/v1/news/")
    Observable<File> getproductdata();
}
