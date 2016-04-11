package com.loonggg.eventbusdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class OtherActivity extends AppCompatActivity {

    private Button btnContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        //EventBus.getDefault().register(this);
        btnContent= (Button) findViewById(R.id.btnContent);
        btnContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserEvent ue = new UserEvent();
                ue.setUserName("sssssssssssssss");
                EventBus.getDefault().post(ue);
                finish();
            }
        });
    }






    @Override
    protected void onDestroy() {
        super.onDestroy();
        //EventBus.getDefault().unregister(this);
    }
}
