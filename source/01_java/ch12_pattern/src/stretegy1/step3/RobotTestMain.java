package stretegy1.step3;

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
			robot.actionMissile();
			robot.actionKnife();
				
		}
		
	}
	
}
