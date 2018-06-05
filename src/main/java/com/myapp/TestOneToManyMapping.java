package com.myapp;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myapp.dao.AbstractDao;
import com.myapp.model.Phone;
import com.myapp.model.Student;
import com.myapp.service.StudentService;

public class TestOneToManyMapping  extends AbstractDao
{
    public static void main( String[] args )
    {
        System.out.println( "Code execution started!" );
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        StudentService service = (StudentService) context.getBean("studentService");
        
        Set<Phone> phoneNumbers = new HashSet<Phone>();
		phoneNumbers.add(new Phone("house","32354353"));
		phoneNumbers.add(new Phone("mobile","9889343423"));
		
		Student student = new Student("Sau", phoneNumbers);
        service.saveStudent(student);
        
        System.out.println( "Code executed successfully!" );
    }
}
