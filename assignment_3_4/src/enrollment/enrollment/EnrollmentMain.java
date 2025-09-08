package enrollment;

import java.io.*;
import java.util.Date;
import java.util.logging.Logger;
import java.util.logging.Level;

public class EnrollmentMain {
    private static final String FILE_NAME = "enrollments.ser";
    private static final Logger logger = Logger.getLogger(EnrollmentMain.class.getName());

    public static void main(String[] args) {
        Student student = new Student(1, "Mark Z", 20);
        Course course = new Course("CS50", "Introduction to Computer Science", "Dr. David J. Malan");
        Enrollment enrollment = new Enrollment(student, course, new Date().toString());

        // Serialize
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(enrollment);
            logger.info("Serialized enrollment to " + FILE_NAME);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error during serialization", e);
        }

        // Deserialize
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Enrollment deserialized = (Enrollment) ois.readObject();
            logger.info("Deserialized enrollment: " + deserialized);
        } catch (IOException | ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Error during deserialization", e);
        }
    }
}
