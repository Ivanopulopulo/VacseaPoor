package menuparts;


import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.view.View;

import com.example.vacseapoor.R;





public class StartActivity extends View {

	NotAnimatePersmenu vac = new NotAnimatePersmenu(BitmapFactory.decodeResource(getResources(), R.drawable.startvac)), sea = new NotAnimatePersmenu(BitmapFactory.decodeResource(getResources(), R.drawable.startsear)), back = new NotAnimatePersmenu(BitmapFactory.decodeResource(getResources(), R.drawable.backstart));
	
	Boolean first=true, second=false, third=false, fourth = false;
	
	Paint p;
	
	float xvac, yvac, xsea, ysea;
	int vis = 255;
	
	public StartActivity(Context context) {
		super(context);
	
		yvac = vac.Pers.getHeight()*5;
		ysea = vac.Pers.getHeight()*6.2f;
		
		xvac = -vac.Pers.getWidth()-2;
		xsea = -sea.Pers.getWidth()-2;
		
		p = new Paint();
		p.setColor(Color.BLACK);
		
		timer.start();
	}

	
	protected void onDraw(Canvas gra) {
		
		back.Draw(gra, -2, -2);
		sea.Draw(gra, xsea, ysea);
		vac.Draw(gra, xvac, yvac);
		
		p.setAlpha(vis);
		gra.drawRect(-2, -2, gra.getWidth(), gra.getHeight(), p);
		super.onDraw(gra);
	};
	

	CountDownTimer timer = new CountDownTimer(20000,5) {
		
		@Override
		public void onTick(long millisUntilFinished) {
			if (first) {
				vis -= 1;
				if (vis == 0) {
					second = true;
					first = false;
				}
			}
			
			if (second) {
				xvac += 16;
				if (xvac >= vac.Pers.getWidth()/2) {
					third = true;
					second = false;
				}
			}
			
			if (third) {
				xsea += 16;
				if (xsea >= vac.Pers.getWidth()) {
					third = false;
					fourth = true;
				}
			}
			
			if (fourth == true) {
				vis +=1 ;
				if (vis == 255) {
					fourth = false;
					Config.is = 1;
				}
			}
			
			invalidate();
		}
		
		@Override
		public void onFinish() {
			// TODO Auto-generated method stub
			timer.start();
		}
	};
	
	
    
	
}
