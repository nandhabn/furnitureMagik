package com.nandha.fmstore.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nandha.fmstore.Furniture;
import com.nandha.fmstore.R;

import java.util.List;

public class FurnitureMap extends RecyclerView.Adapter<FurnitureMap.FurnituresViewHolder> {

    private List<Furniture> list;
    public FurnitureMap(List<Furniture> list){
        this.list = list;
    }

    @NonNull
    @Override
    public FurnituresViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FurnituresViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.furniture,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FurnituresViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.desc.setText(list.get(position).getDiscription());
        holder.price.setText(list.get(position).getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class FurnituresViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView desc;
        TextView price;
        public FurnituresViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.furnitureName);
            desc = itemView.findViewById(R.id.desc);
            price = itemView.findViewById(R.id.price);
        }
    }

}
