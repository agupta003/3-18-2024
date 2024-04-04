package orm.sorm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import orm.dao.StudentDao;
import orm.entities.Student;


public class App 
{
    public static void main( String[] args )
    {
        @SuppressWarnings("resource")
		ApplicationContext context=  new ClassPathXmlApplicationContext("orm/sorm/Config.xml");
    StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
    Student student=new Student(1237, "Kushi Gupta", "Charlotte");
		int r = studentDao.insert(student);
		System.out.println("One record is insertted :"+r);
    }
}
