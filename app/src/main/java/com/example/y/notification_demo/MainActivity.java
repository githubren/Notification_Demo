package com.example.y.notification_demo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;

public class MainActivity extends AppCompatActivity {
    private NotificationManager mNotificationManager;

    private final static int RED = 110;
    private final static int GREEN = 111;
    private final static int BLUE = 112;
    private final static int YELLOW = 113;
    private final static int GRAY= 114;
    private final static int CYAN= 115;
    private final static int BLACK= 116;

    private TextView textView;
    private TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Button btn  =findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,OtherActivity.class);
                PendingIntent pit = PendingIntent.getActivity(MainActivity.this,0,intent,0);

                Notification.Builder mBuilder = new Notification.Builder(MainActivity.this);
                mBuilder.setContentTitle("标题")
                        .setContentText("内容")
                        .setTicker("收到信息后状态栏显示的文字信息")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                        .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE)
                        .setAutoCancel(true)
                        .setContentIntent(pit);
                Notification notification = mBuilder.build();
                mNotificationManager.notify(1,notification);
            }
        });

        textView = findViewById(R.id.text);

        textView1 = findViewById(R.id.text1);
        registerForContextMenu(textView1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1,RED,4,"红色");
        menu.add(1,GREEN,2,"绿色");
        menu.add(1,BLUE,3,"蓝色");
        menu.add(1,YELLOW,1,"黄色");
        menu.add(1,GRAY,5,"灰色");
        menu.add(1,CYAN,6,"蓝绿色");
        menu.add(1,BLACK,7,"黑色");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case RED:
                textView.setTextColor(Color.RED);
                break;
            case GREEN:
                textView.setTextColor(Color.GREEN);
                break;
            case BLUE:
                textView.setTextColor(Color.BLUE);
                break;
            case YELLOW:
                textView.setTextColor(Color.YELLOW);
                break;
            case GRAY:
                textView.setTextColor(Color.GRAY);
                break;
            case CYAN:
                textView.setTextColor(Color.CYAN);
                break;
            case BLACK:
                textView.setTextColor(Color.BLACK);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_context,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.blue:
                textView1.setTextColor(Color.BLUE);
                break;
            case R.id.green:
                textView1.setTextColor(Color.GREEN);
                break;
            case R.id.red:
                textView1.setTextColor(Color.RED);
                break;
        }
        return true;
    }
}
