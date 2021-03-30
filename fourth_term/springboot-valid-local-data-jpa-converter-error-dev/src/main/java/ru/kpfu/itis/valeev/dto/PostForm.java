package ru.kpfu.itis.valeev.dto;

import lombok.Data;
import ru.kpfu.itis.valeev.validation.ValidTitle;

import javax.validation.constraints.NotEmpty;

@Data
// Можно так же над классом вешать общую аннотацию на несколько полей, если у нее есть аткой метод
public class PostForm {

    @NotEmpty(message = "{errors.empty.field}")
    @ValidTitle(message = "{errors.invalid.title}")
    private String title;

    @NotEmpty(message = "{errors.empty.field}")
    private String text;

    @NotEmpty(message = "{errors.empty.field}")
    private String categoryName;
}
