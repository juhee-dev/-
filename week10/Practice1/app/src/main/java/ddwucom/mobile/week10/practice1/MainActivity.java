package ddwucom.mobile.week10.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private WeatherAdapter weatherAdapter;
    private ListView listView;
    DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataManager = new DataManager(); // 원본 데이터 생성

        listView = findViewById(R.id.customListView);

        weatherAdapter = new WeatherAdapter(this, R.layout.custom_adapter_view, dataManager.weatherDataList);

        listView.setAdapter(weatherAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, dataManager.getString(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}