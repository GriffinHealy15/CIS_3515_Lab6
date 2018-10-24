package edu.temple.fragmentpassing;

import android.widget.BaseAdapter;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;

import java.util.Locale;

public class Color_Adapter extends BaseAdapter {


    Context context;
    String myData[];

    public Color_Adapter(Context context, String[] myData) {
        this.context = context;
        this.myData = myData;
    }

    @Override
    public int getCount() {
        return myData.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = (TextView) new TextView(context);

        if(position == 6) {
            textView.setTextColor(Color.parseColor("White"));
        }

        if (Locale.getDefault().getLanguage().equals("en")){ //if the language is in english
            textView.setText(myData[position]);
            textView.setBackgroundColor(Color.parseColor(myData[position]));
            textView.setTextSize(32);
        } else{
            final String[] parseColors = context.getResources().getStringArray(R.array.parseColors);
            textView.setText(myData[position]);
            textView.setBackgroundColor(Color.parseColor(parseColors[position]));
            textView.setTextSize(32);
        }
        return textView;
    }
}
