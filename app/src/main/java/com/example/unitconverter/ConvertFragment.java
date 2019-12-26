package com.example.unitconverter;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ConvertFragment extends Fragment {

    public static final String ITEM_EXTRA_KEY = "conversion";

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

    public static ConvertFragment newInstance(Conversion conversion) {
        Bundle args = new Bundle();
        ConvertFragment fragment = new ConvertFragment();
        args.putSerializable(ITEM_EXTRA_KEY, conversion);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_convert, container, false);

        init(root);
        initAdapter();
        initSpinners();

        return root;
    }


    private void init(View root) {
        mConversion = (Conversion) getArguments().getSerializable(ITEM_EXTRA_KEY);

        toEditText = root.findViewById(R.id.to_edit_text);
        fromEditText = root.findViewById(R.id.from_edit_text);
        fromSpinner = root.findViewById(R.id.from_spinner);
        toSpinner = root.findViewById(R.id.to_spinner);
        fromText = fromEditText.getText().toString();
        toText = toEditText.getText().toString();
        enumList = new ArrayList<>();
    }

    private void initAdapter() {
        for (Unit mUnit : mConversion.mUnits) {
            enumList.add(getString(mUnit.mLabelResource));
        }
        ArrayAdapter<String> fromAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, enumList);
        toAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, enumList);
        fromSpinner.setAdapter(fromAdapter);
        toSpinner.setAdapter(toAdapter);
    }


    public void initSpinners() {
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

                DecimalFormat format = new DecimalFormat("#.#########");

                double from = Double.parseDouble(fromEditText.getText().toString());
                double result = from * mFromUnit.mConventionToBase * mToUnit.mConvertionFromBase;

                toEditText.setText(format.format(result));
                toAdapter.setNotifyOnChange(true);
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

