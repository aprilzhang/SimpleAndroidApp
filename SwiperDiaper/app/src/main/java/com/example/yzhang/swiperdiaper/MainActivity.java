package com.example.yzhang.swiperdiaper;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView buckysMessage;
    private GestureDetectorCompat gestureDetector;

    private GestureDetector.OnGestureListener onGestureListener = new GestureDetector.OnGestureListener()
    {
        @Override
        public boolean onDown(MotionEvent motionEvent) {
            buckysMessage.setText("onDown");
            return true;
        }

        @Override
        public void onShowPress(MotionEvent motionEvent) {
            buckysMessage.setText("onShowPress");

        }

        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            buckysMessage.setText("onSingleTapUp");
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            buckysMessage.setText("onScroll");
            return true;
        }

        @Override
        public void onLongPress(MotionEvent motionEvent) {

            buckysMessage.setText("onLongPress");
        }

        @Override
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            buckysMessage.setText("onFling");
            return true;
        }
    };
    private GestureDetector.OnDoubleTapListener onDoubleTapListener = new GestureDetector.OnDoubleTapListener()
    {
        @Override
        public boolean onDoubleTap(MotionEvent motionEvent) {
            buckysMessage.setText("onDoubleTap");
            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            buckysMessage.setText("onSingleTapConfirmed");
            return true;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            buckysMessage.setText("onDoubleTapEvent");
            return true;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.buckysMessage =(TextView)findViewById(R.id.buckysMessage);
        this.gestureDetector = new GestureDetectorCompat(this,onGestureListener);
        gestureDetector.setOnDoubleTapListener(onDoubleTapListener);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
