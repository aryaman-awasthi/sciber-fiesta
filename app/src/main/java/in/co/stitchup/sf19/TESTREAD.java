package in.co.stitchup.sf19;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TESTREAD extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private DatabaseReference mMessageReference;
    private ValueEventListener mMessageListener;
    private static final String TAG = "MessageActivity";
    private static final String REQUIRED = "Required";
    String userEmail1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testread);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Intent in = getIntent();
        userEmail1 = in.getStringExtra("email");
        String path = "IDs/"+userEmail1;
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mMessageReference = FirebaseDatabase.getInstance().getReference("IDs/"+userEmail1);

    }
    @Override
    protected void onStart() {
        super.onStart();

        ValueEventListener messageListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    SigninUser data = dataSnapshot.getValue(SigninUser.class);

                    //Log.e(TAG, "onDataChange: Message data is updated: " +data.consumerName + ", " + data.consumerDob);

                    String emailId = data.category;
                    Log.e(TAG, "onDataChange: Message data is updated: " +emailId + ", " + data.category);
                    if(emailId.equalsIgnoreCase("School"))
                    {
                        Intent in = new Intent(TESTREAD.this,SignUpSchool.class);
                        in.putExtra("email",userEmail1);
                        startActivity(in);
                        TESTREAD.this.finish();
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Failed to read value
                //Log.e(TAG, "onCancelled: Failed to read message");
                Toast.makeText(TESTREAD.this,"Some error occured. Try again !!!",Toast.LENGTH_SHORT ).show();

            }
        };

        mMessageReference.addValueEventListener(messageListener);

        // copy for removing at onStop()
        mMessageListener = messageListener;
    }
}
