package com.mainaction;


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

import menuparts.Config;
import menuparts.Smallable;






public class NewDraw extends View{
	
	int f=0;
	
	public static int rec=0, nowlevel=2;
	
	public boolean start=false, finish=false;
	
	public static boolean win=false;

	//����������
		Bitmap Left = BitmapFactory.decodeResource(getResources(), R.drawable.leftnottap);
		Bitmap Leftt = BitmapFactory.decodeResource(getResources(), R.drawable.lefttap);
		
		Bitmap Right = BitmapFactory.decodeResource(getResources(), R.drawable.rightnottap);
		Bitmap Rightt = BitmapFactory.decodeResource(getResources(), R.drawable.righttap);
		
		Bitmap Jump = BitmapFactory.decodeResource(getResources(), R.drawable.jumpnottap);
		Bitmap Jumpt = BitmapFactory.decodeResource(getResources(), R.drawable.jumptap);
		
		Bitmap Shoot = BitmapFactory.decodeResource(getResources(), R.drawable.shootnottap);
		Bitmap Shoott = BitmapFactory.decodeResource(getResources(), R.drawable.shoottap);
	    Joystick control = new Joystick(Left, Right, Jump, Shoot, Leftt, Rightt, Jumpt, Shoott);
	//����������    

	СonditionItems  c;
	NotAnimatePers backbut = new NotAnimatePers(BitmapFactory.decodeResource(getResources(), R.drawable.backbut));
    Hero hero ;
    Context cont;
	Map map;
	BackItime[] backgr = new BackItime[10];
	
	Canvas gri;
	
	public int vis=255;
	
	 Paint p, p2;
	
    int touchcount;
	
