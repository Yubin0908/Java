package stretegy1.step4.modulearization;

import strategy1.step4.interfaces.FlyImpl;
import strategy1.step4.interfaces.FlyNo;
import strategy1.step4.interfaces.KnifeImpl;
import strategy1.step4.interfaces.KnifeWood;
import strategy1.step4.interfaces.MissileImpl;
import strategy1.step4.interfaces.MissileYes;

public class StandardRobot extends Robot {

	private FlyImpl fly = new FlyNo();
	private MissileImpl missile = new MissileYes();
	private KnifeImpl knife = new KnifeWood();
	
	public StandardRobot() {
		
		setFly(new FlyNo());
		setMissile(new MissileYes());
		setKnife(new KnifeWood());
		
	}
	
	@Override
	public void actionFly() {
		
		fly.fly();
		
	}
	@Override
	public void actionMissile() {
		
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
