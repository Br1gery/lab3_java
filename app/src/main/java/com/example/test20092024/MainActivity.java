package com.example.test20092024;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
    }

    public void testToast(View view) {

        Toast myToast = Toast.makeText(getApplicationContext(),"Кнопка номер 1 нажата",Toast.LENGTH_SHORT);
        myToast.show();
    }

    public void longToastTop(View view) {
        Toast myToast = Toast.makeText(getApplicationContext(),"Кнопка номер 2 нажата", Toast.LENGTH_SHORT);
        myToast.setGravity(Gravity.TOP,0,0);
        myToast.show();

    }

    public void dialogFirst(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Кнопка 3")
                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        Toast myToast = Toast.makeText(getApplicationContext(),"Окно закрыто", Toast.LENGTH_SHORT);
                        myToast.show();
                        btn1.setTextColor(Color.BLACK);
                        btn2.setTextColor(Color.BLACK);
                        btn3.setTextColor(Color.BLACK);
                        btn4.setTextColor(Color.BLACK);
                    }
                })
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        btn1.setTextColor(Color.RED);
                        btn2.setTextColor(Color.RED);
                        btn3.setTextColor(Color.RED);
                        btn4.setTextColor(Color.RED);
                    }
                })
                .setIcon(R.drawable.test_icon);
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void dialogSecond(View view) {

        String[] Pers = {"Вариант 1", "Вариант 2", "Вариант 3"};
        boolean[] pers = {false, false, false};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setPositiveButton("Подтвердить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(pers[2] && !pers[0] && !pers[1]){
                            Toast myToast = Toast.makeText(getApplicationContext(),"Все верно",Toast.LENGTH_LONG);
                            myToast.setGravity(Gravity.CENTER,0,0);
                            myToast.show();
                            dialogInterface.cancel();
                        }
                        else{
                            btn1.setVisibility(View.INVISIBLE);
                            btn2.setVisibility(View.INVISIBLE);
                            btn3.setVisibility(View.INVISIBLE);
                            btn4.setVisibility(View.INVISIBLE);
                            dialogInterface.cancel();
                        }
                    }
                })
//                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialogInterface.cancel();
//                    }
//                })
                .setMultiChoiceItems(Pers, pers, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        pers[i] = b;
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }
}
