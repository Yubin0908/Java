package stretegy2.modulearization;

import stretegy2.interpaces.EngineHi;
import stretegy2.interpaces.FuelGasoline;
import stretegy2.interpaces.Km10;

public class Genesis extends Car {
	
	public Genesis() {
		
		setEngine(new EngineHi());
		setKm(new Km10());
		setFuel(new FuelGasoline());
		
	}
	

	@Override
	public void shape() {
		
		System.out.println("제네시스 차량은 문, 시트. 핸들로 이루어져 있습니다.");
		
	}

}
