package hidetut.fix.j2gliteware.camper1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (Exception e) {

                }
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
            }
        }.start();

    }
}
