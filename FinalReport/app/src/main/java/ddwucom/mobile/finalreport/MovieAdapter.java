package ddwucom.mobile.finalreport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    int count;
    private Context context;
    private int layout;
    private ArrayList<Movie> movieList;
    private LayoutInflater layoutInflater;

    public MovieAdapter(Context context, int layout, ArrayList<Movie> movieList) {
        this.context = context;
        this.layout = layout;
        this.movieList = movieList;
        count = 0;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int position) {
        return movieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return movieList.get(position).get_id();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null) {
            convertView = layoutInflater.inflate(R.layout.movie_adapter_view, parent, false); // 화면에 담을 수 있을 만큼만 뷰 출력

            viewHolder = new ViewHolder();
            viewHolder.tvTitle = convertView.findViewById(R.id.tvTitle);
            viewHolder.tvDirector = convertView.findViewById(R.id.tvDirector);
            viewHolder.tvRank = convertView.findViewById(R.id.tvRank);
            viewHolder.tvDate = convertView.findViewById(R.id.tvDate);
            viewHolder.imageView = convertView.findViewById(R.id.imageView);
            switch (position / 5) {
                case 0:
                    viewHolder.imageView.setImageResource(R.mipmap.sunny);
                    break;
                case 1:
                    viewHolder.imageView.setImageResource(R.mipmap.singstreet);
                    break;
                case 2:
                    viewHolder.imageView.setImageResource(R.mipmap.inception);
                    break;
                case 3:
                    viewHolder.imageView.setImageResource(R.mipmap.momoko);
                    break;
                case 4:
                    viewHolder.imageView.setImageResource(R.mipmap.madmax);
                    break;
            }
            convertView.setTag(viewHolder); // 만들어둔 view 항목들을 보관
        } else {
            viewHolder = (ViewHolder) convertView.getTag(); // 이미 view 항목들이 만들어져 있으면 그것들을 가져와 데이터를 바꿔치기 한다
        }

        viewHolder.tvTitle.setText(movieList.get(position).getTitle());
        viewHolder.tvDirector.setText(movieList.get(position).getDirector());
        viewHolder.tvRank.setText(movieList.get(position).getRate());
        viewHolder.tvDate.setText(movieList.get(position).getDate());

        return convertView;
    }
    static class ViewHolder {
        TextView tvTitle;
        TextView tvDirector;
        TextView tvRank;
        TextView tvDate;
        ImageView imageView;
    }

}
