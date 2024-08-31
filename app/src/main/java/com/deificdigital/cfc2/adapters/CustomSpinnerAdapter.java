package com.deificdigital.cfc2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.deificdigital.cfc2.R;

import java.util.List;

public class CustomSpinnerAdapter extends ArrayAdapter<String> {
    public CustomSpinnerAdapter(@NonNull Context context, List<String> items) {
        super(context, R.layout.spinner_item, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return createViewFromResource(position, convertView, parent, R.layout.spinner_item);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return createViewFromResource(position, convertView, parent, R.layout.spinner_item);
    }

    private View createViewFromResource(int position, View convertView, ViewGroup parent, int resource) {
        final TextView text;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(resource, parent, false);
        }

        text = convertView.findViewById(R.id.spinner_item_text);
        text.setText(getItem(position));
        text.setTextColor(ContextCompat.getColor(getContext(), android.R.color.black));

        return convertView;
    }
}
