package in.co.stitchup.sf19;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText et;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        progressDialog= new ProgressDialog(this);

        mAuth =FirebaseAuth.getInstance();

        et = (EditText)findViewById(R.id.sinem);
        Button bt= (Button)findViewById(R.id.buton);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Sending you E-Mail!!");
                progressDialog.show();
                String em = et.getText().toString();
                if(TextUtils.isEmpty(em))
                {
                    progressDialog.cancel();
                    Toast.makeText(ForgotPassword.this,"Please enter your email",Toast.LENGTH_LONG);
                    et.setError("Provide Your Email First!!");
                    et.requestFocus();


                }
                else
                {
                    mAuth.sendPasswordResetEmail(em).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(ForgotPassword.this,"Please check your inbox",Toast.LENGTH_LONG);
                                progressDialog.cancel();
                                startActivity(new Intent(ForgotPassword.this,SignIn.class));
                                ForgotPassword.this.finish();

                            }
                        }
                    });
                }
            }
        });
    }
}
/*
*
* em.setError("Provide your Email first!");
                                em.requestFocus();
* */