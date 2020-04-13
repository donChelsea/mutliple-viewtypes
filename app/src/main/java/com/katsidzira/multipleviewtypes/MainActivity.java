package com.katsidzira.multipleviewtypes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Item> itemList = new ArrayList<>();

        itemList.add(new Item("Tom", "Dentist", "male"));
        itemList.add(new Item("Jill", "Nurse", "female"));
        itemList.add(new Item("Sandy", "Clerk", "female"));
        itemList.add(new Item("John", "Plumber", "male"));
        itemList.add(new Item("Heather", "Teacher", "female"));
        itemList.add(new Item("Phil", "Banker", "male"));

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setAdapter(new ItemAdapter(itemList));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
