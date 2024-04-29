package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    EditText etId;
    EditText etFood;

    FoodDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        etId = findViewById(R.id.etUpdateId);
        etFood = findViewById(R.id.etUpdateFood);

        dbHelper = new FoodDBHelper(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnUpdateFood:
                SQLiteDatabase myDB = dbHelper.getWritableDatabase();
                ContentValues value = new ContentValues();
                Cursor cursor = myDB.rawQuery("select * from " + FoodDBHelper.TABLE_NAME, null); // cursor 가 각각의 column 값을 읽어들인다

                value.put("food", etFood.getText().toString());
                String whereClause  = "_id=?";
                String[] whereArgs = new String[] {etId.getText().toString()};   // 조건 값

                long count = myDB.update(FoodDBHelper.TABLE_NAME, value, whereClause, whereArgs);

                if (count > 0) {    // 정상적으로 추가되면 홈 화면으로 돌아감
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("food", etId.getText().toString());
                    setResult(RESULT_OK, resultIntent);
                    dbHelper.close();
                    finish();
                } else {
                    Toast.makeText(this, "음식 수정 실패", Toast.LENGTH_SHORT).show();
                    dbHelper.close();
                }

                break;
            case R.id.btnUpdateCancel:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}
