package DoctorManagemetSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * User can enter information from keyboard
 *
 * @author Admin
 */
public class Input {

    public Scanner sc = new Scanner(System.in);
    Validate check = new Validate();

    public int option(String message, int first, int last) {
        int input = 0;
        //Run again until number is integer number
        //and integer number is in range between 1 and 6 so stop
        do {
            try {
                System.out.print(message);
                input = Integer.parseInt(sc.nextLine());
                if (input >= first && input <= last) {
                    break;
                }
                if (input < first || input > last) {
                    System.out.println("Must from " + first + " to"
                            + last + ". Pls, enter again!");
                }
            } catch (Exception e) {
                System.out.println("Must integer number. Pls, enter again!");
            }
        } while (true);
        return input;
    }

    public int option(String message) {
        int input = 0;
        //Run again until number is integer number
        //and integer number is in range between 1 and 6 so stop
        do {
            try {
                System.out.println(message);
                input = Integer.parseInt(sc.nextLine());
                if (input > 0 && input < 7) {
                    break;
                }
                if (input <= 0 || input >= 7) {
                    System.out.println("Must from 1 to 6. Pls, enter again!");
                }
            } catch (Exception e) {
                System.out.println("Must integer number. Pls, enter again!");
            }
        } while (true);
        return input;
    }

    public float floatNumber(String message) {
        float input = 0;
        //Run again until number is float so break loop
        do {
            try {
                System.out.println(message);
                input = Float.parseFloat(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Must number. Pls, enter again!");
            }
        } while (true);
        return input;
    }

    public String stringCode(String message) {
        String input = "";
        //Run again until check valid vode is true so break loop
        do {
            System.out.print(message);
            input = sc.nextLine();
            if (check.isCode(input)) {
                break;
            } else {
                System.out.println("Must code. Pls, enter again!");
            }
        } while (true);
        return input;
    }

    public String stringWord(String message, int number) {
        String input = "";
        //Run again until check valid words is true so break loop
        do {
            System.out.print(message);
            input = sc.nextLine();
            if (check.isWord(input) && input.length() <= number) {
                break;
            } else {
                System.out.println("Pls, enter again!");
            }
        } while (true);
        return input;
    }
    
    public String stringEmail(String message) {
        String input = "";
        //Run again until check valid words is true so break loop
        do {
            System.out.print(message);
            input = sc.nextLine();
            if (check.isEmail(input)) {
                break;
            } else {
                System.out.println("Pls, enter again!");
            }
        } while (true);
        return input;
    }

    public Date stringDate(String message) {
        String input = "";
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        //Run again until check valid words is true so break loop
        do {
            System.out.print(message);
            input = sc.nextLine();
            if (check.isDate(input)) {
                break;
            } else {
                System.out.println("Pls, enter again!");
            }
        } while (true);
        try {
            return format.parse(input);
        } catch (ParseException ex) {
            Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    String stringPhone(String message) {
        String input = "";
        //Run again until check valid vode is true so break loop
        do {
            System.out.print(message);
            input = sc.nextLine();
            if (check.isPhone(input)) {
                break;
            } else {
                System.out.println("Must number. Pls, enter again!");
            }
        } while (true);
        return input;
    }
}
