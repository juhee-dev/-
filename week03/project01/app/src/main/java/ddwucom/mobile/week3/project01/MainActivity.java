package ddwucom.mobile.week3.project01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String msg = "Mobile Software!\n" +
                "Mobile Software!\n" +
                "Mobile Software!\n" +
                "Mobile Software!\n" +
                "Mobile Software!\n" +
                "Mobile Software!\n" +
                "Mobile Software!\n";

        TextView textView = findViewById(R.id.my_text);
        textView.setText(msg);
    }

    public void onClick(View v) {
        EditText myEdit = findViewById(R.id.myEditText);
        String msg = myEdit.getText().toString();

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

        myEdit.setText("Mobile!!!");
    }
}