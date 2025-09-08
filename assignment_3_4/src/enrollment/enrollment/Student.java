package enrollment;

import java.io.Serial;
import java.io.Serializable;

public record Student(int id, String name, int age) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', age=" + age + "}";
    }
}