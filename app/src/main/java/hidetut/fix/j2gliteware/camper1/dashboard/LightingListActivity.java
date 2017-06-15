package hidetut.fix.j2gliteware.camper1.dashboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import hidetut.fix.j2gliteware.camper1.R;
import hidetut.fix.j2gliteware.camper1.adapters.ListRecyclerAdapter;

public class LightingListActivity extends AppCompatActivity {

    String[] types = new String[] {
            "Strip Lights", "Piranhas" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lighting_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        ListRecyclerAdapter recyclerAdapter = new ListRecyclerAdapter(this, createItemList(), imageArray);
        recyclerView.setAdapter(recyclerAdapter);
    }

    private List<String> createItemList() {
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < types.length; i++) {
            list.add(types[i]);
        }
        return list;
    }

    // references to our images
    public Integer[] imageArray = {
            R.drawable.striplights,
            R.drawable.lights2
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {

            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
