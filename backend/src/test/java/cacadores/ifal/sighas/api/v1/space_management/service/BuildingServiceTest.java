package cacadores.ifal.sighas.api.v1.space_management.service;

import cacadores.ifal.sighas.api.v1.space_management.model.entity.Building;
import cacadores.ifal.sighas.api.v1.space_management.repository.BuildingRepository;
import static cacadores.ifal.sighas.api.v1.space_management.common.BuildingConstants.BUILDING;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class BuildingServiceTest {
    @InjectMocks
    private BuildingService service;

    @Mock
    private BuildingRepository repository;

    @Test
    public void createBuilding_WithValidData_ReturnsBuilding() {
        when(repository.save(BUILDING)).thenReturn(BUILDING);
            Building sut = service.createBuilding(BUILDING);
        assertThat(sut).isEqualTo(BUILDING);
    }
}
