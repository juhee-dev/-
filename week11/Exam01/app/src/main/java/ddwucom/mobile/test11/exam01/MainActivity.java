package ddwucom.mobile.test11.exam01;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter adapter;
    ArrayList<Food> foodList;
    FoodManager foodManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        foodManager = new FoodManager(); // 실제 데이터

        // DataManager
        foodList = foodManager.getFoodList(); // 가져온 데이터

        // Food 객체의 toString() 메소드가 호출되어 하나의 문자열로 처리됨
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, foodList); // foodList 는 food 객체이지만 toString 메소드 이용하여 문자열로 변환되어 사용

        listView.setAdapter(adapter);

        // listView 롱클릭 이벤트 추가
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                String msg = foodList.get(position).getFood() +"을(를) 삭제하시겠습니까?"; // food 객체의 음식이름 꺼내오기

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("음식 삭제");
                builder.setMessage(msg);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // step1. 원본 데이터 삭제 - foodManager 의 메소드 이용
                        foodManager.deleteFood(position); // position 값을 상수로 설정해야. 대화상자 뜨는 시점과 클릭시점이 다르기 때문에
                        // step2. 화면 갱신
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("취소", null);
                builder.setCancelable(false);
                builder.show();

                return true;
            }
        });
    }

    public void onClick(View v) {
        final ConstraintLayout orderLayout = (ConstraintLayout) View.inflate(this, R.layout.order_layout, null); // custom layout 객체 생성

        switch(v.getId()) {
            case R.id.button:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("음식 추가")
                        .setView(orderLayout) // 레이아웃 연결
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("추가", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 커스텀 대화상자의 내용을 읽어옴
                                EditText etFoodName = orderLayout.findViewById(R.id.etFoodName);
                                EditText etFoodNation = orderLayout.findViewById(R.id.etFoodNation);
                                // 원본데이터 추가
                                foodManager.addFood(new Food(etFoodName.getText().toString(), etFoodNation.getText().toString()));
                                // 화면 갱신
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() { // 앱 끄기
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setCancelable(false) // 핸드폰의 돌아가기 버튼 눌러도 대화상자 유지하도록
                        .show();
                break;
        }
    }

}
