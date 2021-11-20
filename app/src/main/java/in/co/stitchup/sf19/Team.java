package in.co.stitchup.sf19;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class Team extends AppCompatActivity {
    String names[]={"Arnav Sharma","Aryaman Awasthi","Shreshtha Singh",
            "Anushka Singh","Prabhleen Kaur","Varun Jaiswal",
            "Shrey Dwivedi","Luv Srivastava","Ifraz Ahmad",
            "Aditya Jain","Aditi Gupta","Preksha Jain",
            "Isha Srivastava","Janvi Tiwari","Disha Mishra",
            "Shreya Maurya","Avikal Sinha"};


    String posts[]={"President","Technical Head","Vice President",
            "Secretary","Treasurer","Coding In Charge",
            "Designing In Charge","Web In Charge","Gaming In Charge",
            "Marketing Head","Literary Head","Creative Head",
            "School Decoration In Charge","Venue Decoration In Charge","Hospitality Head",
            "Logistics Head","Logistics Head"};


    String email[]={"arpush12@gmail.com",
            "aryaman.awasthi79@gmail.com",
            "chandelshreshtha@gmail.com",
            "anushkasingh081103@gmail.com",
            "prabhleenkaur2023@gmail.com",
            "vj.bro.833@gmail.com",
            "kemlin308@gmail.com",
            "srivastavluv007@gmail.com",
            "ifrazahmad@icloud.com",
            "adityajain0102@gmail.com",
            "aditiguptaa03@gmail.com",
            "jain.preksha0211@gmail.com",
            "isha.srivastava.78687@gmail.com",
            "tiwarijanvi20@gmail.com",
            "dishamsr2001@gmail.com",
            "shreya.maurya.215@gmail.com",
            "haravikal06@gmail.com"
            };


            String phno[]={ "9794169566",
                            "7007334949",
                            "9935882625",
                            "8090720587",
                            "9307990190",

                            "9532284201",
                            "7881113489",
                            "8765259256",
                            "7007144571",
                            "7408449965",
                            "7985311251",
                            "9389439374",
                            "9935606449",
                            "6392583572",
                            "7317280401",
                            "7355204447",
                            "7309905905"

            };


    Integer image[]={R.drawable.arnav,R.drawable.aryaman,R.drawable.shreshtha,
            R.drawable.anushka,R.drawable.prabhleen,R.drawable.varun,
            R.drawable.shrey,R.drawable.luv,R.drawable.ifraz,
            R.drawable.aditya,R.drawable.aditi,R.drawable.preksha,
            R.drawable.isha,R.drawable.janvi,R.drawable.disha,
            R.drawable.shreya,R.drawable.avikal};



    ListView lw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        CustomTeamAdapter ca = new CustomTeamAdapter(Team.this,names,posts,image);
        lw =(ListView)findViewById(R.id.list_view_team);
        lw.setAdapter(ca);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


    }

    public void sendToEmail(View view) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("email"));
        int position = (Integer)view.getTag();
        String s[]={email[position]};
        i.putExtra(Intent.EXTRA_EMAIL,s);
        i.setType("message/rfc822");
        Intent chooser = Intent.createChooser(i,"Launch Email");
        startActivity(chooser);

    }

    public void sendToCall(View view) {
        Intent i = new Intent(Intent.ACTION_DIAL);
        int position = (Integer)view.getTag();
        String num = phno[position];
        i.setData(Uri.parse("tel:"+num));
        startActivity(i);
    }
}
