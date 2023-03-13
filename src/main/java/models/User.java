package models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class User {

    private long id;
    @NonNull
    private String username;
    @NonNull
    private String email;
    @NonNull
    private String password;
}
