package singleton2;

public class TestMain {

	public static void main(String[] args) {
		
		FirstClass firstObj = new FirstClass();
		
		SecondClass secondObj = new SecondClass();
		
		SingletonClass singObj = SingletonClass.getInstance();
		
		System.out.println("main함수에서의 싱글톤 객체 i 값은 : " + singObj.getI());
		
	}
	
}
