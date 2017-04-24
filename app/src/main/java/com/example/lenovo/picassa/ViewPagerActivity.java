package com.example.lenovo.picassa;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ViewPagerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        Intent intent = getIntent();
        String[] android_image_urls = intent.getStringArrayExtra("string-array");


        ViewPager viewPager= (ViewPager) findViewById(R.id.viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, android_image_urls);
        viewPager.setAdapter(viewPagerAdapter);
    }
}
