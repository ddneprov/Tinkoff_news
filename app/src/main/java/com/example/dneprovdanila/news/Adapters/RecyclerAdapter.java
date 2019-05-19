package com.example.dneprovdanila.news.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dneprovdanila.news.MainActivity;
import com.example.dneprovdanila.news.NewsLetterActivity;
import com.example.dneprovdanila.news.POJO_classes.Item;
import com.example.dneprovdanila.news.R;

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Myholder> {


    List<Item> list;
    static Integer NUMBER = 0;



    public RecyclerAdapter(List<Item> list) {
        this.list = list;
    }


    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.block, parent, false);
        Myholder myHolder = new Myholder(view);
        return myHolder;
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    @Override
    public void onBindViewHolder(Myholder holder, final int position) {

        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, NewsLetterActivity.class);

                Integer POST_ID = list.get(position).getId();

                intent.putExtra("id", POST_ID);
                context.startActivity(intent);
            }
        });

        Item product = list.get(position);
        holder.ptext.setText(product.getText());

        int current_position = position;
        holder.news_number.setText(Integer.toString(++current_position));
    }


    public class Myholder extends RecyclerView.ViewHolder {
        TextView news_number, ptext;
        CardView card_view;


        public Myholder(View itemView) {
            super(itemView);

            ptext = (TextView) itemView.findViewById(R.id.text);
            news_number = (TextView) itemView.findViewById(R.id.news_number);
            card_view = (CardView) itemView.findViewById(R.id.card_view);
        }
    }
}
