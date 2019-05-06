import java.util.List;

public interface Student_Interface {

    /**
     * Adds course c to the list of enrolled courses Also removes c from the
     * waitlisted courses
     *
     * @param c Course to be enrolled in
     */
    public void enrollCourse(Course c);

    /**
     * Adds course c to the waitlist
     *
     * @param c course to be waitlisted
     */

    public void waitlistCourse(Course c);

    /**
     * Accessor for name
     *
     * @return name - Name of the student
     */
    public String getStudentName();

    /**
     * Accessor for Student ID
     *
     * @return studentID - Student ID
     */
    public String getStudentID();

    /**
     * Returns a list of all enrolled courses
     *
     * @return List of enrolled courses
     */
    public List<Course> getmyEnrolledCourses();

    /**
     * Returns a list of all waitlisted courses
     *
     * @return List of waitlisted courses
     */
    public List<Course> getmyWaitlist();

    /**
     * Accessor for course coins
     *
     * @return course coins
     */
    public int getCoins();

    /**
     * Deducts numCoins from coursecoins
     *
     * @param numCoins Number of coins to be deducted
     */
    public void deductCoins(int numCoins);
}
