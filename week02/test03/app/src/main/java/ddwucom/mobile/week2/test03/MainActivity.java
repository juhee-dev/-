package ddwucom.mobile.week2.test03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate is started");

        TextView myText = new TextView(this);
        myText.setText("코드로 문자열 출력");
        setContentView(myText);
    }
}