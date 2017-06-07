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



public class MyListActivity extends AppCompatActivity {


    //private static String sentt;
    public static final String List_key = "List_Item";

    private ListView nextlist;
    static List<ListDataClass> mylist1=new ArrayList<ListDataClass>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.event_recylerview);
        if (savedInstanceState == null) {
        /*    sentt = "Bakery";
            //sentt = getIntent().getStringExtra(List_key);
            Toast.makeText(getApplicationContext(), "nhi hua ", Toast.LENGTH_LONG).show();
        */
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container,new MyListFragment())
                    .commit();
        }
        /*else{
           sentt = "Caters";
            Toast.makeText(getApplicationContext(), "ho gaya ", Toast.LENGTH_LONG).show();
        }

        Bundle args1 = new Bundle();
        args1.putCharSequence(MyListActivity.List_key, sentt);

        MyListFragment fragmentone = new MyListFragment();
        fragmentone.setArguments(args1);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container,fragmentone)
                .commit();
*/
    }
    /*    @Override
        protected void onSaveInstanceState(Bundle outState) {
            outState.putString("string",sentt);
            super.onSaveInstanceState(outState);
        }

*/
    public class MyListFragment extends Fragment {


        public MyListFragment()
        {

        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            /*String text1=null;
            Bundle args1 = getArguments();
            if(args1 != null) {
                //text1 = args1.getString(MyListActivity.List_key);
            }
            text1="Bakery"; */
            SharedPreferences prfs = getSharedPreferences(Constants.MyPreferences, Context.MODE_PRIVATE);
            String text1 = prfs.getString(Constants.category,null);
            View rootView = inflater.inflate(R.layout.event_recylerview, container,false);

            addtoliist(text1);
            createlist();

            ClickMagic();
            return rootView;
        }



        public void addtoliist(String text1)
        {
            String[][] list=new String[3][5];

            //list= new String[][]{{"Flo","Bakers Hub","Delhi Bakers","King Bakers","Amma Bakers"},
              //      {"Katpadi,near VIT,Vellore","Gandhi Nagar","Near Chitoor Bus Stand","Near Vellore Fort","Central Vellore,Near CMC"}};

            switch(text1)
            {
                case "Bakery":
                    list= new String[][]{{"Flo","Bakers Hub","Delhi Bakers","King Bakers","Amma Bakers"},
                    {"Katpadi,near VIT,Vellore","Gandhi Nagar","Near Chitoor Bus Stand","Near Vellore Fort","Central Vellore,Near CMC"},
                            {"bakery","bakers","catereres","bakers","cater"}};
                    break;
                case "Caters":
                    list= new String[][]{{"Aadar Satkaar","Flavours","Alfa","Food Spice","Darling"},
                    {"Lajpat Nagar,New Delhi","Chennai Road,Vellore","Gandhi Nagar","Market Vellore","Bangalore Road"},
                            {"catereres","cater","bakers","bakery","cater"}};
                    break;
                case "Decorations":
                    list= new String[][]{{"Flo","Bakers Hub","Delhi Bakers","King Bakers","Amma Bakers"},
                    {"Katpadi,near VIT,Vellore","Gandhi Nagar","Near Chitoor Bus Stand","Gandhi Nagar","Central Vellore,Near CMC"},
                            {"decoration","dja","djb","djc","cater"}};
                    break;
                case "DJ":
                    list= new String[][]{{"Lloyd DJ","VIT DJ","DJ Sam","King Bakers","Amma Bakers"},
                    {"Katpadi,near VIT,Vellore","Gandhi Nagar","Near Chitoor Bus Stand","Near Vellore Fort","Central Vellore,Near CMC"},
                            {"djc","dja","djb","djc","djb"}};
                    break;
                case "Dhol":
                list= new String[][]{{"funVITics","Rajni Company","Special Dhol","Party Makers","Raja"},
                    {"Katpadi,near VIT,Vellore","Gandhi Nagar","Bangalore Road","Near Vellore Fort","Gandhi Nagar"},
                        {"catereres","dja","djb","djc","cater"}};
                break;
                case "Invitation Cards":
                    list= new String[][]{{"wedVITners","Danik Bhaskar","Danik jaagran","Amar Ujala","Amma Press"},
                    {"Gandhi Nagar","Gandhi Nagar","Near Chitoor Bus Stand","Near Vellore Fort","Central Vellore,Near CMC"},
                            {"decoration","dja","djb","djc","cater"}};
                    break;
                case "Photographer":
                    list= new String[][]{{"VIT Photography Club","Digital Group","Royal Photo","King Gallery","TFC Bangs"},
                    {"Katpadi,near VIT,Vellore","Gandhi Nagar","Near Chitoor Bus Stand","Near Vellore Fort","Central Vellore,Near CMC"},
                            {"decoration","dja","djb","djc","cater"}};
                    break;
                case "Venue":
                    list= new String[][]{{"SJT","FOODYS","GREENOS","Food Court","TT Amphi"},
                    {"Bangalore Road","Gandhi Nagar","Near Chitoor Bus Stand","Gandhi Nagar","Central Vellore,Near CMC"},
                            {"decoration","dja","djb","djc","cater"}};
                    break;
                default: list= new String[][]{{"Flo","Bakers Hub","Delhi Bakers","King Bakers","Amma Bakers"},
                    {"Katpadi,near VIT,Vellore","Gandhi Nagar","Near Chitoor Bus Stand","Near Vellore Fort","Central Vellore,Near CMC"},
                        {"decoration","dja","djb","djc","cater"}};
            }

            mylist1.clear();
            mylist1.add(new ListDataClass(list[0][0],list[1][0], R.mipmap.smarker,R.mipmap.catereres));
            mylist1.add(new ListDataClass(list[0][1],list[1][1],R.mipmap.smarker,R.mipmap.bakery));
            mylist1.add(new ListDataClass(list[0][2], list[1][2], R.mipmap.smarker, R.mipmap.dja));
            mylist1.add(new ListDataClass(list[0][3], list[1][3], R.mipmap.smarker, R.mipmap.cater));
            mylist1.add(new ListDataClass(list[0][4], list[1][4], R.mipmap.smarker, R.mipmap.decoration));

        }
        private void createlist() {
            nextlist = (ListView) findViewById(R.id.recycler);

            nextlist.clearChoices();
                            ArrayAdapter<ListDataClass> eventadapter = new MyAdapter(getActivity(), mylist1);


                            nextlist.setAdapter(eventadapter);




        }

        private void ClickMagic() {
            ListView lv1=(ListView)findViewById(R.id.recycler);
            lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getActivity(), Profile.class);
                    //.putExtra(categoryActivity.event_key,category);
                    startActivity(intent);
                }
            });


        }

    }
}
