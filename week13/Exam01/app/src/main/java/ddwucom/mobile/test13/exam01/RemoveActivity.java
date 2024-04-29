package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RemoveActivity extends AppCompatActivity {
    EditText etRFood;

    FoodDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        etRFood = findViewById(R.id.etRemoveFood);

        dbHelper = new FoodDBHelper(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRemoveFood:
                SQLiteDatabase myDB = dbHelper.getWritableDatabase();
                String whereClause = "food=?";  // 조건
                String[] whereArgs = new String[] {etRFood.getText().toString()};   // 조건 값

                long count = myDB.delete(FoodDBHelper.TABLE_NAME, whereClause, whereArgs);

                if (count > 0) {    // 정상적으로 추가되면 홈 화면으로 돌아감
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("food", etRFood.getText().toString());
                    setResult(RESULT_OK, resultIntent);
                    dbHelper.close();
                    finish();
                } else {
                    Toast.makeText(this, "음식 삭제 실패", Toast.LENGTH_SHORT).show();
                    dbHelper.close();
                }
                break;
            case R.id.btnRemoveCancel:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}
