package ru.tsystems.tchallenge.service.kernel.domain.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Lazy(false)
public class CategoryBootstrap {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostConstruct
    public void init() {
        categoryRepository.save(category("JAVA", "Java"));
        categoryRepository.save(category("TEST", "Тестирование"));
        categoryRepository.save(category("OOD", "ООП"));
        categoryRepository.save(category("COMMON", "Общая логика"));
    }

    private Category category(String id, String title) {
        Category category = new Category();
        category.setId(id);
        category.setTitle(title);
        return category;
    }
}
