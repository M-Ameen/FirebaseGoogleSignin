package com.example.firebasegooglesignin;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity {


    TextView email, name;
    ImageView profileimg;
    GoogleSignInClient googleSignInClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
        profileimg = findViewById(R.id.profileimg);

        GoogleSignInAccount googleSignInAccount= GoogleSignIn.getLastSignedInAccount(this);
        email.setText(googleSignInAccount.getEmail());
        name.setText(googleSignInAccount.getDisplayName());
        Glide.with(this).load(googleSignInAccount.getPhotoUrl()).into(profileimg);


    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        googleSignInClient.signOut();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));

    }
}