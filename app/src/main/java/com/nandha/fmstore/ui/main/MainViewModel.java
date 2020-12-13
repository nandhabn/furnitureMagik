package com.nandha.fmstore.ui.main;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nandha.fmstore.Furniture;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private List<Furniture> furnitures;
    MutableLiveData<List<Furniture>> fObserver;
    public LiveData<List<Furniture>> getFurniture() {
        if(fObserver == null){
            fObserver = new MutableLiveData<List<Furniture>>();
        }
        fObserver.setValue(furnitures);
        return fObserver;
    }


    public void add(Furniture f){
        furnitures.add(f);
    }

    public void loadFurniture() {
        // Do an asynchronous operation to fetch users.
        if (furnitures == null) {
            furnitures = new ArrayList<Furniture>();
        }
        DatabaseReference mFirebaseDatabase = FirebaseDatabase.getInstance().getReference("/");
        mFirebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                furnitures = new ArrayList<Furniture>();
                for (DataSnapshot snap : snapshot.getChildren()){
                    furnitures.add(snap.getValue(Furniture.class));
                }
                fObserver.setValue(furnitures);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}

