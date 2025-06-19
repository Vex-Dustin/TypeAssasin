package app;

import java.util.ArrayList;
import utilities.IO;

public class MonsterList {
    private ArrayList<Monster> monsterList = new ArrayList<>();
    private SkillList SL = new SkillList();
    
    public MonsterList() {
        
    }
    
    public void clear() {
        monsterList.clear();
    }
    
    public void saveMonsterList() {
        ArrayList<String> data = new ArrayList<>();
        for (Monster mons: monsterList) {
            String line = String.format("%s#%d#%d", mons.getName(), mons.getHp(), mons.getTime());
            data.add(line);
        }
        IO.writeFile("monsterList.txt", data);
    }
    
    public void readMonsterList() {
        ArrayList<String> datas = IO.readFile("monsterList.txt");
        for (String line: datas) {
            String[] data = line.split("#");
            Monster mons = new Monster(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
            monsterList.add(mons);
        }
    }
    
    public void generateMonsterList() {
        SL.readSkillList();
        int hp = SL.getSkillList().get(IO.rand.nextInt(SL.getSkillList().size())).getDamage();
        int limit = IO.rand.nextInt(5);
        for (int i = 0; i < limit; i++) {
            hp += SL.getSkillList().get(IO.rand.nextInt(SL.getSkillList().size())).getDamage();
        }
            
        Monster mons = new Monster(hp);
        monsterList.add(mons);
    }

    public ArrayList<Monster> getMonsterList() {
        return monsterList;
    }
    
    
}
