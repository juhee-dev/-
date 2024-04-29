package ddwucom.mobile.week10.practice1;

import android.app.AppComponentFactory;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WeatherAdapter extends BaseAdapter {
    int count;
    private Context context;
    private int layout;
    private ArrayList<WeatherData> weatherDataList;
    private LayoutInflater layoutInflater;

    public WeatherAdapter(Context context, int layout, ArrayList<WeatherData> weatherDataList) {
        this.context = context;
        this.layout = layout;
        this.weatherDataList = weatherDataList;
        count = 0;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return weatherDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return weatherDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return weatherDataList.get(position).get_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        ViewHolder viewHolder;

        if(convertView == null) {
            convertView = layoutInflater.inflate(layout, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.tvNo = convertView.findViewById(R.id.tvNo); // 처음 한 번만 id를 찾아놓으면 viewHolder 에 보관하여 convertView 에서 재사용할 수 있다. 뷰 개수만큼만 호출됨
            viewHolder.tvName = convertView.findViewById(R.id.tvName);
            viewHolder.tvPhone = convertView.findViewById(R.id.tvPhone);
            viewHolder.button = convertView.findViewById(R.id.button);

            convertView.setTag(viewHolder); // 만들어둔 view 항목들을 보관

        }

        TextView tvNo = convertView.findViewById(R.id.tvNo);
        TextView tvLocation = convertView.findViewById(R.id.tvLocation);
        TextView tvDetail = convertView.findViewById(R.id.tvDetail);
        TextView tvWeather = convertView.findViewById(R.id.tvWeather);

        tvNo.setText((String.valueOf(weatherDataList.get(position).get_id())));
        tvLocation.setText(weatherDataList.get(position).getLocation());
        tvDetail.setText(weatherDataList.get(position).getDetail());
        tvWeather.setText(weatherDataList.get(position).getWeather());

        return convertView;
    }
}
