package com.example.animatedlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.res.TypedArray;
import android.os.Bundle;

import com.example.animatedlist.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding bi;
    List<Person> list;
    RecyclerAnimationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_main);

        init();

    }

    private void init() {
        list = getData();
        list.addAll(getData());
        list.addAll(getData());
        list.addAll(getData());
        list.addAll(getData());
        list.addAll(getData());

        initRecyclerView();
    }

    private void initRecyclerView() {

        adapter = new RecyclerAnimationAdapter(this, list);
        bi.myList.setLayoutManager(new LinearLayoutManager(this));
        bi.myList.setAdapter(adapter);


    }


    List<Person> getData() {
        List<Person> list = new ArrayList<>();
        TypedArray imagesArray = getResources().obtainTypedArray(R.array.people_images);
        String[] names = getResources().getStringArray(R.array.people_names);

        for (int i = 0; i < imagesArray.length(); i++) {
            Person person = new Person();
            person.name = names[i];
            person.image = imagesArray.getResourceId(i, -1);
            list.add(person);
        }
        Collections.shuffle(list);
        return list;
    }
}
