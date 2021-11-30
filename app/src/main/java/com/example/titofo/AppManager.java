package com.example.titofo;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract; //연락처 불러오기 위한 import
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AppManager extends AppCompatActivity {


    ScheduleMethod[] schedule_box = new ScheduleMethod[1000]; //class ScheduleBox의 객체
    ScheduleMethod delete_box = new ScheduleMethod(new ScheduleBox()); //SchedulerBox의 1001번째 객체
    //delete_schedule_box로 스케줄박스를 지워줄 때 1000번째 상자에 데어터 초기값을 덮어씌우는 용도
    ScheduleBox reset_data = new ScheduleBox();
    ScheduleMethod set_schedule_box = new ScheduleMethod(new ScheduleBox());

    int s_hour,s_min,e_hour,e_min;
    int num;
    int data_num;

    public AppManager(){

        s_hour = set_schedule_box.schedule_start_hour;
        s_min = set_schedule_box.schedule_start_min;
        e_hour = set_schedule_box.schedule_end_hour;
        e_min = set_schedule_box.schedule_end_min;

    }


    Intent intent;
    ScheduleData data = new ScheduleData();
    void start_page(String page){
        switch (page){
            case "main":
                intent = new Intent(getApplicationContext(),MainActivity.class);
                send_data();
                startActivity(intent);
                break;
            case "scheduler1":
                intent = new Intent(getApplicationContext(),Scheduler1.class);
                send_data();
                startActivity(intent);
                break;
            case "scheduler2":
                intent = new Intent(getApplicationContext(),Scheduler2.class);
                send_data();
                startActivity(intent);
                break;
            case "messenger":
                intent = new Intent(getApplicationContext(),Messenger.class);
                send_data();
                startActivity(intent);
                break;
            case "option":
                intent = new Intent(getApplicationContext(),Option.class);
                send_data();
                startActivity(intent);
                break;
        }
    }


    String current_page; //현재 페이지 – 페이지가 바뀔 때
    public class ScheduleBox implements Serializable {

        String schedule_color = "write"; //스케줄 색상
        int schedule_start_hour = 0; //스케줄 시작 시간
        int schedule_start_min = 0; //스케줄 시작 시간
        int schedule_end_hour = 0; //스케줄 끝 시간
        int schedule_end_min = 0; //스케줄 끝 시간
        Boolean[] schedule_week = {false,false,false,false,false,false,false}; //스케줄 요일
        String schedule_name = "스케줄을 입력하세요"; //스케줄 이름
        Boolean schedule_on = true; //스케줄 전원 온오프
        String selected_message = ""; //선택된 메시지를 저장할 변수


    }
    class ScheduleMethod extends ScheduleBox{

        public ScheduleMethod(ScheduleBox sc){
            schedule_color = sc.schedule_color; //스케줄 색상
            schedule_start_hour = sc.schedule_start_hour; //스케줄 시작 시간
            schedule_start_min = sc.schedule_start_min; //스케줄 시작 시간
            schedule_end_hour = sc.schedule_end_hour; //스케줄 끝 시간
            schedule_end_min = sc.schedule_end_min; //스케줄 끝 시간
            schedule_week = sc.schedule_week; //스케줄 요일
            schedule_name = sc.schedule_name; //스케줄 이름
            schedule_on = sc.schedule_on; //스케줄 전원 온오프
            selected_message = sc.selected_message; //선택된 메시지를 저장할 변수
        }
        void fix_color(String color){
            schedule_color = color;
        }
        //스케줄러박스의 색상을 바꿔주는 함수
        void fix_start_hour(boolean up){
            if(up) {
                if(schedule_start_hour==23){
                    schedule_start_hour =0;
                }else{
                    schedule_start_hour++;
                }
            }else{
                if(schedule_start_hour==0)
                {
                    schedule_start_hour =23;
                }else{
                    schedule_start_hour--;
                }
            }
        }
        //시작시간(1시간)을 바꿔주는 함수

        void fix_start_ten_min(boolean up){
            if(up) {
                if(schedule_start_min >= 50)
                {
                    schedule_start_min -= 60;
                    fix_start_hour(true);
                }
                schedule_start_min += 10;
            }else{
                if(schedule_start_min < 10)
                {
                    schedule_start_min += 60;
                    fix_start_hour(false);
                }
                schedule_start_min -= 10;
            }
        }
        //시작시간(10분)을 바꿔주는 함수

        void fix_start_one_min(boolean up){
            if(up) {
                if(schedule_start_min == 59)
                {
                    schedule_start_min -= 60;
                    fix_start_hour(true);
                }
                schedule_start_min++;
            }else{
                if(schedule_start_min == 0)
                {
                    schedule_start_min += 60;
                    fix_start_hour(false);
                }
                schedule_start_min--;
            }
        }
        //시작시간(1분)을 바꿔주는 함수

        void fix_end_hour(boolean up){
            if(up) {
                if(schedule_end_hour==23){
                    schedule_end_hour =0;
                }else{
                    schedule_end_hour++;
                }
            }else{
                if(schedule_end_hour==0)
                {
                    schedule_end_hour =23;
                }else{
                    schedule_end_hour--;
                }
            }
        }
        //종료시간(1시간)을 바꿔주는 함수

        void fix_end_ten_min(boolean up){
            if(up) {
                if(schedule_end_min >= 50)
                {
                    schedule_end_min -= 60;
                    fix_end_hour(true);
                }
                schedule_end_min += 10;
            }else{
                if(schedule_end_min < 10)
                {
                    schedule_end_min += 60;
                    fix_end_hour(false);
                }
                schedule_end_min -= 10;
            }
        }
        //종료시간(10분)을 바꿔주는 함수

        void fix_end_one_min(boolean up){
            if(up) {
                if(schedule_end_min == 59)
                {
                    schedule_end_min -= 60;
                    fix_end_hour(true);
                }
                schedule_end_min++;
            }else{
                if(schedule_end_min == 0)
                {
                    schedule_end_min += 60;
                    fix_end_hour(false);
                }
                schedule_end_min--;
            }
        }
        //종료시간(1분)을 바꿔주는 함수

        void fix_week(int i, boolean b){
            schedule_week[i] = b;
        }


        void fix_name(String name){
            schedule_name = name;
        }
        void fix_on(boolean on){
            schedule_on = on;
        }
        void fix_message(String message){
            selected_message = message;
        }
    }


    void make_schedule_box(){
        Subschedule sch = new Subschedule(getApplicationContext());
        LinearLayout sch_mem = findViewById(R.id.schedule_members);
        sch_mem.addView(sch);
        set_schedule_box = schedule_box[num];
        num++;
    }


    void send_data(){
        intent.putExtra("data",data.box_number);
        data_num++;

    }

    void reset_data(){
        intent = new Intent(this.getIntent());
        data_num = intent.getIntExtra("data",0);
        data_num++;
    }






    void delete_schedule_box(int index)
    {
        if(data.box_number!=schedule_box.length)
        {
            for(int i = index; i<data.box_number; i++){

                schedule_box[i] = schedule_box[i+1];
            }
        }else{
            for(int i = index; i<schedule_box.length-1; i++){
                schedule_box[i] = schedule_box[i+1];
            }
            schedule_box[schedule_box.length - 1] = delete_box;
        }
        data.box_number--;
    }//스케줄러박스를 지워주는 함수



    boolean calculate(Boolean[] week,int hour, int min){
        int true_num = 0;

        if(data.week_num == 1)
        {
            if(week[6]){
                true_num++;
            }
        }else{
            if(week[data.week_num-2]){
                true_num++;
            }
        }
        if(hour < data.get_hour || (hour == data.get_hour && min < data.get_min)){
            true_num++;
        }

        if(true_num == 2){
            return true;
        }else {
            return false;
        }
    }

    //메신저 페이지
    public class MessageBox{
        String message_content; //메시지 내용
        String message_date; //메시지를 작성한 날짜
    }
    MessageBox[] message_box = {}; //class MessageBox의 객체
    //옵션 페이지
    public class ContactBox{
        Boolean contact_block; //차단할 지에 대한 여부에 대한 변수
        String phone_number; //연락처를 저장할 변수
    }
    ContactBox[] contact_box = {}; //class ContactBox의 객체
    String theme_color; //테마 색상을 저장할 변수
    //다른 페이지랑 같이 사용할 변수들
}

class ScheduleData implements Serializable{
    //스케줄러 페이지
    int box_number = 0; //마지막 생성된 상자의 index번호(상자의 총 갯수)
    int selected_box_number = 0; //선택된 상자의 index번호

    //스케줄러 페이지2
    long now = System.currentTimeMillis();//현재 시간 가져오기
    Date date = new Date(now);//날짜 생성하기
    SimpleDateFormat hour_format = new SimpleDateFormat("hh");
    int get_hour = Integer.parseInt(hour_format.format(date));
    SimpleDateFormat min_format = new SimpleDateFormat("mm");
    int get_min = Integer.parseInt(min_format.format(date));
    Calendar cal = Calendar.getInstance();
    int week_num = cal.get(Calendar.DAY_OF_WEEK);
}
