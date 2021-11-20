package in.co.stitchup.sf19;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

public class SignIn extends AppCompatActivity {
    private EditText em,pasw;
    private Button btn;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference mDatabase;
    private DatabaseReference mMessageReference;
    private ValueEventListener mMessageListener;
    private String emailId;
     String  email;
     String userEmail1;
     String userPaswd1;

     ProgressDialog progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ImageView im = (ImageView)findViewById(R.id.backbut1);
        progressbar =new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        em= (EditText) findViewById(R.id.sinem);
        pasw = (EditText) findViewById(R.id.sinpass);
        btn  = (Button) findViewById(R.id.sinbutt);
        TextView SUP=(TextView)findViewById(R.id.signup);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        SUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(SignIn.this,SignUP.class);
                startActivity(in);
                SignIn.this.finish();
            }
        });

        userEmail1 = em.getText().toString();
        userPaswd1 = pasw.getText().toString();


        TextView we=(TextView)findViewById(R.id.needhelp);
        we.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignIn.this,ForgotPassword.class));
                SignIn.this.finish();
            }
        });

        /*email = userEmail1.replace("_",".");
        email = email.replace("^","#");
        email = email.replace("+","$");
        email = email.replace("*","[");
        email = email.replace("/","]");*/

        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(SignIn.this,MainActivity.class);
                startActivity(in);
                SignIn.this.finish();
            }
        });


        //Signin Start from Here

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                progressbar.setMessage("Loging you in");
                progressbar.show();
                final String userEmail= em.getText().toString().trim();
                String userPaswd = pasw.getText().toString();


                if (userEmail.isEmpty()) {
                    progressbar.cancel();
                    em.setError("Provide your Email first!");
                    em.requestFocus();
                } else if (userPaswd.isEmpty()) {
                    progressbar.cancel();
                    pasw.setError("Enter Password!");
                    pasw.requestFocus();
                } else if (userEmail.isEmpty() && userPaswd.isEmpty()) {
                    progressbar.cancel();
                    Toast.makeText(SignIn.this, "Fields Empty!", Toast.LENGTH_SHORT).show();
                } else if (!(userEmail.isEmpty() && userPaswd.isEmpty())) {
                    firebaseAuth.signInWithEmailAndPassword(userEmail, userPaswd)
                            .addOnCompleteListener(SignIn.this, new OnCompleteListener() {
                        @Override
                        public void onComplete(@NonNull Task task) {
                            if (!task.isSuccessful())
                            {
                                progressbar.cancel();
                                Toast.makeText(SignIn.this.getApplicationContext(),
                                        "Signin unsuccessful: " + task.getException().getMessage(),
                                        Toast.LENGTH_SHORT).show();
                                //Toast.makeText(SignIn.this, "Not sucessfull", Toast.LENGTH_SHORT).show();
                            }
                            else
                                {
                                    progressbar.cancel();
                                    email = userEmail.replace(".","_");
                                    email = email.replace("#","^");
                                    email = email.replace("$","+");
                                    email = email.replace("[","*");
                                    email = email.replace("]","/");

                                    Intent in = new Intent(SignIn.this,NewsFeed.class);
                                    startActivity(in);
                                    SignIn.this.finish();

                                    /*Intent j = new Intent(SignIn.this,TESTREAD.class);
                                    j.putExtra("email",email);
                                    startActivity(j);*/


                                }
                        }
                    });

                } else {
                    Toast.makeText(SignIn.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}
