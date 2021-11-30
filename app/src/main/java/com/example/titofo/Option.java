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

        Button move_to_main = (Button) findViewById(R.id.move_to_main);
        Button move_to_scheduler = (Button) findViewById(R.id.move_to_sheduler);
        Button move_to_messenger = (Button) findViewById(R.id.move_to_messenger);
        Button move_to_option = (Button) findViewById(R.id.move_to_option);

        Button.OnClickListener bt_click = new Button.OnClickListener() {
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.move_to_main:
                        start_page("main");
                        finish();
                        break;
                    case R.id.move_to_sheduler:
                        start_page("scheduler1");
                        finish();
                        break;
                    case R.id.move_to_messenger:
                        start_page("option");
                        finish();
                        break;
                    case R.id.move_to_option:
                        finish();
                        break;
                }
            }
        };

        move_to_main.setOnClickListener(bt_click);
        move_to_scheduler.setOnClickListener(bt_click);
        move_to_messenger.setOnClickListener(bt_click);
        move_to_option.setOnClickListener(bt_click);

    }
}
