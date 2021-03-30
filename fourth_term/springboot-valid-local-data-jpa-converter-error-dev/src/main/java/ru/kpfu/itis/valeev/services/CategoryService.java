package ru.kpfu.itis.valeev.services;

import ru.kpfu.itis.valeev.models.Category;

public interface CategoryService {
    Category getCategoryByName(String name);
}
