package cacadores.ifal.sighas.api.v1.academic_management.service;

import cacadores.ifal.sighas.api.v1.academic_management.exception.affiliation.AffiliationUUIDNotFoundException;
import cacadores.ifal.sighas.api.v1.academic_management.exception.user.UserUUIDNotFoundException;
import cacadores.ifal.sighas.api.v1.academic_management.model.dto.professor.ProfessorRequestDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.dto.professor.ProfessorResponseDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.entity.Department;
import cacadores.ifal.sighas.api.v1.academic_management.model.entity.Professor;
import cacadores.ifal.sighas.api.v1.academic_management.model.entity.User;
import cacadores.ifal.sighas.api.v1.academic_management.repository.DepartmentRepository;
import cacadores.ifal.sighas.api.v1.academic_management.repository.ProfessorRepository;
import cacadores.ifal.sighas.api.v1.academic_management.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
//TODO: Add @Transactional annotation on methods
public class ProfessorService {
    private final ProfessorRepository repository;
    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;
    public ProfessorService(ProfessorRepository professorRepository, UserRepository userRepository, DepartmentRepository departmentRepository) {
        this.repository = professorRepository;
        this.userRepository = userRepository;
        this.departmentRepository = departmentRepository;
    }

    //CREATE
    public ProfessorResponseDTO createProfessor(ProfessorRequestDTO createProfessorDTO) {
        return this.toProfessorResponseDTO(
            repository.save(this.toProfessor(createProfessorDTO))
        );
    }

    //READ ALL
    public List<ProfessorResponseDTO> getAllProfessors() {
        return repository.findAll().stream()
                                   .map(this::toProfessorResponseDTO)
                                   .collect(Collectors.toList());
    }

    //READ BY ID
    public ProfessorResponseDTO getProfessorByAffiliationId(UUID affiliationId) {
        return this.toProfessorResponseDTO(
            repository.findById(affiliationId).orElseThrow(
                () -> new AffiliationUUIDNotFoundException(
                    String.format("Professor with affiliation id '%s' not found", affiliationId)
                )
            )
        );
    }

    //UPDATE BY AFFILIATION ID
    public ProfessorResponseDTO updateProfessorByAffiliationId(UUID affiliationId, ProfessorRequestDTO professorUpdateDTO) {
        Professor savedProfessor = repository.findById(affiliationId).orElseThrow(
                () -> new AffiliationUUIDNotFoundException(
                    String.format("Professor with affiliation id '%s' not found", affiliationId)
                )
        );

        User savedUser = userRepository.findById(professorUpdateDTO.userId()).orElseThrow(
            () -> new UserUUIDNotFoundException(
                String.format("User with id '%s' not found", professorUpdateDTO.userId())
            )
        );

        //TODO: Implement custom exception
        Department savedDepartment = departmentRepository.findById(professorUpdateDTO.departmentId()).orElseThrow(
                () -> new RuntimeException("Department not found")
        );

        savedProfessor.setUser(savedUser);
        savedProfessor.setStartingDate(professorUpdateDTO.startingDate());
        savedProfessor.setEndingDate(professorUpdateDTO.endingDate());
        savedProfessor.setStatus(professorUpdateDTO.status());
        savedProfessor.setSiape(professorUpdateDTO.siape());
        savedProfessor.setEducation(professorUpdateDTO.education());
        savedProfessor.setDepartment(savedDepartment);
        savedProfessor.setInstitutionalEmail(professorUpdateDTO.institutionalEmail());

        return this.toProfessorResponseDTO(repository.save(savedProfessor));
    }

    //DELETE BY AFFILIATION ID
    public void deleteProfessorByAffiliationId(UUID affiliationId) {
        if(repository.existsById(affiliationId)) {
            repository.deleteById(affiliationId);
        } else {
            throw new AffiliationUUIDNotFoundException(
                String.format("Professor with affiliation id '%s' not found", affiliationId)
            );
        }
    }

    //ENTITY TO RESPONSE DTO
    protected ProfessorResponseDTO toProfessorResponseDTO(Professor professor) {
        return new ProfessorResponseDTO(
            professor.getSiape(),
            professor.getUser().getName(),
            professor.getStatus(),
            professor.getEducation(),
            professor.getInstitutionalEmail(),
            professor.getCreatedAt()
        );
    }

    //REQUEST DTO TO ENTITY
    private Professor toProfessor(ProfessorRequestDTO professorRequestDTO) {
        User professorUser = userRepository.findById(professorRequestDTO.userId()).orElseThrow(
            () -> new UserUUIDNotFoundException(
                String.format("User with UUID '%s' not found", professorRequestDTO.userId())
            )
        );

        Department professorDepartment = departmentRepository.findById(professorRequestDTO.departmentId()).orElseThrow(
                () -> new RuntimeException("Department not found")
        );

        return new Professor(
            professorUser,
            professorRequestDTO.startingDate(),
            professorRequestDTO.endingDate(),
            professorRequestDTO.status(),
            professorRequestDTO.siape(),
            professorRequestDTO.education(),
            //TODO: Check it out if department is obligatory
            professorDepartment,
            professorRequestDTO.institutionalEmail()
        );
    }
}