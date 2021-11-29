package com.example.titofo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.text.AttributedCharacterIterator;

public class Subschedule extends LinearLayout {

    //AppManager scheduler = new AppManager();

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
            view[0] = new TextView(this.getContext());
        }
        view[0].setText("0");
        const_box.addView(view[0],findViewById(R.id.schedule_start_time).getLayoutParams());
    }

}
