package in.co.stitchup.sf19;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpSchool extends AppCompatActivity {
    private EditText p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17;

    private Button btn;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_school);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        btn=(Button) findViewById(R.id.continueButt);
        databaseReference = FirebaseDatabase.getInstance().getReference("Participants");
        Intent in = getIntent();
        final String email = in.getStringExtra("email");

        p1 = (EditText)findViewById(R.id.participant1);
        p2 = (EditText)findViewById(R.id.participant2);
        p3 = (EditText)findViewById(R.id.participant3);
        p4 = (EditText)findViewById(R.id.participant4);
        p5 = (EditText)findViewById(R.id.participant5);
        p6 = (EditText)findViewById(R.id.participant6);
        p7 = (EditText)findViewById(R.id.participant7);
        p8 = (EditText)findViewById(R.id.participant8);
        p9 = (EditText)findViewById(R.id.participant9);
        p10 = (EditText)findViewById(R.id.participant10);
        p11 = (EditText)findViewById(R.id.participant11);
        p12 = (EditText)findViewById(R.id.participant12);
        p13 = (EditText)findViewById(R.id.participant13);
        p14 = (EditText)findViewById(R.id.participant14);
        p15 = (EditText)findViewById(R.id.participant15);
        p16 = (EditText)findViewById(R.id.participant1L);
        p17 = (EditText)findViewById(R.id.participant2L);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17;

                s1 = p1.getText().toString().trim();
                s2 = p2.getText().toString().trim();
                s3 = p3.getText().toString().trim();
                s4 = p4.getText().toString().trim();
                s5 = p5.getText().toString().trim();
                s6 = p6.getText().toString().trim();
                s7 = p7.getText().toString().trim();
                s8 = p8.getText().toString().trim();
                s9 = p9.getText().toString().trim();
                s10 = p10.getText().toString().trim();
                s11 = p11.getText().toString().trim();
                s12 = p12.getText().toString().trim();
                s13 = p13.getText().toString().trim();
                s14 = p14.getText().toString().trim();
                s15 = p15.getText().toString().trim();
                s16 = p16.getText().toString().trim();
                s17 = p17.getText().toString().trim();


                addParicipants(email,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17);
                Intent in = new Intent(SignUpSchool.this,EventsParticipants.class);
                String par=""+" "+s1+" "+s2+" "+s3+" "+s4+" "+s5+" "+s6+" "+s7+" "+s8+" "+s9+" "+s10+" "+s11+" "+s12+" "+s13+" "+s14+" "+s15;

                String arr[]=par.split(" ");
                in.putExtra("par",arr);
                in.putExtra("lc",((s16+" "+s17)));
                in.putExtra("email",email);
                /*in.putExtra("p1",s1);
                in.putExtra("p2",s2);
                in.putExtra("p3",s3);
                in.putExtra("p4",s4);
                in.putExtra("p1",s5);
                in.putExtra("p1",s6);
                in.putExtra("p1",s7);
                in.putExtra("p1",s8);
                in.putExtra("p1",s9);
                in.putExtra("p1",s10);
                in.putExtra("p1",s11);
                in.putExtra("p1",s12);
                in.putExtra("p1",s13);
                in.putExtra("p1",s14);
                in.putExtra("p1",s15);
                in.putExtra("p16",s16);
                in.putExtra("p17",s17);*/

                startActivity(in);

            }
        });





    }
    public void addParicipants(String email,String z1,String z2, String z3,String z4,String z5, String z6,String z7,String z8, String z9,String z10,String z11, String z12,String z13,String z14, String z15,String z16,String z17)
    {
        AddParticipants sup = new AddParticipants(email,z1,z2,z3,z4,z5,z6,z7,z8,z9,z10,z11,z12,z13,z14,z15,z16,z17);
        databaseReference.child(email).setValue(sup);
    }

}
