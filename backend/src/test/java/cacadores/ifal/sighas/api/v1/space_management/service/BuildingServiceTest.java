package cacadores.ifal.sighas.api.v1.space_management.service;

import cacadores.ifal.sighas.api.v1.space_management.model.entity.Building;
import cacadores.ifal.sighas.api.v1.space_management.repository.BuildingRepository;
import static cacadores.ifal.sighas.api.v1.space_management.common.BuildingConstants.BUILDING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {BuildingService.class})
public class BuildingServiceTest {
    @Autowired
    private BuildingService service;

    @MockBean
    private BuildingRepository repository;

    @Test
    public void createBuilding_WithValidData_ReturnsBuilding() {
        //AAA
        //Arrange
        when(repository.save(BUILDING)).thenReturn(BUILDING);

        //Act
        Building sut = service.createBuilding(BUILDING);

        //Assert
        assertThat(sut).isEqualTo(BUILDING);
    }
}
