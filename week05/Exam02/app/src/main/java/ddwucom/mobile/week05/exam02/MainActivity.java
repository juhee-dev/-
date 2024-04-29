package ddwucom.mobile.week05.exam02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private MyView myView;
    int x, y, r, layoutWidth, layoutHeight;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = findViewById(R.id.myView);
    }

    public void onClick(View v) {
        x = random.nextInt(layoutWidth);
        y = random.nextInt(layoutHeight);
        r = (random.nextInt(3) + 1) * 100;
        switch(v.getId()) {
            case R.id.button:
                myView.setCircleX(x);
                myView.setCircleY(y);
                myView.setCircleR(r);
                myView.invalidate(); // 다시 그리기
                break;
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) { // 원을 MyView 내에서만 나타내기 위해 뷰의 크기 구하기
        layoutWidth = myView.getWidth();
        layoutHeight = myView.getHeight();
    }


}