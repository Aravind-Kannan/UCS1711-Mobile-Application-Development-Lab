package com.k12mate.ex06;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Thread t1,t2;
    ImageView i;
    int direction,direction1,flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bitmap bg = Bitmap.createBitmap(720, 1280, Bitmap.Config.ARGB_8888);
        i = (ImageView) findViewById(R.id.banner);
        i.setBackgroundDrawable(new BitmapDrawable(bg));
        Canvas canvas = new Canvas(bg);
        Paint paint = new Paint();
        paint.setColor(Color.CYAN);
        canvas.drawRect(50, 300, 500, 500, paint);

        direction=0;
        direction1=0;

        Button btn = (Button) findViewById(R.id.button);

        final int[] btnVal = {0};

        t1=new Thread() {
            public void run() {
                while(true) {
                    while(btnVal[0]==0) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    while(btnVal[0]==1) {
                        //System.out.println("Thread started");
                        try {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //System.out.println("Inside runnable run func");
                                    if(direction==0) {
                                        i.animate().translationYBy(-300).setDuration(600);
                                    } else if(direction==1) {
                                        i.animate().translationXBy(300).setDuration(600);
                                    }
                                    else if(direction==2) {
                                        i.animate().translationYBy(300).setDuration(600);
                                    } else if(direction==3) {
                                        i.animate().translationXBy(-300).setDuration(600);
                                    }
                                    direction++;
                                    direction%=4;
                                }
                            });
                            Thread.sleep(1000);
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        t2=new Thread() {
            public void run() {
                while(true) {
                    while(btnVal[0]==0) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    while(btnVal[0]==1) {
                        //System.out.println("Thread started");
                        try {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //System.out.println("Inside runnable run func");
                                    if(direction1==0) {
                                        i.setBackgroundDrawable(new BitmapDrawable(bg));
                                        Canvas canvas = new Canvas(bg);
                                        Paint paint = new Paint();
                                        paint.setColor(Color.CYAN);
                                        canvas.drawRect(50, 300, 500, 500, paint);
                                    } else if(direction1==1) {
                                        i.setBackgroundDrawable(new BitmapDrawable(bg));
                                        Canvas canvas = new Canvas(bg);
                                        Paint paint = new Paint();
                                        paint.setColor(Color.RED);
                                        canvas.drawRect(50, 300, 500, 500, paint);
                                        //i.animate().translationXBy(300).setDuration(600);
                                    }
                                    else if(direction1==2) {
                                        i.setBackgroundDrawable(new BitmapDrawable(bg));
                                        Canvas canvas = new Canvas(bg);
                                        Paint paint = new Paint();
                                        paint.setColor(Color.GREEN);
                                        canvas.drawRect(50, 300, 500, 500, paint);
                                        //i.animate().translationYBy(300).setDuration(600);
                                    } else if(direction1==3) {
                                        i.setBackgroundDrawable(new BitmapDrawable(bg));
                                        Canvas canvas = new Canvas(bg);
                                        Paint paint = new Paint();
                                        paint.setColor(Color.YELLOW);
                                        canvas.drawRect(50, 300, 500, 500, paint);
                                        //i.animate().translationXBy(-300).setDuration(600);
                                    }
                                    direction1++;
                                    direction1%=4;
                                }
                            });
                            Thread.sleep(1000);
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnVal[0] ==0) {
                    btnVal[0] = 1;
                    btn.setText("Stop");
                    if(flag==0) {
                        t1.start();
                        t2.start();
                        flag++;
                    }
                } else {
                    btnVal[0] = 0;
                    btn.setText("Start");
                }
            }
        });

    }
}