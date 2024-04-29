package ddwucom.mobile.week3.practice03.exam02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    int num1 = 0, num2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        EditText myEdit = findViewById(R.id.etDisplay);
        String msg = myEdit.getText().toString();

        switch(v.getId()) {
            case R.id.btn_1:
                msg += "1";
                break;
            case R.id.btn_2:
                msg += "2";
                break;
            case R.id.btn_plus:
                num1 = Integer.parseInt(msg);
                msg = "";
                break;
            case R.id.btn_equal:
                if (msg.length() != 0) // msg != null 를 사용하는 경우에는 오류. 왜?
                    num2 = Integer.parseInt(msg);
                msg = String.valueOf(num1 + num2);
                break;
        }

        myEdit.setText(msg);
    }
}