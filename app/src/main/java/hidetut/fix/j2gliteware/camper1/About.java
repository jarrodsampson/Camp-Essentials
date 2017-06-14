package hidetut.fix.j2gliteware.camper1;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final FrameLayout flHolder = (FrameLayout)findViewById(R.id.about);


        AboutView view = AboutBuilder.with(this)
                .setAppIcon(R.drawable.tent)
                .setAppName(R.string.app_name)
                .setPhoto(R.drawable.me)
                .setCover(R.drawable.sunset)
                .setIconColor(Color.parseColor("#e67e22"))
                .setVersionNameAsAppSubTitle()
                .setLinksAnimated(true)
                .setDividerDashGap(13)
                .setName("Jarrod Sampson")
                .setSubTitle("Software Engineer")
                .setLinksColumnsCount(3)
                .setBrief("I am a software engineer who focuses on creating awesome software on the web and mobile.")
                .addGooglePlayStoreLink("7864337768608157526")
                .addGitHubLink("planlodge")
                .addFacebookLink("jarrodsampson11")
                .addLinkedInLink("jarrodsampson")
                .addEmailLink("jarrod.sampson91@gmail.com")
                .addWebsiteLink("https://planlodge.com")
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .setActionsColumnsCount(2)
                .addFeedbackAction("jarrod.sampson91@gmail.com")
                .addHelpAction(helpIntent())
                .addDonateAction(donateIntent())
                .setWrapScrollView(true)
                .setShowAsCard(false)
                .build();

        flHolder.addView(view);

    }

    public Intent helpIntent() {
        return new Intent(About.this, HelpActivity.class);
    }

    public Intent donateIntent() {
        return new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://ko-fi.com/jarrodsampson"));
    }


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
