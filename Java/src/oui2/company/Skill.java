package oui2.company;

public class Skill {
    private Language language;
    private int linesPerDay; // nb lignes de code par jour

    public Skill(Language language, int linesPerDay) {
        this.language = language;
        this.linesPerDay = linesPerDay;
    }

    public Language language() {
        return language;
    }

    public int linesOfCodePerDay() {
        return linesPerDay;
    }

    @Override
    public String toString() {
        return language.name() + " : " + linesPerDay + " lines";
    }
}
