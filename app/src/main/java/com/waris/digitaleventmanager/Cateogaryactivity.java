package com.waris.digitaleventmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Cateogaryactivity extends ActionBarActivity {

    private static String sent;
    public static final String event_key="category_name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cateogaryactivity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        if (savedInstanceState == null){
            //TextView txt = (TextView)findViewById(R.id.tv);
            //txt.setText(sent);


           // sent = getIntent().getStringExtra(event_key);

           // Bundle args = new Bundle();
          //  args.putCharSequence(Cateogaryactivity.event_key, sent);

           // CateogaryactivityFragment fragment = new CateogaryactivityFragment();
            //fragment.setArguments(args);

            //getSupportFragmentManager().beginTransaction()
            //        .add(R.id.fragment, fragment)
            //        .commit();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment, new CateogaryactivityFragment())
                    .commit();
    }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action barso long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

/**
 * A placeholder fragment containing a simple view.
 */
class CateogaryactivityFragment extends Fragment {
    ArrayAdapter categoryAdapter;
    ListView lv;
    List<DataClass> categorylist = new ArrayList<DataClass>();
    public CateogaryactivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       /* String text=null;
        Bundle args = getArguments();
        if(args != null) {
            text = args.getString(Cateogaryactivity.event_key);
        }
*/
        View rootview = inflater.inflate(R.layout.activity_cateogaryactivity,container,false);

        //TextView textview = (TextView) rootview.findViewById(R.id.tv);
        //textview.setText(text);

        lv = (ListView) rootview.findViewById(R.id.lv1);
        //View rootview =populate(text,container,inflater);
        populateClass();
        populatelist();
        // performclick();
        lv.setVisibility(View.VISIBLE);
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

        lv.clearChoices();
        lv.setAdapter(eventadapter);
        Log.e("CHECK", categorylist.get(0).getName());


    }


    private void performclick() {

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                String listitem = categoryAdapter.getItem(position).toString();

           //     Intent intent = new Intent(getActivity(), detailedlist.class).putExtra(detailedlist.item_key, listitem);
             //   startActivity(intent);
            }
        });



    }

    private View populate(String text,ViewGroup container,LayoutInflater inflater) {

        View root = inflater.inflate(R.layout.activity_cateogaryactivity,container,false);


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




        return root;

    }
}
