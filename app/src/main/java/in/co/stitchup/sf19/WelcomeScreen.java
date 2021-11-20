package in.co.stitchup.sf19;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_welcome_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ImageView im = (ImageView)findViewById(R.id.imageView);
        TextView tm = (TextView)findViewById(R.id.textView13);

        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        im.startAnimation(anim);
        tm.startAnimation(anim);
        LogoLauncher l = new LogoLauncher();
        l.start();
    }
    private class LogoLauncher extends Thread
    {
        public void run()
        {
            try{
                sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            Intent in=new Intent(WelcomeScreen.this,MainActivity.class);
            startActivity(in);
            WelcomeScreen.this.finish();
        }

    }
}
