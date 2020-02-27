package entities.demo.repository;

import entities.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookRepo {

    @Autowired
    private EntityManager entityManager;

    /**
     * Find by ID
     *
     * @param id
     * @return Book
     */
    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    /**
     * Delete by ID
     *
     * @param id
     * @return Book
     */
    public Book deletById(long id) {
        Book byId = findById(id);
        if (byId == null) {
            return null;
        }
        entityManager.remove(byId);
        return byId;
    }

    /**
     * Insert & Update
     *
     * @param course
     * @return Book
     */
    public Book save(Book course) {
        if (course.getId() == null) {
            entityManager.persist(course);
        } else {
            entityManager.merge(course);
        }
        return course;
    }

    /**
     * Find all - Named Query
     *
     * @return List of Book
     */
    public List<Book> findAllNamed() {
        return entityManager.createNamedQuery("find_all", Book.class)
                .getResultList();
    }

    /**
     * Find Book by name - Harry Potter
     *
     * @return Book
     */
    public Book findHarry() {
        return entityManager.createNamedQuery("find_harry", Book.class)
                .getSingleResult();
    }

    /**
     * Find all - create Query
     *
     * @return List of Book
     */
    public List<Book> findAll() {
        TypedQuery<Book> all = entityManager.
                createQuery("select b from Book b", Book.class);
        return all.getResultList();
    }


    /**
     * Find by Name
     *
     * @param name
     * @return Book
     */
    public Book findByName(String name) {
        TypedQuery<Book> byName = entityManager
                .createQuery("select b from Book b where b.name = :name", Book.class);
        return byName.setParameter("name", name).getSingleResult();
    }

    /**
     * Find by Name - Native SQL
     *
     * @param name
     * @return Book
     */
    public Book findByNameNative(String name) {
        Query byName = entityManager
                .createNativeQuery("select * from Book where name = :name", Book.class)
                .setParameter("name", name);
        return (Book) byName.getSingleResult();
    }

    /**
     * Entity manager keep tracking of entities
     * @param name
     */
    public void createAndUpdate(String name) {
        Book book = new Book(name);
        entityManager.persist(book);
        book.setName("Jazz Harmony");
    }

    /**
     * Entity manager detach object
     */
    public void createDetach() {
        Book book1 = new Book("Goku Food Recipes");
        entityManager.persist(book1);
        entityManager.flush();
        entityManager.detach(book1);
//        entityManager.clear(); all entities manager keep tracking
        book1.setName("Still Goku");

    }

    /**
     * Clear all entities from manager
     */
    public void createClear() {
        Book book1 = new Book("book1");
        Book book2 = new Book("book2");
        entityManager.persist(book1);
        entityManager.persist(book2);

        entityManager.flush();

        book1.setName("bk1");
        entityManager.flush();

        book2.setName("bk2");
        entityManager.clear();

    }

    /**
     * Refresh data from data base
     */
    public void createRefresh() {
        Book book1 = new Book("bookA");
        Book book2 = new Book("bookB");
        entityManager.persist(book1);
        entityManager.persist(book2);

        entityManager.flush();

        book1.setName("bkA");
        book2.setName("bkB");
        entityManager.refresh(book1);

    }


}
