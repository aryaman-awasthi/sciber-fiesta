package in.co.stitchup.sf19;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.Arrays;

public class SignUP extends AppCompatActivity {

    private EditText em,pasw,field,nameFull;
    private Button btn;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private DatabaseReference mDatabase;
    private DatabaseReference mMessageReference;
    private ValueEventListener mMessageListener;
    ProgressDialog progressDialog;
    String emailID,paswd,name;
    private String[] array={"Select Category","Participant School","Sciber Crew","Others"};
    String f;
    String x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mMessageReference=FirebaseDatabase.getInstance().getReference("Emails");
        progressDialog = new ProgressDialog(this);

        TextView siny = (TextView)findViewById(R.id.sin);
        siny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(SignUP.this,SignIn.class);
                startActivity(in);
                SignUP.this.finish();
            }
        });




        //Image Back Button



        ImageView im = (ImageView)findViewById(R.id.backbutt);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(SignUP.this,MainActivity.class);
                startActivity(in);
                SignUP.this.finish();
            }
        });

        //Signup Starts from Here

        firebaseAuth = FirebaseAuth.getInstance();
        em = (EditText)findViewById(R.id.email);
        pasw = (EditText) findViewById(R.id.password);
        btn = (Button)findViewById(R.id.signup2);

        nameFull = (EditText) findViewById(R.id.fullName);

        final String email = em.getText().toString().trim();

        databaseReference = FirebaseDatabase.getInstance().getReference("IDs/"+email+"/");


        Spinner s = (Spinner)findViewById(R.id.spinner);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                f= array[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, R.layout.spinner_item,array);
        s.setAdapter(aa);





        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Signing you up !");
                progressDialog.show();

                String arr[]={};

                try {
                    arr= x.split(" ");
                    Arrays.sort(arr);


                }catch (Exception e)
                {
                    progressDialog.cancel();
                    Toast.makeText(SignUP.this,"An Error Occured Try Again Later",Toast.LENGTH_SHORT);

                }
                emailID = em.getText().toString().toLowerCase().trim();
                paswd = pasw.getText().toString();
                name = nameFull.getText().toString().trim();

                if(Arrays.binarySearch(arr,emailID)>=0)
                {
                    progressDialog.cancel();
                    Toast.makeText(SignUP.this,"This email is already taken by some one. Try another !!",Toast.LENGTH_LONG).show();
                }
                else {
                        if(f.equalsIgnoreCase("School"))
                        {

                            if (emailID.isEmpty()) {
                                progressDialog.cancel();
                                em.setError("Provide your Email first!");
                                em.requestFocus();
                            } else if (paswd.isEmpty()) {
                                progressDialog.cancel();
                                pasw.setError("Set your password");
                                pasw.requestFocus();
                            } else if (emailID.isEmpty() && paswd.isEmpty()) {
                                progressDialog.cancel();
                                Toast.makeText(SignUP.this, "Fields Empty!", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                //registerSciber(emailID,paswd,f);
                                //addUser(name, f, emailID);
                                progressDialog.cancel();
                                Intent in =  new Intent(SignUP.this,VerificationSup.class);
                                in.putExtra("email",emailID);
                                in.putExtra("cat",f);
                                in.putExtra("emails",x);
                                in.putExtra("name",name);
                                in.putExtra("pass",paswd);
                                startActivity(in);
                            }


                        }
                        else if (f.equalsIgnoreCase("Sciber Crew"))
                        {

                            if (emailID.isEmpty()) {
                                progressDialog.cancel();
                                em.setError("Provide your Email first!");
                                em.requestFocus();
                            } else if (paswd.isEmpty()) {
                                progressDialog.cancel();
                                pasw.setError("Set your password");
                                pasw.requestFocus();
                            } else if (emailID.isEmpty() && paswd.isEmpty()) {
                                progressDialog.cancel();
                                Toast.makeText(SignUP.this, "Fields Empty!", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                //progressDialog.cancel();
                                //registerSciber(emailID,paswd,f);
                                //addUser(name, f, emailID);
                                Intent in =  new Intent(SignUP.this,VerificationSup.class);
                                in.putExtra("email",emailID);
                                in.putExtra("name",name);
                                in.putExtra("cat",f);
                                in.putExtra("pass",paswd);
                                in.putExtra("emails",x);
                                startActivity(in);
                            }

                        }
                        else if(f.equalsIgnoreCase("Others")||f.equalsIgnoreCase("Other"))
                        {
                            if (emailID.isEmpty()) {
                                progressDialog.cancel();
                                em.setError("Provide your Email first!");
                                em.requestFocus();
                            } else if (paswd.isEmpty()) {
                                progressDialog.cancel();
                                pasw.setError("Set your password");
                                pasw.requestFocus();
                            } else if (emailID.isEmpty() && paswd.isEmpty()) {
                                progressDialog.cancel();
                                Toast.makeText(SignUP.this, "Fields Empty!", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                progressDialog.cancel();
                                //registerOthers(emailID,paswd);

                                firebaseAuth.createUserWithEmailAndPassword(emailID, paswd).addOnCompleteListener(SignUP.this, new OnCompleteListener() {
                                    @Override
                                    public void onComplete(@NonNull Task task) {

                                        if (!task.isSuccessful()) {
                                            Toast.makeText(SignUP.this.getApplicationContext(),
                                                    "SignUp unsuccessful: " + task.getException().getMessage(),
                                                    Toast.LENGTH_SHORT).show();
                                        } else {
                                            addUser(name, f, emailID);
                                            Intent in =  new Intent(SignUP.this,NewsFeed.class);
                                            startActivity(in);
                                            SignUP.this.finish();
                                            Toast.makeText(SignUP.this.getApplicationContext(),
                                                    "SignUp successful",
                                                    Toast.LENGTH_SHORT).show();
                                            //startActivity(new Intent(MainActivity.this, UserActivity.class));
                                        }
                                    }
                                });

                            }

                        }
                        else
                        {
                            progressDialog.cancel();
                            Toast.makeText(SignUP.this, "Please give the valid input in the category box ",Toast.LENGTH_SHORT).show();
                        }


                }


            }
        });




    }



    public void registerSciber(String emailID, String paswd, String cat)
    {
        if (emailID.isEmpty()) {
            em.setError("Provide your Email first!");
            em.requestFocus();
        } else if (paswd.isEmpty()) {
            pasw.setError("Set your password");
            pasw.requestFocus();
        } else if (emailID.isEmpty() && paswd.isEmpty()) {
            Toast.makeText(SignUP.this, "Fields Empty!", Toast.LENGTH_SHORT).show();
        } else if (!(emailID.isEmpty() && paswd.isEmpty()))
        {
            if(cat.equalsIgnoreCase("Sciber Crew")||cat.equalsIgnoreCase("SciberCrew"))
            {
                firebaseAuth.createUserWithEmailAndPassword(emailID, paswd).addOnCompleteListener(SignUP.this, new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {

                        if (!task.isSuccessful()) {
                            Toast.makeText(SignUP.this.getApplicationContext(),
                                    "SignUp unsuccessful: " + task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SignUP.this.getApplicationContext(),
                                    "SignUp successful",
                                    Toast.LENGTH_SHORT).show();
                            //startActivity(new Intent(MainActivity.this, UserActivity.class));
                        }
                    }
                });
            }
            else
            {
                firebaseAuth.createUserWithEmailAndPassword(emailID, paswd).
                        addOnCompleteListener(SignUP.this, new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {

                        if (!task.isSuccessful()) {
                            Toast.makeText(SignUP.this.getApplicationContext(),
                                    "SignUp unsuccessful: " + task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SignUP.this.getApplicationContext(),
                                    "SignUp successful",
                                    Toast.LENGTH_SHORT).show();
                            //startActivity(new Intent(MainActivity.this, UserActivity.class));
                        }
                    }
                });

            }
        } else {
            Toast.makeText(SignUP.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }


    public void registerOthers(String emailID, String paswd)
    {
        if (emailID.isEmpty()) {
            em.setError("Provide your Email first!");
            em.requestFocus();
        } else if (paswd.isEmpty()) {
            pasw.setError("Set your password");
            pasw.requestFocus();
        } else if (emailID.isEmpty() && paswd.isEmpty()) {
            Toast.makeText(SignUP.this, "Fields Empty!", Toast.LENGTH_SHORT).show();
        } else if (!(emailID.isEmpty() && paswd.isEmpty())) {
            firebaseAuth.createUserWithEmailAndPassword(emailID, paswd).addOnCompleteListener(SignUP.this, new OnCompleteListener() {
                @Override
                public void onComplete(@NonNull Task task) {

                    if (!task.isSuccessful()) {
                        Toast.makeText(SignUP.this.getApplicationContext(),
                                "SignUp unsuccessful: " + task.getException().getMessage(),
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SignUP.this.getApplicationContext(),
                                "SignUp successful",
                                Toast.LENGTH_SHORT).show();
                        //startActivity(new Intent(MainActivity.this, UserActivity.class));
                    }
                }
            });
        } else {
            Toast.makeText(SignUP.this, "Error", Toast.LENGTH_SHORT).show();
        }
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

    @Override
    protected void onStart() {
        super.onStart();


        ValueEventListener messageListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Email data = dataSnapshot.getValue(Email.class);

                    //Log.e(TAG, "onDataChange: Message data is updated: " +data.consumerName + ", " + data.consumerDob);

                    String emailId = data.email;
                    x=emailId;
                   // Log.e(TAG, "onDataChange: Message data is updated: " +emailId + ", " + data.category);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Failed to read value
                //Log.e(TAG, "onCancelled: Failed to read message");
                //Toast.makeText(TESTREAD.this,"Some error occured. Try again !!!",Toast.LENGTH_SHORT ).show();

            }
        };

        mMessageReference.addValueEventListener(messageListener);

        // copy for removing at onStop()
        mMessageListener = messageListener;

    }
}
//'.', '#', '$', '[', or ']'