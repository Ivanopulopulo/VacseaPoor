package com.mainaction;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;


public class СonditionItems {

	NotAnimatePers mainy = new NotAnimatePers(Pictures.StrH);
	NotAnimatePers hel = new NotAnimatePers(Pictures.hel);
	
	Rect src,dst;
	
	int bul, ali, dea, now, kol=0, s=0;
	
	public СonditionItems() {
		
	}
	
	public void Draw(Canvas gra) {
     
      hel.width = hel.Pers.getWidth()*(Hero.health/100f);
      hel.Draw(gra, mainy.Pers.getWidth()*(107/385f), mainy.Pers.getHeight()*(153/191f));
      
      bul=Glob.hasbulletinbox;
      ali=Hero.ill;
      dea=Hero.killed;
      
      Paint p;
		p = new Paint();
		p.setAntiAlias(true);
      kol = 0;
      s =0;
      while(bul!=0) {
    	  s +=1;
    	  bul = bul/10;
      }
      
      bul =Glob.hasbulletinbox;
      
      while(bul!=0) {
      	now = bul%10;
    	bul = bul/(10);

    	src = new Rect( now*Pictures.num.getWidth()/10 + 1, 0, (now+1)*Pictures.num.getWidth()/10, Pictures.num.getHeight());
    	dst = new Rect( ((s-kol-1)*Pictures.num.getWidth()/10)+(int)(mainy.Pers.getWidth()*(184/385f)), (int)(mainy.Pers.getHeight()*(122/191f)),  ((s-kol-1)*Pictures.num.getWidth()/10)+(int)(mainy.Pers.getWidth()*(184/385f))+Pictures.num.getWidth()/10, (int)(mainy.Pers.getHeight()*(122/191f))+Pictures.num.getHeight());
    	gra.drawBitmap(Pictures.num, src, dst, p);
    	kol+=1;
      }
     
      bul=Hero.ill;
      
      kol = 0;
      s =0;
      while(bul!=0) {
    	  s +=1;
    	  bul = bul/10;
      }
      
      bul = Hero.ill;
      
      while(bul!=0) {
      	now = bul%10;
    	bul = bul/(10);

    	src = new Rect( now*Pictures.num.getWidth()/10 + 1, 0, (now+1)*Pictures.num.getWidth()/10, Pictures.num.getHeight());
    	dst = new Rect( ((s-kol-1)*Pictures.num.getWidth()/10)+(int)(mainy.Pers.getWidth()*(251/385f)), (int)(mainy.Pers.getHeight()*(122/191f)),  ((s-kol-1)*Pictures.num.getWidth()/10)+(int)(mainy.Pers.getWidth()*(251/385f))+Pictures.num.getWidth()/10, (int)(mainy.Pers.getHeight()*(122/191f))+Pictures.num.getHeight());
    	gra.drawBitmap(Pictures.num, src, dst, p);
    	kol+=1;
      }
      
      
 bul=Hero.killed;
      
      kol = 0;
      s =0;
      while(bul!=0) {
    	  s +=1;
    	  bul = bul/10;
      }
      
      bul = Hero.killed;
      
      while(bul!=0) {
      	now = bul%10;
    	bul = bul/(10);

    	src = new Rect( now*Pictures.num.getWidth()/10 + 1, 0, (now+1)*Pictures.num.getWidth()/10, Pictures.num.getHeight());
    	dst = new Rect( ((s-kol-1)*Pictures.num.getWidth()/10)+(int)(mainy.Pers.getWidth()*(309/385f)), (int)(mainy.Pers.getHeight()*(122/191f)),  ((s-kol-1)*Pictures.num.getWidth()/10)+(int)(mainy.Pers.getWidth()*(309/385f))+Pictures.num.getWidth()/10, (int)(mainy.Pers.getHeight()*(122/191f))+Pictures.num.getHeight());
    	gra.drawBitmap(Pictures.num, src, dst, p);
    	kol+=1;
      }
      
      
      mainy.Draw(gra, 0, 0);
      
	}
	
}
