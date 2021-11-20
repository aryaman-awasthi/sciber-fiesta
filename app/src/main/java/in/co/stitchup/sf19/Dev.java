package in.co.stitchup.sf19;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Dev extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_dev);
    }

    public void sendToEmail(View view) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("email"));

        String s[]={"aryaman.awasthi79@gmail.com"};
        i.putExtra(Intent.EXTRA_EMAIL,s);
        i.setType("message/rfc822");
        Intent chooser = Intent.createChooser(i,"Launch Email");
        startActivity(chooser);

    }

    public void sendToCall(View view) {
        Intent i = new Intent(Intent.ACTION_DIAL);

        String num = "7007334949";
        i.setData(Uri.parse("tel:"+num));
        startActivity(i);
    }
}
