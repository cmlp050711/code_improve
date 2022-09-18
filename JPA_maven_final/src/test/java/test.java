import Dao.impl.StudentDao;
import Entity.Hobby;
import Entity.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class test {
    StudentDao studentDao=new StudentDao();
    @Test
    public void creatStudent(){
        Student s=new Student();
        s.setName("喜欢吃零食的陈世慧");
        s.setAge(7);
        s.setSex(false);
        s.setPassword("020811");

        List<Hobby>hobbyList=new ArrayList<>();
        Hobby h1=new Hobby();
        h1.setStu(s);
        Hobby h2=new Hobby();
        h2.setStu(s);
        h1.setName("摸小狗");
        h2.setName("欺负小狗");
        hobbyList.add(h1);
        hobbyList.add(h2);

        s.setHobbyList(hobbyList);

        studentDao.save(s);

    }
}
