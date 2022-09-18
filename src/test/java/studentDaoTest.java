import Dao.StudentDao;
import Entity.Student;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class studentDaoTest {
   StudentDao studentDao=new StudentDao();

   @Test
   public void ceateStu(){
       Student student = new Student();
       student.setName("³ÂÊÀ»Û");
       student.setSex(false);
       student.setAge(20);
       student.setPassword("050711");
       studentDao.sava(student);
       student.setAge(19);
       studentDao.update(student);
   }
   @Test
    public void updateStu(){
        studentDao.remove(2L);
   }

   @Test
   public void findOne(){
       Student student = studentDao.findOne(1L);
       System.out.println(student.toString());
   }

   @Test
    public void findAll(){
       List<Student> all = studentDao.getAll();
       Iterator<Student> iterator=all.iterator();
       while(iterator.hasNext()){
           Student student = iterator.next();
           System.out.println(student.toString());
       }
   }

   @Test
    public void test(){

   }
}
