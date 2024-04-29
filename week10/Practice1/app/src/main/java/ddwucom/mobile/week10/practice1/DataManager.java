package ddwucom.mobile.week10.practice1;

import java.util.ArrayList;

public class DataManager {
    ArrayList<WeatherData> weatherDataList;

    public DataManager() {
        weatherDataList.add(new WeatherData(1, "하월곡동", "서울시 성북구", "좋음"));
        weatherDataList.add(new WeatherData(2, "소사본동", "경기도 부천시", "보통"));
        weatherDataList.add(new WeatherData(3, "구로1동", "서울시 구로구", "나쁨"));
        weatherDataList.add(new WeatherData(4, "하월곡동", "서울시 성북구", "좋음"));
        weatherDataList.add(new WeatherData(5, "소사본동", "경기도 부천시", "보통"));
        weatherDataList.add(new WeatherData(6, "구로1동", "서울시 구로구", "나쁨"));
        weatherDataList.add(new WeatherData(7, "하월곡동", "서울시 성북구", "좋음"));
        weatherDataList.add(new WeatherData(8, "소사본동", "경기도 부천시", "보통"));
        weatherDataList.add(new WeatherData(9, "구로1동", "서울시 구로구", "나쁨"));
        weatherDataList.add(new WeatherData(10, "하월곡동", "서울시 성북구", "좋음"));
        weatherDataList.add(new WeatherData(11, "소사본동", "경기도 부천시", "보통"));
        weatherDataList.add(new WeatherData(12, "구로1동", "서울시 구로구", "나쁨"));
        weatherDataList.add(new WeatherData(13, "하월곡동", "서울시 성북구", "좋음"));
        weatherDataList.add(new WeatherData(14, "소사본동", "경기도 부천시", "보통"));
        weatherDataList.add(new WeatherData(15, "구로1동", "서울시 구로구", "나쁨"));
        weatherDataList.add(new WeatherData(16, "하월곡동", "서울시 성북구", "좋음"));
        weatherDataList.add(new WeatherData(17, "소사본동", "경기도 부천시", "보통"));
        weatherDataList.add(new WeatherData(18, "구로1동", "서울시 구로구", "나쁨"));
        weatherDataList.add(new WeatherData(19, "하월곡동", "서울시 성북구", "좋음"));
        weatherDataList.add(new WeatherData(20, "소사본동", "경기도 부천시", "보통"));
    }

    public String getString(int pos) {
        return weatherDataList.get(pos).getDetail() + " " + weatherDataList.get(pos).getLocation() + "의 날씨는 " + weatherDataList.get(pos).getWeather();
    }
}
