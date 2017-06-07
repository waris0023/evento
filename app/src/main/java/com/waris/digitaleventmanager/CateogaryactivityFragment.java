package com.waris.digitaleventmanager;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
/*public class CateogaryactivityFragment extends Fragment {
    ArrayAdapter categoryAdapter;
    ListView listview;
    List<DataClass> categorylist = new ArrayList<DataClass>();
    public CateogaryactivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String text=null;
        Bundle args = getArguments();
        if(args != null) {
            text = args.getString(Cateogaryactivity.event_key);
        }
        View rootview = inflater.inflate(R.layout.event_recylerview,container,false);
        //TextView textview = (TextView) rootview.findViewById(R.id.tv);
        //textview.setText(text);
        listview = (ListView) rootview.findViewById(R.id.recycler);
        //View rootview =populate(text,container,inflater);
            populateClass();
        populatelist();
           // performclick();
        return rootview;


    }
    private void populateClass() {
        String[] categories = {"Bakery","Caters"
                , "Decorations","DJ", "Dhol","Invitation Cards","Photographer","Venue"};
       // categories = new String[]{"Bakery","Caters"
         //       , "Decorations","DJ", "Dhol","Invitation Cards","Photographer","Venue"};

        categorylist.add(new DataClass(R.mipmap.ic_launcher,categories[0],R.mipmap.ic_launcher));
        categorylist.add(new DataClass(R.mipmap.ic_launcher,categories[1],R.mipmap.ic_launcher));
        categorylist.add(new DataClass(R.mipmap.ic_launcher, categories[2], R.mipmap.ic_launcher));
        categorylist.add(new DataClass(R.mipmap.ic_launcher, categories[3], R.mipmap.ic_launcher));
        categorylist.add(new DataClass(R.mipmap.ic_launcher,categories[4],R.mipmap.ic_launcher));
    }


    private void populatelist() {



        ArrayAdapter<DataClass> eventadapter = new MyListAdapter(getActivity(),categorylist);


        listview.setAdapter(eventadapter);


    }


    private void performclick() {

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                String listitem=categoryAdapter.getItem(position).toString();

                Intent intent=new Intent(getActivity(),detailedlist.class).putExtra(detailedlist.item_key,listitem);
                startActivity(intent);
            }
        });



    }

    private View populate(String text,ViewGroup container,LayoutInflater inflater) {

        View root = inflater.inflate(R.layout.event_recylerview,container,false);


        // View rootview = inflater.inflate(R.layout.fragment_cateogaryactivity,container,false);
        //TextView textview = (TextView) root.findViewById(R.id.tv);
        //textview.setText(text);
      /* switch (text)
        {
            case "Marriage" : categories = new String[]{"Bakery","Caters"
                                     , "Decorations","DJ", "Dhol","Invitation Cards","Photographer","Venue"};

                break;
            case "Birthday party" : categories = new String[]{"Bakery","Caters"
                    , "Decorations","DJ", "Dhol","Invitation Cards","Photographer","Venue"};
                break;
            case "Funeral" : categories = new String[]{"Caters",
                    "Sound System","Venue"};
                break;
            case "Kitty Party" : categories = new String[]{"Bakery","Caters"
                    ,"Soound System" , "Venue"};
                break;
            case "Bachelor Party" : categories = new String[]{"Caters"
                    , "Decorations","DJ","Drinks","Entertainment","Photographer","Venue"};
                break;
            case "Worship(puja)" : categories = new String[]{"Caters"
                    , "Decorations","Photographer","Sound System","Venue"};
                break;
            case "Baby Shower" : categories = new String[]{"Bakery","Caters"
                    , "Decorations","Invitation Cards","Photographer","Venue"};

                break;
            default: categories = new String[]{"Bakery","Caters"
                    , "Decorations","Invitation Cards","Photographer","Venue"};
        }*/
       /*List<String> categorylist = new ArrayList<String>(
                Arrays.asList(categories));

       categoryAdapter = new ArrayAdapter<String>(
                getActivity(), R.layout.fragment_cateogaryactivity, R.id.tv, categorylist);
        listview = (ListView) root.findViewById(R.id.recycler);
        listview.setAdapter(categoryAdapter);
            */



/*
        return root;

    }
}
*/