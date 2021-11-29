package com.example.titofo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract; //연락처 불러오기 위한 import
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

public class AppManager extends AppCompatActivity {

    Intent intent;

    void start_page(String page){
        switch (page){
            case "main":
                intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                break;
            case "scheduler1":
                intent = new Intent(getApplicationContext(),Scheduler1.class);
                startActivity(intent);
                break;
            case "scheduler2":
                intent = new Intent(getApplicationContext(),Scheduler2.class);
                startActivity(intent);
                break;
            case "messenger":
                intent = new Intent(getApplicationContext(),Messenger.class);
                startActivity(intent);
                break;
            case "option":
                intent = new Intent(getApplicationContext(),Option.class);
                startActivity(intent);
                break;
        }
    }


    String current_page; //현재 페이지 – 페이지가 바뀔 때
    public class ScheduleBox {
        String schedule_color = "write"; //스케줄 색상
        int schedule_start_hour = 0; //스케줄 시작 시간
        int schedule_start_min = 0; //스케줄 시작 시간
        int schedule_end_hour = 0; //스케줄 끝 시간
        int schedule_end_min = 0; //스케줄 끝 시간
        Boolean[] schedule_week = {false,false,false,false,false,false,false}; //스케줄 요일
        String schedule_name = "스케줄을 입력하세요"; //스케줄 이름
        Boolean schedule_on = true; //스케줄 전원 온오프
        String selected_message = ""; //선택된 메시지를 저장할 변수

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
    }
    void get_box_num(int num,int selected_num)
    {
        box_number = num;
        selected_box_number = selected_num;
    }

    //스케줄러 페이지
    int box_number = 0; //마지막 생성된 상자의 index번호(상자의 총 갯수)
    int selected_box_number = 0; //선택된 상자의 index번호

    ScheduleBox[] schedule_box = new ScheduleBox[1000]; //class ScheduleBox의 객체
    ScheduleBox delete_box = new ScheduleBox(); //SchedulerBox의 1001번째 객체
    //delete_schedule_box로 스케줄박스를 지워줄 때 1000번째 상자에 데어터 초기값을 덮어씌우는 용도
    void delete_schedule_box(int index)
    {
        if(box_number!=schedule_box.length)
        {
            for(int i = index; i<box_number; i++){

                schedule_box[i] = schedule_box[i+1];
            }
        }else{
            for(int i = index; i<schedule_box.length-1; i++){
                schedule_box[i] = schedule_box[i+1];
            }
            schedule_box[schedule_box.length - 1] = delete_box;
        }
        box_number--;
    }//스케줄러박스를 지워주는 함수

    //스케줄러 페이지2
    long now = System.currentTimeMillis();//현재 시간 가져오기
    Date date = new Date(now);//날짜 생성하기
    SimpleDateFormat hour_format = new SimpleDateFormat("hh");
    int get_hour = Integer.parseInt(hour_format.format(date));
    SimpleDateFormat min_format = new SimpleDateFormat("mm");
    int get_min = Integer.parseInt(min_format.format(date));
    Calendar cal = Calendar.getInstance();
    int week_num = cal.get(Calendar.DAY_OF_WEEK);

    boolean calculate(Boolean[] week,int hour, int min){
        int true_num = 0;

        if(week_num == 1)
        {
            if(week[6]){
                true_num++;
            }
        }else{
            if(week[week_num-2]){
                true_num++;
            }
        }
        if(hour < get_hour || (hour == get_hour && min < get_min)){
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
