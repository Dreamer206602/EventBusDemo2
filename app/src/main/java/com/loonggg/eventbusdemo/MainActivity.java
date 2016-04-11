package com.loonggg.eventbusdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends Activity {
    private Button btn, fragment_btn;
    private TextView service_tv;
    private Button atyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method   stub
                Intent intent = new Intent(MainActivity.this,
                        SecondActivity.class);
                startActivity(intent);
            }
        });
        fragment_btn = (Button) findViewById(R.id.fragment_btn);
        fragment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        FragmenTestActivity.class);
                startActivity(intent);
            }
        });
        service_tv = (TextView) findViewById(R.id.service_tv);
        startService(new Intent(this, EventTestService.class));

        atyBtn= (Button) findViewById(R.id.aty_btn);
        atyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                 UserEvent ue = new UserEvent();
//                ue.setUserName("sssssssssssssss");
//                EventBus.getDefault().post(ue);
                startActivity(new Intent(MainActivity.this,OtherActivity.class));
            }
        });
    }

    @Subscribe
    public void onEventMainThread(UserEvent event) {
        Log.d("MainActivity",event.getUserName());
        btn.setText(event.getUserName());
        service_tv.setText(event.getUserName());
        atyBtn.setText(event.getUserName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }




}
