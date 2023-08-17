package stretegy.quiz.modulearization;

import strategy.quiz.interfaces.GetSalary;
import strategy.quiz.interfaces.JobLec;

public class Lecturer extends Person {
	
	private String subject;
	
	public Lecturer(String id, String name, String subject) {
		
		super(id, name);
		this.subject = subject;
		setJob(new JobLec());
		setGet(new GetSalary());
		
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("\t[강의과목]"+subject);
	}
}