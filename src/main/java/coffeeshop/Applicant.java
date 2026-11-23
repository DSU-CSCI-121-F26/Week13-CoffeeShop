package coffeeshop;

public class Applicant {
    private String name;
    private int yearsExperience;
    private String answer;

    public Applicant(String name,
                     int yearsExperience,
                     String answer) {

        this.name = name;
        this.yearsExperience = yearsExperience;
        this.answer = answer;
    }

    public String getName() {
        return name;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public String getAnswer() {
        return answer;
    }
}
