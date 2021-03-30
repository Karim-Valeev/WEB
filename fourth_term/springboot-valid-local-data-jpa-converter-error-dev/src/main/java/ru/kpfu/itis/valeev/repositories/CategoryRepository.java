package ru.kpfu.itis.valeev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.valeev.models.Category;

import java.util.Calendar;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoryByName(String name);
}
