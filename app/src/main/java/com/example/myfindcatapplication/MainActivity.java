package com.example.myfindcatapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.myfindcatapplication.R;

public class MainActivity extends AppCompatActivity {

    private int x, y = 500;
    private int inaccuracy = 40;

    private Toast toast;

    private View.OnTouchListener listener = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            System.out.println(event.getX() + " " + event.getX());

            if ((event.getX() > 500 - inaccuracy && event.getX() > 500 + inaccuracy)
                    && (event.getY() > 500 - inaccuracy && event.getY() > 500 + inaccuracy)) {
                toast.show();
            }

            return true;
        }
    };

    private ConstraintLayout myLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLayout = findViewById(R.id.myLayout);

        myLayout.setOnTouchListener(listener);

        toast = Toast.makeText(getApplicationContext(), "Вы нашли выход",
                Toast.LENGTH_SHORT);
        LinearLayout toastContainer = (LinearLayout) toast.getView();

        ImageView exitImage = new ImageView(getApplicationContext());
        exitImage.setImageResource(R.drawable.exit);

        toastContainer.addView(exitImage);
    }
}