package coffeeshop;

public class HiringManager {
    public boolean hire(Applicant applicant) {

        int score = 0;

        if (applicant.getYearsExperience() >= 2) {
            score += 50;
        }

        String answer =
                applicant.getAnswer().toLowerCase();

        if (answer.contains("array")) {
            score += 25;
        }

        if (answer.contains("loop")) {
            score += 25;
        }

        if (answer.contains("object")) {
            score += 25;
        }

        return score >= 75;
    }
}
