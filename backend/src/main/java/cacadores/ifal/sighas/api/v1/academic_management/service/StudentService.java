package cacadores.ifal.sighas.api.v1.academic_management.service;

import cacadores.ifal.sighas.api.v1.academic_management.model.entity.Student;
import cacadores.ifal.sighas.api.v1.academic_management.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository repository;
    public StudentService(StudentRepository studentRepository) {
        this.repository = studentRepository;
    }

    public Student createStudent(Student student) {
        return repository.save(student);
    }
}
