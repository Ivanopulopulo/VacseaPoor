package com.mainaction;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class BackItime {
	
	int vis, vers, size, v, x, y, W, H, num;
	float alf;
	Paint p;
	Rect scr, dst;
	boolean begin, end;
	
	public BackItime(int w, int h) {
		W=w;
		H=h;
		vers = (int)Randomik(-2, 2);
		num = (int)Randomik(0,3);
		size = (int)Randomik(20,990);
		vis = 0;
		alf = Randomik(0, 360);
		v = (int)Randomik(3, 10);
		x = (int)Randomik(0, 1000);
		y = (int)Randomik(0, 1000);
		begin = true;
		end = false;
		p = new Paint();
		
		if (vers<=0) {
			scr = new Rect(num*(Pictures.backsqrs.getWidth()/4),0,(num+1)*(Pictures.backsqrs.getWidth()/4),Pictures.backsqrs.getHeight());
		}
		else {
			scr = new Rect(0,num*Pictures.backlines.getHeight()/4+4,Pictures.backlines.getWidth(),(num+1)*(Pictures.backlines.getHeight()/4)-4);
		}
		
	}

	void Draw (Canvas gra) {
		
		
		
		dst = new Rect(x, y, x+(scr.right-scr.left) , y+(scr.bottom-scr.top));
		
		
		gra.rotate(alf,x,y);
		
		if (size < 990) {
			size+=v;
		}
		
		if (begin) {
			vis+=v;
		}
		
		if (end) {
		    vis-=v/10f;
		}
		
		if (vis >= 180) {
			begin = false;
			end = true;
		}
		p.setAlpha(vis);
		
		
		if (vers<=0){
			gra.drawBitmap(Pictures.backsqrs, scr, dst, p);
		}
		else{
			gra.drawBitmap(Pictures.backlines, scr, dst, p);

		}
		
		gra.rotate(-alf,x,y);
		
		if (vers<=0){
			alf += 1;
		}
		else
		{
			x += v;
		}
		
		if (end) {
		    if (vis <=1) {
		    	refresh();
		    }
		}
		
	}
	
	void refresh() {
		vers = (int)Randomik(-2, 2);
		num = (int)Randomik(0,3);
		size = (int)Randomik(20,1000);
		vis = 0;
		alf = Randomik(0, 360);
		v = (int)Randomik(3, 10);
		x = (int)Randomik(0, 1000);
		y = (int)Randomik(0, 1000);
		begin = true;
		end = false;
		p = new Paint();
		
		if (vers<=0) {
			scr = new Rect(num*(Pictures.backsqrs.getWidth()/4),0,(num+1)*(Pictures.backsqrs.getWidth()/4),Pictures.backsqrs.getHeight());
		}
		if (vers>0) {
			scr = new Rect(0,num*Pictures.backlines.getHeight()/4+4,Pictures.backlines.getWidth(),(num+1)*(Pictures.backlines.getHeight()/4)-4);
		}
	}
	
	public float Randomik(float min, float max) {
		
		return (float) (Math.random() * (max - min + 1)) + min;
	}
}
