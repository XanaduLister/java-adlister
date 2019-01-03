package com.codeup.adlister.util;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import org.apache.commons.validator.routines.EmailValidator;

public class Authentication {

  public static boolean isExistingUser(String username) {
    User user = DaoFactory.getUsersDao().findByUsername(username);
    System.out.println("Username does not exist: " + (user == null));
    return user == null;
  }

  public static boolean isExistingEmail(String email) {
    User user = DaoFactory.getUsersDao().findByEmail(email);
    System.out.println("Email does not exist: " + (user == null));
    return user == null;
  }

  public static boolean isValidPassword(String password) {
    String specialChars = "~`!@#$%^&*()-_=+\\|[{]};:'\",<.>/?";
    char currentCharacter;
    boolean numberPresent = false;
    boolean upperCasePresent = false;
    boolean lowerCasePresent = false;
    boolean specialCharacterPresent = false;

    if (password.length() > 7) {
      for (int i = 0; i < password.length(); i++) {
        currentCharacter = password.charAt(i);
        if (Character.isDigit(currentCharacter)) {
          numberPresent = true;
        } else if (Character.isUpperCase(currentCharacter)) {
          upperCasePresent = true;
        } else if (Character.isLowerCase(currentCharacter)) {
          lowerCasePresent = true;
        } else if (specialChars.contains(String.valueOf(currentCharacter))) {
          specialCharacterPresent = true;
        }
      }
    }

    return
        numberPresent && upperCasePresent && lowerCasePresent && specialCharacterPresent;
  }

  public static boolean isValidEmail(String email) {
    EmailValidator validator = EmailValidator.getInstance();
    return validator.isValid(email);
  }

  public static boolean passwordsMatching(String password, String passwordConfirmation) {
    return password.equals(passwordConfirmation);
  }

}
