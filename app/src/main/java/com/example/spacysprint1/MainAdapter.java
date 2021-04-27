package com.example.spacysprint1;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{
    ArrayList<MainModel> mainModels;
    Context context;

    //Create Constructure

    public MainAdapter( Context context,ArrayList<MainModel> mainModels){
        this.context = context;
        this.mainModels = mainModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Create View
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
       //Return view
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      //Set to image view
        holder.imageView.setImageResource(mainModels.get(position).getNumeng());
        //Set Name to textview
        holder.textView.setText(mainModels.get(position).getNumbName());
        //Set image on image view

    }

    @Override
    public int getItemCount() {
        return mainModels.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //Initialize Variable
            ImageView imageView;
            TextView textView;
        public ViewHolder(@NonNull View itemView) {
                super(itemView);
                //Assign Variable
                imageView =itemView.findViewById(R.id.image_view);
                textView = itemView.findViewById(R.id.text_view);

        }
    }
}
