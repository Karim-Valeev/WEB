package ru.kpfu.itis.valeev.dto;

import lombok.*;
import ru.kpfu.itis.valeev.models.User;

// @Data is a convenient shortcut annotation that bundles the features of
// @ToString,
// @EqualsAndHashCode,
// @Getter / @Setter,
// @RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WebsiteDto {
    Long id;
    User creator;
    String title;
    String body;
    String parentUrl;

    public WebsiteDto(User creator, String title, String body, String parentUrl) {
        this.creator = creator;
        this.title = title;
        this.body = body;
        this.parentUrl = parentUrl;
    }
}
