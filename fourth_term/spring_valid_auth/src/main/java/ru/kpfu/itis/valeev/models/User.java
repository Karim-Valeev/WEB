package ru.kpfu.itis.valeev.models;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String login;
    private String email;
    private String password;
    public String bio;
}
