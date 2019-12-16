package com.example.unitconverter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

public class ValuesListFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    public ValuesListFragment() {
        super(R.layout.fragment_values_list);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = super.onCreateView(inflater, container, savedInstanceState);
        recyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerViewAdapter = new RecyclerViewAdapter(Arrays.asList(Conversion.values()), new ListItemClickListener() {
            @Override
            public void onConvectionClickListener(Conversion conversion) {
                FragmentActivity activity = getActivity();
                if (activity instanceof ConvertionSystem) {
                    ((ConvertionSystem) activity).convertionStart(conversion);
                }
            }
        });
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    public interface ConvertionSystem {
        void convertionStart(Conversion conversion);
    }
}
