package in.co.stitchup.sf19;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;

public class VerificationSup extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private DatabaseReference mMessageReference;
    private DatabaseReference databaseReference;
    private ValueEventListener mMessageListener;
    private EditText textfield;
    FirebaseAuth firebaseAuth;
    private  DatabaseReference db;
    private Button btn;
    String preseq;
    String cat;
    String email;
    String passw;
    String email1;
    String emails;
    String name ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        /*ImageView im = (ImageView)findViewById(R.id.imageView2);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(VerificationSup.this,SignUP.class);
                startActivity(in);
                VerificationSup.this.finish();
            }
        });
        */

        setContentView(R.layout.activity_verification_sup);
        db=FirebaseDatabase.getInstance().getReference("Emails");
        Intent in = getIntent();
        email1 = in.getStringExtra("email");

        cat = in.getStringExtra("cat");
        emails=in.getStringExtra("emails");
        passw = in.getStringExtra("pass");
        firebaseAuth = FirebaseAuth.getInstance();
        name = in.getStringExtra("name");
        email =email1;
        email = email.replace(".","_");
        email = email.replace("#","^");
        email = email.replace("$","+");
        email = email.replace("[","*");
        email = email.replace("]","/");
        databaseReference = FirebaseDatabase.getInstance().getReference("IDs/"+email+"/");


        mDatabase = FirebaseDatabase.getInstance().getReference();
        mMessageReference = FirebaseDatabase.getInstance().getReference("KEYS");
        textfield  = (EditText)findViewById(R.id.editText);
        btn = (Button) findViewById(R.id.buttonVerify);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keyarr[] = preseq.split(" ");
                Arrays.sort(keyarr);
                if(Arrays.binarySearch(keyarr,textfield.getText().toString().trim())>=0)
                {
                    /*SignUP su = new SignUP();
                    su.registerSciber(email1,passw,cat);
                    su.addUser(name,cat,email1);
                    */
                    registerUser(email1,passw);
                    addUser(name,cat,email1);


                    preseq = preseq.replace(textfield.getText().toString().trim()+" " ,"");
                    updateKey(preseq);
                    updateEmailList(emails+" "+email1);
                    if(cat.equalsIgnoreCase("School")){
                    Intent in = new Intent(VerificationSup.this,SignUpSchool.class);
                    in.putExtra("email",email);
                    startActivity(in);
                    VerificationSup.this.finish();
                    }
                    else {
                        Intent in = new Intent(VerificationSup.this,NewsFeed.class);
                        in.putExtra("email",email);
                        startActivity(in);
                        VerificationSup.this.finish();
                    }
                }
                else
                {
                    Toast.makeText(VerificationSup.this,"Wrong Key Try again!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        ValueEventListener messageListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    keys data = dataSnapshot.getValue(keys.class);

                    //Log.e(TAG, "onDataChange: Message data is updated: " +data.consumerName + ", " + data.consumerDob);

                    String ka[] = data.keys.split(" ");
                    preseq = data.keys;
                    //k.setText("No of Keys - "+ka.length);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Failed to read value
                //Log.e(TAG, "onCancelled: Failed to read message");
                //k.setText("failed");



            }
        };

        mMessageReference.addValueEventListener(messageListener);

        // copy for removing at onStop()
        mMessageListener = messageListener;
    }


    private void updateKey(String k)
    {
        keys data = new keys("KEYS",k);
        mDatabase.child("KEYS").setValue(data);
    }

    public void updateEmailList(String em)
    {
        Email data = new Email(em);
        db.setValue(data);
    }


    public void registerUser(String ema, String password)
    {
        firebaseAuth.createUserWithEmailAndPassword(ema, password).addOnCompleteListener(VerificationSup.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(VerificationSup.this.getApplicationContext(),
                            "SignUp unsuccessful: " + task.getException().getMessage(),
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(VerificationSup.this.getApplicationContext(),
                            "SignUp successful",
                            Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(MainActivity.this, UserActivity.class));
                }
            }
        });
    }

    public  void addUser(String name,String Category , String email)
    {
        email = email.replace(".","_");
        email = email.replace("#","^");
        email = email.replace("$","+");
        email = email.replace("[","*");
        email = email.replace("]","/");

        signUpPara sup = new signUpPara(email, name , Category);

        databaseReference.child(email).setValue(sup);
    }

}
