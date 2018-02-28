package com.example.desk.a1_3_numeroaleatorio;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtn,txtn2;
    double a1=0;
    double a2=1.0;
    String cad,cad2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtn=(TextView)findViewById(R.id.textView);
        txtn2=(TextView)findViewById(R.id.textView2);
        btn=(Button)findViewById(R.id.btn);

        a1=(float)(Math.random()*2)+(1.1);
        cad=a1+"";
        txtn.setText(cad.substring(0,3));

        tim();
    }

    public void tim(){
        a2=1.0;
            new CountDownTimer(100000,500){
            @Override
            public void onTick(long l) {
                if(a2<3.1){
                    cad2=a2+"";
                    txtn2.setText(cad2.substring(0,3));
                    a2=a2+0.1;
                }else{
                    a2=1.0;
                }
            }

            public void onFinish(){


            }
        }.start();
    }

    public void compara(View v){
        float numero1 = Float.parseFloat((String) txtn.getText());
        float numero2 = Float.parseFloat((String) txtn2.getText());
        if(numero1-numero2==0){
            Toast.makeText(getApplicationContext(),"Has Ganado",Toast.LENGTH_LONG).show();
            reinicio(this);
        }else{
            Toast.makeText(getApplicationContext(),"Perdiste",Toast.LENGTH_LONG).show();
            reinicio(this);
        }
    }

    public static void reinicio(Activity a){
        Intent intent = new Intent();
        intent.setClass(a,a.getClass());
        a.startActivity(intent);
        a.finish();
    }

}
