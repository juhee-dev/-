package ddwucom.mobile.week3.practice01.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LayoutInflater inflater = LayoutInflater.from(this); // MainActivity는 context를 상속받기에 자기 자신을 넣어준다

        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.activity_main, null); // XML의 최상위 레이아웃을 반환

        setContentView(layout); // 화면에 객체를 채운다
    }
}