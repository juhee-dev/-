package ddwucom.mobile.finalreport;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class MovieDBManager {
    MovieDBHelper movieDBHelper = null;
    Cursor cursor = null;
    SQLiteDatabase db;

    public MovieDBManager(Context context) { movieDBHelper = new MovieDBHelper(context); }

    public ArrayList<Movie> getAllMovie() {
        ArrayList movieList = new ArrayList(); // movieList 를 만들어 DB를 채운 후 movieList 반환
        db = movieDBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + movieDBHelper.TABLE_NAME, null);

        while(cursor.moveToNext()) {
            long id = cursor.getLong(cursor.getColumnIndex(movieDBHelper.COL_ID));
            String title = cursor.getString(cursor.getColumnIndex(movieDBHelper.COL_TITLE));
            String director = cursor.getString(cursor.getColumnIndex(movieDBHelper.COL_DIRECTOR));
            String rank = cursor.getString(cursor.getColumnIndex(movieDBHelper.COL_RANK));
            String date = cursor.getString(cursor.getColumnIndex(movieDBHelper.COL_DATE));
            String review = cursor.getString(cursor.getColumnIndex(movieDBHelper.COL_REVIEW));

            movieList.add ( new Movie (id, title, director, rank, date, review) );
        }

        cursor.close();
        movieDBHelper.close();
        return movieList;
    }

    //    DB 에 새로운 movie 추가
    public boolean addNewMovie(Movie newMovie) { // Movie 객체 DTO 를 전달받아 DB에 추가
        db = movieDBHelper.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(movieDBHelper.COL_TITLE, newMovie.getTitle());
        value.put(movieDBHelper.COL_DIRECTOR, newMovie.getDirector());
        value.put(movieDBHelper.COL_RANK, newMovie.getRate());
        value.put(movieDBHelper.COL_DATE, newMovie.getDate());
        value.put(movieDBHelper.COL_REVIEW, newMovie.getReview());

//      insert 메소드를 사용할 경우 데이터 삽입이 정상적으로 이루어질 경우 1 이상, 이상이 있을 경우 0 반환 확인 가능
        long result = db.insert(movieDBHelper.TABLE_NAME, null, value);
        movieDBHelper.close();
        if (result > 0) return true;
        return false;
    }

    //    _id 를 기준으로 movie 의 정보 변경
    public boolean modifyMovie(Movie movie) {
        db = movieDBHelper.getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put(MovieDBHelper.COL_TITLE, movie.getTitle());
        row.put(MovieDBHelper.COL_DIRECTOR, movie.getDirector());
        row.put(MovieDBHelper.COL_RANK, movie.getRate());
        row.put(MovieDBHelper.COL_DATE, movie.getDate());
        row.put(MovieDBHelper.COL_REVIEW, movie.getReview());

        String whereClause = MovieDBHelper.COL_ID + "=?"; // 조건
        String[] whereArgs = new String[] { String.valueOf(movie.get_id()) };
        long result = db.update(MovieDBHelper.TABLE_NAME, row, whereClause, whereArgs);
        movieDBHelper.close();
        if (result > 0) return true;
        return false;
    }

    //    _id 를 기준으로 DB에서 movie 삭제
    public boolean removeMovie(long id) {
        db = movieDBHelper.getWritableDatabase();
        String whereClause = MovieDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(id) };
        int result = db.delete(MovieDBHelper.TABLE_NAME, whereClause,whereArgs);
        movieDBHelper.close();
        if (result > 0) return true;
        return false;
    }

    //    영화 이름으로 DB 검색
    public String getMovieByTitle(String title) {
        String result = "";
        db = movieDBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ movieDBHelper.TABLE_NAME +" WHERE "+ movieDBHelper.COL_TITLE +"='"+ title +"'", null);
        if (cursor.getCount() == 0) {
            return null;
        }
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()) {
            result += cursor.getString(cursor.getColumnIndex(MovieDBHelper.COL_TITLE));
        }
        cursor.close();
        movieDBHelper.close();
        return result;
    }

    //    감독 이름으로 DB 검색
    public ArrayList<Movie> getMovieByDirector(String director) {
        return null;
    }

    //    id 로 DB 검색
    public Movie getMovieById(long id) {

        return  null;
    }

    //    close 수행
    public void close() {
        if (movieDBHelper != null) movieDBHelper.close();
        if (cursor != null) cursor.close();
    };
}
