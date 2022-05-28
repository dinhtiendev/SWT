/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DoctorManagemetSystem.Doctor;
import DoctorManagemetSystem.DoctorHash;
import DoctorManagemetSystem.Main;
import DoctorManagemetSystem.Input;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Admin
 */
public class DoctorInputTest {

    List<Doctor> listDoctors;
    List<Doctor> listDoctors1;
    DoctorHash managerDoctor;
    Input input;

    public DoctorInputTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
    

    @Before
    public void setUp() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        managerDoctor = new DoctorHash();
        listDoctors = new ArrayList<>();
        listDoctors1 = new ArrayList<>();
        input = new Input();
        try {
            listDoctors.add(new Doctor("1", "tien", format.parse("26/10/2001"), "abc", 2, "tien@fgm.ods", "0981987625"));
            listDoctors.add(new Doctor("2", "tiendep", format.parse("26/11/2001"), "def", 2, "tien@fgm.ods", "0981987625"));
            listDoctors.add(new Doctor("3", "tientrai", format.parse("26/03/2001"), "ghj", 2, "tien@fgm.ods", "0981987625"));
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
    public void inputValidID_NormalCase_ExpectSuccess() throws IOException {
        String s = "1";
        String expected = s;
        String actual = input.code(s);
        // checkout output
        Assert.assertEquals(expected, actual);
        System.out.println(actual);
        System.out.println("-----------------------------------");
    }
    
    @Test
    public void inputInvalidID_AbnormalCase_ExpectError() throws IOException {
        String s = "-1";
        String expected = "ID is positive integer number";
        String actual = input.code(s);
        // checkout output
        Assert.assertEquals(expected, actual);
        System.out.println(actual);
        System.out.println("-----------------------------------");
    }
    
    @Test
    public void inputValidName_NormalCase_ExpectSuccess() throws IOException {
        String s = "abcxyz";
        String expected = s;
        String actual = input.name(s);
        // checkout output
        Assert.assertEquals(expected, actual);
        System.out.println(actual);
        System.out.println("-----------------------------------");
    }
    
    @Test
    public void inputInvalidName_AbnormalCase_ExpectError() throws IOException {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String expected = "Name is not longer than 50 characters";
        String actual = input.name(s);
        // checkout output
        Assert.assertEquals(expected, actual);
        System.out.println(actual);
        System.out.println("-----------------------------------");
    }
    
    @Test
    public void inputValidDoB_NormalCase_ExpectSuccess() throws IOException {
        String s = "26/10/2001";
        String expected = s;
        String actual = input.date(s);
        // checkout output
        Assert.assertEquals(expected, actual);
        System.out.println(actual);
        System.out.println("-----------------------------------");
    }
    
    @Test
    public void inputInvalidDoB_AbnormalCase_ExpectError() throws IOException {
        String s = "26-10-2001";
        String expected = "DateOfBirth is string which conforms dd/MM/yyyy";
        String actual = input.date(s);
        // checkout output
        Assert.assertEquals(expected, actual);
        System.out.println(actual);
        System.out.println("-----------------------------------");
    }
    
    @Test
    public void inputValidSpecialization_NormalCase_ExpectSuccess() throws IOException {
        String s = "pediantrician";
        String expected = s;
        String actual = input.specialization(s);
        // checkout output
        Assert.assertEquals(expected, actual);
        System.out.println(actual);
        System.out.println("-----------------------------------");
    }
    
    @Test
    public void inputInvalidSpecialization_AbnormalCase_ExpectError() throws IOException {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String expected = "Specialization is not longer than 100 characters";
        String actual = input.specialization(s);
        // checkout output
        Assert.assertEquals(expected, actual);
        System.out.println(actual);
        System.out.println("-----------------------------------");
    }
    
    @Test
    public void inputValidAvailability_NormalCase_ExpectSuccess() throws IOException {
        String s = "2";
        String expected = s;
        String actual = input.availability(s);
        // checkout output
        Assert.assertEquals(expected, actual);
        System.out.println(actual);
        System.out.println("-----------------------------------");
    }
    
    @Test
    public void inputInvalidAvailability_AbnormalCase_ExpectError() throws IOException {
        String s = "5";
        String expected = "Availability is integer number indicating 4 states of a doctor: 0 for in vacation, 1 for available, 2 for busy in emergency case, 3 for in diagnosing case.";
        String actual = input.availability(s);
        // checkout output
        Assert.assertEquals(expected, actual);
        System.out.println(actual);
        System.out.println("-----------------------------------");
    }
    
    @Test
    public void inputValidEmail_NormalCase_ExpectSuccess() throws IOException {
        String s = "dinhvantiendev@gmail.com";
        String expected = s;
        String actual = input.email(s);
        // checkout output
        Assert.assertEquals(expected, actual);
        System.out.println(actual);
        System.out.println("-----------------------------------");
    }
    
    @Test
    public void inputInValidEmail_AbnormalCase_ExpectError() throws IOException {
        String s = "abcxyz";
        String expected = "Email is a string conforming email format";
        String actual = input.email(s);
        // checkout output
        Assert.assertEquals(expected, actual);
        System.out.println(actual);
        System.out.println("-----------------------------------");
    }
    
    @Test
    public void inputValidPhone_NormalCase_ExpectSuccess() throws IOException {
        String s = "098-1987-625";
        String expected = s;
        String actual = input.phone(s);
        // checkout output
        Assert.assertEquals(expected, actual);
        System.out.println(actual);
        System.out.println("-----------------------------------");
    }
    
    @Test
    public void inputInValidPhone_AbnormalCase_ExpectError() throws IOException {
        String s = "0981987625";
        String expected = "Mobile is a string of number conforming (000)-000-0000 format";
        String actual = input.phone(s);
        // checkout output
        Assert.assertEquals(expected, actual);
        System.out.println(actual);
        System.out.println("-----------------------------------");
    }
    
    @Test
    public void editDoctor_ExpectIDNotExist() throws IOException {
        String s = "10";
        String expected = "ID is not exist in the list";
        String actual = managerDoctor.IDNotExist(listDoctors, s);
        // checkout output
        Assert.assertEquals(expected, actual);
        System.out.println(actual);
        System.out.println("-----------------------------------");
    }
    
    @Test
    public void editDoctor_ExpectIDExist() throws IOException {
        String s = "1";
        String expected = s;
        String actual = managerDoctor.IDNotExist(listDoctors, s);
        // checkout output
        Assert.assertEquals(expected, actual);
        System.out.println(actual);
        System.out.println("-----------------------------------");
    }
    
    @Test
    public void editDoctor_ListEmpty() throws IOException {
        String expected = "List students is empty.";
        String actual = managerDoctor.empty(listDoctors1);
        // checkout output
        Assert.assertEquals(expected, actual);
        System.out.println(actual);
        System.out.println("-----------------------------------");
    }
    
    @Test
    public void deletetDoctor_ListEmpty() throws IOException {
        String expected = "List students is empty.";
        String actual = managerDoctor.empty(listDoctors1);
        // checkout output
        Assert.assertEquals(expected, actual);
        System.out.println(actual);
        System.out.println("-----------------------------------");
    }
    
    @Test
    public void searchDoctor_ListEmpty() throws IOException {
        String expected = "List students is empty.";
        String actual = managerDoctor.empty(listDoctors1);
        // checkout output
        Assert.assertEquals(expected, actual);
        System.out.println(actual);
        System.out.println("-----------------------------------");
    }
    
    @Test
    public void sortDoctor_ListEmpty() throws IOException {
        String expected = "List students is empty.";
        String actual = managerDoctor.empty(listDoctors1);
        // checkout output
        Assert.assertEquals(expected, actual);
        System.out.println(actual);
        System.out.println("-----------------------------------");
    }
}
