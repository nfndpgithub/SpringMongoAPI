package com.springmongoapi.spirngmongoapi;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentDTOMapper studentDTOMapper;
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(studentDTOMapper)
                .collect(Collectors.toList());
    }

    public boolean insetStudent(Student student) {
     try{
        // Student s= new Student(student.firstName(),student.lastName(),student.email(), student.gender(), student.adress(), student.favouriteSubject(), student.totalSpentInBooks(),
                 //.created());
         studentRepository.findStudentByLastName(student.getLastName()).ifPresentOrElse(s->{
            System.out.println("vec postoji sa tim imenom");
            throw new RuntimeException();
         },()->{
             studentRepository.insert(student);
             System.out.println("uspesno sacuvan stent");
         });

     }catch (Exception ex){

         return false;
     }
     return  true;


    }
}
