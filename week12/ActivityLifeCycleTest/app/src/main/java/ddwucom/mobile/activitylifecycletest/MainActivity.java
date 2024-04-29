//LogCat의 필터에 MainActivity 추가

package ddwucom.mobile.activitylifecycletest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

	static final String TAG = "MainActivity"; 
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i(TAG, "onCreate");
	}

	public void mOnClick(View v) {
		Log.i(TAG, "start Child Activity");
		Intent intent = new Intent(this, ChildActivity.class);
		startActivity(intent);
	}
	
	public void onStart() {
		super.onStart();
		Log.i(TAG, "onStart");
	}

	public void onResume() {
		super.onResume();
		Log.i(TAG, "onResume");
	}

	public void onPause() {
		super.onPause();
		Log.i(TAG, "onPause");
	}

	public void onRestart() {
		super.onRestart();
		Log.i(TAG, "onRestart");
	}

	public void onStop() {
		super.onStop();
		Log.i(TAG, "onStop");
	}

	public void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "onDestroy");
	}
	
//	앱을 사용하는 동안에는 상태 임시 저장
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		outState.putString("save_data", "test!");
		Log.i(TAG, "onSaveInstanceState");
		super.onSaveInstanceState(outState);
	}

//	임시 저장된 상태 복구
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.i(TAG, "onRestoreInstanceState: " + savedInstanceState.getString("save_data"));
		super.onRestoreInstanceState(savedInstanceState);
	}

}
