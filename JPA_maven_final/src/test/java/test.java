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
        s.setName("ϲ������ʳ�ĳ�����");
        s.setAge(7);
        s.setSex(false);
        s.setPassword("020811");

        List<Hobby>hobbyList=new ArrayList<>();
        Hobby h1=new Hobby();
        h1.setStu(s);
        Hobby h2=new Hobby();
        h2.setStu(s);
        h1.setName("��С��");
        h2.setName("�۸�С��");
        hobbyList.add(h1);
        hobbyList.add(h2);

        s.setHobbyList(hobbyList);

        studentDao.save(s);

    }
}
