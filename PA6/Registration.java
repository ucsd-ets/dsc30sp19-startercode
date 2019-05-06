public class Registration implements Comparable<Registration> {

    private Student student;
    private Course course;
    private int coins;
    private long timestamp;

    public Registration(Student student, Course course, int coins) {
        //TODO
    }

    public Student getStudent() {
        return null; //XXX-CHANGE-XXX
    }

    public Course getCourse() {
        return null; //XXX-CHANGE-XXX
    }

    public int getCoins() {
        return -1; //XXX-CHANGE-XXX
    }

    /**
     * Compares this Student with another Student, by comparing their course
     * coins/timestamps If the coins of this is less, returns a negative
     * integer. If the coins of the Student received is less, returns a positive
     * integer. If the number of coins is same, use the timestamp comparison to
     * ensure FCFS. (You may want to check the implementation of System.nanoTime
     * to ensure correctness)
     *
     * @param o Student to be compared with
     * @return Result of the comparison
     */
    @Override
    public int compareTo(Registration o) {
        return -1; //XXX-CHANGE-XXX
    }

    /**
     * Sets the timestamp inside this registration to be the current time in
     * nano seconds.
     */
    public void setTimestamp() {
        timestamp = System.nanoTime();
    }
}
