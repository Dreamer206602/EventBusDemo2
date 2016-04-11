package com.loonggg.eventbusdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;


public class OneFragment extends Fragment {
    private Button btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        btn = (Button) view.findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener(

        ) {
            @Override
            public void onClick(View v) {
                UserEvent ue = new UserEvent();
                ue.setUserName("smart_android");
                EventBus.getDefault().post(ue);
            }
        });
        return view;
    }


}
