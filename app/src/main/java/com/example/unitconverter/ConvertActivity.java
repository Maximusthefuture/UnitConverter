package com.example.unitconverter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Spinner;

import java.util.List;

public class ConvertActivity extends AppCompatActivity {

    private static final String ITEM_EXTRA_KEY = "conversion";
    private Spinner fromSpinner;
    private Spinner toSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        fromSpinner = findViewById(R.id.from_spinner);
        toSpinner = findViewById(R.id.to_spinner);
        Conversion[] spinnerItems = Conversion.values();
        SpinnerAdapter adapter = new SpinnerAdapter();
        fromSpinner.setAdapter(adapter);

    }


    public static Intent getStartIntent(Context context, Conversion conversion) {
        Intent intent = new Intent(context, ConvertActivity.class);
        intent.putExtra(ITEM_EXTRA_KEY, conversion);
        return intent;
    }


    public void initSpiner() {

    }




}
