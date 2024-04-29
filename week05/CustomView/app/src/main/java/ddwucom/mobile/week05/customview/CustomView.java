package ddwucom.mobile.week05.customview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 인플레이션됨

//        MyView myView = new MyView(this);
//        setContentView(myView); // 화면에 출력. 인플레이션 하지 않음
    }

    public void onClick(View v) {
        MyCustomView myView = findViewById(R.id.myView);
        myView.setCircleY(myView.getCirecleY() + 100);
        myView.invalidate(); // myView 다시 그리도록 호출
    }

    class MyView extends View {

        public MyView(Context context) {
            super(context);
        }

        public MyView(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
        }

        public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

//            canvas.drawColor(Color.GRAY);
//            Paint pnt = new Paint();
//            pnt.setColor(Color.BLUE);
//
//            canvas.drawCircle(100, 100, 80, pnt);
        }
    }
}