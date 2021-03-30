package ru.kpfu.itis.valeev.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Website {
    Long id;
    String title;
    String htmlFileSrc;
    String url;
    Long creator;
    String parentSiteUrl;
    String body;
    List<Website> children;

    public Website(String title, String url, Long creator, String parentSiteUrl, String body) {
        this.title = title;
        this.url = url;
        this.creator = creator;
        this.parentSiteUrl = parentSiteUrl;
        this.body = body;
    }
}
