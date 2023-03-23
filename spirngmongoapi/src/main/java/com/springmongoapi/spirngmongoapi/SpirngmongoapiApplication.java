package com.springmongoapi.spirngmongoapi;

import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class SpirngmongoapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpirngmongoapiApplication.class, args);
	}

	/*@Bean
	CommandLineRunner runner(StudentRepository repository, MongoTemplate mongoTemplate){
		return args -> {
			String email="nemanja @gmail.com";
			Student student=new Student("jamila ", "ahmed", email, Gender.FEMALE,
					new Adress("Spain", "Barcelona,", "111111"), List.of("mata", "p1", "spa", "aros"), BigDecimal.TEN, LocalDateTime.now());
			//usingMongoTemplate(repository, mongoTemplate, email, student);

			repository.findStudentByEmail(email).ifPresentOrElse(s->{
				System.out.println(s+" already exist");
			},()->{repository.save(student);
				System.out.println("inserted was susccesful");});

		};


	}*/

	private static void usingMongoTemplate(StudentRepository repository, MongoTemplate mongoTemplate, String email, Student student) {
		Query query =new Query();
		query.addCriteria(Criteria.where("email").is(email));
		List<Student> students = mongoTemplate.find(query, Student.class);
		if(students.size()>1){
			throw new IllegalStateException("found many students whit emial"+ email);
		}
		if(students.isEmpty()){
			repository.save(student);
			System.out.println("inserted was susccesful");
		}else
			System.out.println("student already exist");
	}

}
