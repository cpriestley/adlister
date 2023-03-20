package data;

import models.User;

public interface UsersRepository {
    User findByUsername(String username);
    User findByEmail(String email);
    Long insert(User user);
    int update(User user);
    int delete(long id);
}
