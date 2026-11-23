package coffeeshop;

public class HiringManager {
    public int hire(Applicant applicant) {

        int score = 0;

        if (applicant.getYearsExperience() >= 2) {
            score += 25;
        }

        String answer =
                applicant.getAnswer().toLowerCase();

        if (answer.contains("array")) {
            score += 15;
        }

        if (answer.contains("loop")) {
            score += 15;
        }

        if (answer.contains("object")) {
            score += 15;
        }

        if (answer.contains("class")) {
            score += 15;
        }

        if (answer.contains("method")) {
            score += 15;
        }

        return score;


    }
}
