package hidetut.fix.j2gliteware.camper1.dashboard.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import hidetut.fix.j2gliteware.camper1.R;

public class ItemDetailActivity extends AppCompatActivity {

    CollapsingToolbarLayout collapsingToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        setSupportActionBar(toolbar);

        ImageView imageView = (ImageView)findViewById(R.id.htab_detail_header);
        FrameLayout coolingLayout = (FrameLayout)findViewById(R.id.coolingLayout);
        FrameLayout energyLayout = (FrameLayout)findViewById(R.id.energyLayout);
        FrameLayout gasLayout = (FrameLayout)findViewById(R.id.gasLayout);
        FrameLayout lightingLayout = (FrameLayout)findViewById(R.id.lightingLayout);
        FrameLayout soilLayout = (FrameLayout)findViewById(R.id.soilLayout);
        FrameLayout soundLayout = (FrameLayout)findViewById(R.id.soundLayout);
        FrameLayout tempLayout = (FrameLayout)findViewById(R.id.tempLayout);
        FrameLayout timeLayout = (FrameLayout)findViewById(R.id.timeLayout);
        FrameLayout waterLayout = (FrameLayout)findViewById(R.id.waterLayout);

        coolingLayout.setVisibility(LinearLayout.GONE);
        energyLayout.setVisibility(LinearLayout.GONE);
        gasLayout.setVisibility(LinearLayout.GONE);
        lightingLayout.setVisibility(LinearLayout.GONE);
        soilLayout.setVisibility(LinearLayout.GONE);
        soundLayout.setVisibility(LinearLayout.GONE);
        tempLayout.setVisibility(LinearLayout.GONE);
        timeLayout.setVisibility(LinearLayout.GONE);
        waterLayout.setVisibility(LinearLayout.GONE);


        Intent i = getIntent();
        String title = i.getStringExtra("Title");
        int image = i.getIntExtra("Image", 0);
        imageView.setImageResource(image);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title);

        switch(title) {
            case "Fan":
                coolingLayout.setVisibility(LinearLayout.VISIBLE);
                return;
            case "Buzzer Alarm":
                soundLayout.setVisibility(LinearLayout.VISIBLE);
                return;
            case "Solar|Battery":
                energyLayout.setVisibility(LinearLayout.VISIBLE);
                return;
            case "Liquidizer":
                waterLayout.setVisibility(LinearLayout.VISIBLE);
                return;
            case "RTC Clock":
                timeLayout.setVisibility(LinearLayout.VISIBLE);
                return;
            case "Methane|Carbon":
                gasLayout.setVisibility(LinearLayout.VISIBLE);
                return;
            case "Soil Measure":
                soilLayout.setVisibility(LinearLayout.VISIBLE);
                return;
            case "Humidifier Sensor":
                tempLayout.setVisibility(LinearLayout.VISIBLE);
                return;
            case "Strip Lights":
                lightingLayout.setVisibility(LinearLayout.VISIBLE);
                return;
            case "Piranha Lights":
                lightingLayout.setVisibility(LinearLayout.VISIBLE);
                return;
            default:
        }



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {

            case android.R.id.home:
                // this will make sure the place from the original list is held
                supportFinishAfterTransition();
                //finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
