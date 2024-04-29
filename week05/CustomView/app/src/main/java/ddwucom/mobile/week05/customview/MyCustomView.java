package ddwucom.mobile.week05.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyCustomView extends View {

    int y = 100;

    public MyCustomView(Context context) {
        super(context);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setCircleY(int y) {
        this.y = y;
    }
    public int getCirecleY() { // 상속받은 View 클래스의 getY는 float를 반환하는데 반환타입이 다르므로 오류가 뜬다. 따라서 게터의 이름을 다르게 정의
        return y;
    }

    @Override
    protected void onDraw(Canvas canvas) { // 만약 다른 그림이 있다면 그 그림들도 다 다시 그려야함
        super.onDraw(canvas);
        canvas.drawColor(Color.YELLOW);
        Paint pnt = new Paint();
        pnt.setColor(Color.BLUE);
        canvas.drawCircle(100, y, 80, pnt);
    }
}
