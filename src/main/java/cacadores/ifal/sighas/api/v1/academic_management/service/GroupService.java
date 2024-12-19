package cacadores.ifal.sighas.api.v1.academic_management.service;

import cacadores.ifal.sighas.api.v1.academic_management.exception.group.GroupUUIDNotFoundException;
import cacadores.ifal.sighas.api.v1.academic_management.exception.professor.ProfessorSiapeNotFoundException;
import cacadores.ifal.sighas.api.v1.academic_management.exception.student.StudentEnrollmentNotFoundException;
import cacadores.ifal.sighas.api.v1.academic_management.exception.subject.SubjectUUIDNotFoundException;
import cacadores.ifal.sighas.api.v1.academic_management.model.dto.group.GroupRequestDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.dto.group.GroupResponseDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.entity.AcademicPeriod;
import cacadores.ifal.sighas.api.v1.academic_management.model.entity.Group;
import cacadores.ifal.sighas.api.v1.academic_management.model.entity.Professor;
import cacadores.ifal.sighas.api.v1.academic_management.model.entity.Student;
import cacadores.ifal.sighas.api.v1.academic_management.model.entity.Subject;
import cacadores.ifal.sighas.api.v1.academic_management.repository.GroupRepository;
import cacadores.ifal.sighas.api.v1.academic_management.repository.ProfessorRepository;
import cacadores.ifal.sighas.api.v1.academic_management.repository.StudentRepository;
import cacadores.ifal.sighas.api.v1.academic_management.repository.SubjectRepository;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
//TODO: Add @Transactional annotation on methods
public class GroupService {
    private final GroupRepository repository;
    private final SubjectRepository subjectRepository;
    private final ProfessorService professorService;
    private final StudentService studentService;
    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;

    public GroupService(GroupRepository groupRepository, SubjectRepository subjectRepository, ProfessorService professorService, StudentService studentService, ProfessorRepository professorRepository, StudentRepository studentRepository) {
        this.repository = groupRepository;
        this.subjectRepository = subjectRepository;
        this.professorService = professorService;
        this.studentService = studentService;
        this.professorRepository = professorRepository;
        this.studentRepository = studentRepository;
    }

    //CREATE
    @Transactional
    public GroupResponseDTO createGroup(GroupRequestDTO createGroupDTO) {
        return this.toGroupResponseDTO(
            repository.save(this.toGroup(createGroupDTO))
        );
    }

    //READ ALL
    public List<GroupResponseDTO> getAllGroups() {
        return repository.findAll().stream()
                                   .map(this::toGroupResponseDTO)
                                   .collect(Collectors.toList());
    }

    //READ BY ID
    public GroupResponseDTO getGroupById(UUID id) {
        return this.toGroupResponseDTO(
            repository.findById(id).orElseThrow(
                () -> new GroupUUIDNotFoundException(
                    String.format("Group with UUID '%s' not found", id)
                )
            )
        );
    }

    //UPDATE
    public GroupResponseDTO updateGroup(UUID id, GroupRequestDTO groupUpdateDTO) {
        Group savedGroup = repository.findById(id).orElseThrow(
            () -> new GroupUUIDNotFoundException(
                String.format("Group with UUID '%s' not found", id)
            )
        );

        Subject groupSubject = this.subjectRepository.findById(groupUpdateDTO.subjectId()).orElseThrow(
            () -> new SubjectUUIDNotFoundException(
                    String.format("Subject with UUID '%s' not found", groupUpdateDTO.subjectId())
            )
        );
        
        savedGroup.setCode(groupUpdateDTO.code());
        savedGroup.setSubject(groupSubject);
        savedGroup.setStatus(groupUpdateDTO.status());

        return this.toGroupResponseDTO(repository.save(savedGroup));
    }
    
    //DELETE
    public void deleteGroup(UUID id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new GroupUUIDNotFoundException(
                String.format("Group with UUID '%s' not found", id)
            );
        }
    };

    //ADD PROFESSORS TO GROUP
    @Transactional
    public GroupResponseDTO addsProfessorsToGroup(UUID id, List<String> professorsSiapeCodes) {
        Group group = this.repository.findById(id).orElseThrow(
            () -> new GroupUUIDNotFoundException(
                String.format("Group with UUID '%s' not found", id)
            )
        );

        new HashSet<>(professorsSiapeCodes).forEach(
           professorSiapeCode -> {
              Professor professor = professorRepository.findBySiape(professorSiapeCode).orElseThrow(
                  () -> new ProfessorSiapeNotFoundException(
                      String.format("Professor with UUID %s not found", professorSiapeCode)
                  )
              );

              group.getProfessors().add(professor);
           }
        );

        return this.toGroupResponseDTO(repository.save(group));
    }

    //ADD STUDENTS TO GROUP
    @Transactional
    public GroupResponseDTO addsStudentsToGroup(UUID id, List<String> studentsEnrollmentCodes) {
        Group group = this.repository.findById(id).orElseThrow(
            () -> new GroupUUIDNotFoundException(
                String.format("Group with UUID '%s' not found", id)
            )
        );

        new HashSet<>(studentsEnrollmentCodes).forEach(
            enrollmentCode -> {
                Student student = studentRepository.findByEnrollment(enrollmentCode).orElseThrow(
                    () -> new StudentEnrollmentNotFoundException(
                        String.format("Student with enrollment code '%s' not found", enrollmentCode)
                    )
                );

                group.getStudents().add(student);
            }
        );

        return this.toGroupResponseDTO(repository.save(group));
    }

    //ENTITY TO RESPONSE DTO
    private GroupResponseDTO toGroupResponseDTO(Group group) {
        return new GroupResponseDTO(
            group.getId(),
            group.getCode(),
            group.getSubject().getId(),
            group.getAcademicPeriod().toString(),
            group.getStatus(),
            group.getProfessors() != null ? group.getProfessors().stream().map(professorService::toProfessorResponseDTO).collect(Collectors.toSet()) : Collections.emptySet(),
            group.getStudents() != null ? group.getStudents().stream().map(studentService::toStudentResponseDTO).collect(Collectors.toSet()) : Collections.emptySet(),
            group.getCreatedAt()
        );
    }

    //REQUEST DTO TO ENTITY
    private Group toGroup(GroupRequestDTO groupRequestDTO) {
        Subject groupSubject = this.subjectRepository.findById(groupRequestDTO.subjectId()).orElseThrow(
            () -> new SubjectUUIDNotFoundException(
                String.format("Subject with UUID '%s' not found", groupRequestDTO.subjectId())
            )
        );

        return new Group(
            groupRequestDTO.code(),
            groupSubject,
            new AcademicPeriod(groupRequestDTO.year(), groupRequestDTO.semester()),
            groupRequestDTO.status()
        );
    }
}
