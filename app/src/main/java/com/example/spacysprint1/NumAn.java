package com.example.spacysprint1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class NumAn extends AppCompatActivity {
   //Initialize Variable
   ViewPager2 vphorizontal;
   RecyclerView recyclerView;
   ArrayList<MainModel> mainModels;
   MainAdapter mainAdapter;
   MainAdapterim Adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.numbersan);

        //Assign variable
        recyclerView =findViewById(R.id.recycler_View);
        vphorizontal = findViewById(R.id.vp_horizontal);

        //Initialize main adapter


        //Create Integer Array
        int[] images={R.drawable.zeroengli,R.drawable.oneenglish,R.drawable.numdeuxing,R.drawable.numtroising
                ,R.drawable.numfouing,R.drawable.numfiveing,R.drawable.numsixing,R.drawable.numsvening,R.drawable.numeighting,R.drawable.numnineing,R.drawable.numtening};

        Integer[] numeng = {R.drawable.zeroengli,R.drawable.oneenglish,R.drawable.two,R.drawable.threee
        ,R.drawable.four,R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine,R.drawable.ten};

        //Create String array
        String[] Names={"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};
        String[] numbName = {" "," ","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};

        //Intialize arraylist
        mainModels = new ArrayList<>();

        for (int i=0;i<numeng.length;i++){
            MainModel model = new MainModel(numeng[i],numbName[i]);
            mainModels.add(model);
        }

        //Design Horizontal Layout
        LinearLayoutManager layoutManager = new LinearLayoutManager(NumAn.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager((layoutManager));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //Inialize MainAdapter
        mainAdapter = new MainAdapter(NumAn.this,mainModels);
        Adapter = new  MainAdapterim(images);

        //Set clip padding
         vphorizontal.setClipToPadding(false);

         //Set clip children
        vphorizontal.setClipChildren(false);

        //Set page limit
        vphorizontal.setOffscreenPageLimit(3);

        //Set default start position
        vphorizontal.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);

        //Set A dapter on horizontal viewpager
        vphorizontal.setAdapter(Adapter);

        //Initialize composite page transformer
        CompositePageTransformer transformer = new CompositePageTransformer();

        //Add margin between page
        transformer.addTransformer(new MarginPageTransformer(8));

        //Increase selected page size
        transformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
               float v= 1- Math.abs(position);
               //Set scale y
                page.setScaleY(0.8f + v* 0.2f);
            }
        });
        //Set page transform
        vphorizontal.setPageTransformer(transformer);

        //Set Mainadapter
        recyclerView.setAdapter(mainAdapter);
    }
}