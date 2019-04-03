package fr.rekeningrijdersapplicatie.pojos;

public class RegistrationInfo extends UserInfo {

    private String username;
    private String password;
    private String email;
    private String BSN;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBSN() {
        return BSN;
    }

    public void setBSN(String BSN) {
        this.BSN = BSN;
    }
}
