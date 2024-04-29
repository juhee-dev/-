package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final static int REQ_CODE = 100;
    final static int UPDATE_CODE = 200;
    final static int REMOVE_CODE = 300;

    TextView tvDisplay;
    FoodDBHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvDisplay);

        myDbHelper = new FoodDBHelper(this);
        myDbHelper.getReadableDatabase();
    }


    public void onClick(View v) {
        SQLiteDatabase myDB = myDbHelper.getWritableDatabase();
//        SQLiteDatabase myDB = myDbHelper.getReadableDatabase();

        switch(v.getId()) {
            case R.id.btnSelect:
                Cursor cursor = myDB.rawQuery("select * from " + FoodDBHelper.TABLE_NAME, null);

                String result = "";
                while (cursor.moveToNext()) {
                    result += cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_ID)) + " : ";
                    result += cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_FOOD)) + " : ";
                    result += cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_NATION)) + " : ";
                }
                tvDisplay.setText(result);
                cursor.close();
                break;
            case R.id.btnAdd:
                Intent intent = new Intent(this, AddActivity.class);
                startActivityForResult(intent, REQ_CODE);
                break;
            case R.id.btnUpdate:
                intent = new Intent(this, UpdateActivity.class);
                startActivityForResult(intent, UPDATE_CODE);
                break;
            case R.id.btnRemove:
                intent = new Intent(this, RemoveActivity.class);
                startActivityForResult(intent, REMOVE_CODE);
                break;
        }

        myDbHelper.close(); // 항상 close 해야 한다
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQ_CODE) {
            switch (resultCode) {
                case RESULT_OK:
                    Toast.makeText(this, "음식 추가 완료", Toast.LENGTH_SHORT).show();
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "음식 추가 취소", Toast.LENGTH_SHORT).show();
                    break;
            }
        } else if (requestCode == UPDATE_CODE) {
                switch (resultCode) {
                    case RESULT_OK:
                        Toast.makeText(this, "음식 수정 완료", Toast.LENGTH_SHORT).show();
                        break;
                    case RESULT_CANCELED:
                        Toast.makeText(this, "음식 수정 취소", Toast.LENGTH_SHORT).show();
                        break;
            }
        } else if (requestCode == REMOVE_CODE) {
            switch (resultCode) {
                case RESULT_OK:
                    Toast.makeText(this, "음식 삭제 완료", Toast.LENGTH_SHORT).show();
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "음식 삭제 취소", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

}
