package hidetut.fix.j2gliteware.camper1.dashboard;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import hidetut.fix.j2gliteware.camper1.About;
import hidetut.fix.j2gliteware.camper1.MainActivity;
import hidetut.fix.j2gliteware.camper1.R;
import hidetut.fix.j2gliteware.camper1.adapters.GridRecyclerAdapter;
import hidetut.fix.j2gliteware.camper1.bluetooth.DeviceSearchActivity;

public class ControlPanel extends AppCompatActivity {

    String address = null;

    FloatingActionButton btn;

    String[] topics = new String[] {
            "Temperature", "Lighting","Soil", "Gas", "Sound", "Time", "Water", "Energy", "Cooling" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_panel);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // get the dang address for bluetooth connection
        Intent newint = getIntent();
        address = newint.getStringExtra(DeviceSearchActivity.EXTRA_ADDRESS);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerViewGrid);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        GridRecyclerAdapter recyclerAdapter = new GridRecyclerAdapter(this, createItemList());
        recyclerView.setAdapter(recyclerAdapter);

        btn = (FloatingActionButton)findViewById(R.id.floater);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ControlPanel.this);
                alertDialogBuilder.setMessage("Select a Category to Control Tent VIA Bluetooth.");
                alertDialogBuilder.setPositiveButton("OK", null);
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        notificationCreate();

    }

    private List<String> createItemList() {
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < topics.length; i++) {
            list.add(topics[i]);
        }
        return list;
    }

    private void notificationCreate() {
        NotificationCompat.Builder builder =
                (android.support.v7.app.NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.tent)
                        .setContentTitle("Connection Accepted")
                        .setContentText("Bluetooth Device Connected");

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {

            case android.R.id.home:
                finish();
                return true;
            case R.id.action_about:
                Intent i = new Intent(ControlPanel.this, About.class);
                startActivity(i);
                return true;
            case R.id.action_settings:
                // none yet
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
