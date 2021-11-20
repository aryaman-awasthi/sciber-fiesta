package in.co.stitchup.sf19;

import android.app.usage.UsageEvents;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;

public class EventsParticipants extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    private DatabaseReference databaseReference;
    String []papt;
    String email;
    String[] Events = new String[27];
    String [] event = new String[27];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_participants);
        //databaseReference = FirebaseDatabase.getInstance().getReference("Events");
        Intent in = getIntent();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        papt=in.getStringArrayExtra("par");
        email= in.getStringExtra("email");
        Events[26]=in.getStringExtra("lc");
        databaseReference = FirebaseDatabase.getInstance().getReference("Events/"+email+"/");

        Spinner prot1=(Spinner)findViewById(R.id.ptp1);
        Spinner prot2=(Spinner)findViewById(R.id.ptp2);
        prot1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[0]=papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        prot2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[0]=Events[0]+papt[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Spinner cod1=(Spinner)findViewById(R.id.cdp1);
        Spinner cod2=(Spinner)findViewById(R.id.cdp2);
        cod1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[1]=papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        cod2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[1]=Events[1]+papt[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        Spinner var=(Spinner)findViewById(R.id.vap1);
        var.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[2]=papt[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Spinner otw=(Spinner)findViewById(R.id.otwp1);
        otw.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[3]=papt[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner crt=(Spinner)findViewById(R.id.cp1);
        crt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[4]=papt[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner cco=(Spinner)findViewById(R.id.ccp1);
        cco.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[5]=papt[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner doc=(Spinner)findViewById(R.id.dp1);
        doc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[6]=papt[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner aud=(Spinner)findViewById(R.id.aup1);
        aud.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[7]=papt[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner wom1=(Spinner)findViewById(R.id.womp1);
        Spinner wom2=(Spinner)findViewById(R.id.womp2);
        Spinner wom3=(Spinner)findViewById(R.id.womp3);
        wom1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[8]=papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        wom2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[8]=Events[8]+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        wom3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[8]=Events[8]+papt[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        Spinner mtw=(Spinner)findViewById(R.id.mtwip1);
        mtw.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[9]=papt[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner wb=(Spinner)findViewById(R.id.wbp1);
        wb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[10]=papt[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner dd=(Spinner)findViewById(R.id.ddp1);
        dd.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[11]=papt[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner pm1=(Spinner)findViewById(R.id.pmp1);
        Spinner pm2=(Spinner)findViewById(R.id.pmp2);
        Spinner pm3=(Spinner)findViewById(R.id.pmp3);
        Spinner pm4=(Spinner)findViewById(R.id.pmp4);
        Spinner pm5=(Spinner)findViewById(R.id.pmp5);
        Spinner pm6=(Spinner)findViewById(R.id.pmp6);
        Spinner pm7=(Spinner)findViewById(R.id.pmp7);
        Spinner pm8=(Spinner)findViewById(R.id.pmp8);
        Spinner pm9=(Spinner)findViewById(R.id.pmp9);
        Spinner pm10=(Spinner)findViewById(R.id.pmp10);

        pm1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[12]=papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        pm2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[12]=Events[12]+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        pm3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[12]=Events[12]+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        pm4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[12]=Events[12]+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        pm5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[12]=Events[12]+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        pm6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[12]=Events[12]+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        pm7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[12]=Events[12]+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        pm8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[12]=Events[12]+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        pm9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[12]=Events[12]+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        pm10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[12]=Events[12]+papt[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });






        Spinner ad=(Spinner)findViewById(R.id.alp1);
        ad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[13]=papt[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner rr=(Spinner)findViewById(R.id.rrp1);
        Spinner rr2=(Spinner)findViewById(R.id.rrp2);
        rr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[14]=papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        rr2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[14]=Events[14]+papt[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Spinner cm1=(Spinner)findViewById(R.id.cmp1);
        Spinner cm2=(Spinner)findViewById(R.id.cmp2);
        cm1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[15]=papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        cm2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[15]=Events[15]+papt[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner th=(Spinner)findViewById(R.id.thp1);
        th.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[16]=papt[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Spinner ap1=(Spinner)findViewById(R.id.app1);
        Spinner ap2=(Spinner)findViewById(R.id.app2);
        ap1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[17]=papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ap2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[17]=Events[17]+papt[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner ie1=(Spinner)findViewById(R.id.iep1);
        Spinner ie2=(Spinner)findViewById(R.id.iep2);
        ie1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[18]=papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ie2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[18]=Events[18]+papt[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //18

        Spinner ppp1=(Spinner)findViewById(R.id.pppp1);
        Spinner ppp2=(Spinner)findViewById(R.id.pppp2);
        Spinner ppp3=(Spinner)findViewById(R.id.pppp3);
        Spinner ppp4=(Spinner)findViewById(R.id.pppp4);
        ppp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[19]=papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ppp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[19]=Events[19]+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ppp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[19]=Events[19]+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ppp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[19]=Events[19]+papt[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //19

        Spinner ttt1=(Spinner)findViewById(R.id.tttp1);
        Spinner ttt2=(Spinner)findViewById(R.id.tttp2);
        Spinner ttt3=(Spinner)findViewById(R.id.tttp3);
        Spinner ttt4=(Spinner)findViewById(R.id.tttp4);
        ttt1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[20]=papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ttt2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[20]=Events[20]+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ttt3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[20]=Events[20]+" "+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ttt4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[20]=Events[20]+papt[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //21

        Spinner bs1=(Spinner)findViewById(R.id.bsp1);
        Spinner bs2=(Spinner)findViewById(R.id.bsp2);
        Spinner bs3=(Spinner)findViewById(R.id.bsp3);
        Spinner bs4=(Spinner)findViewById(R.id.bsp4);
        bs1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[21]=papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        bs2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[21]=Events[21]+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        bs3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[21]=Events[21]+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        bs4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[21]=Events[21]+papt[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //22

        Spinner mob1=(Spinner)findViewById(R.id.mobp1);
        Spinner mob2=(Spinner)findViewById(R.id.mobp2);
        mob1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[22]=papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mob2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[22]=Events[22]+papt[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //23

        Spinner e1=(Spinner)findViewById(R.id.ep1);
        Spinner e2=(Spinner)findViewById(R.id.ep2);
        e1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[23]=papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        e2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[0]=Events[23]+papt[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //24

        Spinner b1=(Spinner)findViewById(R.id.bp1);
        Spinner b2=(Spinner)findViewById(R.id.bp2);
        Spinner b3=(Spinner)findViewById(R.id.bp3);
        Spinner b4=(Spinner)findViewById(R.id.bp4);
        Spinner b5=(Spinner)findViewById(R.id.bp5);
        Spinner b6=(Spinner)findViewById(R.id.bp6);
        Spinner b7=(Spinner)findViewById(R.id.bp7);
        Spinner b8=(Spinner)findViewById(R.id.bp8);
        b1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[24]=papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        b2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[24]=Events[24]+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        b3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[24]=Events[24]+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        b4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[24]=Events[24]+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        b5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[24]=Events[24]+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        b6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[24]=Events[24]+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        b7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[24]=Events[24]+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        b8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[24]=Events[24]+papt[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //25

        Spinner dat1=(Spinner)findViewById(R.id.datp1);
        Spinner dat2=(Spinner)findViewById(R.id.datp2);
        Spinner dat3=(Spinner)findViewById(R.id.datp3);
        Spinner dat4=(Spinner)findViewById(R.id.datp4);
        Spinner dat5=(Spinner)findViewById(R.id.datp5);
        Spinner dat6=(Spinner)findViewById(R.id.datp6);
        Spinner dat7=(Spinner)findViewById(R.id.datp7);
        Spinner dat8=(Spinner)findViewById(R.id.datp8);
        Spinner dat9=(Spinner)findViewById(R.id.datp9);
        Spinner dat10=(Spinner)findViewById(R.id.datp10);
        dat1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[25]=papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dat2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[25]=Events[25]+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dat3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[25]=Events[25]+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dat4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[25]=Events[25]+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dat5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[25]=Events[25]+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dat6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[25]=Events[25]+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dat7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[25]=Events[25]+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dat8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[25]=Events[25]+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dat9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[25]=Events[25]+papt[position]+" ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dat10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Events[25]=Events[25]+papt[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });







        /*prot1.setOnItemSelectedListener(this);
        prot2.setOnItemSelectedListener(this);*/
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, R.layout.spinner_item,papt);

        prot1.setAdapter(aa);
        prot2.setAdapter(aa);

        cod1.setAdapter(aa);
        cod2.setAdapter(aa);
        var.setAdapter(aa);
        cod1.setAdapter(aa);
        otw.setAdapter(aa);
        crt.setAdapter(aa);
        cco.setAdapter(aa);
        doc.setAdapter(aa);
        aud.setAdapter(aa);
        wom1.setAdapter(aa);
        wom2.setAdapter(aa);
        wom3.setAdapter(aa);
        mtw.setAdapter(aa);
        wb.setAdapter(aa);
        dd.setAdapter(aa);
        pm1.setAdapter(aa);
        pm2.setAdapter(aa);
        pm3.setAdapter(aa);
        pm4.setAdapter(aa);
        pm5.setAdapter(aa);
        pm6.setAdapter(aa);
        pm7.setAdapter(aa);
        pm8.setAdapter(aa);
        pm9.setAdapter(aa);
        pm10.setAdapter(aa);
        ad.setAdapter(aa);
        rr.setAdapter(aa);
        rr2.setAdapter(aa);
        cm1.setAdapter(aa);
        cm2.setAdapter(aa);
        th.setAdapter(aa);
        ap1.setAdapter(aa);
        ap2.setAdapter(aa);
        ie1.setAdapter(aa);
        ie2.setAdapter(aa);
        ppp1.setAdapter(aa);
        ppp2.setAdapter(aa);
        ppp3.setAdapter(aa);
        ppp4.setAdapter(aa);
        ttt1.setAdapter(aa);
        ttt2.setAdapter(aa);
        ttt3.setAdapter(aa);
        ttt4.setAdapter(aa);
        bs1.setAdapter(aa);
        bs2.setAdapter(aa);
        bs3.setAdapter(aa);
        bs4.setAdapter(aa);
        mob1.setAdapter(aa);
        mob2.setAdapter(aa);
        e1.setAdapter(aa);
        e2.setAdapter(aa);

        b1.setAdapter(aa);
        b2.setAdapter(aa);
        b3.setAdapter(aa);
        b4.setAdapter(aa);
        b5.setAdapter(aa);
        b6.setAdapter(aa);
        b7.setAdapter(aa);
        b8.setAdapter(aa);


        dat1.setAdapter(aa);
        dat2.setAdapter(aa);
        dat3.setAdapter(aa);
        dat4.setAdapter(aa);
        dat5.setAdapter(aa);
        dat6.setAdapter(aa);
        dat7.setAdapter(aa);
        dat8.setAdapter(aa);
        dat9.setAdapter(aa);
        dat10.setAdapter(aa);


        String s= "prot"+" cd"+" var"+" otw"+" crt"+" cco"+" doc"+" aud"+" wom"+" mtw"+" wb"+" dd"+" pm"+" ad"+" rr"+" cm"+" th"+" ap"+" ie"+" ppp"+" ttt"+" bs"+" mob"+" e"+" b"+" dat"+" lc";
        event=s.split(" ");


        //event={"prot","cd","var","otw","crt","cco","doc","aud","wom","mtw","wb","dd","pm","ad","rr","cm","th","ap","ie","ppp","ttt","bs","mob","e","b","dat","lc"};


        Button btn = (Button)findViewById(R.id.SubmitButt);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i<27;i++)
                {
                    EventParticipantHandler eh = new EventParticipantHandler(event[i],Events[i]);
                    databaseReference.child(event[i]).setValue(Events[i]);
                }
                Toast.makeText(getApplicationContext(),"Participants registered Successfully",Toast.LENGTH_LONG).show();
                Intent in = new Intent(EventsParticipants.this,NewsFeed.class);
                startActivity(in);
                EventsParticipants.this.finish();


            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        //Toast.makeText(getApplicationContext(),papt[position] , Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}
