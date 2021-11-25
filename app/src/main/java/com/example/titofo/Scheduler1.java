package com.example.titofo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Scheduler1 extends AppManager {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduler1);

        Button bt = (Button)findViewById(R.id.move_to_scheduler2);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start_page("scheduler2");
                selected_box_number = box_number;
            }
        });

    }
}
