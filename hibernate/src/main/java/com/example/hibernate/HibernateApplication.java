package com.example.hibernate;

import com.example.hibernate.dao.studentDAO;
import com.example.hibernate.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(studentDAO st)
    {
        return runner-> {

             readStudent(st);
            queryforstudent(st);
            querylastname(st);
            updatestudent(st);
            deletestu(st);
        };
    }

    private void deletestu(studentDAO st) {
        int sid=2;
        st.deletest(sid);


    }

    private void updatestudent(studentDAO st) {
      int sid=1;
      Student temp=st.findbyid(sid);

      temp.setFirstname("Scooby");
      st.update(temp);
    }

    private void querylastname(studentDAO st) {
        List<Student> last = st.findbylast("Rajpal");

        for(Student temp : last)
        {
            System.out.println(temp);
        }
    }

    private void queryforstudent(studentDAO st) {
        List<Student> thestu = st.findall();

        for(Student temp : thestu)
        {
            System.out.println(temp);
        }

    }

    private void readStudent(studentDAO st1) {
        System.out.println("Creating Object");
        Student temp= new Student("vaibhav","Rajpal","fdfdfdf@gmail.com");
        System.out.println("creating student");
        st1.save(temp);
        int theid= temp.getId();
        System.out.println("Saved student " + temp.getId());
        System.out.println("Retrieving student ");
        Student mystudent = st1.findbyid(theid);
        System.out.println("found " + mystudent);

    }

}
