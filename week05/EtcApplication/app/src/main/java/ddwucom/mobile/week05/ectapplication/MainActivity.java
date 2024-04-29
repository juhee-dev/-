package ddwucom.mobile.week05.ectapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    SoundPool soundPool;
    int sound;

    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        sound = soundPool.load(this, R.raw.dingdong, 1); // 소리를 loading하는 단계. 메모리공간에 할당하여 매번 loading될 필요 없게 한다.

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); // 시스템으로부터 진동 관리자를 얻어온다.
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button:
                soundPool.play(sound, 1, 1, 0, 0, 1); // 버튼 눌렀을 때 바로 소리가 들릴 수 있도록 실행시 onCreate 메소드에서 먼저 loading되게 한다.
                break;
            case R.id.button2:
//                vibrator.vibrate(500);
                vibrator.vibrate(new long[] {100, 50, 200, 50}, 0); // 진동의 패턴 설정
//                vibrator.cancel(); // 진동 중지 기능
                break;
        }
    }
}