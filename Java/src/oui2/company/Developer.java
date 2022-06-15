package oui2.company;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Developer {

    private final String name;
    private final int coffeePerDay; // En millilitres

    private final List<Skill> skills;
    private final List<Hobby> hobbies;

    public Developer(String name, int coffePerDay, Collection<Skill> skills, Collection<Hobby> hobbies) {
        this.name = name;
        this.coffeePerDay = coffePerDay;
        this.skills = new LinkedList<>();
        for (Skill skill : skills) { // Evite naïvement les doublons du random
            if (!this.skills.stream().anyMatch(s -> s.language() == skill.language()))
                this.skills.add(skill);
        }
        this.hobbies = new LinkedList<>(hobbies);
    }

    public String name() {
        return name;
    }

    public int coffeeConsumption() {
        return coffeePerDay;
    }

    public List<Skill> skills() {
        return skills;
    }

    public List<Hobby> hobbies() {
        return hobbies;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(", ");
        sb.append(String.format("%.2f dl", coffeePerDay / 100.0));
        sb.append(", skills { ");
        for (Skill s : skills)
            sb.append(String.format("[%s] ", s));
        sb.append("}, hobbies { ");
        for (Hobby hobby : hobbies)
            sb.append(String.format("[%s] ", hobby));
        sb.append("}");
        return sb.toString();
    }
}
