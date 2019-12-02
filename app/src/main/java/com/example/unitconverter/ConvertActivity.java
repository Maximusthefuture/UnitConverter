package com.example.unitconverter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ConvertActivity extends AppCompatActivity {

    private static final String ITEM_EXTRA_KEY = "conversion";
    String fromText;
    String toText;
    List<String> enumList;

    ArrayAdapter<String> toAdapter;
    private Spinner fromSpinner;
    private Spinner toSpinner;
    private EditText fromEditText;
    private EditText toEditText;
    private Conversion mConversion;
    private Unit mFromUnit;
    private Unit mToUnit;


    public static Intent getStartIntent(Context context, Conversion conversion) {
        Intent intent = new Intent(context, ConvertActivity.class);
        intent.putExtra(ITEM_EXTRA_KEY, conversion);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        mConversion = (Conversion) getIntent().getSerializableExtra(ITEM_EXTRA_KEY);
        init();
        initAdapter();
        spinnerListeners();
    }

    public void init() {
        toEditText = findViewById(R.id.to_edit_text);
        fromEditText = findViewById(R.id.from_edit_text);
        fromText = fromEditText.getText().toString();
        toText = toEditText.getText().toString();
        fromSpinner = findViewById(R.id.from_spinner);
        toSpinner = findViewById(R.id.to_spinner);
        enumList = new ArrayList<>();
    }

    public void initAdapter() {
        for (Unit mUnit : mConversion.mUnits) {
            enumList.add(getString(mUnit.mLabelResource));
        }
        ArrayAdapter<String> fromAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, enumList);
        toAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, enumList);
        fromSpinner.setAdapter(fromAdapter);
        toSpinner.setAdapter(toAdapter);

    }

    public void spinnerListeners() {

        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                mFromUnit = mConversion.mUnits.get(position);
                fromEditText.setText(String.valueOf(1));
                toAdapter.setNotifyOnChange(true);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                adapterView.getItemIdAtPosition(0);
                toEditText.setHint(R.string.default_value);
            }
        });

        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mToUnit = mConversion.mUnits.get(position);

                DecimalFormat format = new DecimalFormat("#");

                double from = Double.parseDouble(fromEditText.getText().toString());
                double result = from * mFromUnit.mConventionToBase * mToUnit.mConvertionFromBase;



                toEditText.setText(format.format(result));
                toAdapter.notifyDataSetChanged();
                Log.d("ConvertActivity", "result : " + result);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                parent.getItemIdAtPosition(0);
                toEditText.setHint(R.string.default_value);
            }
        });
    }

}
