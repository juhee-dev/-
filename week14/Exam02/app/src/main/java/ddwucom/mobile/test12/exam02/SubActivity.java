package ddwucom.mobile.test12.exam02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    EditText etFood;
    EditText etNation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        etFood = findViewById(R.id.et_food_name);
        etNation = findViewById(R.id.et_nation);
    }


    public void onClick(View v) {
//        버튼의 종류에 따라 결과 설정 후 finish()

    }
}

