package africa.semicolon.sendAm.dtos.responses;

public class RegisterUserResponse {
    private String fullName;
    private String email;

    @Override
    public String toString() {
        return "RegisterUserResponse{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
