package ddwucom.mobile.week07.mycircletest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MyCircle myCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myCircle = findViewById(R.id.myCircle);

        registerForContextMenu(myCircle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemBigger:
                myCircle.setCircleR(myCircle.circleR + 20);
                myCircle.invalidate();
                break;
            case R.id.itemSmaller:
                myCircle.setCircleR(myCircle.circleR - 20);
                myCircle.invalidate();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()) {
            case R.id.myCircle:
                menu.setHeaderTitle("Change Color");
                getMenuInflater().inflate(R.menu.menu_context, menu);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemRed:
                item.setChecked(true);
                myCircle.setPaintColor(Color.RED);
                myCircle.invalidate();
                break;
            case R.id.itemGreen:
                item.setChecked(true);
                myCircle.setPaintColor(Color.GREEN);
                myCircle.invalidate();
                break;
            case R.id.itemBlue:
                item.setChecked(true);
                myCircle.setPaintColor(Color.BLUE);
                myCircle.invalidate();
                break;
        }
        return super.onContextItemSelected(item);
    }
}

