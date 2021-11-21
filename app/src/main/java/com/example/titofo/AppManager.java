package com.example.titofo;
import java.util.ArrayList;

import android.content.Intent;
import android.provider.ContactsContract; //연락처 불러오기 위한 import

import androidx.appcompat.app.AppCompatActivity;

public class AppManager extends AppCompatActivity {


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
        int box_number = 0; //마지막 생성된 상자의 index번호
        int selected_box_number = 0; //선택된 상자의 index번호
        ScheduleBox[] schedule_box = new ScheduleBox[1000]; //class ScheduleBox에 push, pop 해줄 변수

        public class MessageBox{
            String message_content; //메시지 내용
            String message_date; //메시지를 작성한 날짜
        }
        MessageBox[] message_box = {}; //class MessageBox에 push, pop 해줄 변수

        public class ContactBox{
            Boolean contact_block; //차단할 지에 대한 여부에 대한 변수
            String phone_number; //연락처를 저장할 변수
        }
        ContactBox[] contact_box = {}; //class ContactBox에 push, pop 해줄 변수

        String theme_color; //테마 색상을 저장할 변수

//다른 페이지랑 같이 사용할 변수들
}
