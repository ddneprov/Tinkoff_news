package com.example.dneprovdanila.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


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


        Log.e(TAG, "0");

        Observable<File> observable = apiService.getproductdata().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());


        observable.subscribe(new DisposableObserver<File>() {

            @Override
            public void onNext(File file) {
                Log.e(TAG, "onNext");


                item_list = (List<Item>)file.getPayload();


                Log.e(TAG, "onNext - 2");

                Item item = new Item();
                item.setText(item_list.get(0).getText());
                item.setName(item_list.get(0).getName());

                item_list.add(item);


               /* for (int i =0 ;i < 1; i++){


                    Log.e(TAG, "onNext - 2");

                    Item item = new Item();
                    item.setText(item_list.get(i).getText());
                    item.setName(item_list.get(i).getName());

                    item_list.add(item);
                }*/

                Log.e(TAG, "onNext - 3");
                RecyclerAdapter recyclerAdapter = new RecyclerAdapter(item_list);
                RecyclerView.LayoutManager recyce = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(recyce);
                recyclerView.setAdapter(recyclerAdapter);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, e.getMessage());
                HttpException error = (HttpException)e;
                String errorBody = error.response().errorBody().toString();
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete");

            }
        });

    }
}

