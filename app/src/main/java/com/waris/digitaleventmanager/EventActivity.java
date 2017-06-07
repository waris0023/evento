package com.waris.digitaleventmanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EventActivity extends AppCompatActivity {

    private static ListView listview;
    //private static ArrayAdapter eventadapter;
    static List<DataClass> eventlist = new ArrayList<DataClass>();
    SharedPreferences sharedprefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //to implement the xml page to java.
        setContentView(R.layout.event_recylerview);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new EventFragment())
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if(id == R.id.action_team)
        {
            Intent ins = new Intent(this,team.class);
            startActivity(ins);
        }
        return super.onOptionsItemSelected(item);
    }


    public class EventFragment extends Fragment{


        public EventFragment(){

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            //return super.onCreateView(inflater, container, savedInstanceState);

            View rootView = inflater.inflate(R.layout.event_recylerview, container,false);


                 //   Arrays.asList(events));

           /* eventadapter = new ArrayAdapter<String>(
                    getActivity(), R.layout.card_view, R.id.textView, eventlist);

            listview = (ListView) rootView.findViewById(R.id.recycler);
            listview.setAdapter(eventadapter);
                */
            populateclass();
         /*   if(savedInstanceState == null) {
                populatecard();
            }*/
            listview = (ListView) rootView.findViewById(R.id.recycler);

            listview.clearChoices();
            ArrayAdapter<DataClass> eventadapter = new MyListAdapter(getActivity(),eventlist);


            listview.setAdapter(eventadapter);

           //listview = (ListView) rootView.findViewById(R.id.recycler);

            performClick();

            return rootView;

        }



        private void populateclass() {

            String[] events =
                    {
                            "Marriage",
                            "Birthday party",
                            "Funeral",
                            "Baby Shower",
                            "Kitty Party",
                            "Bachelor Party",
                            "Worship(puja)"
                    };
            eventlist.clear();
            eventlist.add(new DataClass(R.mipmap.marriage_ic,events[0],R.mipmap.ic_arrow));
            eventlist.add(new DataClass(R.mipmap.birthday_ic,events[1],R.mipmap.ic_arrow));
            eventlist.add(new DataClass(R.mipmap.funeral_ic,events[2],R.mipmap.ic_arrow));
            eventlist.add(new DataClass(R.mipmap.birthday_ic,events[3],R.mipmap.ic_arrow));
            eventlist.add(new DataClass(R.mipmap.kitty_ic, events[4], R.mipmap.ic_arrow));
            eventlist.add(new DataClass(R.mipmap.party_ic, events[5], R.mipmap.ic_arrow));
            eventlist.add(new DataClass(R.mipmap.puja_ic, events[6], R.mipmap.ic_arrow));
        }

    /*    private void populatecard() {

            listview = (ListView) findViewById(R.id.recycler);

            listview.clearChoices();
            ArrayAdapter<DataClass> eventadapter = new MyListAdapter(getActivity(),eventlist);


            listview.setAdapter(eventadapter);

        }*/

        private void performClick() {
           // Toast.makeText(getActivity(), "DARY ", Toast.LENGTH_LONG).show();



            listview.setOnItemClickListener(

                    new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                    //String category=eventadapter.getItem(position).toString();
                    //Toast.makeText(getActivity(), "DARY ", Toast.LENGTH_LONG).show();
                    DataClass obj = eventlist.get(position);
                    String category =obj.getName();

                    sharedprefs = getSharedPreferences(Constants.MyPreferences, Context.MODE_PRIVATE);

                    SharedPreferences.Editor editor = sharedprefs.edit();

                    editor.putString(Constants.event,category);
                    editor.apply();
                    Intent intent=new Intent(getActivity(),categoryActivity.class);
                            //.putExtra(categoryActivity.event_key,category);
                    startActivity(intent);

                }

            });
        }
    }
}
