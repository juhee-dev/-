package ddwucom.mobile.finalreport;

import java.io.Serializable;

public class Movie implements Serializable {
    private long _id;
    private String title;
    private String director;
    private String rate;
    private String date;
    private String review;

    public Movie(String title, String director, String rate, String date, String review) {
        this.title = title;
        this.director = director;
        this.rate = rate;
        this.date = date;
        this.review = review;
    }

    public Movie(long _id, String title, String director, String rate, String date, String review) {
        this._id = _id;
        this.title = title;
        this.director = director;
        this.rate = rate;
        this.date = date;
        this.review = review;
    }

    public long get_id() { return _id; }
    public void set_id(long _id) { this._id = _id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDirector() { return director; }
    public void setDirector(String phone) { this.director = director; }

    public String getRate() { return rate; }
    public void setRate(String rate) { this.rate = rate; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getReview() { return review; }
    public void setReview(String review) { this.review = review; }

}
