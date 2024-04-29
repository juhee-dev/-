package ddwucom.mobile.week03.project02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onMyBtnClick(View v) {
        EditText name = findViewById(R.id.etName);
        EditText phone = findViewById(R.id.etPhone);

        String msg = "안녕하세요, 저는 "+ name.getText().toString() +"입니다. 전화번호는 "+ phone.getText().toString() +"입니다.";

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    public void onMyExitBtnClick(View v) {
        finish();
    }
}