package com.bosch.s4t.hackathon;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.bosch.s4t.hackathon.entity.MasterEntity;
import com.bosch.s4t.hackathon.repository.DataRepository;
import com.bosch.s4t.hackathon.repository.MasterRepository;

@SpringBootApplication
@ComponentScan()
@ServletComponentScan()
public class Application extends SpringBootServletInitializer
{
	
    @Override
    protected SpringApplicationBuilder configure( final SpringApplicationBuilder application )
    {
        return application.sources(Application.class);
    }

    public static void main( final String[] args )
    {
        SpringApplication.run(Application.class, args);  
    }
     
}
