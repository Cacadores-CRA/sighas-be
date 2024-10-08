package cacadores.ifal.sighas.api.v1.data_generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cacadores.ifal.sighas.api.v1.academic_management.repository.CourseRepository;
import cacadores.ifal.sighas.api.v1.academic_management.model.entity.Course;
import cacadores.ifal.sighas.api.v1.data_generator.DataFaker;

@Service
public class DataService {
    private final CourseRepository courseRepository;
    private final DataFaker dataFaker;

    @Autowired
    public DataService(DataFaker dataFaker, CourseRepository courseRepository) {
        this.dataFaker = dataFaker;
        this.courseRepository = courseRepository;
    }

    public void run() {
        for (int i = 0; i < 15; i++) {
            Course fakeCourse = dataFaker.generateFakeCourse();
            courseRepository.save(fakeCourse);
        }
    }
}

