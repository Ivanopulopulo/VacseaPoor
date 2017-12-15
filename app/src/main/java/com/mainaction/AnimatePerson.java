package com.mainaction;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class AnimatePerson
{
	Bitmap Pers;
	Rect src,dst;
	int pos = 0, col, animate = 0;
	
	public AnimatePerson(Bitmap frames, int coll) 
	{
		// TODO Auto-generated constructor stub
		Pers = frames;
		col = coll;
		
	}
	
		
	void Draw(Canvas gra, float x, float y, float zader)
	{	
		Paint p;
		p = new Paint();
		
		//gra.drawColor(Color.YELLOW);
		
		p.setAntiAlias(true);
		src = new Rect(Pers.getWidth()*pos/col+(int)(zader*(pos+1))+2, 0, Pers.getWidth()*(pos+1)/col-1, Pers.getHeight());
       		float x2, y2;
		
		
		x2 = x + Pers.getWidth()/col;
		y2 = y + Pers.getHeight();
		
		
		dst = new Rect( (int)x, (int)y, (int)x2 - (int)(zader*(pos)), (int)y2);
		
		pos += 1;
		pos = pos*animate;
		
		if (pos >= col) 
		{
			pos = 0;
		}
		
		gra.drawBitmap(Pers, src, dst, p);	
	}	
	
}
