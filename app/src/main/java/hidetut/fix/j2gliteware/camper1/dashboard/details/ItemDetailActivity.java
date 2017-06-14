package hidetut.fix.j2gliteware.camper1.dashboard.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import hidetut.fix.j2gliteware.camper1.R;

public class ItemDetailActivity extends AppCompatActivity {

    CollapsingToolbarLayout collapsingToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooling_item_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        setSupportActionBar(toolbar);

        ImageView imageView = (ImageView)findViewById(R.id.htab_detail_header);

        Intent i = getIntent();
        String title = i.getStringExtra("Title");
        int image = i.getIntExtra("Image", 0);
        imageView.setImageResource(image);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title);

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
