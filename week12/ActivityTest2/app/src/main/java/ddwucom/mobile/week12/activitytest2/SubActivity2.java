package ddwucom.mobile.week12.activitytest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SubActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnOk:
                Intent resultIntent = new Intent(); // 결과 저장 intent
                resultIntent.putExtra("result_data", "good!"); // 결과 저장
                setResult(RESULT_OK, resultIntent); // 변화시킨 결과를 mainActivity 에 돌려줌
                break;
            case R.id.btnCancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish(); // 현재 액티비티 종료: 호출 activity(mainActivity) 의 onActivityResult 로 돌아감
    }

}