package com.sdust.wearsunshine;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends Activity {

    private TextView currentTimeView, currentDateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                String dateFormat = "EEE, MMM d yyyy";
                String timeFormat = "hh:mm a";
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
                SimpleDateFormat simpleTimeFormat = new SimpleDateFormat(timeFormat);
                String currentDate = simpleDateFormat.format(calendar.getTime());
                String currentTime = simpleTimeFormat.format(calendar.getTime());

                currentDateView = (TextView) stub.findViewById(R.id.current_date);
                currentTimeView = (TextView) stub.findViewById(R.id.current_time);
                currentDateView.setText(currentTime);
                currentTimeView.setText(currentDate);
            }
        });


    }
}
