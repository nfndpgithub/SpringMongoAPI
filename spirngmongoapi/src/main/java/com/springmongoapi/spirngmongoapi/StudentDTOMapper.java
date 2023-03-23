package com.springmongoapi.spirngmongoapi;

import org.springframework.stereotype.Service;

import java.util.function.Function;




@Service
public class StudentDTOMapper implements Function<Student,StudentDTO > {
    @Override
    public StudentDTO apply(Student student) {
        return new StudentDTO(student.getId(), student.getFirstName(), student.getLastName(),
                student.getEmail(), student.getGender(), student.getAdress(), student.getFavouriteSubject());
    }
}
