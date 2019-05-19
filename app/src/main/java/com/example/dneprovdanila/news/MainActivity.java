package com.example.dneprovdanila.news;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;


import com.example.dneprovdanila.news.Adapters.RecyclerAdapter;
import com.example.dneprovdanila.news.Interfaces.APiService;
import com.example.dneprovdanila.news.POJO_classes.File;
import com.example.dneprovdanila.news.POJO_classes.Item;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Item> item_list = new ArrayList<>();
    File file;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        getProductData();
    }


    public void getProductData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.url))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();


        APiService apiService = retrofit.create(APiService.class);


        Observable<File> observable = apiService.getproductdata().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());


        observable.subscribe(new DisposableObserver<File>() {

            @Override
            public void onNext(File file) {
                item_list = (List<Item>)file.getPayload();

                RecyclerAdapter recyclerAdapter = new RecyclerAdapter(item_list);
                RecyclerView.LayoutManager recyce = new LinearLayoutManager(MainActivity.this);

                recyclerView.setLayoutManager(recyce);
                recyclerView.setAdapter(recyclerAdapter);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, e.getMessage());
                HttpException error = (HttpException) e;
                String errorBody = error.response().errorBody().toString();
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete");
            }
        });

    }
}