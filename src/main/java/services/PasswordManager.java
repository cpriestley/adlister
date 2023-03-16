package services;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordManager {
    final int ROUNDS = 12;

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(ROUNDS));
    }

    public boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
