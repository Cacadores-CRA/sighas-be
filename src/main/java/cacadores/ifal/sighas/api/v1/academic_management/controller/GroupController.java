package cacadores.ifal.sighas.api.v1.academic_management.controller;

import cacadores.ifal.sighas.api.v1.academic_management.model.dto.group.GroupRequestDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.dto.group.GroupResponseDTO;
import cacadores.ifal.sighas.api.v1.academic_management.service.GroupService;

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
@RequestMapping("/v1/groups")
@Tag(name = "Groups", description = "Endpoints for groups management")
//TODO: Complete documentation
public class GroupController {
    private final GroupService service;
    public GroupController(GroupService groupService) {
        this.service = groupService;
    }

    //CREATE
    @Operation(summary = "Creates a course", method = "POST")
    @PostMapping
    public ResponseEntity<GroupResponseDTO> createCourse(@Valid @RequestBody GroupRequestDTO groupCreateDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createGroup(groupCreateDTO));
    }

    //READ ALL
    @Operation(summary = "Gets all groups", method = "GET")
    @GetMapping
    public ResponseEntity<List<GroupResponseDTO>> getAllGroups() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllGroups());
    }

    //READ BY ID
    @Operation(summary = "Gets a group by its ID", method = "GET")
    @GetMapping("/{id}")
    public ResponseEntity<GroupResponseDTO> getGroupById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getGroupById(id));
    }

    //UPDATE
    @Operation(summary = "Updates a group by its id", method = "UPDATE")
    @PutMapping("/{id}")
    public ResponseEntity<GroupResponseDTO> updateGroup(@PathVariable UUID id, @Valid @RequestBody GroupRequestDTO groupUpdateDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateGroup(id, groupUpdateDTO));
    }

    //DELETE
    @Operation(summary = "Deletes a group by its ID", method = "DELETE")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable UUID id) {
        service.deleteGroup(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
