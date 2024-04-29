package ddwucom.mobile.finalreport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {
    Movie movie;

    EditText etTitle;
    EditText etDirector;
    EditText etRate;
    EditText etDate;
    EditText etReview;
    CalendarView calendarView;
    RatingBar ratingBar2;

    MovieDBManager movieDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        movie = (Movie) getIntent().getSerializableExtra("movie");

        etTitle = findViewById(R.id.etTitle);
        etDirector = findViewById(R.id.etDirector);
        etRate = findViewById(R.id.etRate);
        etDate = findViewById(R.id.etDate);
        etReview = findViewById(R.id.etReview);
        calendarView = findViewById(R.id.calendarView);
        ratingBar2 = findViewById(R.id.ratingBar2);

        etTitle.setText(movie.getTitle());
        etDirector.setText(movie.getDirector());
        etRate.setText(movie.getRate());
        etDate.setText(movie.getDate());
        etReview.setText(movie.getReview());
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = year +"-"+ (month+1) +"-"+ dayOfMonth;
                etDate.setText(date);
            }
        });
        ratingBar2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                etRate.setText(rating +"점");
            }
        });


        movieDBManager = new MovieDBManager(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnUpdate:
                movie.setTitle(etTitle.getText().toString());
                movie.setDirector(etDirector.getText().toString());
                movie.setRate(etRate.getText().toString());
                movie.setDate(etDate.getText().toString());
                movie.setReview(etReview.getText().toString());

                if (!isTextInputted(movie)) {
                    Toast.makeText(this, "필수 항목을 입력하세요!", Toast.LENGTH_SHORT).show();
                    break;
                }

                if (movieDBManager.modifyMovie(movie)) {    // 정상수행에 따른 처리
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("title", etTitle.getText().toString());
                    setResult(RESULT_OK, resultIntent);
                    finish();
                } else {        // 이상에 따른 처리
                    Toast.makeText(this, "리뷰 수정 실패!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnCancel:   // 취소에 따른 처리
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }

    // 필수 항목을 입력하지 않은 상태면 false 반환
    public boolean isTextInputted(Movie movie) {
        if ((movie.getTitle().length() == 0) || (movie.getDirector().length() == 0) || (movie.getRate().length() == 0) || (movie.getDate().length() == 0))
            return false;
        return true;
    }

}
