package app;

import java.util.ArrayList;
import java.util.Arrays;
import utilities.IO;

public class Monster {
    private ArrayList<String> nameList = new ArrayList<>(Arrays.asList("Barbarian", "Archer", "Goblin", "Giant", "Wall Breaker", "Ballon", "Wizard", "Healer", "Dragon", "Pekka", "Baby Dragon", "Miner", "Electric Dragon", "Minion", "Hog Rider", "Valkyrie", "Golem"));
    private String name;
    private int hp, time;
    
    public Monster(int hp) {
        this.name = nameList.get(IO.rand.nextInt(nameList.size()));
        this.hp = hp;
        this.time = IO.rand.nextInt(16)+15;
    }
    
    public Monster(String name, int hp, int time) {
        this.name = name;
        this.hp = hp;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getTime() {
        return time;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
}
