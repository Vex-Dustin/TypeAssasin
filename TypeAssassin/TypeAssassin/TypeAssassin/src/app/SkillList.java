package app;

import java.util.ArrayList;
import utilities.IO;

public class SkillList {
    private ArrayList<Skill> skillList = new ArrayList<>();
    
    public SkillList() {
        
    }
    
    public void readSkillList() {
        skillList.clear();
        ArrayList<String> datas = IO.readFile("skillList.txt");
        for (String line: datas) {
            String[] data = line.split("#");
            Skill skill = new Skill(data[0], Integer.parseInt(data[1]));
            skillList.add(skill);
        }
    }
    
    public void saveSkillList() {
        ArrayList<String> data = new ArrayList<>();
        for (Skill skill: skillList) {
            String line = String.format("%s#%d", skill.getNama(), skill.getDamage());
            data.add(line);
        }
        IO.writeFile("skillList.txt", data);
    }
    
    public void generateSkillList() {
        for (int i = 0; i < 5; i++) {
            boolean bisa = true;
            Skill newSkill = new Skill();
            for (Skill skill: skillList) {
                if (skill.getNama().equals(newSkill.getNama())) {
                    bisa = false;
                }
                if (skill.getDamage() == newSkill.getDamage()) {
                    bisa = false;
                }
            }
            if (bisa) {
                skillList.add(newSkill);
            } else {
                i--;
            }
        }
    }

    public ArrayList<Skill> getSkillList() {
        return skillList;
    }
    
    
}
