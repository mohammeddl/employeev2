
abstract class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private String role;
    private Date birthDate;

    public User(String name, String email, String password, String role, Date birthDate) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
    
}
