package in.co.stitchup.sf19;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }
    public void sendToEmail(View view) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("email"));

        String s[]={"info@sciberfiesta.org"};
        i.putExtra(Intent.EXTRA_EMAIL,s);
        i.setType("message/rfc822");
        Intent chooser = Intent.createChooser(i,"Launch Email");
        startActivity(chooser);

    }

    public void sendToCall(View view) {
        Intent i = new Intent(Intent.ACTION_DIAL);

        String num = "9794169566";
        i.setData(Uri.parse("tel:"+num));
        startActivity(i);
    }
}
