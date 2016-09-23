package com.yf.duitang.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yf.duitang.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WelcomeActivity extends Activity {

    // private final int MESSAGE_START_ACTIVITY = 0;
    // private Handler mHandler;
    @Bind(R.id.welcome_image)
    ImageView welcomeImage;

    @Bind(R.id.count_down_timer_text)
    TextView count_down_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);

        ButterKnife.bind(this);
        initView();
        /*
        一种实现自动开启下一个活动的方法，用handler
        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case MESSAGE_START_ACTIVITY:
                        Intent i = new Intent(WelcomeActivity.this, MainActivity.class);
                        startActivity(i);
                        finish();
                }
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message message = new Message();
                message.what = MESSAGE_START_ACTIVITY;
                mHandler.sendMessage(message);
            }
        }).start();
    */
    }

    // 第二种实现延时开启下一个活动的方法是使用CountDownTimer
    private void initView(){
        Picasso.with(this).load(R.drawable.welcome_img).into(welcomeImage);
        CountDownTimer timer = new CountDownTimer(3200, 1000) {
            int number = 2;

            @Override
            public void onTick(long l) {
                count_down_text.setText(String.valueOf(number));
                number--;
            }

            @Override
            public void onFinish() {
                Intent i = new Intent(WelcomeActivity.this, MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                overridePendingTransition(0, 0);
                finish();
            }
        }.start();
    }
}
