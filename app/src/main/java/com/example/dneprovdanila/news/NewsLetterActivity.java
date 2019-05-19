package com.example.dneprovdanila.news;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import com.example.dneprovdanila.news.Interfaces.NewsLetterService;
import com.example.dneprovdanila.news.POJO_classes.FullNewsLetter;
import com.example.dneprovdanila.news.POJO_classes.Item;
import com.example.dneprovdanila.news.POJO_classes.NewsLetterContent;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;


public class NewsLetterActivity extends AppCompatActivity {

    String baseUrl;
    String specialCode;
    String result;

    FullNewsLetter fullnewsletter;
    NewsLetterContent newsLetterContent;
    Item item;

    TextView news_title;
    TextView news_text;
    Integer id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsletter);

        news_text = findViewById(R.id.news_text);
        news_title = findViewById(R.id.news_title);

        //baseUrl =  getResources().getString(R.string.url_newsletter);
        getnewsletter();
    }


    public void getnewsletter() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.url_newsletter))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();


        NewsLetterService apiService = retrofit.create(NewsLetterService.class);


        id = getIntent().getExtras().getInt("id");
        Observable<FullNewsLetter> observable = apiService.getnewsletter(id).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());


        observable.subscribe(new DisposableObserver<FullNewsLetter>() {
            @Override
            public void onNext(FullNewsLetter fullNewsLetter) {

                fullnewsletter = fullNewsLetter;
                newsLetterContent = fullnewsletter.getPayload();
                item = newsLetterContent.getTitle();

                news_title.setText(item.getText());

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    news_text.setText(Html.fromHtml(newsLetterContent.getContent(), Html.FROM_HTML_MODE_COMPACT));
                } else {
                    news_text.setText(Html.fromHtml(newsLetterContent.getContent()));
                }

            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, e.getMessage() + "<-----------");
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete");
            }
        });
    }
}






