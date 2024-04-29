package ddwucom.mobile.week12.activitytest2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SubActivity1 extends AppCompatActivity {
    private static final String TAG = "SubActivity1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);

        Intent intent = getIntent();

        String id = intent.getStringExtra("id"); // 피호출 액티비티: 전달받은 intent 불러오기
        ArrayList<String> foods =
                (ArrayList<String>)intent.getSerializableExtra("foods"); // ArrayList 등 객체는 는 Serializing 으로 불러오기: downCasting 이므로 typeCasting 해야

        Log.d(TAG, "id: "+ id);
        Log.d(TAG, foods.get(0));
        Log.d(TAG, foods.get(1));
        Log.d(TAG, foods.get(2));

    }
}
