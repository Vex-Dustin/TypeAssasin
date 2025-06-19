/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.TypeAssassin;

public class IO {
    public static Scanner scanner = new Scanner(System.in);
    public static Random rand = new Random();
    
    public static void clear() {
        for (int i = 0; i < 30; i++) {
            System.out.println("");
        }
    }
    
    public static void enter() {
        System.out.print("Press ENTER to continue...");
        scanner.nextLine();
    }
    
    public static ArrayList<String> readFile(String source) {
        ArrayList<String> data = new ArrayList<>();
        try {
            FileReader fr = new FileReader(source);
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
                data.add(s);
            }
        } catch (FileNotFoundException ex) {
            writeFile(source, new ArrayList<String>());
        } catch (IOException ex) {
            Logger.getLogger(TypeAssassin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    public static void writeFile(String source, ArrayList<String> data) {
        FileWriter fw;
        try {
            fw = new FileWriter(source);
            for (String line: data) {
                fw.write(line);
                fw.write("\n");
            }
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(TypeAssassin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
