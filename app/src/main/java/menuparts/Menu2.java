package menuparts;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;

import com.example.vacseapoor.R;





public class Menu2 extends View {
	
    int y = -1, x = -1, xtap, ytap, xlast, xnow, ynow, ylast, xlast2;
	
    float vx = 0;
    
    static int vis = 255, t, levelnow;
    
    int[] records = new int[8];
    
    boolean start = false, finish = false;
    
	BackGround back  = new BackGround(BitmapFactory.decodeResource(getResources(), R.drawable.backsqr));
	
	
	Bitmap item = BitmapFactory.decodeResource(getResources(), R.drawable.levelsqr);
	
	Label lab = new Label(BitmapFactory.decodeResource(getResources(), R.drawable.numbers));
	
   NotAnimatePersmenu title  = new NotAnimatePersmenu(BitmapFactory.decodeResource(getResources(), R.drawable.title));
    
	menubutton[] buttons = new menubutton[8];
	
    Context cont;
    
    Paint p;
    
    MenuActivity act;
    
	public Menu2(Context context, MenuActivity Act ) {
		super(context);
		
		for(int i =0; i<8; i++) {
		buttons[i] = new menubutton(item, i+1, 1.5f*item.getWidth()*(i) , item.getWidth());
		}
		
		cont = context;		
		
		p = new Paint();
		p.setColor(Color.BLACK);
		
		timer.start();
		
	}
	
	@Override
	protected void onDraw(Canvas polot) {

		
    back.draw(polot, polot.getWidth(), polot.getHeight());

    
    for(int i =0; i<8; i++) {
		buttons[i].Draw(polot, x, y, records[i]);
		}
    
    title.Draw(polot,  polot.getWidth()/2 - title.Pers.getWidth()/2, title.Pers.getHeight()/2);
    
    p.setAlpha(vis);
	polot.drawRect(-2, -2, polot.getWidth(), polot.getHeight(), p);
    
	super.onDraw(polot);
	}
	
	
     CountDownTimer timer = new CountDownTimer(1000000,5) {
		
		@Override
		public void onTick(long millisUntilFinished) {
		
			if (start) {
				vis -=3;
				if (vis == 0) {
					start = false;	
				}
			}
			
			if (finish) {
				vis +=3;
				if (vis >= 255) {
					finish = false;	
					Config.is = t;
				}
			}
			
			invalidate();
		}
		
		@Override
		public void onFinish() {
			// TODO Auto-generated method stub
			
		}
		
		};
	
	
	
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {

		if (event.getAction() == MotionEvent.ACTION_DOWN){
		xtap = (int)event.getX();
		ytap = (int)event.getY();
	    xlast = (int)event.getX();
	   
	    }
		
		xnow = (int)event.getX();
		ynow = (int)event.getY();
		
	

		if ((Math.pow(xtap-xnow,2) <  100)&(Math.pow(ytap-ynow,2) <  100)&(event.getAction() == MotionEvent.ACTION_UP)) {
			
			t=0;
			
			for(int i = 0; i<8; i++) {
				if (buttons[i].check(-x+xnow, ynow)) {
					t = i+2;
					levelnow = i;
				}
				}
			
			if (t!=0) {
			start = false;
			finish = true;
			}
		}
			
		if((x-xlast+xnow<=0)&(x-xlast+xnow>= -1.5f*item.getWidth()*(6))) {
			  x -= xlast-xnow;	
		}
	
		invalidate();
	
			ylast = ynow;
			xlast = xnow;
		return true;
		
	}
	
	void inv() {
		invalidate();
	}
	

}
