package com.example.unitconverter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ConvertActivity extends AppCompatActivity {

    private static final String ITEM_EXTRA_KEY = "conversion";
    private Spinner fromSpinner;
    private Spinner toSpinner;
    private Conversion mConversion;
    private Unit mFromUnit;
    private Unit mToUnit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        fromSpinner = findViewById(R.id.from_spinner);
        toSpinner = findViewById(R.id.to_spinner);
        ArrayAdapter<Conversion> fromAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Conversion.values());
        ArrayAdapter<Conversion> toAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Conversion.values());
        fromSpinner.setAdapter(fromAdapter);
        toSpinner.setAdapter(toAdapter);
        mConversion = (Conversion) getIntent().getSerializableExtra(ITEM_EXTRA_KEY);



        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
               mFromUnit = mConversion.mUnits.get(position);
               Log.d("CONVERTACTIVITY", mFromUnit.toString());
               convert();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });

    }


    public static Intent getStartIntent(Context context, Conversion conversion) {
        Intent intent = new Intent(context, ConvertActivity.class);
        intent.putExtra(ITEM_EXTRA_KEY, conversion);
        return intent;
    }


    public void getNumber() {
        fromSpinner.getSelectedItem().toString();
    }


    public void convert() {
        double i = editText.getText * mFromUnit.mConventionToBase * mToUnit.mConventionToBase;
    }




}
