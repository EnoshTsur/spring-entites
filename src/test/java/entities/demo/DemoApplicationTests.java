package entities.demo;

import entities.demo.repository.BookRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles(profiles = "dev")
class DemoApplicationTests {

    @Autowired
    private BookRepo repo;

    @Test
    void contextLoads() {
    }


    @Test
    void create() {
//        Book book = new Book("harry potter");
//        Book book2 = new Book("lord of the rings");
//        repo.save(book);
//        repo.save(book2);
    }

    @Test
    void update(){
//        Book book = new Book(2L, "Easy Java");
//        repo.save(book);
    }


    @Test
    void delete() {
//        Book course = repo.deletById(4L);
//        System.out.println(course);
    }

    @Test
    void all() {
        System.out.println(repo.findAll());
    }

    @Test
    void allNamed(){
        System.out.println(repo.findAllNamed());
    }

    @Test
    void byNameJPQL(){
        System.out.println(repo.findByName("Easy Java"));
    }

    @Test
    void byNameNative(){
        System.out.println(repo.findByNameNative("Easy Java"));
    }

    @Test
    void byHarryNamed(){
        System.out.println(repo.findHarry());
    }

    @Test
    void createUpdate(){
//        repo.createAndUpdate("Doesnt matter");
    }

    @Test
    void createDetach(){
//        repo.createDetach();
    }

    @Test
    void createClear(){
//        repo.createClear();
    }

    @Test
    void createRefresh(){
//        repo.createRefresh();
    }


}
