package ddwucom.mobile.finalreport;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MovieDBHelper extends SQLiteOpenHelper {
    final static String DB_NAME = "movies.db";
    public final static String TABLE_NAME = "movie_table";

    public final static String COL_ID = "_id";
    public final static String COL_TITLE = "title";
    public final static String COL_DIRECTOR = "director";
    public final static String COL_RANK = "rank";
    public final static String COL_DATE = "date";
    public final static String COL_REVIEW = "review";

    public MovieDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " integer primary key autoincrement, " +
                COL_TITLE + " TEXT, " + COL_DIRECTOR + " TEXT, " + COL_RANK + " TEXT, " + COL_DATE + " TEXT, " + COL_REVIEW + " TEXT)";
        db.execSQL(sql);

        db.execSQL("insert into " + TABLE_NAME + " values (null, '써니', '강형철', '4.5점', '2017-05-30', '우정 영화');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '싱 스트리트', '존 카니', '3.0점', '2015-02-04', '청춘 영화');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '인셉션', '크리스토퍼 놀란', '5.0점', '2018-11-27', 'SF 영화');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '불량 공주 모모코', '나카시마 테츠야', '3.5점', '2019-12-21', '일본 우정 영화');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '매드맥스:분노의 도로', '조지 밀러', '5.0점', '2020-01-06', 'SF / 디스토피아 영화');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
