package com.example.dneprovdanila.news.Interfaces;


import com.example.dneprovdanila.news.POJO_classes.FullNewsLetter;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsLetterService {
    @GET("news_content?")
    Observable<FullNewsLetter> getnewsletter(@Query("id") Integer id);
}

