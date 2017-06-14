package hidetut.fix.j2gliteware.camper1.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import hidetut.fix.j2gliteware.camper1.About;
import hidetut.fix.j2gliteware.camper1.R;
import hidetut.fix.j2gliteware.camper1.adapters.GridRecyclerAdapter;
import hidetut.fix.j2gliteware.camper1.bluetooth.DeviceSearchActivity;

public class ControlPanel extends AppCompatActivity {

    String address = null;

    String[] topics = new String[] {
            "Temperature", "Lighting","Soil", "Gas", "Sound", "Time", "Water", "Energy", "Cooling" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_panel);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // get the dang address for bluetooth connection
        Intent newint = getIntent();
        address = newint.getStringExtra(DeviceSearchActivity.EXTRA_ADDRESS);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerViewGrid);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        GridRecyclerAdapter recyclerAdapter = new GridRecyclerAdapter(this, createItemList());
        recyclerView.setAdapter(recyclerAdapter);

    }

    private List<String> createItemList() {
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < topics.length; i++) {
            list.add(topics[i]);
        }
        return list;
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
