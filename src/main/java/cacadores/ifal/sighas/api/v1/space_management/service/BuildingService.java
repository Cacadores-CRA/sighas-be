package cacadores.ifal.sighas.api.v1.space_management.service;

import cacadores.ifal.sighas.api.v1.space_management.model.entity.Building;
import cacadores.ifal.sighas.api.v1.space_management.repository.BuildingRepository;

import org.springframework.stereotype.Service;

@Service
public class BuildingService {
    private BuildingRepository repository;
    public BuildingService(BuildingRepository buildingRepository){
        this.repository = buildingRepository;
    }

    //CREATE
    public Building createBuilding(Building building){
        return repository.save(building);
    }

    //READ BY ID
    //READ ALL
    //UPDATE
    //DELETE
}
