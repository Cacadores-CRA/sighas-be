package cacadores.ifal.sighas.api.v1.data_generator;

import com.github.javafaker.Faker;
import cacadores.ifal.sighas.api.v1.academic_management.model.entity.Course;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class DataFaker {
    final Faker faker = new Faker(new Locale("pt-BR"));

    public Course generateFakeCourse() {
        Course course = new Course();
        course.setCode(faker.regexify("[0-9]{10}"));
        course.setTitle(faker.educator().course());
        course.setShortTitle("-");
        course.setQuantityOfSemesters(faker.number().numberBetween(4, 10));
        return course;
    }
}
