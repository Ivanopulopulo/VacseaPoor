package com.mainaction;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class NotAnimatePers {
	
	Bitmap Pers;
	
	Paint p;
	
	public float width;
	
	Boolean Ground = false;
	Rect src, dst;
	public NotAnimatePers(Bitmap frame) {
		// TODO Auto-generated constructor stub
		Pers = frame;
		p = new Paint();
		width = Pers.getWidth();
	}
	
void Draw(Canvas gra, float x, float y) {

		
		
		p.setAntiAlias(true);
		 
		
		src = new Rect(0, 0, (int)width, Pers.getHeight());
		
		
		
		
		float x2, y2;
		
		
		x2 = x + width;
		
		
		if (Ground) {
			y2 = y + Pers.getWidth();
			y = y+(Pers.getWidth()-Pers.getHeight());
		}
		else{
			y2 = y + Pers.getHeight();
		}
		
		dst = new Rect( (int)x, (int)y, (int)x2, (int)y2);
		
		gra.drawBitmap(Pers, src, dst, p);
		
	}

}
