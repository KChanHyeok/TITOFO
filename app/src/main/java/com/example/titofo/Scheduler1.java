package com.example.titofo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

public class Scheduler1 extends AppManager {

    int box_number = super.box_number;
    int selected_box_number = super.box_number;

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
                get_box_num(box_number,selected_box_number);
            }
        });
    }
    @Override
    protected void onStart() {
        for(int i=0; i<3; i++){
            make_schedule_box();
        }
        box_number = super.box_number;
        selected_box_number = super.box_number;
        super.onStart();
    }
}
