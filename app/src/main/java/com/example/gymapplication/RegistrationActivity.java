package com.example.gymapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class RegistrationActivity extends AppCompatActivity {

    private EditText emailTextView, passwordTextView,confirmpasswdView;
    private Button Btn;
    private FirebaseAuth mAuth;
    private TextView backtoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // taking FirebaseAuth instance
        mAuth = FirebaseAuth.getInstance();

        // initialising all views through id defined above
        emailTextView = findViewById(R.id.email);
        passwordTextView = findViewById(R.id.passwd);
        confirmpasswdView=findViewById(R.id.confirmpasswd);
        Btn = findViewById(R.id.btnregister);
        backtoLogin=findViewById(R.id.backtoLogin);

        //for comparing passwords
        String pw=passwordTextView.getText().toString();
        String cpw=confirmpasswdView.getText().toString();

        // Set on Click Listener on Registration button
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                registerNewUser();
            }
        });

        backtoLogin.setOnClickListener((View view)->{
            Intent i=new Intent(this,SignInActivity.class);
            startActivity(i);
        });
    }

    private void registerNewUser()
    {


        // Take the value of two edit texts in Strings
        String email, password,confirmpassword;
        email = emailTextView.getText().toString().trim();
        password = passwordTextView.getText().toString().trim();
        confirmpassword=confirmpasswdView.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(),
                    "Please enter email!!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(),
                    "Please enter password!!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }
        if (TextUtils.isEmpty(confirmpassword)) {
            Toast.makeText(getApplicationContext(),
                    "Please enter the confirm password!!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }


        if(password.equals(confirmpassword))
        {
            // create new user or register new user
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    Toast.makeText(getApplicationContext(),
                            "Registration successful!",
                            Toast.LENGTH_LONG)
                            .show();
                    if (!task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(),
                                "Auth failed..",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                    else {

                        RegistrationActivity.this.startActivity(new Intent(getApplicationContext(),SignInActivity.class));
                        Toast.makeText(getApplicationContext(),
                                "Sign In to continue",
                                Toast.LENGTH_LONG)
                                .show();
                        RegistrationActivity.this.finish();
                    }
                }
            });

        }
        else{
            Toast.makeText(this, "Password doesn't match", Toast.LENGTH_LONG).show();
        }
    }
}