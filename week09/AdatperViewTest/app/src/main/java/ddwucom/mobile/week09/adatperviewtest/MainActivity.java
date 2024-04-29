package ddwucom.mobile.week09.adatperviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DataManager dataManager;
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editText;

    int selectedPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataManager = new DataManager();

//        원본 데이터를 가져오는 방법 4: 별도의 data manager class 만들어 화면과 Data 분리
        ArrayList<String> subjectList = dataManager.getSubjectList();

//        원본 데이터를 가져오는 방법 1: ArrayList 의 add 메소드로 data 추가
//        원본 데이터를 가져오는 방법 2: 배열
//        String[] subjectList = {"모바일소프트웨어", "네트워크", "웹서비스", "운영체제", "웹프로그래밍2"};

//        원본 데이터를 가져오는 방법 3: values/arrays.xml 리소스 파일 사용
//        String[] subjectList = getResources().getStringArray(R.array.subjectList);

        adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, subjectList); // step1. 어댑터 생성

        listView = findViewById(R.id.listview);
        editText = findViewById(R.id.editText);

        listView.setAdapter(adapter); // step2. adapter 와 listView 연결: layout 에 data 결합됨

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // listView 객체에 클릭 이벤트 리스너 연결
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) { // 클릭한 subject 값을 editText 에 불러옴
                Toast.makeText(MainActivity.this, "pos: " + position, Toast.LENGTH_SHORT).show(); // MainActivity 가 context 역할
                editText.setText(dataManager.getDataByPos(position)); // item 을 클릭하면 그 item 의 값을 editText 에 불러들임
                selectedPos = position;
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // listView 객체에 롱클릭 이벤트 리스너 연결
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                dataManager.removeSubject(position); // 데이터 삭제 메소드
                adapter.notifyDataSetChanged(); // 원본 데이터가 달라졌음을 알려주는 메소드 -> adapter view 갱신
                return true;
            }
        });
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAdd: // 추가 버튼을 누르면 editText 이름의 항목을 AdapterView 에 추가
                dataManager.addSubject(editText.getText().toString());
                adapter.notifyDataSetChanged();
                break;
            case R.id.btnUpdate: // 수정 버튼을 누르면 원본 데이터 수정
                // DataManager 에 수정 메소드 불러오기 (위치-selectedPos, 바꿀 값-editText 에서 불러온 값)
                dataManager.updateSubject(selectedPos, editText.getText().toString());
                // 어댑터 갱신 요청
                adapter.notifyDataSetChanged();
                break;
        }
    }
}