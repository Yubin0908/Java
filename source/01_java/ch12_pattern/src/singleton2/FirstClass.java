package singleton2;

public class FirstClass {

	public FirstClass() {
		
		System.out.println("First Class 생성자 실행 중 -------------------");
		
		SingletonClass SingletonObject = SingletonClass.getInstance();
		
		System.out.println("싱글톤 객체의 i 값 : " + SingletonObject.getI());
		
		SingletonObject.setI(999);
	
		System.out.println("싱클톤 객체의 i 값(수정 후) : " + SingletonObject.getI());
	
		System.out.println("FirstClass 생성 과 실행  끝 -------------------");
	}
}
