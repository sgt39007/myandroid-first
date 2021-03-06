package com.example.echo.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit>{

    private int resourceId;

    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        this.resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = getItem(position);
//        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        View view;

        ViewHolder viewHolder;

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);

            viewHolder = new ViewHolder();
            viewHolder.fruitId = (TextView) view.findViewById(R.id.fruit_imageid);
            viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.fruitId.setText(fruit.getImgId());
        viewHolder.fruitName.setText(fruit.getName());

//        TextView fruitId = (TextView) view.findViewById(R.id.fruit_imageid);
//        TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
//
//        fruitId.setText(fruit.getImgId());
//        fruitName.setText(fruit.getName());

        return view;
    }

    class ViewHolder {
        TextView fruitId;
        TextView fruitName;
    }
}
