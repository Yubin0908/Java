package stretegy1.step5.modulearization;

import strategy1.step4.interfaces.FlyNo;
import strategy1.step4.interfaces.KnifeWood;
import strategy1.step4.interfaces.MissileYes;

public class StandardRobot extends Robot {


	public StandardRobot() {
		
		setFly(new FlyNo());
		setMissile(new MissileYes());
		setKnife(new KnifeWood());
		
	}
	
	
}
