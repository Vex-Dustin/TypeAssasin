package page;

import app.Monster;
import app.MonsterList;
import app.Player;
import app.Skill;
import app.SkillList;
import java.util.ArrayList;
import utilities.IO;

public class Input {
    private Player PL = new Player();
    private MonsterList ML = new MonsterList();
    private SkillList SL = new SkillList();
    
    public Input() {
        while (true) {
            System.out.println("");
            System.out.print("Input Combo (use ', ' in between skill): ");
            String comboString = IO.scanner.nextLine();
            SL.readSkillList();
            PL.readPlayerInfo();
            
            String[] combos = comboString.split(", ");
            boolean bisa = true;
            int damage = 0;
            for (String combo: combos) {
                boolean ada = false;
                for (Skill skill: SL.getSkillList()) {
//                    System.out.println(skill.getNama());
//                    System.out.println(combo);
                    if (skill.getNama().equals(combo)) {
                        ada = true;
                        damage += skill.getDamage();
                        break;
                    }
                }
                if (!ada) {
                    bisa = false;
                }
            }
            if (!bisa) {
                System.out.println("Invalid Combo!");
                continue;
            }
            
            ML.clear();
            ML.readMonsterList();
            if (ML.getMonsterList().isEmpty()) {
                System.out.println("No Monster to be killed!");
                continue;
            }
//            System.out.println(ML.getMonsterList().get(0).getHp());
//            System.out.println(damage);
            if (ML.getMonsterList().get(0).getHp() == damage) {
                System.out.println(ML.getMonsterList().get(0).getName() + " has been slain!");
                PL.setScore(PL.getScore() + 100);
                ML.getMonsterList().remove(0);
            } else {
                System.out.println("Combo is not effective!");
            }
            PL.savePlayerInfo();
            ML.saveMonsterList();
        }
    }
    
    
}