    public void refresh(int level) {
    	
    	win=false;
    	rec = 0;
    	
    	nowlevel = level;
    	
    	if(level == 2) {
			map = new Map(getResources().getStringArray(R.array.map1));
			hero = new Hero(map.xh, map.yh, map.kolz, getResources().getStringArray(R.array.map1));	
		}
    	else
    		if(level == 3) {
    			map = new Map(getResources().getStringArray(R.array.map2));
    			hero = new Hero(map.xh, map.yh, map.kolz, getResources().getStringArray(R.array.map2));	
    		}
    		else
    			if(level == 4) {
        			map = new Map(getResources().getStringArray(R.array.map3));
        			hero = new Hero(map.xh, map.yh, map.kolz, getResources().getStringArray(R.array.map3));	
        		}
    			else
    				if(level == 5) {
	         		map = new Map(getResources().getStringArray(R.array.map4));
		         	hero = new Hero(map.xh, map.yh, map.kolz, getResources().getStringArray(R.array.map4));	
	              	}
    				else
    					if(level == 6) {
    		         		map = new Map(getResources().getStringArray(R.array.map5));
    			         	hero = new Hero(map.xh, map.yh, map.kolz, getResources().getStringArray(R.array.map5));	
    		              	}
    					else
        					if(level == 7) {
        		         		map = new Map(getResources().getStringArray(R.array.map6));
        			         	hero = new Hero(map.xh, map.yh, map.kolz, getResources().getStringArray(R.array.map6));	
        		              	}
        					else
            					if(level == 8) {
            		         		map = new Map(getResources().getStringArray(R.array.map7));
            			         	hero = new Hero(map.xh, map.yh, map.kolz, getResources().getStringArray(R.array.map7));	
            		              	}
            					else
                					if(level == 9) {
                		         		map = new Map(getResources().getStringArray(R.array.map8));
                			         	hero = new Hero(map.xh, map.yh, map.kolz, getResources().getStringArray(R.array.map8));	
                		              	}
    	
		else{

			map = new Map(getResources().getStringArray(R.array.map1));
			hero = new Hero(map.xh, map.yh, map.kolz, getResources().getStringArray(R.array.map1));
			
		}
    }
    
    
	public NewDraw(Context context) {
		super(context);
		
		cont = context;
	
		
		setpictures();
		
		for (int i=0; i<10; i++) {
			backgr[i] = new BackItime(getWidth(), getHeight());
		}
		
			map = new Map(getResources().getStringArray(R.array.map1));
			hero = new Hero(map.xh, map.yh, map.kolz, getResources().getStringArray(R.array.map1));
			
		p = new Paint();
		p2 = new Paint();
		

	 	c = new СonditionItems();
		
		MyTimer timer = new MyTimer(100000000, 30);
		timer.start();
	}
	
	
	@Override
	protected void onDraw(Canvas gra) {
		
       gri = gra;
	    
		p.setTextSize(50);
		
		p.setColor(Color.BLACK);
		
		p.setAntiAlias(true);
		
		gra.drawRect(-1, -1, getWidth()+2, getHeight()+2, p);
		
		for (int i=0; i<10; i++) {
			backgr[i].Draw(gra);;
		}
		
		hero.winH = getHeight();
		hero.winW = getWidth();
		
		hero.Draw(gra);
		
		map.Draw(gra, getWidth(), getHeight());
		
		control.Draw(gra, getHeight(), getWidth());
		
		if (hero.health <= 0) {
			finish = true;
		}
		
		if (hero.ill == 0) {
			finish = true;
			win = true;
		}
		
		c.Draw(gra);
		
		backbut.Draw(gra, gra.getWidth()-backbut.Pers.getWidth(), 0);
		
		p2.setAlpha(vis);
		
		gra.drawRect(-2, -2, gra.getWidth()+2, gra.getHeight()+2, p2);
		
		super.onDraw(gra);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		
		
		int k = event.getPointerCount();
		
		if ((event.getActionMasked() == MotionEvent.ACTION_UP)) {
			if ((event.getX() > gri.getWidth()-backbut.Pers.getWidth()) & (event.getX() < gri.getWidth()) &(event.getY() < backbut.Pers.getHeight())) {
			 finish = true;	
			 start = false;
			}
		}
		
		 if ((event.getActionMasked() == MotionEvent.ACTION_POINTER_UP) | (event.getActionMasked() == MotionEvent.ACTION_UP)) {
				k -= 1;
			}
		 
		 control.Check(event, k);
		 
		return true;
	}
	
	
	
