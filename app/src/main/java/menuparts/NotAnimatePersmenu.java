package menuparts;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class NotAnimatePersmenu {
	
	Bitmap Pers;
	
	public float width;
	
	public NotAnimatePersmenu(Bitmap frame) {
		// TODO Auto-generated constructor stub
		Pers = frame;
		width = Pers.getWidth();
	}
	
void Draw(Canvas gra, float x, float y) {
		
		Paint p;
		p = new Paint();

		
		p.setAntiAlias(true);
		 
		
		Rect src = new Rect(0, 0, (int)width, Pers.getHeight());
		
		
		
		float x2, y2;
		
		
		x2 = x + (int)width;
		y2 = y + Pers.getHeight();
		
		
		Rect dst = new Rect( (int)x, (int)y, (int)x2, (int)y2);
		
		gra.drawBitmap(Pers, src, dst, p);
		
	}

}
