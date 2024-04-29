package ddwucom.mobile.week05.eventtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener { // interface 사용하려면 interface에 구현된 메소드를 구현해야 한다(onClick)

    Button button1, button2, button3, button4;
//    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // callback. on이 붙은 메소드는 대부분 callback 메소드
        super.onCreate(savedInstanceState);

//        뷰 클래스 생성 후 리스너를 구현하는 방법
//        MyView view = new MyView(this);
//        view.setOnTouchListener(view);
//        setContentView(view);
        setContentView(R.layout.activity_main);

        ConstraintLayout layout = findViewById(R.id.layout);

//        TextView textView = findViewById(R.id.textView); // textView는 onCreate의 지역변수, onTouchListener는 onCreate이 끝나고 앱 동작 중에 실행되는 메소드.
                                                         // 따라서 onTouchListener가 실행될 때에는 textView 지역변수는 사라지고 없다 -> 오류
//        textView = findViewById(R.id.textView); // 해결방법1. 멤버변수로 설정
        final TextView textView = findViewById(R.id.textView); // 해결방법2. final(상수) 선언 -> App 종료 시까지 변수가 유지됨

        layout.setOnTouchListener( new View.OnTouchListener() { // 화면에서 찾아낸 layout에 OnTouch 기능 연결
            @Override
            public boolean onTouch(View v, MotionEvent event) { // MotionEvent: Action의 형태
//                Toast.makeText(MainActivity.this, "Layout Touch!", Toast.LENGTH_SHORT).show();
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    textView.setText("Layout Touch Down!");
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    textView.setText("Layout Touch Up!");
                }
                return true;
            }
        });

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        // 1. 기본 방법 - 클래스 생성 후 적용
        MyClick myClick = new MyClick();
        button1.setOnClickListener(myClick); // button1을 누르면 이벤트 실행되도록 OnClickListner 클래스를 myClick객체에 연결한다

        // 2. 액티비티가 리스너를 구현
        button2.setOnClickListener(this); // button2을 누르면 onClick 이벤트 실행되도록 자기자신 클래스(MainActivity)를 연결한다

        // 4. 익명 클래스의 객체 사용
        button3.setOnClickListener(myClickListener);

        // 5. 익명 클래스의 임시 객체 사용
        button4.setOnClickListener( new View.OnClickListener() { // 객체의 이름 없이 바로 생성
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "다섯번째 익명 클래스 임시 객체 방식!", Toast.LENGTH_SHORT).show(); // MainActivity.this를 명시적으로 작성해야 한다.
            }
        } );
    }

    // 위젯 이벤트 처리 - XML에서 연결
    public void onMyClick(View v) {
        Toast.makeText(this, "위젯 방식!", Toast.LENGTH_SHORT).show();
    }

    // 2. Activity가 리스너 인터페이스 직접 구현
    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this, "두번째 Activity 방식!", Toast.LENGTH_SHORT).show(); // MainActivity.this를 명시적으로 작성해야 한다.
    }

    // 1. 별도의 리스너 인터페이스 구현 클래스 작성
    class MyClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "첫번째 방식!", Toast.LENGTH_SHORT).show(); // MainActivity.this를 명시적으로 작성해야 한다.
        }
    }

    // 4. 익명 내부 클래스로 구현
    View.OnClickListener myClickListener = new View.OnClickListener() { // 클래스인 것처럼 취급될 수 있게 메소드를 채워넣어 객체를 생성한다->인터페이스에서 직접 객체 생성
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "네번째 익명 클래스 방식!", Toast.LENGTH_SHORT).show(); // MainActivity.this를 명시적으로 작성해야 한다.
        }
    };

    // 3. 뷰를 직접 작성하여 뷰에 리스너 인터페이스 구현
    class MyView extends View implements View.OnTouchListener {
        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawColor(Color.YELLOW);
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            Toast.makeText(MainActivity.this, "세번째 View 자체 구현 방식!", Toast.LENGTH_SHORT).show();
            return true; // true 반환값 의미: 이 이벤트 핸들러가 수행되면 해당 이벤트의 처리는 끝났다는 의미
                         // false 반환값 의미: 해당 이벤트를 처리할 수 있는 기능을 모두 실행(상위로 전달). onTouch->onTouchEvent
        }
    }

    // 메소드 선언 <- 운영체제(시스템)이 호출: method callback
//    @Override
//    public boolean onTouchEvent(MotionEvent event) { // 이벤트 핸들러 메소드 재정의. view 터치 기능이 activity에서 처리됨
//        Toast.makeText(this, "Touch Event!!!", Toast.LENGTH_SHORT).show();
//        return true;
//    }
}