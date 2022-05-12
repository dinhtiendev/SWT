package DoctorManagemetSystem;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Check informations from entered user
 *
 * @author Admin
 */
public class Validate {

    public boolean isWord(String id) {
        String regex = "[a-z\\s]+|^$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(id);
        //If id and pattern matches and id isn't empty so return true (if no return false)
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    public boolean isCode(String name) {
        String regex = "[a-z0-9\\s]+|^$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        //If name and pattern matches and name isn't empty so return true (if no return false)
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    public boolean isDate(String date) {
        String regex = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]|(?:Jan|Mar|May|Jul|Aug|Oct|Dec)))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2]|(?:Jan|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)(?:0?2|(?:Feb))\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9]|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep))|(?:1[0-2]|(?:Oct|Nov|Dec)))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(date);
        //If name and pattern matches and name isn't empty so return true (if no return false)
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    public boolean isDuplicatelyCodeDoctor(String code,
            List<Doctor> listDoctors) {
        //Run from first doctor until check is true or to last doctor
        for (Doctor doctor : listDoctors) {
            //Check duplicately code
            if (code.compareToIgnoreCase(doctor.getId()) == 0) {
                return true;
            }
        }
        return false;
    }
    
    boolean isDuplicatelyCodeDoctorUpdate(String code,
            List<Doctor> listDoctors, String codeToUpdate) {
        //Run from first doctor until check is true or to last doctor
        for (Doctor doctor : listDoctors) {
            //Check duplicately code and diffirent code to update
            if (code.compareToIgnoreCase(doctor.getId()) == 0 &&
                    codeToUpdate.compareToIgnoreCase(doctor.getId()) != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmail(String email) {
        String regex = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        //If name and pattern matches and name isn't empty so return true (if no return false)
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    public boolean isSameInfo(Doctor doc, List<Doctor> listDoctors, String codeToUpdate) {
        for (Doctor doctor : listDoctors) {
            if (doctor.getId().compareToIgnoreCase(codeToUpdate) == 0) {
                if (doctor.getName().compareToIgnoreCase(doc.getName()) == 0
                        && doctor.getDateOfBird().equals(doc.getDateOfBird())
                        && doctor.getSpecialization().compareToIgnoreCase(doc.getSpecialization()) == 0
                        && doctor.getAvailability() == doc.getAvailability()
                        && doctor.getEmail().compareToIgnoreCase(doc.getEmail()) == 0
                        && doctor.getMobile().compareToIgnoreCase(doc.getMobile()) == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isPhone(String input) {
        String regex = "[0-9]+";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        //If name and pattern matches and name isn't empty so return true (if no return false)
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}
