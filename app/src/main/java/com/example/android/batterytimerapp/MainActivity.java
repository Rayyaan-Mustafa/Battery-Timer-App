package com.example.android.batterytimerapp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
    private TextView contentTxt;
    Activity loseText = this;
    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context arg0, Intent intent) {
            // TODO Auto-generated method stub
            int level = intent.getIntExtra("level", 0);
            contentTxt.setText(String.valueOf(level) + "%");

            if (level<2) {
                TimerTask endtimer = new TimerTask() {
                    @Override
                    public void run() {
                        Toast.makeText(loseText, "Time Up, You Lose!", Toast.LENGTH_LONG).show();
                    }
                };

                Timer timerObject = new Timer();
                timerObject.schedule(endtimer, 10000);
                
                }
            };
    };

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        contentTxt = (TextView) this.findViewById(R.id.monospaceTxt);
        this.registerReceiver(this.mBatInfoReceiver,
                new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
    /* TODO: Use this API (which returns a boolian) for shutting off the timer.
    public boolean isCharging(){
        
    }
        if( (level<2) && (isCharging() = true) ){
            code to stop the timer
            System.out.println("The Timer is off")
        }
    */
}
//we like pie


//hi people
