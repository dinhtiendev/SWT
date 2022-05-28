/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoctorManagemetSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DoctorHash {

    public void displayMenu() {
        System.out.println("========= Doctor Management ==========");
        System.out.println("  1   Add Doctor");
        System.out.println("  2   Update Doctor");
        System.out.println("  3   Delete Doctor");
        System.out.println("  4   Search Doctor");
        System.out.println("  5   Sort Doctor");
        System.out.println("  6   Exit");
    }

    public int userChoice() {
        Input input = new Input();
        return input.option("Enter option:");
    }

    public void addDoctor(List<Doctor> listDoctors) {
        System.out.println("--------- Add Doctor ----------");
        //Enter information of Doctor
        Doctor doctor = inputInfoDoctor(listDoctors);
        if (doctor != null) {
            listDoctors.add(doctor);
            System.out.println("Add doctor successfully");
        }
    }

    private Doctor inputInfoDoctor(List<Doctor> listDoctors) {
        Input input = new Input();
        Validate check = new Validate();
        //Run until the information is satisfy
        do {
            String code = input.stringCode("Enter Id:");
            //Check code has existed in list
            if (check.isDuplicatelyCodeDoctor(code, listDoctors)) {
                System.out.println("Id is duplicate");
            } else {
                String name = input.stringName("Enter Name:");
                Date dateOfBirth = input.stringDate("Enter Date of Birth:");
                String specialization = input.stringSpecialization("Enter Specialization:");
                int availability = input.option("Enter availablility:", 0, 3);
                String email = input.stringEmail("Enter email:");
                String mobile = input.stringPhone("Enter phone:");
                Doctor doc = new Doctor(code.trim(), name.trim(),
                        dateOfBirth, specialization, availability,
                        email, mobile);
                return doc;
            }
        } while (true);
    }

    public void updateDoctorByID(List<Doctor> listDoctors) {
        //Check list is empty
        if (empty(listDoctors) != null) {
            System.out.println(empty(listDoctors));
            return;
        }
        System.out.println("--------- Update Doctor -------");
        String codeToUpdate = inputCode(listDoctors);
        Doctor doctor = inputInfoToUpdate(listDoctors, codeToUpdate);
        if (doctor == null) {
            return;
        }
        //Run from first doctor to last doctor
        for (Doctor doctor1 : listDoctors) {
            if (doctor1.getId().compareToIgnoreCase(codeToUpdate) == 0) {
                //Update Doctor
                doctor1.setId(doctor.getId());
                doctor1.setName(doctor.getName());
                doctor1.setSpecialization(doctor.getSpecialization());
            }
        }
        System.out.println("Update doctor successfully");
    }

    public String empty(List<Doctor> listDoctors) {
        if (listDoctors.isEmpty()) {
            return "List students is empty.";
        } else {
            return null;
        }
    }

    public String inputCode(List<Doctor> listDoctors) {
        Input input = new Input();

        //Run until find code in list
        do {
            String code = input.stringCode("Enter code to find: ");
            code = IDNotExist(listDoctors, code);
            if (code.compareTo(code) == 0) {
                return code;
            }
        } while (true);
    }

    public String IDNotExist(List<Doctor> listDoctors, String code) {
        Validate check = new Validate();
        if (check.isDuplicatelyCodeDoctor(code, listDoctors)) {
            return code;
        } else {
            return "ID is not exist in the list";
        }
    }

    private Doctor inputInfoToUpdate(List<Doctor> listDoctors,
            String codeToUpdate) {
        Input input = new Input();
        Validate check = new Validate();
        //Run until information is satisfy
        do {
            String code = input.stringCode("Enter Code:");
            //Check code is duplicately in list(except codeToUpdate)
            if (check.isDuplicatelyCodeDoctorUpdate(code, listDoctors,
                    codeToUpdate)) {
                System.out.println("Code is duplicate");
            } else {
                String name = input.stringName("Enter Name:");
                Date dateOfBirth = input.stringDate("Enter Date of Birth:");
                String specialization = input.stringSpecialization("Enter Specialization:");
                int availability = input.stringAvailability("Enter availablility:");
                String email = input.stringEmail("Enter email:");
                String mobile = input.stringPhone("Enter phone:");
                Doctor doc = new Doctor(code.trim(), name.trim(),
                        dateOfBirth, specialization, availability,
                        email, mobile);
                //Check information of code and codeToUpdate is the same
                if (code.compareToIgnoreCase(codeToUpdate) == 0
                        && check.isSameInfo(doc, listDoctors, codeToUpdate)) {
                    System.out.println("Data is same, so it doesn't update");
                    return null;
                } else {
                    return doc;
                }
            }
        } while (true);
    }

    public void deleteDoctorById(List<Doctor> listDoctors) {
        //Check list is empty
        if (empty(listDoctors) != null) {
            System.out.println(empty(listDoctors));
            return;
        }
        System.out.println("--------- Delete Doctor -------");
        String code = inputCode(listDoctors);
        //Delete Doctor
        try {
            //Run from first Doctor to last Doctor
            for (Doctor doctor : listDoctors) {
                if (doctor.getId().compareToIgnoreCase(code) == 0) {
                    listDoctors.remove(doctor);
                }
            }
            System.out.println("Delete doctor successfully");
        } catch (Exception e) {
            System.out.println("Can't remove");
        }
    }

    public void searchDoctorsById(List<Doctor> listDoctors) {
        Input input = new Input();
        if (empty(listDoctors) != null) {
            System.out.println(empty(listDoctors));
            return;
        }
        System.out.println("--------- Search Doctor -------");
        //User enter text
        String text = input.stringCode("Enter text:");
        List<Doctor> doctorsByCode;
        try {
            System.out.println("--------- Result -------");
            //Search Doctors by code
            doctorsByCode = searchDoctor(listDoctors, text);
            //Check list find by code is empty
            if (doctorsByCode.isEmpty()) {
                System.out.println("Can't find text is " + text);
                return;
            }
            System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%-10s\n", "Code", "Name", "DoB",
                    "Specializ", "Availa", "Email", "Mobile");
            //Display Doctors just searched
            for (Doctor doctor : listDoctors) {
                doctor.display();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private List<Doctor> searchDoctor(List<Doctor> listDoctors,
            String id) throws Exception {
        //Check list is empty
        if (listDoctors.isEmpty()) {
            throw new Exception("Database is not exist");
        } else {
            List<Doctor> doctorsByCode = new ArrayList<>();
            for (Doctor doctor : listDoctors) {
                //Check any attribute can contain text
                if (doctor.getId().toLowerCase().contains(id.toLowerCase())) {
                    doctorsByCode.add(doctor);
                }
            }
            return doctorsByCode;
        }
    }

    public void sortByDoB(List<Doctor> listDoctors) {
        if (empty(listDoctors) != null) {
            System.out.println(empty(listDoctors));
            return;
        }
        List<Doctor> doctorsByDoB = new ArrayList<>();
        doctorsByDoB.addAll(listDoctors);
        try {
            System.out.println("--------- Result -------");
            //Search Doctors by code
            Collections.sort(doctorsByDoB, new Comparator<Doctor>() {
                @Override
                public int compare(Doctor o1, Doctor o2) {
                    return o1.getDateOfBird().compareTo(o2.getDateOfBird());
                }
            });

            System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%-10s\n", "Code", "Name", "DoB",
                    "Specializ", "Availa", "Email", "Mobile");
            //Display Doctors just searched
            for (Doctor doctor : listDoctors) {
                doctor.display();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void exitProgram(List<Doctor> listDoctors) {
        System.out.println("Thanks.");
    }

    public void wrongOption() {
        System.out.println("You choice wrong option. Pls, choice again.");
    }

}
