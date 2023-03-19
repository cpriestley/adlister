package services;

import data.DaoFactory;
import models.Ad;
import models.User;
import models.UserRegistration;
import models.ValidationResult;

public interface ValidationService {
    static ValidationResult validate(Ad ad) {
        boolean isValid = false;
        ad.getId();
        ad.getTitle();
        ad.getDescription();
        ad.getUserId();
        return new ValidationResult(isValid, "");
    };

    static ValidationResult validate(User user) {
        boolean isValid = false;
        user.getId();
        user.getUsername();
        user.getEmail();
        user.getPassword();
        return new ValidationResult(isValid, "");
    }

    static ValidationResult validate(UserRegistration registration) {
        boolean isValid = false;

        if(registration.getUsername().isBlank()) {
            return new ValidationResult(isValid, "Invalid user name");
        }

        if (DaoFactory.getUsersDao().findByUsername(registration.getUsername()) != null) {
            return new ValidationResult(isValid, "User name already exists");
        }
        if(DaoFactory.getUsersDao().findByEmail(registration.getEmail()) != null) {
            return new ValidationResult(isValid, "Email already exists");
        }

        return new ValidationResult(isValid, "");
    }


}
