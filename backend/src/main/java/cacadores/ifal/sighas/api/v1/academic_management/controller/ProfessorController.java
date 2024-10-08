package cacadores.ifal.sighas.api.v1.academic_management.controller;

import cacadores.ifal.sighas.api.v1.academic_management.model.dto.professor.ProfessorRequestDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.dto.professor.ProfessorResponseDTO;
import cacadores.ifal.sighas.api.v1.academic_management.service.ProfessorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/professors")
@Tag(name = "Professors", description = "Endpoints for professors management")
public class ProfessorController {
    private final ProfessorService service;
    public ProfessorController(ProfessorService professorService) {
        this.service = professorService;
    }

    //CREATE
    @Operation(description = "Creates a professor", method = "POST")
    @GetMapping
    public ResponseEntity<ProfessorResponseDTO> createProfessor(@Valid @RequestBody ProfessorRequestDTO professorCreateDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createProfessor(professorCreateDTO));
    }

    //READ ALL
    //READ BY ID
    //UPDATE
    //DELETE
}
