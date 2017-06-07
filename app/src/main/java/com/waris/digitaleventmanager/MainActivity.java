package com.waris.digitaleventmanager;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends Activity implements OnMapReadyCallback{

    Spinner spnr;
    Button submit;
    EditText name;
    ImageView icon,back_map;
    String temp;
    LatLng target;
    GoogleMap map;
    boolean mapread=false;
    MapFragment mapFragment;
    String[] places = {
            "Ahmedabad",
            "Chennai",
            "Delhi",
            "Mumbai",
            "Vellore"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnr = (Spinner)findViewById(R.id.spinner);
        submit =(Button)findViewById(R.id.submit_bt);
        name = (EditText)findViewById(R.id.event_name);
        icon = (ImageView)findViewById(R.id.marker_icon);
        back_map = (ImageView)findViewById(R.id.back_map);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, places);

        spnr.setAdapter(adapter);

        spnr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                temp = parent.getItemAtPosition(position).toString();

                switch (position) {
                    case 0:
                        target = new LatLng(23.022505, 72.571362 );
                        break;
                    case 1:
                        target = new LatLng(13.082680, 80.270718 );
                        break;
                    case 2:
                        target = new LatLng( 28.613939, 77.209021 );
                        break;
                    case 3:
                        target = new LatLng( 19.75984, 72.877656);
                        break;
                    case 4:
                        target = new LatLng(12.916517, 79.132499);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapid);
        mapFragment.getMapAsync(this);
        after();


}



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        return super.onOptionsItemSelected(item);
    }




    public void after() {


        submit.setOnClickListener(new View.OnClickListener()

        {
            public void onClick (View v){

                icon.setVisibility(View.INVISIBLE);
                name.setVisibility(View.INVISIBLE);
                submit.setVisibility(View.INVISIBLE);
                spnr.setVisibility(View.INVISIBLE);
                back_map.setVisibility(View.INVISIBLE);
                    String tar =target.toString();
                Toast.makeText(getApplicationContext(), tar, Toast.LENGTH_LONG).show();
                if(mapread)
                    flyTo();

            }

        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mapread=true;
        map=googleMap;
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

    }

    private void flyTo()
    {
        CameraPosition cp = CameraPosition.builder().target(target).zoom(15).bearing(0).tilt(65).build();
       // map.moveCamera(CameraUpdateFactory.newCameraPosition(cp));
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cp), 5000, new GoogleMap.CancelableCallback() {
            @Override
            public void onFinish() {
                //Intent in = new Intent(getApplicationContext(),EventActivity.class);
                //startActivity(in);
            }

            @Override
            public void onCancel() {
                //Intent in = new Intent(getApplicationContext(),EventActivity.class);
                //startActivity(in);
            }
        });

        MarkerOptions mark = new MarkerOptions().position(target).title(temp).icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker_ic));
        map.addMarker(mark);
    }
}
