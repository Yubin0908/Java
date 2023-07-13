package stretegy1.step5.modulearization;

import strategy1.step4.interfaces.FlyHi;
import strategy1.step4.interfaces.KnifePlastic;

public class RobotTestMain {

	public static void main(String[] args) {
		
		Robot superRobot = new SuperRobot();
		
		Robot standardRobot = new StandardRobot();
		
		Robot lowRobot = new LowRobot();
		
		Robot[] robots = {superRobot, standardRobot, lowRobot};
		
		for(Robot robot : robots) {
			
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMIssile();
			robot.actionKnife();
				
		}
		System.out.println("SuperRobot이 높이 아주 높이 날수 있는 기능으로 업그레이드");
		superRobot.setFly(new FlyHi());
		superRobot.shape();
		superRobot.actionFly();
		
		System.out.println("LowRobot의 장난감 검이 있는 기능으로 업그레이드");
		lowRobot.setKnife(new KnifePlastic());
		lowRobot.shape();
		lowRobot.actionKnife();
		
	}
	
	
}
