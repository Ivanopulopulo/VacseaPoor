package menuparts;


import android.content.Context;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;


public class Levels extends View {
	

    
	public Levels(Context context) {
		super(context);
		
		
	}
	
	@Override
	protected void onDraw(Canvas polot) {
    Paint p = new Paint();

    polot.drawCircle(500, 500, 300, p);
    
	super.onDraw(polot);
	}
	
	
	
	
	

	
	

}
