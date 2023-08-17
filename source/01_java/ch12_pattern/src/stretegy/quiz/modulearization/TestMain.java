package stretegy.quiz.modulearization;

public class TestMain {

	public static void main(String[] args) {

		Student st1 = new Student("ere", "홍길동", "국비자바");
		Student st2 = new Student("dbd", "김길동", "자바단기");

		Lecturer l1 = new Lecturer("aaa", "유길동", "빅데이터");
		Lecturer l2 = new Lecturer("bdc", "홍길순", "웹프로그래밍");

		Staff s1 = new Staff("sss", "유용현", "관리");

		Person[] person = { st1, st2, l1, l2, s1 };

		for (Person p : person) {

			p.print();
			p.job();
			p.get();

		}
	}
}