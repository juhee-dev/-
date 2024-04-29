package ddwucom.mobile.week11.dialogtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int selectedIndex = 0;
    boolean[] selectedItems = {false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        final String[] foodsArray = {"라면", "김밥", "떡볶이", "오뎅"};
//        custom layout 객체 생성 - findViewById 사용하기 위해 inflate 사용해 객체 만들어야 함
        final ConstraintLayout orderLayout = (ConstraintLayout) View.inflate(this, R.layout.order_layout, null);

        switch (v.getId()) {
            case R.id.button:
                AlertDialog.Builder builder = new AlertDialog.Builder(this); // builder 에서 dialog 객체를 만든다

                builder.setTitle("대화상자 제목") // 메소드 체이닝
//                    .setMessage("대화상자 메세지")
//                    .setItems(foodsArray, new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) { // which: 몇 번째 항목 클릭했는지 저장됨
//                            String[] foods = getResources().getStringArray(R.array.foods); // resource 에서 저장한 배열 불러옴
//                            Toast.makeText(MainActivity.this, foodsArray[which], Toast.LENGTH_SHORT).show(); // 클릭한 항목을 toast로 띄움
//                        }
//                    })
//                    .setSingleChoiceItems(R.array.foods, selectedIndex, new DialogInterface.OnClickListener() { // 라디오 버튼 - 선택한 항목의 정보를 멤버변수 selectedIndex 에 저장
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) { // 선택한 항목을 selectedIndex 로 저장
//                            selectedIndex = which;
//                        }
//                    })
//                    .setMultiChoiceItems(R.array.foods, selectedItems, new DialogInterface.OnMultiChoiceClickListener() { // 체크박스
//                        @Override
//                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
//                            selectedItems[which] = isChecked; // 체크 여부를 멤버변수 boolean type selectedItems 배열에 보관
//                        }
//                    })
                    .setView(orderLayout) // custom layout 적용 -
                    .setIcon(R.mipmap.ic_launcher)
                    .setPositiveButton("확인버튼", new DialogInterface.OnClickListener() { // 확인버튼을 클릭 시 이벤트 리스너 작동
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//                            String[] foods = getResources().getStringArray(R.array.foods);
//                            String result = "선택: ";
//                            for(int i = 0; i < selectedItems.length; i++) { // multiChoiceItems 중 체크 된 아이템만 선별
//                                if(selectedItems[i]) {
//                                    result += foods[i] +" ";
//                                }
//                            }
                            EditText etProduct = orderLayout.findViewById(R.id.etProduct);
                            EditText etQuantity = orderLayout.findViewById(R.id.etQuantity);
                            CheckBox cbPayment = orderLayout.findViewById(R.id.cbPayment);
                            String result = etProduct.getText() + " : " + etQuantity.getText() + " : " + cbPayment.isChecked(); // toString 사용하지 않아도 뒤의 문자열이 추가되기 때문에 자동으로 String 형으로 변환됨

                            Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNeutralButton("대기버튼", null)
                    .setNegativeButton("취소버튼", new DialogInterface.OnClickListener() { // 취소버튼 클릭 시 이벤트 리스너 작동
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish(); // 액티비티 종료
                        }
                    })
                    .setCancelable(false) // 핸드폰의 돌아가기 버튼이나 대화상자 바깥을 눌러도 대화상자 닫히지 않도록
                    .show(); // 대화상자 띄우는 방법1 - Builder 객체로

//                Dialog dlg = builder.create(); // 대화상자 띄우는 방법2 - Dialog 객체로
//                dlg.setCanceledOnTouchOutside(false); // 대화상자 바깥을 눌러도 대화상자 닫히지 않도록. Dialog 객체를 직접 생성해야 사용할 수 있다.
//                dlg.show();

                break;
        }
    }
}