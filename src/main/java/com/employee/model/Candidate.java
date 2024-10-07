public class Candidate extends User {
    private String SocialSecurityNumber;


    public Candidate(String name, String email, String password, String role, Date birthDate, String SocialSecurityNumber) {
        super(name, email, password, role, birthDate);
        this.SocialSecurityNumber = SocialSecurityNumber;
    }

    public String getSocialSecurityNumber() {
        return SocialSecurityNumber;
    }
    
}
