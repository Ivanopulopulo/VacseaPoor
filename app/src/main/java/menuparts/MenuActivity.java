package menuparts;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;

import com.mainaction.NewDraw;

public class MenuActivity extends Activity {

	menuparts.Menu2  d;
	
	NewDraw level;
	
	int[] records = new int[8];
	
	StartActivity k;
	
	 SharedPreferences sPref;
	
	 
	 void saveRec(int level, int record) {
		    sPref = getPreferences(MODE_PRIVATE);
		    Editor ed = sPref.edit();
		    ed.putInt(level+"", record);
		    ed.commit();
		  }
		  
		  int loadRec(int level) {
		    sPref = getPreferences(MODE_PRIVATE);
		    return sPref.getInt(level+"", 0);
		  }
	 
	 
	 
	 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		for (int i = 0; i<8; i++) {
			records[i]=loadRec(i);
		}
		
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		d = new Menu2(getApplicationContext(), this);
		
		k = new StartActivity(this);

		level = new NewDraw(getApplicationContext());
		
		setContentView(k);
		
		
		
		timer.start();
		
	}
	
	
	CountDownTimer timer = new CountDownTimer(100000000,30) {
		
		@Override
		public void onTick(long millisUntilFinished) {
			if ((Config.is >= 2)) {		
				d.inv();
				startLevel(Config.is);
				Config.is = 0;
			}
			if (Config.is == 1) {	
				setContentView(d);
		        if ((NewDraw.win)&(NewDraw.rec>records[NewDraw.nowlevel-2])) { records[NewDraw.nowlevel-2] = NewDraw.rec;}

				for (int i =0; i< 8; i++) {
					saveRec(i, records[i]);
				}
				
				d.records = records;
				d.vis = 255;
				d.start=true;
				Config.is = 0;
			}
		}
		
		@Override
		public void onFinish() {
			// TODO Auto-generated method stub
			timer.start();
		}
	};
	
	
	public void startLevel(int lev) {
		
		level.refresh(lev);
		level.start=true;
		level.vis = 255;
		
		setContentView(level);
		
		
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		
		super.onDestroy();
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		return super.onTouchEvent(event);

	}
	
}
