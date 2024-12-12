package cacadores.ifal.sighas.api.v1.academic_management.service;

import cacadores.ifal.sighas.api.v1.academic_management.exception.subject.SubjectUUIDNotFoundException;
import cacadores.ifal.sighas.api.v1.academic_management.model.dto.subject.SubjectRequestDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.dto.subject.SubjectResponseDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.entity.Subject;
import cacadores.ifal.sighas.api.v1.academic_management.repository.SubjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
//TODO: Add @Transactional annotation on methods
public class SubjectService {
    private final SubjectRepository repository;
    public SubjectService(SubjectRepository subjectRepository
    ) {
        this.repository = subjectRepository;
    }

    //CREATE
    @Transactional
    public SubjectResponseDTO createGroup(SubjectRequestDTO createSubjectDTO) {
        return this.toSubjectResponseDTO(
            repository.save(this.toSubject(createSubjectDTO))
        );
    }

    //READ ALL
    public List<SubjectResponseDTO> getAllSubjects() {
        return repository.findAll().stream()
                                   .map(this::toSubjectResponseDTO)
                                   .collect(Collectors.toList());
    }

    //READ BY ID
    public SubjectResponseDTO getSubjectById(UUID id) {
        return this.toSubjectResponseDTO(
            repository.findById(id).orElseThrow(
                () -> new SubjectUUIDNotFoundException(
                    String.format("Group with UUID '%s' not found", id)
                )
            )
        );
    }

    //UPDATE
    public SubjectResponseDTO updateGroup(UUID id, SubjectRequestDTO subjectUpdateDTO) {
        Subject savedSubject = repository.findById(id).orElseThrow(
            () -> new SubjectUUIDNotFoundException(
                String.format("Subject with UUID '%s' not found", id)
            )
        );
        
        savedSubject.setCode(subjectUpdateDTO.code());
        savedSubject.setTitle(subjectUpdateDTO.title());
        savedSubject.setShortTile(subjectUpdateDTO.shortTitle());

        return this.toSubjectResponseDTO(repository.save(savedSubject));
    }
    
    //DELETE
    public void deleteSubject(UUID id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new SubjectUUIDNotFoundException(
                String.format("Subject with UUID '%s' not found", id)
            );
        }
    };


    private SubjectResponseDTO toSubjectResponseDTO(Subject subject) {
        return new SubjectResponseDTO(
            subject.getCode(),
            subject.getTitle(),
            subject.getShortTile()
        );
    }

    private Subject toSubject(SubjectRequestDTO subjectRequestDTO) {
        return new Subject(
            subjectRequestDTO.code(),
            subjectRequestDTO.title(),
            subjectRequestDTO.shortTitle()
        );
    }
}
