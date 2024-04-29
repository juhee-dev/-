package ddwucom.mobile.week10.customadaptertest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

public class MyAdapter extends BaseAdapter {

    final static String TAG = "MyAdapter";

    int count;
    private Context context;
    private int layout;
    private ArrayList<MyData> myDataList;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context, int layout, ArrayList<MyData> myDataList) {
        this.context = context;
        this.layout = layout;
        this.myDataList = myDataList;
        count = 0;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myDataList.size();
    } // 원본 데이터의 개수

    @Override
    public Object getItem(int position) { // 어떤 타입의 객체든 상관 없도록 Object 객체 형식으로 반환: UpCasting
        return myDataList.get(position);
    } // 특정 순서의 객체를 꺼낸다

    @Override
    public long getItemId(int position) {
        return myDataList.get(position).get_id();
    } // 특정 순서의 객체 id 를 꺼낸다

    @Override
    public View getView(int position, View convertView, ViewGroup parent) { // 원본 데이터 개수만큼 뷰 호출
        final int pos = position;
        ViewHolder viewHolder;

        Log.d(TAG, "call getView()");

        if(convertView == null) {
            convertView = layoutInflater.inflate(layout, parent, false); // 화면에 담을 수 있을 만큼만 뷰 출력

            viewHolder = new ViewHolder();
            viewHolder.tvNo = convertView.findViewById(R.id.tvNo); // 처음 한 번만 id를 찾아놓으면 viewHolder 에 보관하여 convertView 에서 재사용할 수 있다. 뷰 개수만큼만 호출됨
            viewHolder.tvName = convertView.findViewById(R.id.tvName);
            viewHolder.tvPhone = convertView.findViewById(R.id.tvPhone);
            viewHolder.button = convertView.findViewById(R.id.button);

            convertView.setTag(viewHolder); // 만들어둔 view 항목들을 보관

            Log.d(TAG, "count: "+ count++);
        } else {
            viewHolder = (ViewHolder) convertView.getTag(); // 이미 view 항목들이 만들어져 있으면 그것들을 가져와 데이터를 바꿔치기 한다
        }

//        button.setFocusable(false); // 버튼 말고도 다른 항목 클릭을 인식할 수 있게 한다.

        viewHolder.tvNo.setText(String.valueOf(myDataList.get(position).get_id()));
        viewHolder.tvName.setText(myDataList.get(position).getName());
        viewHolder.tvPhone.setText(myDataList.get(position).getPhone());

        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, myDataList.get(pos).getPhone() +"선택", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    static class ViewHolder {
        TextView tvNo;
        TextView tvName;
        TextView tvPhone;
        TextView button;
    }
}
