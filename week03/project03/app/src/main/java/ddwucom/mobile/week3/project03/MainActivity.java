package ddwucom.mobile.week3.project03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        EditText myEdit = findViewById(R.id.editText);
        String msg = myEdit.getText().toString();

        switch(v.getId()) {
            case R.id.btnOne:
                msg += "1";
                break;
            case R.id.btnTwo:
                msg += "2";
                break;
            case R.id.btnThree:
                msg += "3";
                break;
            case R.id.btnClear:
                msg = "";
                break;
        }

        myEdit.setText(msg);
    }

}