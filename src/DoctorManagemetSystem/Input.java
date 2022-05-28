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
            if (input.compareTo(code(input)) == 0) {
                return input;
            }
        } while (true);
    }

    public String code(String input) {
        if (check.isCode(input) && Integer.parseInt(input) > 0) {
            return input;
        } else {
            return "ID is positive integer number";
        }
    }

    public int stringAvailability(String message) {
        String input = "";
        //Run again until check valid vode is true so break loop
        do {
            System.out.print(message);
            input = sc.nextLine();
            if (input.compareTo(availability(input)) == 0) {
                return Integer.parseInt(input);
            }
        } while (true);
    }

    public String availability(String input) {
        if (check.isCode(input) && Integer.parseInt(input) >= 0 && Integer.parseInt(input) <= 3) {
            return input;
        } else {
            return "Availability is integer number indicating 4 states of a doctor: 0 for in vacation, 1 for available, 2 for busy in emergency case, 3 for in diagnosing case.";
        }
    }

    public String stringName(String message) {
        String input = "";
        //Run again until check valid words is true so break loop
        do {
            System.out.print(message);
            input = sc.nextLine();
            if (input.compareTo(name(input)) == 0) {
                return input;
            }
        } while (true);
    }

    public String name(String input) {
        if (check.isWord(input) && input.length() <= 50) {
            return input;
        } else {
            return "Name is not longer than 50 characters";
        }
    }

    public String stringSpecialization(String message) {
        String input = "";
        //Run again until check valid words is true so break loop
        do {
            System.out.print(message);
            input = sc.nextLine();
            if (input.compareTo(specialization(input)) == 0) {
                return input;
            }
        } while (true);
    }

    public String specialization(String input) {
        if (check.isWord(input) && input.length() <= 100) {
            return input;
        } else {
            return "Specialization is not longer than 100 characters";
        }
    }

    public String stringPhone(String message) {
        String input = "";
        //Run again until check valid words is true so break loop
        do {
            System.out.print(message);
            input = sc.nextLine();
            if (input.compareTo(phone(input)) == 0) {
                return input;
            }
        } while (true);
    }

    public String phone(String input) {
        if (check.isPhone(input)) {
            return input;
        } else {
            return "Mobile is a string of number conforming (000)-000-0000 format";
        }
    }

    public String stringEmail(String message) {
        String input = "";
        //Run again until check valid words is true so break loop
        do {
            System.out.print(message);
            input = sc.nextLine();
            if (input.compareTo(email(input)) == 0) {
                return input;
            }
        } while (true);
    }

    public String email(String input) {

        if (check.isEmail(input)) {
            return input;
        } else {
            return "Email is a string conforming email format";
        }
    }

    public Date stringDate(String message) {
        String input = "";
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        //Run again until check valid words is true so break loop
        do {
            System.out.print(message);
            input = sc.nextLine();
            if (input.compareTo(date(input)) == 0) {
                break;
            }
        } while (true);
        try {
            return format.parse(input);
        } catch (ParseException ex) {
            Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String date(String input) {
        if (check.isDate(input)) {
            return input;
        } else {
            return "DateOfBirth is string which conforms dd/MM/yyyy";
        }
    }
}
