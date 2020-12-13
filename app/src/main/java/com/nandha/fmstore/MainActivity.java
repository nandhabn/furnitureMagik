package com.nandha.fmstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.nandha.fmstore.ui.main.MainFragment;
import com.nandha.fmstore.ui.main.MainViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        if (savedInstanceState == null) {
            if(FirebaseAuth.getInstance().getCurrentUser()!=null){
                finish();
                startActivity(new Intent(getBaseContext(),home.class));
            }
        }
        ((Button)findViewById(R.id.login)).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = String.valueOf(((EditText)findViewById(R.id.username)).getText());
                String password = String.valueOf(((EditText)findViewById(R.id.password)).getText());
                FirebaseAuth.getInstance().signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(getBaseContext(), home.class));
                        }else{
                            Toast.makeText(MainActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    public void addNewFurniture(View view) {
        startActivity(new Intent(getBaseContext(),addNewFurniture.class));
    }

}
