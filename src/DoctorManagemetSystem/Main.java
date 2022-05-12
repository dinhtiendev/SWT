/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoctorManagemetSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        DoctorHash managerDoctor = new DoctorHash();
        List<Doctor> listDoctors = new ArrayList<>();
        try {
            listDoctors.add(new Doctor("he11", "tien", format.parse("26/10/2001"), "abc", 2, "tien@fgm.ods", "0981987625"));
            listDoctors.add(new Doctor("he18", "tiendep", format.parse("26/11/2001"), "def", 2, "tien@fgm.ods", "0981987625"));
            listDoctors.add(new Doctor("he16", "tientrai", format.parse("26/03/2001"), "ghj", 2, "tien@fgm.ods", "0981987625"));
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        int userChoice = 0;
        do {
            //Step 1: Display the menu
            managerDoctor.displayMenu();
            //Step 2: Ask user to choice function
            userChoice = managerDoctor.userChoice();
            switch (userChoice) {
                case 1: {
                    //Step 3: Option 1: Add Doctor
                    managerDoctor.addDoctor(listDoctors);
                    break;
                }
                case 2: {
                    //Step 4: Option 2: Update Doctor by code
                    managerDoctor.updateDoctorByID(listDoctors);
                    break;
                }
                case 3: {
                    //Step 5: Option 3: Delete Doctor by code
                    managerDoctor.deleteDoctorById(listDoctors);
                    break;
                }
                case 4: {
                    //Step 6: Option 4: Search Doctor by code
                    managerDoctor.searchDoctorsById(listDoctors);
                    break;
                }
                case 5: {
                    //Step 7: Option 5: Sort Doctor by dateOfBirth
                    managerDoctor.sortByDoB(listDoctors);
                    break;
                }
                default: {
                    //Step 8: Option 6: Exit the program
                    managerDoctor.exitProgram(listDoctors);
                    break;
                }
            }
        } while (userChoice != 5);

    }
}
