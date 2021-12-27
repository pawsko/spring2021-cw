package pl.javastart.datagenerator;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Service
class DataGeneratorService {
    Map<String, List<String>> generateFakeData(int size,
                                               String language,
                                               boolean firstName,
                                               boolean lastName,
                                               boolean university,
                                               boolean country) {
        Faker faker = new Faker(new Locale(language));
        Map<String, List<String>> data = new LinkedHashMap<>();
        if (firstName) {
            data.put("Imię", generateData(size, faker.name()::firstName));
        }
        if (lastName) {
            data.put("Nazwisko", generateData(size, faker.name()::lastName));
        }
        if (university) {
            data.put("Uczelnia", generateData(size, faker.university()::name));
        }
        if (country) {
            data.put("Kraj pochodzenia", generateData(size, faker.country()::name));
        }
        return data;
    }

    private List<String> generateData(int size, Supplier<String> supplier) {
        return Stream.generate(supplier)
                .limit(size)
                .toList();
    }
}
