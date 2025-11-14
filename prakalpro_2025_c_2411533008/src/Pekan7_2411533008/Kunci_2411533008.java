package Pekan7_2411533008;

public class Kunci_2411533008 {
    private String username;
    private String password;
    private String email;
    private int pinAngka;

    // Setter
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPinAngka(int pinAngka) {
        this.pinAngka = pinAngka;
    }

    // Getter
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getPinAngka() {
        return pinAngka;
    }

    // Helper Method Validasi
    public boolean isPasswordValid() {
        return password.length() >= 8;
    }

    public boolean isEmailValid() {
        return email.contains("@") && email.contains(".");
    }
}

	