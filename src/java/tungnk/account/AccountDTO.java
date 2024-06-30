/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tungnk.account;

/**
 *
 * @author ktung
 */
public class AccountDTO {
    private String userName;
    private String password;
    private String fullName;
    private boolean isAdmin;
    private String phone;
    private String address;

    public AccountDTO() {
    }

    public AccountDTO(String userName, String password, String fullName, boolean isAdmin, String phone, String address) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.isAdmin = isAdmin;
        this.phone = phone;
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
   
}
