package com.example.titofo;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;

public class Scheduler2 extends AppManager {

    TextView test; //테스트용 텍스트 뷰
    TextView start_hour;
    TextView start_min;
    TextView end_hour;
    TextView end_min;
    TextView[] week = new TextView[7];

    int week_num;
    int week_true_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduler2);

        schedule_box[0] = new ScheduleBox();

        test = (TextView)findViewById(R.id.subtitle);
        start_hour = (TextView)findViewById(R.id.start_hour);
        start_min = (TextView)findViewById(R.id.start_min);
        end_hour = (TextView)findViewById(R.id.end_hour);
        end_min = (TextView)findViewById(R.id.end_min);

        Button button_add_schedule = (Button)findViewById(R.id.button_add_schedule);

        week[0] = (TextView) findViewById(R.id.mon) ;
        week[1] = (TextView) findViewById(R.id.tue) ;
        week[2] = (TextView) findViewById(R.id.wed) ;
        week[3] = (TextView) findViewById(R.id.thu) ;
        week[4] = (TextView) findViewById(R.id.fri) ;
        week[5] = (TextView) findViewById(R.id.sat) ;
        week[6] = (TextView) findViewById(R.id.sun) ;

        button_add_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //확인버튼
                selected_box_number++;
                start_page("scheduler1");
                finish();
            }
        });


        Button.OnClickListener bt_click = new Button.OnClickListener(){
            public void onClick(View view){
                switch (view.getId()){
                        //시작시간
                    case R.id.button_start_hour_up:
                        schedule_box[selected_box_number].fix_start_hour(true);
                        start_hour.setText(Integer.toString(schedule_box[selected_box_number].schedule_start_hour));
                        start_min.setText(Integer.toString(schedule_box[selected_box_number].schedule_start_min));
                        break;
                    case R.id.button_start_ten_min_up:
                        schedule_box[selected_box_number].fix_start_ten_min(true);
                        start_hour.setText(Integer.toString(schedule_box[selected_box_number].schedule_start_hour));
                        start_min.setText(Integer.toString(schedule_box[selected_box_number].schedule_start_min));
                        break;
                    case R.id.button_start_one_min_up:
                        schedule_box[selected_box_number].fix_start_one_min(true);
                        start_hour.setText(Integer.toString(schedule_box[selected_box_number].schedule_start_hour));
                        start_min.setText(Integer.toString(schedule_box[selected_box_number].schedule_start_min));
                        break;
                    case R.id.button_start_hour_down:
                        schedule_box[selected_box_number].fix_start_hour(false);
                        start_hour.setText(Integer.toString(schedule_box[selected_box_number].schedule_start_hour));
                        start_min.setText(Integer.toString(schedule_box[selected_box_number].schedule_start_min));
                        break;
                    case R.id.button_start_ten_min_down:
                        schedule_box[selected_box_number].fix_start_ten_min(false);
                        start_hour.setText(Integer.toString(schedule_box[selected_box_number].schedule_start_hour));
                        start_min.setText(Integer.toString(schedule_box[selected_box_number].schedule_start_min));
                        break;
                    case R.id.button_start_one_min_down:
                        schedule_box[selected_box_number].fix_start_one_min(false);
                        start_hour.setText(Integer.toString(schedule_box[selected_box_number].schedule_start_hour));
                        start_min.setText(Integer.toString(schedule_box[selected_box_number].schedule_start_min));
                        break;
                        //종료시간
                    case R.id.button_end_hour_up:
                        schedule_box[selected_box_number].fix_end_hour(true);
                        end_hour.setText(Integer.toString(schedule_box[selected_box_number].schedule_end_hour));
                        end_min.setText(Integer.toString(schedule_box[selected_box_number].schedule_end_min));
                        break;
                    case R.id.button_end_ten_min_up:
                        schedule_box[selected_box_number].fix_end_ten_min(true);
                        end_hour.setText(Integer.toString(schedule_box[selected_box_number].schedule_end_hour));
                        end_min.setText(Integer.toString(schedule_box[selected_box_number].schedule_end_min));
                        break;
                    case R.id.button_end_one_min_up:
                        schedule_box[selected_box_number].fix_end_one_min(true);
                        end_hour.setText(Integer.toString(schedule_box[selected_box_number].schedule_end_hour));
                        end_min.setText(Integer.toString(schedule_box[selected_box_number].schedule_end_min));
                        break;
                    case R.id.button_end_hour_down:
                        schedule_box[selected_box_number].fix_end_hour(false);
                        end_hour.setText(Integer.toString(schedule_box[selected_box_number].schedule_end_hour));
                        end_min.setText(Integer.toString(schedule_box[selected_box_number].schedule_end_min));
                        break;
                    case R.id.button_end_ten_min_down:
                        schedule_box[selected_box_number].fix_end_ten_min(false);
                        end_hour.setText(Integer.toString(schedule_box[selected_box_number].schedule_end_hour));
                        end_min.setText(Integer.toString(schedule_box[selected_box_number].schedule_end_min));
                        break;
                    case R.id.button_end_one_min_down:
                        schedule_box[selected_box_number].fix_end_one_min(false);
                        end_hour.setText(Integer.toString(schedule_box[selected_box_number].schedule_end_hour));
                        end_min.setText(Integer.toString(schedule_box[selected_box_number].schedule_end_min));
                        break;
                    case R.id.all_week:
                        week_true_num = 0;
                        for(week_num=0;week_num<7;week_num++)
                        {
                            if(schedule_box[selected_box_number].schedule_week[week_num]) {
                                week_true_num++;
                            }
                        }
                        if(week_true_num == 7)
                        {
                            for(week_num=0;week_num<7;week_num++)
                            {
                                schedule_box[selected_box_number].fix_week(week_num,false);
                                week[week_num].setTypeface(week[week_num].getTypeface(),Typeface.NORMAL);
                                week[week_num].setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                            }
                        }else{
                            for(week_num=0;week_num<7;week_num++)
                            {
                                schedule_box[selected_box_number].fix_week(week_num,true);
                                week[week_num].setTypeface(week[week_num].getTypeface(),Typeface.BOLD);
                                week[week_num].setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                            }
                        }
                        break;
                    case R.id.bt_blue:
                        schedule_box[selected_box_number].fix_color("blue");
                        break;
                    case R.id.bt_pink:
                        schedule_box[selected_box_number].fix_color("pink");
                        break;
                    case R.id.bt_green:
                        schedule_box[selected_box_number].fix_color("green");
                        break;
                    case R.id.bt_darkblue:
                        schedule_box[selected_box_number].fix_color("darkblue");
                        break;
                }
            }
        };


        TextView.OnClickListener text_click =new TextView.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.mon:
                        if(schedule_box[selected_box_number].schedule_week[0])
                        {
                            week[0].setTypeface(week[0].getTypeface(),Typeface.NORMAL);
                            week[0].setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                            schedule_box[selected_box_number].fix_week(0,false);
                        }else{
                            week[0].setTypeface(week[0].getTypeface(), Typeface.BOLD);
                            week[0].setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                            schedule_box[selected_box_number].fix_week(0,true);
                        }
                        break;
                    case R.id.tue:
                        if(schedule_box[selected_box_number].schedule_week[1])
                        {
                            week[1].setTypeface(week[1].getTypeface(),Typeface.NORMAL);
                            week[1].setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                            schedule_box[selected_box_number].fix_week(1,false);
                        }else{
                            week[1].setTypeface(week[1].getTypeface(), Typeface.BOLD);
                            week[1].setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                            schedule_box[selected_box_number].fix_week(1,true);
                        }
                        break;
                    case R.id.wed:
                        if(schedule_box[selected_box_number].schedule_week[2])
                        {
                            week[2].setTypeface(week[2].getTypeface(),Typeface.NORMAL);
                            week[2].setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                            schedule_box[selected_box_number].fix_week(2,false);
                        }else{
                            week[2].setTypeface(week[2].getTypeface(), Typeface.BOLD);
                            week[2].setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                            schedule_box[selected_box_number].fix_week(2,true);
                        }
                        break;
                    case R.id.thu:
                        if(schedule_box[selected_box_number].schedule_week[3])
                        {
                            week[3].setTypeface(week[3].getTypeface(),Typeface.NORMAL);
                            week[3].setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                            schedule_box[selected_box_number].fix_week(3,false);
                        }else{
                            week[3].setTypeface(week[3].getTypeface(), Typeface.BOLD);
                            week[3].setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                            schedule_box[selected_box_number].fix_week(3,true);
                        }
                        break;
                    case R.id.fri:
                        if(schedule_box[selected_box_number].schedule_week[4])
                        {
                            week[4].setTypeface(week[4].getTypeface(),Typeface.NORMAL);
                            week[4].setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                            schedule_box[selected_box_number].fix_week(4,false);
                        }else{
                            week[4].setTypeface(week[4].getTypeface(), Typeface.BOLD);
                            week[4].setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                            schedule_box[selected_box_number].fix_week(4,true);
                        }
                        break;
                    case R.id.sat:
                        if(schedule_box[selected_box_number].schedule_week[5])
                        {
                            week[5].setTypeface(week[5].getTypeface(),Typeface.NORMAL);
                            week[5].setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                            schedule_box[selected_box_number].fix_week(5,false);
                        }else{
                            week[5].setTypeface(week[5].getTypeface(), Typeface.BOLD);
                            week[5].setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                            schedule_box[selected_box_number].fix_week(5,true);
                        }
                        break;
                    case R.id.sun:
                        if(schedule_box[selected_box_number].schedule_week[6])
                        {
                            week[6].setTypeface(week[6].getTypeface(),Typeface.NORMAL);
                            week[6].setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                            schedule_box[selected_box_number].fix_week(6,false);
                        }else{
                            week[6].setTypeface(week[6].getTypeface(), Typeface.BOLD);
                            week[6].setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                            schedule_box[selected_box_number].fix_week(6,true);
                        }
                        break;
                }
            }
        };

        //시작시간
        Button button_start_hour_up = (Button) findViewById(R.id.button_start_hour_up) ;
        button_start_hour_up.setOnClickListener(bt_click) ;
        Button button_start_ten_min_up = (Button) findViewById(R.id.button_start_ten_min_up) ;
        button_start_ten_min_up.setOnClickListener(bt_click) ;
        Button button_start_one_min_up = (Button) findViewById(R.id.button_start_one_min_up) ;
        button_start_one_min_up.setOnClickListener(bt_click) ;
        Button button_start_hour_down = (Button) findViewById(R.id.button_start_hour_down) ;
        button_start_hour_down.setOnClickListener(bt_click) ;
        Button button_start_ten_min_down = (Button) findViewById(R.id.button_start_ten_min_down) ;
        button_start_ten_min_down.setOnClickListener(bt_click) ;
        Button button_start_one_min_down = (Button) findViewById(R.id.button_start_one_min_down) ;
        button_start_one_min_down.setOnClickListener(bt_click) ;
        //종료시간
        Button button_end_hour_up = (Button) findViewById(R.id.button_end_hour_up) ;
        button_end_hour_up.setOnClickListener(bt_click) ;
        Button button_end_ten_min_up = (Button) findViewById(R.id.button_end_ten_min_up) ;
        button_end_ten_min_up.setOnClickListener(bt_click) ;
        Button button_end_one_min_up = (Button) findViewById(R.id.button_end_one_min_up) ;
        button_end_one_min_up.setOnClickListener(bt_click) ;
        Button button_end_hour_down = (Button) findViewById(R.id.button_end_hour_down) ;
        button_end_hour_down.setOnClickListener(bt_click) ;
        Button button_end_ten_min_down = (Button) findViewById(R.id.button_end_ten_min_down) ;
        button_end_ten_min_down.setOnClickListener(bt_click) ;
        Button button_end_one_min_down = (Button) findViewById(R.id.button_end_one_min_down) ;
        button_end_one_min_down.setOnClickListener(bt_click) ;
        //요일전체버튼
        Button all_week = (Button) findViewById(R.id.all_week) ;
        all_week.setOnClickListener(bt_click) ;
        //색상버튼
        Button bt_blue = (Button) findViewById(R.id.bt_blue) ;
        bt_blue.setOnClickListener(bt_click) ;
        Button bt_pink = (Button) findViewById(R.id.bt_pink) ;
        bt_pink.setOnClickListener(bt_click) ;
        Button bt_green = (Button) findViewById(R.id.bt_green) ;
        bt_green.setOnClickListener(bt_click) ;
        Button bt_darkblue = (Button) findViewById(R.id.bt_darkblue) ;
        bt_darkblue.setOnClickListener(bt_click) ;
        //요일
        for(week_num = 0; week_num<7; week_num++)
        {
            week[week_num].setOnClickListener(text_click) ;
        }



    }



}