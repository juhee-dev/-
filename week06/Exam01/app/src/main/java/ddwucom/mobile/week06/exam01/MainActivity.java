package ddwucom.mobile.week06.exam01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnDisplay;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        btnDisplay = findViewById(R.id.btnDisplay);
        tvDisplay = findViewById(R.id.tvDisplay);

//        MyClick myClick = new MyClick();
        btnDisplay.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = editText.getText().toString();
                tvDisplay.setText(msg);
            }
        } );
    }

    // 2.4 익명 내부 클래스 구현으로 작성
//    View.OnClickListener myClick = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            String msg = editText.getText().toString();
//            tvDisplay.setText(msg);
//        }
//    };

    // 2.1 별도의 리스너 인터페이스 구현 클래스 작성
//    class MyClick implements View.OnClickListener {
//        @Override
//        public void onClick(View v) {
//            String msg = editText.getText().toString();
//            tvDisplay.setText(msg);
//        }
//    }
}