package enrollment;


import java.io.Serial;
import java.io.Serializable;

public record Course(String courseCode, String courseName, String instructor) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Course{courseCode='" + courseCode + "', courseName='" + courseName +
                "', instructor='" + instructor + "'}";
    }
}