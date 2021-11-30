package com.example.titofo;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.text.AttributedCharacterIterator;

public class Subschedule extends LinearLayout {

    AppManager scheduler = new AppManager();
    int s_hour,s_min,e_hour,e_min;
    boolean s_noon,e_noon = false;

    public Subschedule(Context context){
        super(context);
        init(context);

    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.subschedule,this,true);
        ConstraintLayout const_box = findViewById(R.id.schedule_box);

        TextView[] view = new TextView[8];
        for(int i=0; i<6; i++)
        {
            view[i] = new TextView(this.getContext());
        }
        if(s_hour>9) {
            if(s_min>9){
                view[0].setText(+scheduler.s_hour+" : "+scheduler.s_min);
            }else {
                view[0].setText(+scheduler.s_hour+" : 0"+scheduler.s_min);
            }
        }else {
            if(s_min>9){
                view[0].setText("0"+scheduler.s_hour+" : "+scheduler.s_min);
            }else {
                view[0].setText("0"+scheduler.s_hour+" : 0"+scheduler.s_min);
            }
        }

        if(s_hour>=12){
            s_noon = true;
            s_hour -= 12;
        }
        if(s_hour>=12){
            e_noon = true;
            e_hour -= 12;
        }

        if(e_hour>9) {
            if(e_min>9){
                view[1].setText(+scheduler.e_hour+" : "+scheduler.e_min);
            }else {
                view[1].setText(+scheduler.e_hour+" : 0"+scheduler.e_min);
            }
        }else {
            if(e_min>9){
                view[1].setText("0"+scheduler.e_hour+" : "+scheduler.e_min);
            }else {
                view[1].setText("0"+scheduler.e_hour+" : 0"+scheduler.e_min);
            }
        }

        const_box.addView(view[0],findViewById(R.id.schedule_start_time).getLayoutParams());
        const_box.addView(view[1],findViewById(R.id.schedule_end_time).getLayoutParams());
        const_box.addView(view[2],findViewById(R.id.schedule_start_noon).getLayoutParams());
    }

}
