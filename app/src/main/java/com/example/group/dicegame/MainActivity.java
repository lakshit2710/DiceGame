package com.example.group.dicegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView iv1,iv2;
    TextView tv1,tv2;
     int cpuPoints=0,playerPoints=0;
    Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv1= (ImageView) findViewById(R.id.ivcpu);
        iv2= (ImageView) findViewById(R.id.ivplayer);
        tv1= (TextView) findViewById(R.id.tvcpu);
        tv2= (TextView) findViewById(R.id.tvplayer);
          r=new Random();

        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cpuThrow=r.nextInt(6)+1;
                int playerThrow=r.nextInt(6)+1;
                setImageCPU(cpuThrow);
                setImagePlayer(playerThrow);

                if (cpuThrow>playerThrow){
                    cpuPoints++;
                }
                if (playerThrow>cpuThrow){
                    playerPoints++;
                }
                tv1.setText("CPU:" + cpuPoints);
                tv2.setText("YOU:"+ playerPoints);

                Animation rotate= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                iv1.startAnimation(rotate);
                iv2.startAnimation(rotate);
            }
        });
    }
    public void setImageCPU(int num){
        switch (num){
            case 1:
                 iv1.setImageResource(R.drawable.d1);
                break;
            case 2:
                iv1.setImageResource(R.drawable.d2);
                break;
            case 3:
                iv1.setImageResource(R.drawable.d3);
                break;
            case 4:
                iv1.setImageResource(R.drawable.d4);
                break;
            case 5:
                iv1.setImageResource(R.drawable.d5);
                break;
            case 6:
                iv1.setImageResource(R.drawable.d6);
                break;
        }
    }
    public void setImagePlayer(int num){
        switch (num){
            case 1:
                iv2.setImageResource(R.drawable.d1);
                break;
            case 2:
                iv2.setImageResource(R.drawable.d2);
                break;
            case 3:
                iv2.setImageResource(R.drawable.d3);
                break;
            case 4:
                iv2.setImageResource(R.drawable.d4);
                break;
            case 5:
                iv2.setImageResource(R.drawable.d5);
                break;
            case 6:
                iv2.setImageResource(R.drawable.d6);
                break;
        }
    }
}
