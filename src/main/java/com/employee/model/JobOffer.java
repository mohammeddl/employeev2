public class JobOffer {

    private int id;
    private String title;
    private String description;
    private int recruiterId;

    public JobOffer(String title, String description, int recruiterId) {
        this.title = title;
        this.description = description;
        this.recruiterId = recruiterId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getRecruiterId() {
        return recruiterId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRecruiterId(int recruiterId) {
        this.recruiterId = recruiterId;
    }

    
}
