package com.example.unitconverter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerVIewAdapter extends RecyclerView.Adapter<RecyclerVIewAdapter.UnitViewHolder> {
    private List<Conversion> conversions;
    private ListItemClickListener mItemClickListener;

    public RecyclerVIewAdapter(List<Conversion> asList, ListItemClickListener clickListener) {
        conversions = asList;
        mItemClickListener = clickListener;
    }


    @NonNull
    @Override
    public UnitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        return new UnitViewHolder(view, mItemClickListener);

    }

    @Override
    public void onBindViewHolder(@NonNull UnitViewHolder holder, int position) {
            Conversion conversion = conversions.get(position);
            holder.bindView(conversion);


    }

    @Override
    public int getItemCount() {
        return conversions.size();
    }



    public class UnitViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        ListItemClickListener clickListener;

        public UnitViewHolder(@NonNull final View itemView, final ListItemClickListener itemClickListener) {

            super(itemView);
            textView = itemView.findViewById(R.id.tv);
            clickListener = itemClickListener;

        }

        void bindView(final Conversion conversion) {
            textView.setText(conversion.toString());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onConvectionClickListener(conversion);
                }
            });
        }
    }

}
