package com.nandha.fmstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

public class addNewFurniture extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_furniture);
    }

    public void newFurniture(View view) {
        String name = String.valueOf(((EditText)findViewById(R.id.nameInput)).getText());
        String desc = String.valueOf(((EditText)findViewById(R.id.descInput)).getText());
        String price = String.valueOf(((EditText)findViewById(R.id.priceInput)).getText());
        String deliveryCharge = String.valueOf(((EditText)findViewById(R.id.deliveryInput)).getText());

        if((!name.isEmpty() && !desc.isEmpty()) && (!price.isEmpty() && !deliveryCharge.isEmpty())){
            Furniture f = new Furniture();
            f.setName(name);
            f.setPrice(Integer.parseInt(price));
            f.setDeleveryCharge(Integer.parseInt(deliveryCharge));
            f.setDiscription(desc);
            FirebaseDatabase.getInstance().getReference("/").push().setValue(f).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    finish();
                }
            });
        }else{
            Toast.makeText(this, "Fill all the fields", Toast.LENGTH_SHORT).show();
        }
    }

}
