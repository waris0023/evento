package com.waris.digitaleventmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lalli on 10/25/2015.
 */
public class MyAdapter extends ArrayAdapter<ListDataClass> {

    List<ListDataClass> newlist1 = new ArrayList<ListDataClass>();

    public MyAdapter(Context context, List<ListDataClass> list) {
        super(context, R.layout.listcardview,list);
        newlist1 = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            LayoutInflater inflater;
            inflater = LayoutInflater.from(getContext());
            itemView = inflater.inflate(R.layout.listcardview, parent, false);
        }
            ListDataClass currentitem = newlist1.get(position);

            ImageView im = (ImageView) itemView.findViewById(R.id.pointer);
            im.setImageResource(currentitem.getPointer());

             ImageView im1 = (ImageView) itemView.findViewById(R.id.rightimage);
             im1.setImageResource(currentitem.getImage());

            TextView tx = (TextView) itemView.findViewById(R.id.abovetext);
            tx.setText(currentitem.getAbove());

            TextView tx1 = (TextView) itemView.findViewById(R.id.belowtext);
            tx1.setText(currentitem.getBelow());

         //   return super.getView(position, convertView, parent);

        return itemView;

    }
}
