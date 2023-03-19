package services;

import com.mysql.cj.util.StringUtils;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordManager {
    final int ROUNDS = 12;

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(ROUNDS));
    }

    public boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
    
    public boolean checkPasswordsAreValid(String password, String passwordConfirmation) {
        if(StringUtils.isNullOrEmpty(password)) {
            return false;
        }
        if (StringUtils.isNullOrEmpty(passwordConfirmation)) {
            return false;
        }
        return password.equals(passwordConfirmation);
    }
}
