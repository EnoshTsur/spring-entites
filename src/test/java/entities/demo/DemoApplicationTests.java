package entities.demo;

import entities.demo.model.Course;
import entities.demo.repository.CourseRepo;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles(profiles = "test")
class DemoApplicationTests {

    @Autowired
    private CourseRepo repo;

    @Test
    void contextLoads() {
    }


//    @Test
//    @DirtiesContext
//    @Ignore
//    void create() {
//        Course course = new Course("python");
//        repo.save(course);
//    }

    @Test
    void update(){
        Course course = new Course(1L, "java3");
        repo.save(course);
    }


//    @Ignore
//    @Test
//    void delete() {
//        Course course = repo.deletById(6L);
//        System.out.println(course);
//    }

    @Test
    void all() {
//        System.out.println(repo.findAll());
    }

    @Test
    void byNameJPQL(){
//        System.out.println(repo.findByName("sql"));
    }

    @Test
    void byNameNative(){
        System.out.println(repo.findByNameNative("sql"));
    }


}
