package enrollment;

import java.io.Serial;
import java.io.Serializable;

public record Enrollment(Student student, Course course, String enrollmentDate) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Enrollment{" +
                "student=" + student +
                ", course=" + course +
                ", enrollmentDate='" + enrollmentDate + '\'' +
                '}';
    }
}