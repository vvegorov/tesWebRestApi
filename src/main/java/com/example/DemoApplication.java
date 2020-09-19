package com.example;

import com.example.demo.Model.EmployeeEntity;
import com.example.demo.Repositories.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;

import java.util.Optional;


@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication // extends WebSecurityConfigurerAdapter
public class DemoApplication implements CommandLineRunner { //implements CommandLineRunner

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EmployeeRepository repository;

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

//		String[] beanNames = ctx.getBeanDefinitionNames();
//
//		Arrays.sort(beanNames);
//
//		for (String beanName : beanNames)
//		{
//			System.out.println(beanName);
//		}


    }


	@Override
	public void run(String... args) throws Exception
	{
		Optional<EmployeeEntity> emp = repository.findById(2L);

		logger.info("Employee id 2 -> {}", emp.get());
	}

}
