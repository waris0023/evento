package com.waris.digitaleventmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lalli on 10/27/2015.
 */
public class ProfileAdapter extends ArrayAdapter<profileData> {

    List<profileData> newlist1 = new ArrayList<profileData>();
    public ProfileAdapter(Context context, List<profileData> list) {
        super(context, R.layout.profile,list);
        newlist1 = list;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            LayoutInflater inflater;
            inflater = LayoutInflater.from(getContext());
            itemView = inflater.inflate(R.layout.profile, parent, false);
        }
        profileData currentitem = newlist1.get(position);

        ImageView im = (ImageView) itemView.findViewById(R.id.imag);
        im.setImageResource(currentitem.getImage());

        TextView tx = (TextView) itemView.findViewById(R.id.txt1);
        tx.setText(currentitem.getRat());

        TextView tx1 = (TextView) itemView.findViewById(R.id.txt2);
        tx1.setText(currentitem.getReview());

        TextView tx2 = (TextView) itemView.findViewById(R.id.txt3);
        tx2.setText(currentitem.getPics());

        TextView tx3 = (TextView) itemView.findViewById(R.id.txt4);
        tx3.setText(currentitem.getDesc());

        //   return super.getView(position, convertView, parent);

        return itemView;

    }
}
