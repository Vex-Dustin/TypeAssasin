package page;

import app.Monster;
import app.MonsterList;
import app.Player;
import app.Skill;
import app.SkillList;
import java.util.ArrayList;
import utilities.IO;

public class Output {
    
    private Player PL = new Player();
    private SkillList SL = new SkillList();
    private MonsterList ML = new MonsterList();
    
    public Output() {
        System.out.print("Enter your username: ");
        PL.setUsername(IO.scanner.nextLine());
        PL.setScore(0);
        PL.setLife(3);
        
        SL.generateSkillList();
        
        ML.clear();
        ML.saveMonsterList();
        
        SL.saveSkillList();
        PL.savePlayerInfo();
        
        
        loop();
    }
    
    private void loop() {
        ML.clear();
        ML.readMonsterList();
        PL.readPlayerInfo();
        if (ML.getMonsterList().size() < 2) {
            ML.generateMonsterList();
        } else {
            ML.getMonsterList().get(0).setTime(ML.getMonsterList().get(0).getTime() - 1);
        }
        if (ML.getMonsterList().get(0).getTime() == 0) {
            PL.setLife(PL.getLife() - 1);
            ML.getMonsterList().remove(0);
            PL.savePlayerInfo();
        }
        if (PL.getLife() <= 0) {
            System.out.println("Game Over!");
            System.out.println("Your Score: " + PL.getScore());
            PL.saveToLeaderboard();
            IO.enter();
            return;
        }
        ML.saveMonsterList();
        
        displayInfo();
        
        long sTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - sTime < 1000) {
        }
        loop();
    }
    
    private void displayInfo() {
        IO.clear();
        // Name
        System.out.println("Username: " + PL.getUsername());
        // Nyawa
        System.out.println("Life: " + PL.getLife());
        // Score
        System.out.println("Score: " + PL.getScore());
        // MonsterList
        System.out.println("+----+------------------+-----+------+");
        System.out.println("| No | Monster Name     | HP  | Time |");
        System.out.println("+----+------------------+-----+------+");
        int counter = 1;
        for (Monster mons: ML.getMonsterList()) {
            String row = String.format("| %-2d | %-16s | %-3d | %-4d |", counter, mons.getName(), mons.getHp(), mons.getTime());
            System.out.println(row);
            counter++;
        }
        System.out.println("+----+------------------+-----+------+");
        System.out.println("");
        
        // SkillList
        // No Skill Name Damage
        System.out.println("+----+------------+--------+");
        System.out.println("| No | Skill Name | Damage |");
        System.out.println("+----+------------+--------+");
        counter = 1;
        for (Skill skill: SL.getSkillList()) {
            String row = String.format("| %-2d | %-10s | %-6d |", counter, skill.getNama(), skill.getDamage());
            System.out.println(row);
            counter++;
        }
        System.out.println("+----+------------+--------+");
    }
}
