package stretegy2.modulearization;

import stretegy2.interpaces.EngineMid;
import stretegy2.interpaces.FuelGasoline;
import stretegy2.interpaces.Km15;

public class Sonata extends Car {
	
	public Sonata() {
		
		setEngine(new EngineMid());
		setKm(new Km15());
		setFuel(new FuelGasoline());
		
	}
	

	@Override
	public void shape() {
		
		System.out.println("소나타 차량은 문, 시트. 핸들로 이루어져 있습니다.");
		
	}

}
