import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component("student") 
public class Student {
public void study() {System.out.println("Am in Student Class ");}
}
