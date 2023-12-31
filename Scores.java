public class Scores {

    private String category;
    private int score;
    private int numberQ;

    public Scores(String category, int score, int numberQ) {

        this.category = category;
        this.score = score;
        this.numberQ = numberQ;
    }

    public String getCategory() {
        return category;

    }

    public int getScore() {
        return score;
    }

    public void inceaseScore() {
        score++;
    }

    public String toString() {

        return "Category: " + category + "  Score: " + score + "/" + numberQ;
    }

}
