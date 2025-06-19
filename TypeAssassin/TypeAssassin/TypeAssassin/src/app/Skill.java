package app;

import java.util.ArrayList;
import java.util.Arrays;
import utilities.IO;

public class Skill {
    private ArrayList<String> nameList = new ArrayList<>(Arrays.asList("Fireball", "Meteor", "Sword", "Ice Shot", "Earthquake","Thunder", "Iceball", "Tornado", "Wind Slash", "Power Kick","Iron Fist", "Lava Surge", "Storm", "Freezing", "Volt Slash","Shockwave", "Spin Boom", "Inferno", "Dark Pulse", "Gale Force","Poison", "Eye Glare"));
    private String nama;
    private int damage;
    
    public Skill() {
        this.nama = nameList.get(IO.rand.nextInt(nameList.size()));
        this.damage = IO.rand.nextInt(10) + 5;
    }
    
    public Skill(String nama, int damage) {
        this.nama = nama;
        this.damage = damage;
    }

    public String getNama() {
        return nama;
    }

    public int getDamage() {
        return damage;
    }
    
}
