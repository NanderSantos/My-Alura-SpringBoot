package br.com.alura.forum.repository;

import br.com.alura.forum.model.Course;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void CourseRepositoryFindByExistingNameTest() {

        String courseName = "HTML 5";
        String courseCategory = "Programação";

        Course html5 = new Course();
        html5.setName(courseName);
        html5.setCategory(courseCategory);
        entityManager.persist(html5);

        Course course = courseRepository.findByName(courseName);

        assertNotNull(course);
        assertEquals(courseName, course.getName());
        assertEquals(courseCategory, course.getCategory());
    }

    @Test
    public void CourseRepositoryFindByNotExistingNameTest() {

        String courseName = "JPA";
        Course course = courseRepository.findByName(courseName);

        assertNull(course);
    }
}