package cacadores.ifal.sighas.api.v1.academic_management.controller;

import cacadores.ifal.sighas.api.v1.academic_management.model.dto.professor.ProfessorRequestDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.dto.professor.ProfessorResponseDTO;
import cacadores.ifal.sighas.api.v1.academic_management.service.ProfessorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/professors")
@Tag(name = "Professors", description = "Endpoints for professors management")
@SecurityRequirement(name = "jwtAuthentication")
//TODO: Complete documentation
public class ProfessorController {
    private final ProfessorService service;
    public ProfessorController(ProfessorService professorService) {
        this.service = professorService;
    }

    //CREATE
    @Operation(summary = "Creates a professor", method = "POST")
    @PostMapping
    public ResponseEntity<ProfessorResponseDTO> createProfessor(@Valid @RequestBody ProfessorRequestDTO professorCreateDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createProfessor(professorCreateDTO));
    }

    //READ ALL
    @Operation(summary = "Gets all professors", method = "GET")
    @GetMapping
    public ResponseEntity<List<ProfessorResponseDTO>> getAllProfessors() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllProfessors());
    }

    //READ BY AFFILIATION ID
    @Operation(summary = "Gets a professor by its affiliation ID", method = "GET")
    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> getProfessorByAffiliationId(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getProfessorByAffiliationId(id));
    }

    //UPDATE BY AFFILIATION ID
    @Operation(summary = "Updates a professor by its affiliation id", method = "UPDATE")
    @PutMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> updateProfessorByAffiliationId(@PathVariable UUID id, @Valid @RequestBody ProfessorRequestDTO professorUpdateDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateProfessorByAffiliationId(id, professorUpdateDTO));
    }

    //DELETE BY AFFILIATION ID
    @Operation(summary = "Deletes a professor by its ID", method = "DELETE")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessorByAffiliationId(@PathVariable UUID id) {
        service.deleteProfessorByAffiliationId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
