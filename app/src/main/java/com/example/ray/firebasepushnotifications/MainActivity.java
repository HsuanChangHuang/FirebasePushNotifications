package com.example.ray.firebasepushnotifications;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private TextView mProfileLabel;
    private TextView mUsersLabel;
    private TextView mNotificationLabel;

    private ViewPager mMainPager;

    private PagerViewAdapter mPagerViewAdapter;

    private FirebaseAuth mAuth;

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null){

            sendToLogin();
        }
    }

    private void sendToLogin() {
        Intent loginIntent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(loginIntent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        //Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        //startActivity(intent);

        mProfileLabel = (TextView)findViewById(R.id.profileLabel);
        mUsersLabel = (TextView)findViewById(R.id.usersLabel);
        mNotificationLabel = (TextView)findViewById(R.id.notificationsLabel);

        mMainPager = (ViewPager)findViewById(R.id.mainPager);
        mMainPager.setOffscreenPageLimit(2);

        mPagerViewAdapter = new PagerViewAdapter(getSupportFragmentManager());
        mMainPager.setAdapter(mPagerViewAdapter);

        mProfileLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mMainPager.setCurrentItem(0);
            }
        });

        mUsersLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mMainPager.setCurrentItem(1);
            }
        });

        mNotificationLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mMainPager.setCurrentItem(2);
            }
        });
        mMainPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                changeTabs(position);
                
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void changeTabs(int position) {

        if ( position == 0){
            mProfileLabel.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.textTabBright));
            mProfileLabel.setTextSize(24);

            //API 23 以上新用法
            //mUsersLabel.setTextColor(getColor(R.color.textTabLight));
            mUsersLabel.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.textTabLight));
            mUsersLabel.setTextSize(18);

            mNotificationLabel.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.textTabLight));
            mNotificationLabel.setTextSize(18);
        }

        if ( position == 1){
            mProfileLabel.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.textTabLight));
            mProfileLabel.setTextSize(18);

            mUsersLabel.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.textTabBright));
            mUsersLabel.setTextSize(24);

            mNotificationLabel.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.textTabLight));
            mNotificationLabel.setTextSize(18);
        }

        if ( position == 2){
            mProfileLabel.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.textTabLight));
            mProfileLabel.setTextSize(18);

            mUsersLabel.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.textTabLight));
            mUsersLabel.setTextSize(18);

            mNotificationLabel.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.textTabBright));
            mNotificationLabel.setTextSize(24);
        }
    }
}