	void setpictures() {
		// ������
		Pictures.Bullet = BitmapFactory.decodeResource(getResources(), R.drawable.bullet);
		Pictures.Bulletback = BitmapFactory.decodeResource(getResources(), R.drawable.bulletback);
		Pictures.AK = BitmapFactory.decodeResource(getResources(), R.drawable.ak);
		Pictures.AKShootf = BitmapFactory.decodeResource(getResources(), R.drawable.akshoot);
		Pictures.AKShootb = BitmapFactory.decodeResource(getResources(), R.drawable.akshootback);
		Pictures.Vacpistolf = BitmapFactory.decodeResource(getResources(), R.drawable.vacpistolf);
		Pictures.Vacpistolb = BitmapFactory.decodeResource(getResources(), R.drawable.vacpistolb);
		Pictures.Ukolf = BitmapFactory.decodeResource(getResources(), R.drawable.ukolf);
		Pictures.Ukolb = BitmapFactory.decodeResource(getResources(), R.drawable.ukolb);
		
		//�����
		Pictures.HeroArmB = BitmapFactory.decodeResource(getResources(), R.drawable.armback);
		Pictures.HeroArmF = BitmapFactory.decodeResource(getResources(), R.drawable.arm);
		Pictures.HeroForvard = BitmapFactory.decodeResource(getResources(), R.drawable.pers);
		Pictures.HeroBack = BitmapFactory.decodeResource(getResources(), R.drawable.persback);
		
		//�����
		Pictures.Zombiedangf = BitmapFactory.decodeResource(getResources(), R.drawable.zaf);
		Pictures.Zombiedangb = BitmapFactory.decodeResource(getResources(), R.drawable.zab);
		Pictures.Zombief = BitmapFactory.decodeResource(getResources(), R.drawable.zombieforvard);
		Pictures.Zombieb = BitmapFactory.decodeResource(getResources(), R.drawable.zombieback);
		Pictures.Zombiedf = BitmapFactory.decodeResource(getResources(), R.drawable.deadzombief);
		Pictures.Zombiedb = BitmapFactory.decodeResource(getResources(), R.drawable.deadzombieb);
		Pictures.Zombnonillf = BitmapFactory.decodeResource(getResources(), R.drawable.zombienonillforvard);
		Pictures.Zombnonillb = BitmapFactory.decodeResource(getResources(), R.drawable.zombienobillback);
		
		
		//������
		Pictures.gr1 = BitmapFactory.decodeResource(getResources(), R.drawable.ground1);
		Pictures.gr2 = BitmapFactory.decodeResource(getResources(), R.drawable.ground2);
		Pictures.gr3 = BitmapFactory.decodeResource(getResources(), R.drawable.ground3);
		Pictures.gr4 = BitmapFactory.decodeResource(getResources(), R.drawable.ground4);
		Pictures.gr5 = BitmapFactory.decodeResource(getResources(), R.drawable.ground5);
		Pictures.wl = BitmapFactory.decodeResource(getResources(), R.drawable.wall1);
		Pictures.wlt = BitmapFactory.decodeResource(getResources(), R.drawable.wall2);
		Pictures.wlb = BitmapFactory.decodeResource(getResources(), R.drawable.wall3);
		Pictures.pl = BitmapFactory.decodeResource(getResources(), R.drawable.plat1);
		Pictures.pll = BitmapFactory.decodeResource(getResources(), R.drawable.plat2);
		Pictures.plr = BitmapFactory.decodeResource(getResources(), R.drawable.plat3);
		Pictures.Wall = BitmapFactory.decodeResource(getResources(), R.drawable.walbuild); 
		Pictures.Ground = BitmapFactory.decodeResource(getResources(), R.drawable.groundbeton); 
		Pictures.vaci = BitmapFactory.decodeResource(getResources(), R.drawable.vakcine); 
		
		//������ ���������
		Pictures.StrH = BitmapFactory.decodeResource(getResources(), R.drawable.ss); 
		Pictures.hel = BitmapFactory.decodeResource(getResources(), R.drawable.hel);
		Pictures.num = BitmapFactory.decodeResource(getResources(), R.drawable.num);
		
		//������ ����
		Pictures.backlines = BitmapFactory.decodeResource(getResources(), R.drawable.linesback);
		Pictures.backsqrs = BitmapFactory.decodeResource(getResources(), R.drawable.sqrback);
		
		//���. ������
		Pictures.edtlive = BitmapFactory.decodeResource(getResources(), R.drawable.edtlive);
		Pictures.edtbullet = BitmapFactory.decodeResource(getResources(), R.drawable.edtbullet);
		
		Smallable jk = new Smallable(BitmapFactory.decodeResource(getResources(), R.drawable.reclab));
		
	}
	
	
	protected void nextFrame() {
		
		if (start) {
			vis-=5;
			if (vis<=0) {
				start = false;	
			}
		}
		
		if (finish) {
			vis+=5;
			if (vis>=255) {
				finish = false;	
				Config.is = 1;
			}
		}
		
		hero.inv();
		map.gethero(hero.xhero, hero.yhero, hero.winH, hero.winW);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	class MyTimer extends CountDownTimer {

		public MyTimer(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
		
		}

		@Override
		public void onFinish() {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void onTick(long millisUntilFinished) {
			nextFrame();
			hero.setcontrol(control);
			if (control.shoot.taped) {
				control.shoot.taped = false;
			}
			if (control.jump.taped) {
				(control.jump.taped) = false;
			}
			invalidate();
			
			
			
		}
		
		
	}
	
	
	
	
}
