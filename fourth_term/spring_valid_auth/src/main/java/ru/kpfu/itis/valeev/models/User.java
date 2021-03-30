package ru.kpfu.itis.valeev.models;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String login;
    private String email;
    private String password;
    public String bio;

    public User(String login, String email, String password, String bio) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.bio = bio;
    }
}
