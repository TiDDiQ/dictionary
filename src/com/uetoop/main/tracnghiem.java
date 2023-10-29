// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("I am sorry that I can't ___ your invitation");
            System.out.println("[A] take");
            System.out.println("[B] except");
            System.out.println("[C] agree");
            System.out.println("[D] accept");
            System.out.println("Your choice: [A/B/C/D]: ");
            String luaChon = sc.nextLine();
            if(luaChon.equals("A")) {
                System.out.println("Correct!");
                System.out.println("Next question:");
                System.out.println("It took us almost 4 hours to ___ to London");
                System.out.println("[A] reach ");
                System.out.println("[B] arrive ");
                System.out.println("[C] get ");
                System.out.println("[D] approach ");
                System.out.println("Your choice: [A/B/C/D]: ");
                String luaChon2= sc.nextLine();
                if(luaChon2.equals("C")) {
                    System.out.println("Correct!");
                    System.out.println("Next question:");
                    System.out.println("It’s difficult to ___ the difference between margarine and butter");
                    System.out.println("[A] speak ");
                    System.out.println("[B] tell ");
                    System.out.println("[C] say ");
                    System.out.println("[D] look ");
                    System.out.println("Your choice: [A/B/C/D]: ");
                    String luaChon3 = sc.nextLine();
                    if(luaChon3.equals("B")) {
                        System.out.println("Correct!");
                        break;
                    } else {
                        System.out.println("InCorrect!");
                        break;
                    }
                } else{
                    System.out.println("InCorrect!");
                    break;
                }
            } else {
                System.out.println("InCorrect!");
                break;
            }
        }
    }
}
