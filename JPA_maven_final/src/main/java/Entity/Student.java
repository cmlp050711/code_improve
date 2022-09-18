package Entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long StudentId;
    private String name;
    private Boolean Sex;
    private Integer Age;
    private String Password;
    @OneToMany(mappedBy = "Stu",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Hobby> HobbyList;

    public List<Hobby> getHobbyList() {
        return HobbyList;
    }

    public void setHobbyList(List<Hobby> hobbyList) {
        HobbyList = hobbyList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "StudentId=" + StudentId +
                ", name='" + name + '\'' +
                ", Sex=" + Sex +
                ", Age=" + Age +
                ", Password='" + Password + '\'' +
                '}';
    }

    public Long getStudentId() {
        return StudentId;
    }

    public void setStudentId(Long studentId) {
        StudentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSex() {
        return Sex;
    }

    public void setSex(Boolean sex) {
        Sex = sex;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
