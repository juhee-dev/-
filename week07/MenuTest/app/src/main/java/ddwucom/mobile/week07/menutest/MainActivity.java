package ddwucom.mobile.week07.menutest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final static String TAG = "MainActivity";
    final static int MENU_FIRST = 100;
    final static int MENU_SECOND = 200;

    PopupMenu popup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView); // 롱클릭할 뷰 등록

        popup = new PopupMenu(this, textView); // popup 메뉴 객체 생성
        popup.getMenuInflater().inflate(R.menu.menu_main, popup.getMenu()); // popup 메뉴에 menu_main 을 연결
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // popup 메뉴 동작
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(MainActivity.this, "HI!", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        textView.setOnTouchListener(new View.OnTouchListener() { // 텍스트뷰 터치하면 팝업메뉴 띄우는 메소드
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popup.show();
                return true;
            }
        });
//        registerForContextMenu(textView); // Context Menu - step1. 사용할 롱클릭할 뷰 등록
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) { // Context Menu - step2. 메뉴 생성
        switch (v.getId()) {
            case R.id.textView:
                menu.setHeaderTitle("Context Menu!");
                menu.add(0, MENU_FIRST, 0, "FIRST"); // 방법1. 코드로 메뉴 연결
                menu.add(0, MENU_SECOND, 0, "SECOND");

                getMenuInflater().inflate(R.menu.menu_context, menu); // 방법2. xml로 메뉴 연결. 더 좋은 방법

                break;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) { // Context Menu - step3. 메뉴 선택 처리
        switch (item.getItemId()) {
            case MENU_FIRST: // 코드로 만들었기에 상수로 아이템을 찾는다
                Log.i(TAG, "context1");
                break;
            case MENU_SECOND:
                Log.i(TAG, "context2");
                break;
            case R.id.third: // xml로 만들었기에 id로 아이템을 찾는다
                Log.i(TAG, "context3");
                break;
            case R.id.fourth:
                Log.i(TAG, "context4");
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // activity가 시작할 때 한번만 호출되기 때문에 변경 불가 -> 메뉴 구성을 바꾸려면 별도의 메소드 필요
        getMenuInflater().inflate(R.menu.group_menu, menu); // 비어있는 menu 객체에 만든 group_menu 파일을 연결
        return true; // 작업이 끝났음을 의미
    }

//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) { // 메뉴 구성을 바꾸는 메소드
//        if(true) {
//            menu.clear(); // 메뉴를 덧붙이는게 아니라면 onCreateOptionMenu 메소드로 생성된 메뉴를 삭제해야 함
//            getMenuInflater().inflate(R.menu.menu_main, menu); // 비어있는 menu 객체에 만든 group_menu 파일을 연결
//        }
//
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) { // 메뉴 선택했을때 동작 구현
//        switch (item.getItemId()) {
//            case R.id.item01:
//                Log.i(TAG, "item01 is clicked!");
//                break;
//            case R.id.subItem01:
//                Log.i(TAG, "subItem01 is clicked!");
//                break;
//            case R.id.subItem02:
//                Log.i(TAG, "subItem02 is clicked!");
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { // 메뉴 선택했을때 동작 구현
        switch (item.getItemId()) {
            case R.id.gitem01:
                if(item.isChecked())    item.setChecked(false); // 체크가 되어있으면 체크를 풀어준다
                else    item.setChecked(true); // 체크가 안되어있으면 체크를 한다
                break;
            case R.id.gitem02:
                if(item.isChecked())    item.setChecked(false);
                else    item.setChecked(true);
                break;
            case R.id.gitem03:
                item.setChecked(true); // radio는 하나가 체크 true면 나머지는 다 false가 된다
                break;
            case R.id.gitem04:
                item.setChecked(true);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void onMenuItemClick(MenuItem item) { // 우선순위: onMenuItemClick > onOptionsItemSelected
        Log.i(TAG, "item01 is clicked!!!");
    }
}