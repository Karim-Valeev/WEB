package ru.kpfu.itis.valeev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.valeev.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
