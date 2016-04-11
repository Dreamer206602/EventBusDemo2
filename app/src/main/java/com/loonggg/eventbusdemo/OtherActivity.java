package com.loonggg.eventbusdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class OtherActivity extends AppCompatActivity {

    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        EventBus.getDefault().register(this);
        tvContent= (TextView) findViewById(R.id.tvContent);
    }


    @Subscribe
    public void onEventMainThread(UserEvent event) {
        Log.d("otherActivity",event.getUserName());
        tvContent.setText(event.getUserName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
