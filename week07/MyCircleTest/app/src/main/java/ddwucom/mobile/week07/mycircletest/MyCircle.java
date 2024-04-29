package ddwucom.mobile.week07.mycircletest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyCircle extends View {
    int circleR = 100;
    int paintColor = Color.CYAN;

    public MyCircle(Context context) {
        super(context);
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setCircleR(int circleR) {   this.circleR = circleR; }
    public void setPaintColor(int paintColor) { this.paintColor = paintColor; }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.LTGRAY);

        Paint paint = new Paint();
        paint.setColor(paintColor);

        canvas.drawCircle(getWidth() / 2, getHeight() / 2, circleR, paint);
    }

}
