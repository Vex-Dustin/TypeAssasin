/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.util.ArrayList;
import utilities.IO;

/**
 *
 * @author ACER
 */
public class Player {
    
    private String username;
    private int score, life;
    
    
    public void readPlayerInfo() {
        ArrayList<String> datas = IO.readFile("playerInfo.txt");
        for (String line: datas) {
            String[] data = line.split("#");
            username = data[0];
            life = Integer.parseInt(data[1]);
            score = Integer.parseInt(data[2]);
        }
    }
    
    public void savePlayerInfo() {
        ArrayList<String> data = new ArrayList<>();
        data.add(String.format("%s#%d#%d", this.username, this.life, this.score));
        IO.writeFile("playerInfo.txt", data);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
    
    public void saveToLeaderboard() {
        ArrayList<String> datas = IO.readFile("leaderboard.txt");
        String data = String.format("%s#%d", this.username, this.score);
        datas.add(data);
        IO.writeFile("leaderboard.txt", datas);
    }
}
