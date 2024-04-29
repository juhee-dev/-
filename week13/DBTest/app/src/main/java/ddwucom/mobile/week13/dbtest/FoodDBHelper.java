package ddwucom.mobile.week13.dbtest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class FoodDBHelper extends SQLiteOpenHelper {
    final static String TAG = "FoodDBHelper";
    final static String DB_NAME = "foods.db";

    public final static String TABLE_NAME = "food_table";
    public final static String COL_ID = "_id";
    public final static String COL_FOOD = "food";
    public final static String COL_NATION = "nation";

    public FoodDBHelper(Context context) {
        super(context, DB_NAME, null, 1); // activity 에서 전달받은 context, DB 파일명, 커서팩토리, DB ver
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " integer primary key autoincrement, " +
                COL_FOOD + " TEXT, " + COL_NATION + " TEXT)";
        Log.d(TAG, sql);
        db.execSQL(sql); // 테이블을 만드는 것이므로 db 변경을 일으키는 메소드 수행
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME); // 만약 테이블이 있으면 삭제하고
        onCreate(db); // 새로운 테이블을 생성
    }
}
