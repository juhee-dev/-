package ddwucom.mobile.week05.exam02;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {
    int circleX, circleY, circleR;

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private  void init() { // 좌표 초기화
        circleX = 100;
        circleY = 100;
        circleR = 80;
    }

    public int getCircleX() {
        return circleX;
    }

    public int getCircleY() {
        return circleY;
    }

    public int getCircleR() {
        return circleR;
    }

    public void setCircleX(int circleX) {
        this.circleX = circleX;
    }

    public void setCircleY(int circleY) {
        this.circleY = circleY;
    }

    public void setCircleR(int circleR) {
        this.circleR = circleR;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.YELLOW);

        Paint pnt = new Paint();
        pnt.setColor(Color.BLUE);

        canvas.drawCircle(circleX, circleY, 80, pnt);
    }
}
