package main;

import app.Monster;
import java.util.ArrayList;
import page.Input;
import page.Output;
import utilities.IO;

public class TypeAssassin {
    
    public TypeAssassin() {
        String input;
        do {
            IO.clear();
            printMenu();
            input = IO.scanner.nextLine();
            if (input.equals("1")) {
                new Input();
            } else if (input.equals("2")) {
                new Output();
            } else if (input.equals("3")) {
                showRules();
            } else if (input.equals("4")) {
                showLeaderboard();
            }
            else if (input.equals("5")) {
                showLevel();
            }
        } while (!input.equals("6"));
        
        // random nama, hp, waktu
//        Monster mons1 = new Monster();
//        mons1.getHp();
    }
    
    public static void main(String[] args) {
        new TypeAssassin();
    }
    
    public void printMenu() {
        System.out.println("Welcome to Type Assassin!");
        System.out.println("1. Input Mode");
        System.out.println("2. Output Mode");
        System.out.println("3. Rules");
        System.out.println("4. Leaderboard");
        System.out.println("5. Check My Level");
        System.out.println("6. Close");
        System.out.print("Input: ");
    }
    
    private void showLeaderboard() {
        IO.clear();
        ArrayList<String> datas = IO.readFile("leaderboard.txt");
        
        System.out.println("+----+----------------------+-------+");
        System.out.println("| No | Username             | Score |");
        System.out.println("+----+----------------------+-------+");
        int counter = 1;
        for (String data: datas) {
            String[] splitted = data.split("#");
            String row = String.format("| %-2d | %-20s | %-5s |", counter, splitted[0], splitted[1]);
            System.out.println(row);
            counter++;
        }
        System.out.println("+----+----------------------+-------+");
        IO.enter();
    }
    
    private void showRules() {
        IO.clear();
        System.out.println("Hai warriors! Sebelum kita memulai permainan berikut peraturan yang perlu warrior patuhi :\n" +
        "1. Warrior memiliki 3 life. Jika life ini habis maka game over.\n" +
        "2. Setiap Monster memiliki HP tertentu yang harus dikurangi hingga nol untuk dikalahkan dalam waktu terbatas.\n" +
        "3. Warrior memiliki power dengan damage tertentu yang akan diberikan secara acak untuk mengalahkan monster.\n" +
        "4. Monster dikalahkan hanya dengan satu kali input serangan. Satu kali input dapat terdiri dari beberapa power sama atau berbeda dengan menuliskan nama power satu persatu.\n" +
        "5. Jika damage yang diberikan kepada monster setara dengan HP monster, maka warrior akan mendapat +100 poin.\n" +
        "6. Jika damage yang diberikan tidak setara dengan HP monster atau warrior melewati batas waktu yang ditentukan untuk menyerang monster maka, akan -1 life.\n" +
        "7. Monster akan terus bertambah hingga game berakhir.\n" +
        "\n" +
        "Selamat bermain, Warrior! May victory be yours!");
        IO.enter();
    }
    
    private void showLevel(){
        int score;
        String jawab;
        IO.clear();
        System.out.println("Mau cek perkembangan skill kamu dalam bermain, warriors?");
        System.out.println("\n\n");
        System.out.println("Drop your latest score here !!! ");
        System.out.println();
        System.out.print("Your Score : ");
        score = IO.scanner.nextInt();
        IO.scanner.nextLine();
        System.out.println("\n\n\n");
        
        if (score <= 0){
            System.out.println("Waduhhh, gawatttt, kamu perlu banyak latihan nihh warriors!!");
            System.out.println();
            System.out.print("Mau lanjut latihan?  : ");
            jawab = IO.scanner.nextLine();
            if (jawab.charAt(0) == 'y' || jawab.charAt(0) == 'Y'){
                IO.clear();
                new Output();
            }
            else 
                IO.enter();
        }
        else if (score <=1000){
            System.out.println("Lumayan, kamu ada di level pemula");
            System.out.println();
            System.out.print("Mau lanjut latihan? <Y/T> : ");
            jawab = IO.scanner.nextLine();
            if (jawab.charAt(0) == 'y' || jawab.charAt(0) == 'Y'){
                IO.clear();
                new Output();
            }
            else 
                IO.enter();
        }
        else if (score <= 2500){
            System.out.println("Wahhhh, naik ke level Menengah nih Warriors!!!");
            System.out.println();
            System.out.print("Mau lanjut latihan? <Y/T> : ");
            jawab = IO.scanner.nextLine();
            if (jawab.charAt(0) == 'y' || jawab.charAt(0) == 'Y'){
                IO.clear();
                new Output();
            }
            else 
                IO.enter();
        }
        else if (score <=5000){
            System.out.println("Congrattsss, ini level Mahir... Siap menuju Master, Warriors??");
            System.out.println();
            System.out.print("Mau lanjut latihan? <Y/T> : ");
            jawab = IO.scanner.nextLine();
            if (jawab.charAt(0) == 'y' || jawab.charAt(0) == 'Y'){
                IO.clear();
                new Output();
            }
            else 
                IO.enter();
        }
        else {
            System.out.println("WELCOMEEEEE MASTERRRRRRR ! ! !");
            System.out.println();
            System.out.print("Mau lanjut latihan? <Y/T> : ");
            jawab = IO.scanner.nextLine();
            if (jawab.charAt(0) == 'y' || jawab.charAt(0) == 'Y'){
                IO.clear();
                new Output();
            }
            else 
                IO.enter();
        }
                
    }
}
