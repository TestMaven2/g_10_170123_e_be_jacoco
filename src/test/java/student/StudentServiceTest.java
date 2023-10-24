package student;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

public class StudentServiceTest {

    private StudentService service;

    @Before
    public void init() {
        service = new StudentService();
        service.addStudent(new Student(1, "Bob"));
    }

    @Test
    public void addTest() {
        Student student = new Student(2, "Ben");
        service.addStudent(student);
        Student studentFromService = service.getStudentById(2);
        Assert.assertEquals(student, studentFromService);
    }

    @Test
    public void getTest() {
        Student student = service.getStudentById(1);
        String expectedName = "Bob";
        String actualName = student.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test(expected = NoSuchElementException.class)
    public void getException() {
        Student student = service.getStudentById(3);
    }
}