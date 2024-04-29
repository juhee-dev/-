package ddwucom.mobile.week10.practice1;

public class WeatherData {
    private int _id;
    private String location;
    private String detail;
    private String weather;

    public WeatherData(int _id, String location, String detail, String weather) {
        this._id = _id;
        this.location = location;
        this.detail = detail;
        this.weather = weather;
    }

    public int get_id() {
        return _id;
    }
    public void set_id(int _id) {
        this._id = _id;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getWeather() {
        return weather;
    }
    public void setWeather(String weather) {
        this.weather = weather;
    }
}
