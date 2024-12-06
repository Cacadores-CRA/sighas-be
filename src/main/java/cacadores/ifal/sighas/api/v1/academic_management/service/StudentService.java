package cacadores.ifal.sighas.api.v1.academic_management.service;

import cacadores.ifal.sighas.api.v1.academic_management.exception.affiliation.AffiliationUUIDNotFoundException;
import cacadores.ifal.sighas.api.v1.academic_management.exception.user.UserUUIDNotFoundException;
import cacadores.ifal.sighas.api.v1.academic_management.model.dto.student.StudentRequestDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.dto.student.StudentResponseDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.entity.Student;
import cacadores.ifal.sighas.api.v1.academic_management.model.entity.User;
import cacadores.ifal.sighas.api.v1.academic_management.repository.StudentRepository;
import cacadores.ifal.sighas.api.v1.academic_management.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
//TODO: Add @Transactional annotation on methods
public class StudentService {
    private final StudentRepository repository;
    private final UserRepository userRepository;
    public StudentService(StudentRepository studentRepository, UserRepository userRepository) {
        this.repository = studentRepository;
        this.userRepository = userRepository;
    }

    //CREATE
    public StudentResponseDTO createStudent(StudentRequestDTO createStudentDTO) {
        return this.toStudentResponseDTO(
            repository.save(this.toStudent(createStudentDTO))
        );
    }

    //READ ALL
    public List<StudentResponseDTO> getAllStudents() {
        return repository.findAll().stream()
                                   .map(this::toStudentResponseDTO)
                                   .collect(Collectors.toList());
    }

    //READ BY AFFILIATION ID
    public StudentResponseDTO getStudentByAffiliationId(UUID affiliationId) {
        return this.toStudentResponseDTO(
            repository.findById(affiliationId).orElseThrow(
                () -> new AffiliationUUIDNotFoundException(
                    String.format("Student with affiliation id '%s' not found", affiliationId)
                )
            )
        );
    }

    //UPDATE BY AFFILIATION ID
    public StudentResponseDTO updateStudentByAffiliationId(UUID affiliationId, StudentRequestDTO updateStudentDTO) {
        Student savedStudent = repository.findById(affiliationId).orElseThrow(
            () -> new AffiliationUUIDNotFoundException(
                String.format("Student with affiliation id '%s' not found", affiliationId)
            )
        );

        User savedUser = userRepository.findById(updateStudentDTO.userId()).orElseThrow(
            () -> new UserUUIDNotFoundException(
                String.format("User with id '%s' not found", updateStudentDTO.userId())
            )
        );

        savedStudent.setUser(savedUser);
        savedStudent.setStartingDate(updateStudentDTO.startingDate());
        savedStudent.setEndingDate(updateStudentDTO.endingDate());
        savedStudent.setStatus(updateStudentDTO.status());
        savedStudent.setEnrollment(updateStudentDTO.enrollment());
        savedStudent.setInstitutionalEmail(updateStudentDTO.institutionalEmail());

        return this.toStudentResponseDTO(repository.save(savedStudent));
    }

    //DELETE BY AFFILIATION ID
    public void deleteStudentByAffiliationId(UUID affiliationId) {
        if(repository.existsById(affiliationId)) {
            repository.deleteById(affiliationId);
        } else {
            throw new AffiliationUUIDNotFoundException(
                String.format("Student with affiliation id '%s' not found", affiliationId)
            );
        }
    }

    //ENTITY TO RESPONSE DTO
    private StudentResponseDTO toStudentResponseDTO(Student student) {
        return new StudentResponseDTO(
            student.getUser().getName(),
            student.getStatus(),
            student.getEnrollment(),
            student.getInstitutionalEmail()
        );
    }

    //REQUEST DTO TO ENTITY
    private Student toStudent(StudentRequestDTO studentRequestDTO) {
        User user = userRepository.findById(studentRequestDTO.userId()).orElseThrow(
            () -> new UserUUIDNotFoundException(
                String.format("User with UUID '%s' not found", studentRequestDTO.userId())
            )
        );

        return new Student(
            user,
            studentRequestDTO.startingDate(),
            studentRequestDTO.endingDate(),
            studentRequestDTO.status(),
            studentRequestDTO.enrollment(),
            studentRequestDTO.institutionalEmail()
        );
    }
}
