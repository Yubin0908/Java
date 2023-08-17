package stretegy2.modulearization;

import stretegy2.interpaces.EngineLow;
import stretegy2.interpaces.FuelDiesel;
import stretegy2.interpaces.Km20;

public class Accent extends Car {
	
	public Accent() {
		
		setEngine(new EngineLow());
		setKm(new Km20());
		setFuel(new FuelDiesel());
		
	}
	

	@Override
	public void shape() {
		
		System.out.println("엑센트 차량은 문, 시트. 핸들로 이루어져 있습니다.");
		
	}

}
