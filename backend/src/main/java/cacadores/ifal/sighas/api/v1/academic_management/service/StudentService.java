package cacadores.ifal.sighas.api.v1.academic_management.service;

import cacadores.ifal.sighas.api.v1.academic_management.model.dto.student.StudentRequestDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.dto.student.StudentResponseDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.entity.Student;
// import cacadores.ifal.sighas.api.v1.academic_management.model.entity.StudentRole;
import cacadores.ifal.sighas.api.v1.academic_management.repository.StudentRepository;
// import cacadores.ifal.sighas.api.v1.academic_management.repository.StudentRoleRepository;

import org.springframework.stereotype.Service;

// import java.util.HashSet;
import java.util.List;
// import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository repository;
    // private final StudentRoleRepository studentRoleRepository;
    public StudentService(StudentRepository StudentRepository) {
        this.repository = StudentRepository;
        // this.StudentRoleRepository = StudentRoleRepository;
    }

    //CREATE
    public StudentResponseDTO createStudent(StudentRequestDTO createStudentDTO) {
        return this.toStudentResponseDTO(
                repository.save(this.toStudent(createStudentDTO))
        );
    }

    //READ ALL
    public List<StudentResponseDTO> getAllStudents() {
        return repository.findAll().stream().map(this::toStudentResponseDTO).collect(Collectors.toList());
    }

    //READ BY ID
    //TODO: Create a custom exception
    public StudentResponseDTO getStudentById(UUID id) {
        return this.toStudentResponseDTO(repository.findById(id).orElseThrow(
                () -> new RuntimeException("Student not found")
        ));
    }

    //UPDATE
    //TODO: Create a custom exception
    public StudentResponseDTO updateStudent(UUID id, StudentRequestDTO StudentUpdateDTO) {
        Student savedStudent = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Student not found")
        );

        savedStudent.setEnrollment(StudentUpdateDTO.enrollment());
        savedStudent.setInstitutionalEmail(StudentUpdateDTO.institutionalEmail());
        savedStudent.setCourse(StudentUpdateDTO.course());
        savedStudent.setGroups(StudentUpdateDTO.groups());
        // TODO: Implement custom exception
        // StudentUpdateDTO.roles().stream()
           //     .map(role -> StudentRoleRepository.findById(role.ordinal()).orElseThrow(
           //             () -> new IllegalArgumentException("Invalid role assignment")
           //     ))
           //     .collect(Collectors.toSet())
        // );

        return this.toStudentResponseDTO(repository.save(savedStudent));
    }

    //DELETE
    public void deleteStudent(UUID id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Student not found");
        }
    };


    private StudentResponseDTO toStudentResponseDTO(Student Student) {
        return new StudentResponseDTO(
                // Student.getId(),
                Student.getEnrollment(),
                Student.getInstitutionalEmail(),
                Student.getCourse(),
                Student.getGroups()
                // Student.getRoles().stream().map(StudentRole::getRole).collect(Collectors.toSet())
        );
    }

    private Student toStudent(StudentRequestDTO StudentRequestDTO) {
        Student Student = new Student();
        // Set<StudentRole> roles = new HashSet<>();
        //TODO: create custom exception
        // StudentRequestDTO.roles().forEach(
               // role -> {
               //     roles.add(StudentRoleRepository.findById(role.ordinal()).orElseThrow(
               //                     () -> new IllegalArgumentException("Invalid role assignment")
               //             )
               //     );
               // }
        // );

        Student.setEnrollment(StudentRequestDTO.enrollment());
        Student.setInstitutionalEmail(StudentRequestDTO.institutionalEmail());
        Student.setCourse(StudentRequestDTO.course());
        Student.setGroups(StudentRequestDTO.groups());
        //TODO: Verify pre-existent email addresses
        return Student;
    }
}

