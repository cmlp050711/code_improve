import Dao.Impl.StudentDao;
import Entity.Student;
import org.junit.Test;

public class StudentDaoTest {

    StudentDao studentDao=new StudentDao();
    @Test
    public void testStudent() {
        Student s=new Student();
        s.setName("Ðí×£Ô¸");
        s.setAge(99);
        s.setSex(false);
        s.setPassword("0507711");
        studentDao.save(s);
    }
    @Test
    public void findOne(){
        Student s=studentDao.getOne(1L);
        System.out.println(s);
    }

    @Test
    public void testLogin(){
        Student s=new Student();
        s.setName("Ðí×£Ô¸");
        s.setPassword("050711");
        System.out.println(studentDao.Login(s.getName(), s.getPassword()));
    }

    @Test
    public void reflectTest(){
//        StudentDao studentDao1=new StudentDao();
    }
}

