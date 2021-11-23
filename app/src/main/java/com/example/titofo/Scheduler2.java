package com.example.titofo;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Scheduler2 extends AppManager {

    TextView test; //테스트용 텍스트 뷰
    TextView start_hour;
    TextView start_min;
    TextView end_hour;
    TextView end_min;

    TextView mon;
    TextView tue;
    TextView wed;
    TextView thu;
    TextView fri;
    TextView sat;
    TextView sun;

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

        mon = (TextView) findViewById(R.id.mon) ;
        tue = (TextView) findViewById(R.id.tue) ;
        wed = (TextView) findViewById(R.id.wed) ;
        thu = (TextView) findViewById(R.id.thu) ;
        fri = (TextView) findViewById(R.id.fri) ;
        sat = (TextView) findViewById(R.id.sat) ;
        sun = (TextView) findViewById(R.id.sun) ;



        button_add_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //확인버튼
                if(selected_box_number==box_number){
                    schedule_box[box_number+1] = new ScheduleBox(); // 다음 박스 준비(마지막객체는 메인이랑 일정추가페이지에서 드로우 x)
                    test.setText(Integer.toString(schedule_box[0].schedule_start_hour)+"시"+
                            Integer.toString(schedule_box[0].schedule_start_min)+"분"); //테스트
                    box_number++;
                }else{
                    test.setText(Integer.toString(schedule_box[0].schedule_start_hour)+"시"+
                            Integer.toString(schedule_box[0].schedule_start_min)+"분");
                }




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

                            }
                            mon.setTypeface(mon.getTypeface(),Typeface.NORMAL);
                            tue.setTypeface(tue.getTypeface(),Typeface.NORMAL);
                            wed.setTypeface(wed.getTypeface(),Typeface.NORMAL);
                            thu.setTypeface(thu.getTypeface(),Typeface.NORMAL);
                            fri.setTypeface(fri.getTypeface(),Typeface.NORMAL);
                            sat.setTypeface(sat.getTypeface(),Typeface.NORMAL);
                            sun.setTypeface(sun.getTypeface(),Typeface.NORMAL);
                            mon.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                            tue.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                            wed.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                            thu.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                            fri.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                            sat.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                            sun.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                        }else{
                            for(week_num=0;week_num<7;week_num++)
                            {
                                schedule_box[selected_box_number].fix_week(week_num,true);
                            }
                            mon.setTypeface(mon.getTypeface(),Typeface.BOLD);
                            tue.setTypeface(tue.getTypeface(),Typeface.BOLD);
                            wed.setTypeface(wed.getTypeface(),Typeface.BOLD);
                            thu.setTypeface(thu.getTypeface(),Typeface.BOLD);
                            fri.setTypeface(fri.getTypeface(),Typeface.BOLD);
                            sat.setTypeface(sat.getTypeface(),Typeface.BOLD);
                            sun.setTypeface(sun.getTypeface(),Typeface.BOLD);
                            mon.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                            tue.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                            wed.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                            thu.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                            fri.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                            sat.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                            sun.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
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
                            mon.setTypeface(mon.getTypeface(),Typeface.NORMAL);
                            mon.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                            schedule_box[selected_box_number].fix_week(0,false);
                        }else{
                            mon.setTypeface(mon.getTypeface(), Typeface.BOLD);
                            mon.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                            schedule_box[selected_box_number].fix_week(0,true);
                        }
                        break;
                    case R.id.tue:
                        if(schedule_box[selected_box_number].schedule_week[1])
                        {
                            tue.setTypeface(tue.getTypeface(),Typeface.NORMAL);
                            tue.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                            schedule_box[selected_box_number].fix_week(1,false);
                        }else{
                            tue.setTypeface(tue.getTypeface(), Typeface.BOLD);
                            tue.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                            schedule_box[selected_box_number].fix_week(1,true);
                        }
                        break;
                    case R.id.wed:
                        if(schedule_box[selected_box_number].schedule_week[2])
                        {
                            wed.setTypeface(wed.getTypeface(),Typeface.NORMAL);
                            wed.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                            schedule_box[selected_box_number].fix_week(2,false);
                        }else{
                            wed.setTypeface(wed.getTypeface(), Typeface.BOLD);
                            wed.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                            schedule_box[selected_box_number].fix_week(2,true);
                        }
                        break;
                    case R.id.thu:
                        if(schedule_box[selected_box_number].schedule_week[3])
                        {
                            thu.setTypeface(thu.getTypeface(),Typeface.NORMAL);
                            thu.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                            schedule_box[selected_box_number].fix_week(3,false);
                        }else{
                            thu.setTypeface(thu.getTypeface(), Typeface.BOLD);
                            thu.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                            schedule_box[selected_box_number].fix_week(3,true);
                        }
                        break;
                    case R.id.fri:
                        if(schedule_box[selected_box_number].schedule_week[4])
                        {
                            fri.setTypeface(fri.getTypeface(),Typeface.NORMAL);
                            fri.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                            schedule_box[selected_box_number].fix_week(4,false);
                        }else{
                            fri.setTypeface(fri.getTypeface(), Typeface.BOLD);
                            fri.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                            schedule_box[selected_box_number].fix_week(4,true);
                        }
                        break;
                    case R.id.sat:
                        if(schedule_box[selected_box_number].schedule_week[5])
                        {
                            sat.setTypeface(sat.getTypeface(),Typeface.NORMAL);
                            sat.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                            schedule_box[selected_box_number].fix_week(5,false);
                        }else{
                            sat.setTypeface(sat.getTypeface(), Typeface.BOLD);
                            sat.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                            schedule_box[selected_box_number].fix_week(5,true);
                        }
                        break;
                    case R.id.sun:
                        if(schedule_box[selected_box_number].schedule_week[6])
                        {
                            sun.setTypeface(sun.getTypeface(),Typeface.NORMAL);
                            sun.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                            schedule_box[selected_box_number].fix_week(6,false);
                        }else{
                            sun.setTypeface(sun.getTypeface(), Typeface.BOLD);
                            sun.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
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
        mon.setOnClickListener(text_click) ;
        tue.setOnClickListener(text_click) ;
        wed.setOnClickListener(text_click) ;
        thu.setOnClickListener(text_click) ;
        fri.setOnClickListener(text_click) ;
        sat.setOnClickListener(text_click) ;
        sun.setOnClickListener(text_click) ;



    }



}