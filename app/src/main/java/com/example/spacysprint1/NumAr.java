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

public class NumAr extends AppCompatActivity {
    //Initialize Variable
    ViewPager2 vppphorizontal;
    RecyclerView rrrecyclerView;
    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;
    MainAdapterim Aadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.numbersar);
        //Assign variable
        rrrecyclerView =findViewById(R.id.rrrecycler_View);
        vppphorizontal = findViewById(R.id.vppp_horizontal);

        //Create Integer Array
        int[] images={R.drawable.zeroarabic,R.drawable.onearabic,R.drawable.numdeuxarab,R.drawable.numtroisarab
                ,R.drawable.numfourarab,R.drawable.numfivearab,R.drawable.numsixarab,R.drawable.numsevenarab,R.drawable.numeightarab,R.drawable.numninearab,R.drawable.numtenarab};

        Integer[] numeng = {R.drawable.zeroarabic,R.drawable.onearabic,R.drawable.two,R.drawable.threee
                ,R.drawable.four,R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine,R.drawable.ten};

        //Create String array
        String[] Names={"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};
        String[] numbName = {" "," ","اثنان","ثلاثة","أربعة","خمسة","ستة","سبعة","ثمانية","تسعة","عشرة"};

        //Intialize arraylist
        mainModels = new ArrayList<>();

        for (int i=0;i<numeng.length;i++){
            MainModel model = new MainModel(numeng[i],numbName[i]);
            mainModels.add(model);
        }

        //Design Horizontal Layout
        LinearLayoutManager layoutManager = new LinearLayoutManager(NumAr.this,LinearLayoutManager.HORIZONTAL,false);
        rrrecyclerView.setLayoutManager((layoutManager));
        rrrecyclerView.setItemAnimator(new DefaultItemAnimator());

        //Inialize MainAdapter
        mainAdapter = new MainAdapter(NumAr.this,mainModels);
        Aadapter = new  MainAdapterim(images);

        //Set clip padding
        vppphorizontal.setClipToPadding(false);

        //Set clip children
        vppphorizontal.setClipChildren(false);

        //Set page limit
        vppphorizontal.setOffscreenPageLimit(3);

        //Set default start position
        vppphorizontal.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);

        //Set A dapter on horizontal viewpager
        vppphorizontal.setAdapter(Aadapter);

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
        vppphorizontal.setPageTransformer(transformer);

        //Set Mainadapter
        rrrecyclerView.setAdapter(mainAdapter);
    }
}