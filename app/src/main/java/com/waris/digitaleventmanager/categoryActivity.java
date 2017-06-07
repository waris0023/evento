package com.waris.digitaleventmanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lalli on 10/25/2015.
 */
public class categoryActivity extends AppCompatActivity {
    //String text= null;
    private static String sent = "";
    public static final String event_key="category_name";
    Bundle argu;
    //categoryFragment fragment = new categoryFragment();
    private static ListView list;
    static List<DataClass> myList = new ArrayList<DataClass>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_recylerview);

        //categoryFragment fragment = new categoryFragment();
        if (savedInstanceState == null) {
          /*  sent = getIntent().getStringExtra(event_key);

            *Bundle args = new Bundle();
            args.putCharSequence(categoryActivity.event_key, sent);


            fragment.setArguments(args); */

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new categoryFragment()).commit();

        }




    }



    public class categoryFragment extends Fragment {

        public categoryFragment(){

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            //return super.onCreateView(inflater, container, savedInstanceState);

            /*Bundle args = getArguments();
            if(args != null) {
                text = args.getString(categoryActivity.event_key);
                }*/
            View rootView = inflater.inflate(R.layout.event_recylerview, container,false);

            SharedPreferences prfs = getSharedPreferences(Constants.MyPreferences, Context.MODE_PRIVATE);
            String text = prfs.getString(Constants.event,null);

            insertInList(text);
            generateList();
            click();
            return rootView;
        }


        private void insertInList(String text) {
          
          String[] categories = new String[8];
          int count;
             switch (text)
        {
            case "Marriage" : categories = new String[]{"Bakery","Caters"
                                     , "Decorations","DJ", "Dhol","Invitation Cards","Photographer","Venue"}; //8

                break;
            case "Birthday party" : categories = new String[]{"Bakery","Caters"
                    , "Decorations","DJ", "Dhol","Invitation Cards","Photographer","Venue"}; //8
                break;
            case "Funeral" : categories = new String[]{"Caters",
                    "Sound System","Venue"};      //3
                break;
            case "Kitty Party" : categories = new String[]{"Bakery","Caters"
                    ,"Soound System" , "Venue"}; //4
                break;
            case "Bachelor Party" : categories = new String[]{"Caters"
                    , "Decorations","DJ","Drinks","Entertainment","Photographer","Venue"};  //7
                break;
            case "Worship(puja)" : categories = new String[]{"Caters"
                    , "Decorations","Photographer","Sound System","Venue"}; //5
                break;
            case "Baby Shower" : categories = new String[]{"Bakery","Caters"
                    , "Decorations","Invitation Cards","Photographer","Venue"};   //6

                break;
            default: categories = new String[]{"Bakery","Caters"
                    , "Decorations","Invitation Cards","Photographer","Venue"}; //6
        }
            count=0;
            count=categories.length;

            myList.clear();
            myList.add(new DataClass(R.mipmap.checkbox,categories[0],R.mipmap.ic_arrow));
            myList.add(new DataClass(R.mipmap.checkbox,categories[1],R.mipmap.ic_arrow));
            myList.add(new DataClass(R.mipmap.checkbox,categories[2],R.mipmap.ic_arrow));
            if(count==4){
                myList.add(new DataClass(R.mipmap.checkbox, categories[3], R.mipmap.ic_arrow));
            }else if (count == 5) {
                myList.add(new DataClass(R.mipmap.checkbox, categories[3], R.mipmap.ic_arrow));
                myList.add(new DataClass(R.mipmap.checkbox, categories[4], R.mipmap.ic_arrow));
            }else if (count == 6){
                myList.add(new DataClass(R.mipmap.checkbox, categories[3], R.mipmap.ic_arrow));
                myList.add(new DataClass(R.mipmap.checkbox, categories[4], R.mipmap.ic_arrow));
                myList.add(new DataClass(R.mipmap.checkbox, categories[5], R.mipmap.ic_arrow));
            }else if(count == 7){
                myList.add(new DataClass(R.mipmap.checkbox, categories[3], R.mipmap.ic_arrow));
                myList.add(new DataClass(R.mipmap.checkbox, categories[4], R.mipmap.ic_arrow));
                myList.add(new DataClass(R.mipmap.checkbox, categories[5], R.mipmap.ic_arrow));
                myList.add(new DataClass(R.mipmap.checkbox, categories[6], R.mipmap.ic_arrow));

            }else if(count == 8){
                myList.add(new DataClass(R.mipmap.checkbox, categories[3], R.mipmap.ic_arrow));
                myList.add(new DataClass(R.mipmap.checkbox, categories[4], R.mipmap.ic_arrow));
                myList.add(new DataClass(R.mipmap.checkbox, categories[5], R.mipmap.ic_arrow));
                myList.add(new DataClass(R.mipmap.checkbox, categories[6], R.mipmap.ic_arrow));
                myList.add(new DataClass(R.mipmap.checkbox, categories[7], R.mipmap.ic_arrow));

            }
        }

        private void generateList() {
            list = (ListView) findViewById(R.id.recycler);

            list.clearChoices();
            ArrayAdapter<DataClass> eventadapter = new MyListAdapter(getActivity(),myList);


            list.setAdapter(eventadapter);


        }
        private void click() {

            ListView lv=(ListView) findViewById(R.id.recycler);
            lv.setOnItemClickListener(
                    new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                            DataClass obj1 = myList.get(position);
                            String todo = obj1.getName();

                            SharedPreferences sharedprefs = getSharedPreferences(Constants.MyPreferences, Context.MODE_PRIVATE);

                            SharedPreferences.Editor editor = sharedprefs.edit();

                            editor.putString(Constants.category,todo);
                            editor.apply();

                            Intent intent1 = new Intent(getActivity(),MyListActivity.class);
                            //.putExtra(MyListActivity.List_key, todo);
                            startActivity(intent1);
                        }
                    }
            );
        }

    }
}
