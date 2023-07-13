package stretegy.quiz.modulearization;

import strategy.quiz.interfaces.GetSalary;
import strategy.quiz.interfaces.JobMng;

public class Staff extends Person {
	
	private String part;
	public Staff(String id, String name, String part) {
		
		super(id, name);
		this.part = part;
		setJob(new JobMng());
		setGet(new GetSalary());
		
	}
	
	
	
	@Override
	public void print() {

		super.print();
		System.out.println("\t[부서]" + part);
	}




}
