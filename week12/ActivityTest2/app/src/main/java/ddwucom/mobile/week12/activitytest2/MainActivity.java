package ddwucom.mobile.week12.activitytest2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static final int REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
//                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 02-952-6510")); // 전화 기능을 갖고있는 어떠한 요소를 실행시켜달라고 전달: 묵시적 인텐트
//                startActivity(intent); // 특정 activity 를 찾아 전달

                Intent intent = new Intent(MainActivity.this, SubActivity2.class); // SubActivity1 호출 요청: 명시적 인텐트
//
//                String id = "dongduk";
//                intent.putExtra("id", id);
//
//                ArrayList<String> foods = new ArrayList<String>(); // List 는 intent 구현되어있지 않음. ArrayList 는 intent 구현되어 있음
//                foods.add("사과");
//                foods.add("배");
//                foods.add("수박");
//
//                intent.putExtra("foods", foods); // 호출 액티비티: extras 이용하여 자료 저장
//                startActivity(intent); // 특정 activity 를 찾아 전달

                startActivityForResult(intent, REQ_CODE); // 수정된 액티비티를 호출 요청: onActivityResult 로 불러옴
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { // 변화된 결과를 불러오는 메소드
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE) {
            switch (resultCode) {
                case RESULT_OK:
                    String result = data.getStringExtra("result_data"); // key 값으로 피호출 액티비티에서 수정된 결과 불러옴
                    Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "Canceled!!", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}