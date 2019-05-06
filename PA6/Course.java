import java.util.List;

public class Course implements Course_Interface {

	private String courseName;
	private String courseCode;
	private MyPriorityQueue<Registration> waitlistQueue;
	private List<Student> roster;
	private int maxCapacity;

	public Course(String name, String code, int capacity) {
	//TODO
	}

	//TODO

	@Override
	public String toString() {
		return courseCode;
	}
}
