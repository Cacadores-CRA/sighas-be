package cacadores.ifal.sighas.api.v1.academic_management.controller;

import cacadores.ifal.sighas.api.v1.academic_management.model.dto.student.StudentRequestDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.dto.student.StudentResponseDTO;
import cacadores.ifal.sighas.api.v1.academic_management.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("/v1/students")
@Tag(name = "Students Management", description = "Endpoints for managing students")
//TODO: Complete documentation
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService studentService) {
        this.service = studentService;
    }

    //CREATE
    @Operation(summary = "Creates a student", method = "POST")
    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(@Valid @RequestBody StudentRequestDTO studentCreateDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createStudent(studentCreateDTO));
    }

    //READ ALL
    @Operation(summary = "Gets all students", method = "GET")
    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllStudents());
    }

    //READ BY AFFILIATION ID
    @Operation(summary = "Gets a student by its affiliation ID", method = "GET")
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentByAffiliationId(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getStudentByAffiliationId(id));
    }

    //UPDATE BY AFFILIATION ID
    @Operation(summary = "Updates a student by its affiliation id", method = "UPDATE")
    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudentByAffiliationId(@PathVariable UUID id, @Valid @RequestBody StudentRequestDTO studentUpdateDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateStudentByAffiliationId(id, studentUpdateDTO));
    }

    //DELETE BY AFFILIATION ID
    @Operation(summary = "Deletes a student by its ID", method = "DELETE")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentByAffiliationId(@PathVariable UUID id) {
        service.deleteStudentByAffiliationId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
