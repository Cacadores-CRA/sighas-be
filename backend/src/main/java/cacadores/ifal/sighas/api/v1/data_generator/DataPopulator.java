package cacadores.ifal.sighas.api.v1.data_generator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import cacadores.ifal.sighas.api.v1.data_generator.DataService;

@Component
public class DataPopulator implements CommandLineRunner {
    private DataService dataService;

    public DataPopulator(DataService dataService) {
        this.dataService = dataService;
    }

    @Override
    public void run(String... args) throws Exception {
        dataService.run();
    }
}
