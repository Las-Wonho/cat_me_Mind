package com.example.haho6.client;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LinearLayout area;

    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = findViewById(R.id.vv);
        area = findViewById(R.id.area);
        ArrayList<TextView> array = new ArrayList<>();
        ArrayList<Button> Buttons = new ArrayList<>();

        ColorChangeHelper color = new ColorChangeHelper();
        LinearLayout a = findViewById(R.id.paret);
        a.getChildAt(2).setOnClickListener(color);
        findViewById(R.id.black).setOnClickListener(color);
        findViewById(R.id.yellow).setOnClickListener(color);
        findViewById(R.id.pink).setOnClickListener(color);


        for(int j =0; j< 30;j++) {
            LinearLayout layout = new LinearLayout(MainActivity.this);
            LinearLayout.LayoutParams Layparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layout.setLayoutParams(Layparams);

            for(int i =0; i< 30;i++) {
                TextView item = new TextView(MainActivity.this);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(2,2,2,2);
                item.setLayoutParams(params);
                item.setBackgroundColor(Color.parseColor("#FFFFFF"));
                item.setTextSize(0);
                item.setPadding(13,13,13,10);
                layout.addView(item);
                array.add(item);
            }
            area.addView(layout);
        }

        findViewById(R.id.in).setOnTouchListener((view, event)->{
            if(event.getAction()== MotionEvent.ACTION_MOVE){
                //색변경
                //인터넷에 전달
                t.setText(((int)event.getX()-(int)area.getX())/30+" ::  "+((int)event.getY()-(int)area.getY())/30);
                int x =((int)event.getX()-(int)area.getX())/30;
                int y =((int)event.getY()-(int)area.getY())/30;
                if(x<0||x>=30||y<0||y>=30)
                    return false;
                array.get(y*30+x).setBackgroundColor(color.color);
                return true;
            }
            if(event.getAction()== MotionEvent.ACTION_DOWN){
                t.setText(event.getX()+" ::  "+event.getY());
                return true;
            }
            return false;
        });
    }
}
