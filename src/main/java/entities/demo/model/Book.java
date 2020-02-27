package entities.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "Book")
//@NamedQuery(name = "find_all", query = "select c from Book c")
@NamedQueries({
        @NamedQuery(name = "find_all", query = "select b from Book b"),
        @NamedQuery(name = "find_harry", query = "select b from Book b where b.name = 'harry potter'")
})
public class Book {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @Column(name = "NAME")
    private String name;

    public Book() {}

    public Book(String name) {
        this.name = name;
    }

    public Book(Long id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
