package entities.demo.repository;

import entities.demo.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseRepo {

    @Autowired
    private EntityManager entityManager;


    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }

    public Course deletById(long id) {
        Course byId = findById(id);
        if (byId == null) { return null; }
        entityManager.remove(byId);
        return byId;
    }

    public Course save(Course course) {
        if (course.getId() == null) {
            entityManager.persist(course);
        } else {
            entityManager.merge(course);
        }
        return course;
    }

    public List<Course> findAll() {
        TypedQuery<Course> all = entityManager.
                createQuery("select c from Course c", Course.class);
        return all.getResultList();
    }


    public Course findByName(String name) {
        TypedQuery<Course> byName = entityManager
                .createQuery("select c from Course c where c.name = :name", Course.class);
        return  byName.setParameter("name", name).getSingleResult();
    }

    public Course findByNameNative(String name) {
        Query byName = entityManager
                .createNativeQuery("select * from course where name = :name", Course.class)
                .setParameter("name", name);
        return (Course) byName.getSingleResult();
    }



}
