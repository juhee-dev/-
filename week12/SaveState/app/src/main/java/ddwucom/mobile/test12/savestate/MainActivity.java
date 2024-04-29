package ddwucom.mobile.test12.savestate;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;


public class MainActivity extends Activity {

    final static String TAG = "MainActivity";

    private MyView vw;
    int x;
    int y;
    int radius;
    int color;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//		x, y 초기 좌표
        SharedPreferences pref = getSharedPreferences("SaveState", 0);
        y = pref.getInt("y", 300); // 정보 영구 저장: 실행과 상관 없이 영구 유지
        x = 300; // 정보 임시 저장: 실행 중 변경할 때만 유지
        radius = 100;
        color = Color.GREEN;
        Log.d(TAG, "변수 x의 현재값: " + x);
        vw = new MyView(this);
        vw.setFocusable(true);
        vw.setFocusableInTouchMode(true);

        setContentView(vw);
    }

//    onStart 다음에 호출됨
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState == null) {
            x = 300;
        } else {
            x = savedInstanceState.getInt("x"); // onSavaInstanceState 에서 저장한 outState 값 불러옴. 임시저장이므로 앱이 새로 실행될 때에는 x값 초기화됨
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("x", x);
    }

    protected class MyView extends View {
        public MyView(Context context) {
            super(context);
        }

        public void onDraw(Canvas canvas) {
            Paint p = new Paint();
            p.setColor(color);
            canvas.drawCircle(x, y, radius, p);
        }

        public boolean onTouchEvent(MotionEvent event) {
            super.onTouchEvent(event);
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                x = (int) event.getX();
                y = (int) event.getY();
                invalidate();
                return true;
            }
            return false;
        }
    }
}
