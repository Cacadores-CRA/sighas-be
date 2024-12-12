package cacadores.ifal.sighas.api.v1.academic_management.service;

import cacadores.ifal.sighas.api.v1.academic_management.exception.course.CourseUUIDNotFoundException;
import cacadores.ifal.sighas.api.v1.academic_management.exception.group.GroupUUIDNotFoundException;
import cacadores.ifal.sighas.api.v1.academic_management.model.dto.group.GroupRequestDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.dto.group.GroupResponseDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.entity.Group;
import cacadores.ifal.sighas.api.v1.academic_management.repository.GroupRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
//TODO: Add @Transactional annotation on methods
public class GroupService {
    private final GroupRepository repository;
    //  private final UserRoleRepository userRoleRepository;
    // private final PasswordEncoder passwordEncoder;
    public GroupService(GroupRepository groupRepository
    ) {
        this.repository = groupRepository;
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
        
        savedGroup.setCode(groupUpdateDTO.code());
        savedGroup.setSubject(groupUpdateDTO.subject());
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


    private GroupResponseDTO toGroupResponseDTO(Group group) {
        return new GroupResponseDTO(
            group.getCode(),
            group.getSubject(),
            group.getStatus()
        );
    }

    private Group toGroup(GroupRequestDTO groupRequestDTO) {
        return new Group(
            groupRequestDTO.code(),
            groupRequestDTO.subject(),
            groupRequestDTO.status()
        );
    }
}
