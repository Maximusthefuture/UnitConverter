package com.example.unitconverter;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements ListItemClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerVIewAdapter adapter = new RecyclerVIewAdapter(Arrays.asList(Conversion.values()), this);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onConvectionClickListener(Conversion conversion) {
        Intent intent = ConvertActivity.getStartIntent(this, conversion);
        intent.getExtras();
        startActivity(intent);
    }
}
