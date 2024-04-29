package ddwucom.mobile.week3.practice02.exam01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout layout; // 자주 사용하는 객체는 member로 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.linear_layout); // inflation을 수행한 뒤 findViewById 수행하여 id 객체 저장
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_vertical:
                layout.setOrientation(LinearLayout.VERTICAL);
                break;
            case R.id.btn_horizontal:
                layout.setOrientation(LinearLayout.HORIZONTAL);
                break;
        }
    }
}