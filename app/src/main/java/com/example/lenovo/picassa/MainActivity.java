package com.example.lenovo.picassa;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private final String android_version_names[] = {
            "Donut",
            "Eclair",
            "Froyo",
            "Gingerbread",
            "Honeycomb",
            "Ice Cream Sandwich",
            "Jelly Bean",
            "KitKat",
            "Lollipop",
            "Marshmallow"
    };

    private final String android_image_urls[] = {
            "https://api.learn2crack.com/android/images/donut.png",
            "https://api.learn2crack.com/android/images/eclair.png",
            "https://api.learn2crack.com/android/images/froyo.png",
            "https://api.learn2crack.com/android/images/ginger.png",
            "https://api.learn2crack.com/android/images/honey.png",
            "https://api.learn2crack.com/android/images/icecream.png",
            "https://api.learn2crack.com/android/images/jellybean.png",
            "https://api.learn2crack.com/android/images/kitkat.png",
            "https://api.learn2crack.com/android/images/lollipop.png",
            "https://api.learn2crack.com/android/images/marshmallow.png"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();
    }

    private void initViews() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList image = prepareData();
        DataAdapter adapter = new DataAdapter(getApplicationContext(), image);
        recyclerView.setAdapter(adapter);

    }

    private ArrayList prepareData() {

        ArrayList image_version = new ArrayList<>();
        for (int i = 0; i < android_version_names.length; i++) {
            Image image = new Image();
            image.setAndroid_version_name(android_version_names[i]);
            image.setAndroid_image_url(android_image_urls[i]);
            image_version.add(image);
        }
        return image_version;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(this, ViewPagerActivity.class);
        intent.putExtra("string-array", android_image_urls);
        intent.putExtra("img-position", android_image_urls[position]);
        startActivity(intent);

    }

}
