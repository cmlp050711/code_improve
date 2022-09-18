import Dao.Impl.CourseDao;
import Entity.Course;
import org.junit.Test;

public class CourseDaoTest {
    CourseDao courseDao=new CourseDao();
    @Test
    public void CreatCourse(){
        Course c=new Course();
        c.setCourseId(000001L);
        c.setCourseName("编程能力提升");
        c.setCredit(2.0);
        courseDao.save(c);
    }
    @Test
    public void test(){}
}
