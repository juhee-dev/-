package ddwucom.mobile.test08.adapterclicktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SubjectManager subjectManager;
    ArrayList<String> subjectList;
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editText;

    int selectedPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subjectManager = new SubjectManager();
        subjectList = subjectManager.getSubjectList();

        adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, subjectList
        );

        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        editText = findViewById(R.id.etItem);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) { // 아이템을 클릭하면 editText 에 문자열 띄움
                editText.setText(subjectManager.getDataByPos(position));
                selectedPos = position;
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) { // 아이템을 롱클릭하면 삭제
                subjectManager.removeData(position); // 데이터 삭제 메소드
                adapter.notifyDataSetChanged(); // 원본 데이터가 달라졌음을 알려주는 메소드 -> adapter view 갱신
                return true;
            }
        });

    }

    public void onClick(View v) {
        String data = editText.getText().toString();
        switch (v.getId()) {
            case R.id.btnInsert:
                subjectManager.addData(data);
                adapter.notifyDataSetChanged();
                break;
            case R.id.btnUpdate:
                subjectManager.updateData(selectedPos, data);
                adapter.notifyDataSetChanged();
                break;
        }
    }

}
