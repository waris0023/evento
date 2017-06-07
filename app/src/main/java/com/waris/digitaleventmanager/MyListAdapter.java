package com.waris.digitaleventmanager;

        import android.app.Activity;
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
 * Created by lalli on 10/21/2015.
 */
public class MyListAdapter extends ArrayAdapter<DataClass> {
    List<DataClass> newlist = new ArrayList<DataClass>();


    public MyListAdapter(Context context, List<DataClass> list) {
        super(context, R.layout.card_view, list);
        newlist = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            LayoutInflater inflater;
            inflater = LayoutInflater.from(getContext());
            itemView = inflater.inflate(R.layout.card_view, parent, false);
            //itemView = getLayoutInflater().inflate(R.layout.customlisttext, parent, false);
        }

        // find the list item to work with.
        DataClass currentitem = newlist.get(position);

        // set the image.
        ImageView imv = (ImageView) itemView.findViewById(R.id.imageview);

        imv.setImageResource(currentitem.getImg());
        // fill the message(large text view).
        TextView txtview = (TextView) itemView.findViewById(R.id.textView);

        txtview.setText(currentitem.getName());
        ImageView imv1 = (ImageView) itemView.findViewById(R.id.arrow);

        imv1.setImageResource(currentitem.getImg1());
        // fill the message(small text view).
        //TextView txtmessage = (TextView) itemView.findViewById(R.id.mtv_message);
        //txtmessage.setText(currentitem.getMessage());

        //TextView txtnumber = (TextView)itemView.findViewById(R.id.mtxt_no);
        //txtnumber.setText(currentitem.getNo());

        return itemView;


    }
}
