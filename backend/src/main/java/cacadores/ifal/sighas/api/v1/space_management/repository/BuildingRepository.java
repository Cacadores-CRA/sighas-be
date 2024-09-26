package cacadores.ifal.sighas.api.v1.space_management.repository;

import cacadores.ifal.sighas.api.v1.space_management.model.entity.Building;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
    Building save(Building building);
    Optional<Building> findById(Long id);
    List<Building> findAll();
    void deleteById(Long id);
}
