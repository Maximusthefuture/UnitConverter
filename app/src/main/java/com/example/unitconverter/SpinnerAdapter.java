package com.example.unitconverter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.BreakIterator;

public class SpinnerAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return Unit.values().length;
    }

    @Override
    public Object getItem(int i) {
        return Unit.values()[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_list_item_1, viewGroup, false);
            view.setTag(new SpinnerViewHolder(view));
        }
        SpinnerViewHolder holder = (SpinnerViewHolder) view.getTag();
//        holder.mTitle.setText());
        return view;
    }

    class SpinnerViewHolder {
        final TextView mTitle;


        SpinnerViewHolder(View root) {
            mTitle = root.findViewById(android.R.id.text1);
        }

}


 }
