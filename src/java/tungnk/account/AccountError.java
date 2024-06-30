/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tungnk.account;

import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author ktung
 */
public class AccountError {
    private String userIDLengthError;
    private String passwordLengthError;
    private String passwordNotMatch;
    private String fullNameLengthError;
    private String userExisted;

    public String getUserIDLengthError() {
        return userIDLengthError;
    }

    public void setUserIDLengthError(String userIDLengthError) {
        this.userIDLengthError = userIDLengthError;
    }


    public String getPasswordLengthError() {
        return passwordLengthError;
    }

    public void setPasswordLengthError(String passwordLengthError) {
        this.passwordLengthError = passwordLengthError;
    }

    public String getPasswordNotMatch() {
        return passwordNotMatch;
    }

    public void setPasswordNotMatch(String passwordNotMatch) {
        this.passwordNotMatch = passwordNotMatch;
    }

    public String getFullNameLengthError() {
        return fullNameLengthError;
    }

    public void setFullNameLengthError(String fullNameLengthError) {
        this.fullNameLengthError = fullNameLengthError;
    }

    public String getUserExisted() {
        return userExisted;
    }

    public void setUserExisted(String userExisted) {
        this.userExisted = userExisted;
    }

    public boolean checkUserName(String userName) {
        if(userName.trim().length() < 6 || userName.trim().length() > 20) {
            userIDLengthError = "User Name length must be in range 6 to 20";
            return false;
        }
        return true;
    }
    
    public boolean checkPassword(String password) {
//        if
//            passwordLengthError = "Password length must be in range 8 to 20";
//            return false;
//        }
//        return true;
        return true;
    }
    
    public boolean checkConfirm(String password, String confirm) {
        if(!password.equals(confirm)) {
            passwordNotMatch = "Password and confirm do not match";
            return false;
        }
        return true;
    }
    
    public boolean checkFullName(String fullName) {
        if(fullName.trim().length() < 6 || fullName.trim().length() > 50) {
            fullNameLengthError = "Full Name length must be in range 6 to 50";
            return false;
        }
        return true;
    }
    
    public boolean checkInsertNewUser(String userName, String password, String fullName, boolean isAdmin, String phone, String address) throws SQLException, ClassNotFoundException {
        AccountDAO dao = new AccountDAO();
        boolean isSuccess = dao.insertNewUser(userName, password, fullName, false, phone, address);
        if(!isSuccess) {
           userExisted = userName + " is already existed";
           return false;
        }
        return true;
    }
}
