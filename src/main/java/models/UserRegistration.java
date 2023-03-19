package models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class UserRegistration {
    String username;
    private String email;
    private String password;
    private String passwordConfirmation;
}
