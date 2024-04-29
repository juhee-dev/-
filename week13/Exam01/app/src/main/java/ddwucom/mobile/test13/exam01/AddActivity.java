package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    EditText etFood;
    EditText etNation;

    FoodDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etFood = findViewById(R.id.etAddFood);
        etNation = findViewById(R.id.etAddNation);

        dbHelper = new FoodDBHelper(this); // DB에 작성해야 하므로 dbHelper 사용
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAddFood:
                SQLiteDatabase myDB = dbHelper.getWritableDatabase();
                ContentValues value = new ContentValues();
                value.put(FoodDBHelper.COL_FOOD, etFood.getText().toString());
                value.put(FoodDBHelper.COL_NATION, etNation.getText().toString());

                long count = myDB.insert(FoodDBHelper.TABLE_NAME, null, value); // insert 메소드: 정상적으로 데이터 삽입이 이루어진 경우 1, 아니면 0 반환

                if (count > 0) {    // 정상적으로 추가되면 홈 화면으로 돌아감
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("food", etFood.getText().toString());
                    setResult(RESULT_OK, resultIntent);
                    dbHelper.close();
                    finish();
                } else { // 이상에 따른 처리
                    Toast.makeText(this, "음식 추가 실패", Toast.LENGTH_SHORT).show();
                    dbHelper.close();
                }
                break;
            case R.id.btnAddCancel:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}
