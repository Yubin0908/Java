package stretegy1.step4.modulearization;

import strategy1.step4.interfaces.FlyImpl;
import strategy1.step4.interfaces.FlyYes;
import strategy1.step4.interfaces.KnifeImpl;
import strategy1.step4.interfaces.KnifeLazer;
import strategy1.step4.interfaces.MissileImpl;
import strategy1.step4.interfaces.MissileYes;

// actionWalk(), actionRun(), shape()

public class SuperRobot extends Robot {

	private FlyImpl fly = new FlyYes();
	private MissileImpl missile = new MissileYes();
	private KnifeImpl knife = new KnifeLazer();
	
	public SuperRobot() {
		
//		fly = new FlyYes();
//		missile = new MissileYes();
//		knife = new KnifeLazer();
		setFly(new FlyYes());
		setMissile(new MissileYes());
		setKnife(new KnifeLazer());
		
	}
	
	
	@Override
	public void actionFly() {
		
		fly.fly();
		
	}
	
	@Override
	public void actionMissile()	{
		
		missile.missile();
		
	}
	
	@Override
	public void actionKnife() {
		
		knife.Knife();
		
	}


	public void setFly(FlyImpl fly) {
		this.fly = fly;
	}


	public void setMissile(MissileImpl missile) {
		this.missile = missile;
	}


	public void setKnife(KnifeImpl knife) {
		this.knife = knife;
	}
	
	
}
