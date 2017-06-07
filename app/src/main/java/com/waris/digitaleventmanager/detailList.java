package com.waris.digitaleventmanager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lalli on 10/25/2015.
 */
public class detailList extends ActionBarActivity {

    private static ListView list;
    static List<ListDataClass> viewList = new ArrayList<ListDataClass>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_recylerview);
        if(savedInstanceState == null){

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new detailFragment())
                    .commit();
        }
    }

    public class detailFragment extends Fragment {
        
        public detailFragment ()
        {
            
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
           // return super.onCreateView(inflater, container, savedInstanceState);

            View rot = inflater.inflate(R.layout.event_recylerview, container,false);
            fillList();
            fillListView();
            return rot;
        }



        private void fillList() {
            viewList.clear();
            viewList.add(new ListDataClass("hello", "hello", R.mipmap.smarker,R.mipmap.map));
            viewList.add(new ListDataClass("hello","hello",R.mipmap.ic_launcher,R.mipmap.map));
            viewList.add(new ListDataClass("hello","hello",R.mipmap.ic_launcher,R.mipmap.map));
            viewList.add(new ListDataClass("hello","hello",R.mipmap.ic_launcher,R.mipmap.map));
            viewList.add(new ListDataClass("hello","hello",R.mipmap.ic_launcher,R.mipmap.map));
            viewList.add(new ListDataClass("hello","hello",R.mipmap.ic_launcher,R.mipmap.map));
        }
        private void fillListView() {

            list = (ListView) findViewById(R.id.recycler);

            list.clearChoices();
            ArrayAdapter<ListDataClass> eventadapter = new MyAdapter(getActivity(),viewList);


            list.setAdapter(eventadapter);

        }
    }
}
