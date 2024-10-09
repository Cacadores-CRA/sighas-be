package cacadores.ifal.sighas.api.v1.academic_management.service;

import cacadores.ifal.sighas.api.v1.academic_management.model.dto.professor.ProfessorRequestDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.dto.professor.ProfessorResponseDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.entity.Professor;
import cacadores.ifal.sighas.api.v1.academic_management.repository.ProfessorRepository;

import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
    private final ProfessorRepository repository;
    public ProfessorService(ProfessorRepository professorRepository) {
        this.repository = professorRepository;
    }

    //CREATE
    public ProfessorResponseDTO createProfessor(ProfessorRequestDTO professorRequestDTO) {
        ProfessorResponseDTO professor = null;
        return professor;
    }


}