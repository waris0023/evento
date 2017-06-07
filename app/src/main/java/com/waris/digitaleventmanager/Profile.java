package com.waris.digitaleventmanager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lalli on 10/26/2015.
 */
public class Profile extends AppCompatActivity {


    private static ListView listview;
    //private static ArrayAdapter eventadapter;
    static List<profileData> eventlist = new ArrayList<profileData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        call();
    }

    private void call() {
        ImageButton call=(ImageButton)findViewById(R.id.call);
            final String tele="+91-9952599004";
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            Intent callintent = new Intent(Intent.ACTION_CALL);
                callintent.setData(Uri.parse("tel:"+tele));
                startActivity(callintent);

            }
        });

    }

    private class ProfileFragment extends Fragment {

        public ProfileFragment(){

        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


            View root = inflater.inflate(R.layout.profile, container,false);


            //return super.onCreateView(inflater, container, savedInstanceState);
            return root;
        }

        private void populateClass(){

            eventlist.clear();
            eventlist.add(new profileData(R.mipmap.map, "3.5", "15", "150", "nice place amazing experience "));
            eventlist.add(new profileData(R.mipmap.map,"3.5","15","150","nice place amazing experience "));
            eventlist.add(new profileData(R.mipmap.map,"3.5","15","150","nice place amazing experience "));
            eventlist.add(new profileData(R.mipmap.map,"3.5","15","150","nice place amazing experience "));
            eventlist.add(new profileData(R.mipmap.map, "3.5","15","150","nice place amazing experience "));
            eventlist.add(new profileData(R.mipmap.map, "3.5","15","150","nice place amazing experience "));
            eventlist.add(new profileData(R.mipmap.map, "3.5","15","150","nice place amazing experience "));

        }

        private void setView() {


        }
    }
}
