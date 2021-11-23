package com.example.titofo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Option extends AppManager{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        page_main = new Intent(getApplicationContext(),MainActivity.class);
        page_schedule1 = new Intent(getApplicationContext(),Scheduler1.class);
        page_schedule2 = new Intent(getApplicationContext(),Scheduler2.class);
        page_messenger = new Intent(getApplicationContext(),Messenger.class);
        page_option =new Intent(getApplicationContext(),Option.class);

        Button move_to_main = (Button) findViewById(R.id.move_to_main);
        Button move_to_sheduler = (Button) findViewById(R.id.move_to_sheduler);
        Button move_to_messenger = (Button) findViewById(R.id.move_to_messenger);
        Button move_to_option = (Button) findViewById(R.id.move_to_option);

        Button.OnClickListener bt_click = new Button.OnClickListener() {
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.move_to_main:
                        startActivity(page_main);
                        finish();
                        break;
                    case R.id.move_to_sheduler:
                        startActivity(page_schedule1);
                        finish();
                        break;
                    case R.id.move_to_messenger:
                        finish();
                        break;
                    case R.id.move_to_option:
                        startActivity(page_option);
                        finish();
                        break;
                }

            }
        };


        move_to_main.setOnClickListener(bt_click);
        move_to_sheduler.setOnClickListener(bt_click);
        move_to_messenger.setOnClickListener(bt_click);
        move_to_option.setOnClickListener(bt_click);



    }
}
