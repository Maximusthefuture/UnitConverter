package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements ListItemClickListener{
    private ArrayList<Conversion> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerVIewAdapter adapter = new RecyclerVIewAdapter(Arrays.asList(Conversion.values()), this);
//        adapter.setConversions(list);
//
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onConvectionClickListener(Conversion conversion) {
        Intent intent = ConvertActivity.getStartIntent(this, conversion);
        startActivity(intent);
    }
}
