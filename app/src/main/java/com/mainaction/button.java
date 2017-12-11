package com.mainaction;



import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;

public class button  {
	
	boolean taped = false;
	
	float posx, posy;

	NotAnimatePers nottap; 
	NotAnimatePers tap;
	
	
	
	public button(Bitmap Nottap, Bitmap Tap) {
		
		nottap = new NotAnimatePers( Nottap );
		tap = new NotAnimatePers( Tap );
		
		
	}
	
	
	void check (float x, float y, MotionEvent event, int cos) {
		if ((x>posx)&(x<posx+tap.Pers.getWidth())&(y>posy)&(y<posy+tap.Pers.getHeight()))
		{
			
			taped = true;
			
		}
		
		else
		{ 
			
			taped = false;
			
		}
		
		
		
	}
	
	
	
	void Draw (Canvas gra, float x, float y) {
		
		if (taped) {
			tap.Draw(gra, x, y);
		} 
		else
		{
			nottap.Draw(gra, x, y);
		}
		posx = x;
		posy = y;
		
	}
	
	
	
	
}
