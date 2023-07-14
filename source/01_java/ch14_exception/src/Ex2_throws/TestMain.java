package Ex2_throws;

public class TestMain {

	public static void main(String[] args) {
		
		try {
			
			new ThrowsEx();
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
}
