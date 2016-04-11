package com.loonggg.eventbusdemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import org.greenrobot.eventbus.EventBus;

public class EventTestService extends Service {
    public EventTestService() {
    }


    @Override
    public IBinder onBind(Intent intent) {
        return new Binder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new MyServerThread().start();

        return super.onStartCommand(intent, flags, startId);
    }

    class MyServerThread extends Thread {
        @Override
        public void run() {
            EventBus.getDefault().post(new UserEvent("hi，我是Service"));
        }
    }
}
