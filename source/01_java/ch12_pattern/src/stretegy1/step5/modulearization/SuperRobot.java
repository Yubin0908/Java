package stretegy1.step5.modulearization;

import strategy1.step4.interfaces.FlyYes;
import strategy1.step4.interfaces.KnifeLazer;
import strategy1.step4.interfaces.MissileYes;

// actionWalk(), actionRun(), shape()

public class SuperRobot extends Robot {

	
	public SuperRobot() {
		
//		fly = new FlyYes();
//		missile = new MissileYes();
//		knife = new KnifeLazer();
		setFly(new FlyYes());
		setMissile(new MissileYes());
		setKnife(new KnifeLazer());
		
	}
	
}
