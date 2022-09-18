package Entity;

import javax.persistence.*;

@Entity
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String Name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stu_id")
    private Student Stu;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Student getStu() {
        return Stu;
    }

    public void setStu(Student stu) {
        Stu = stu;
    }
}
