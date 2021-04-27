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

public class  NumbersFr extends AppCompatActivity {
    //Initialize Variable
    ViewPager2 vpphorizontal;
    RecyclerView rrecyclerView;
    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;
    MainAdapterim Aadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.numbersfr);

        //Assign variable
        rrecyclerView =findViewById(R.id.rrecycler_View);
        vpphorizontal = findViewById(R.id.vpp_horizontal);

        //Create Integer Array
        int[] images={R.drawable.zerofrancais,R.drawable.unfr,R.drawable.numdeuxfr,R.drawable.numtroisfr
                ,R.drawable.numfourfr,R.drawable.numfivefr,R.drawable.numsixing,R.drawable.numsevenfr,R.drawable.numeightfr,R.drawable.numninefr,R.drawable.numtenfr};

        Integer[] numeng = {R.drawable.zerofrancais,R.drawable.unfr,R.drawable.two,R.drawable.threee
                ,R.drawable.four,R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine,R.drawable.ten};

        //Create String array
        String[] Names={"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};
        String[] numbName = {" "," ","Deux","Trois","Quatre","Cinq","Six","Sept","Huit","Neuf","Dix"};

        //Intialize arraylist
        mainModels = new ArrayList<>();

        for (int i=0;i<numeng.length;i++){
            MainModel model = new MainModel(numeng[i],numbName[i]);
            mainModels.add(model);
        }

        //Design Horizontal Layout
        LinearLayoutManager layoutManager = new LinearLayoutManager(NumbersFr.this,LinearLayoutManager.HORIZONTAL,false);
        rrecyclerView.setLayoutManager((layoutManager));
        rrecyclerView.setItemAnimator(new DefaultItemAnimator());

        //Inialize MainAdapter
        mainAdapter = new MainAdapter(NumbersFr.this,mainModels);
        Aadapter = new  MainAdapterim(images);

        //Set clip padding
        vpphorizontal.setClipToPadding(false);

        //Set clip children
        vpphorizontal.setClipChildren(false);

        //Set page limit
        vpphorizontal.setOffscreenPageLimit(3);

        //Set default start position
        vpphorizontal.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);

        //Set A dapter on horizontal viewpager
        vpphorizontal.setAdapter(Aadapter);

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
        vpphorizontal.setPageTransformer(transformer);

        //Set Mainadapter
        rrecyclerView.setAdapter(mainAdapter);
    }
}