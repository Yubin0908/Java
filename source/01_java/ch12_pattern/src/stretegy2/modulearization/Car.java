package stretegy2.modulearization;
//속성변수-생성자-메소드(일반메소드-override한 메소드-setter&getter)

import stretegy2.interpaces.EngineImpl;
import stretegy2.interpaces.FuelImpl;
import stretegy2.interpaces.KmImpl;

public abstract class Car {
	
	private EngineImpl engine;
	private KmImpl km;
	private FuelImpl fuel;

	public void drive() {
		
		System.out.println("드라이브를 할 수 있습니다.");
		
	}
	public abstract void shape();
	
	public void isEngine() {
		
		engine.engine();
		
	}
	public void isKm() {
		
		km.KmPerLiter();
		
	}
	public void isFuel() {
		
		fuel.fuel();
		
	}
	
	public void setEngine(EngineImpl engine) {
		
		this.engine = engine;
		
	}
	
	public void setKm(KmImpl km) {
		
		this.km = km;
		
	}
	
	public  void setFuel(FuelImpl fuel) {
		
		this.fuel = fuel;
		
	}
	
	
	
}
