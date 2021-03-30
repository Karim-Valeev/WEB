package ru.kpfu.itis.valeev.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import ru.kpfu.itis.valeev.models.Category;
import ru.kpfu.itis.valeev.services.CategoryService;

public class StringToCategoryConverter implements Converter<String, Category> {

    @Autowired
    private CategoryService categoryService;

    @Override
    public Category convert(String categoryDtoAsString) {
        if (categoryDtoAsString == null){
            throw new ConversionFailedException(TypeDescriptor.valueOf(String.class),
                    TypeDescriptor.valueOf(String.class), categoryDtoAsString, null);
        }

        return categoryService.getCategoryByName(categoryDtoAsString);
    }
}
