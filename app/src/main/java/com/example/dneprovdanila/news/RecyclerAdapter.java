package com.example.dneprovdanila.news;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;



public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Myholder> {

    List<Item> list;
    public RecyclerAdapter(List<Item> list) {
        this.list = list;
    }

    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.block,parent,false);
        Myholder myHolder = new Myholder(view);
        return myHolder;
    }




    @Override
    public void onBindViewHolder(Myholder holder, int position) {

        //TODO: взять из объекта еще
        Item product = list.get(position);

        holder.pname.setText(product.getName());
        holder.ptext.setText(product.getText());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Myholder extends RecyclerView.ViewHolder{
        TextView pname,ptext;

        public Myholder(View itemView) {
            super(itemView);

            pname = (TextView) itemView.findViewById(R.id.name);
            ptext = (TextView) itemView.findViewById(R.id.text);
        }
    }

}
