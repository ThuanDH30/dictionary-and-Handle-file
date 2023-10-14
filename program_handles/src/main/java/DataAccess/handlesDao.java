/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Comom.Validation;
import Model.Person;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Bravo
 */
public class handlesDao {

    List<Person> PersonList;
    private static handlesDao instance = null;

    public handlesDao() {
        this.PersonList = new ArrayList<>();
    }

    public static handlesDao instance() {
        if (instance == null) {
            synchronized (handlesDao.class) {
                if (instance == null) {
                    instance = new handlesDao();
                }
            }
        }
        return instance;
    }

    public void findPersonInfo() {

        String pathFile = Validation.checkInputPathFile();
        PersonList = getListPerson(pathFile);
        if (PersonList != null) {
            double money = Validation.checkInputMoney();
            handlesDao dao = handlesDao.instance();
            dao.printListPerson((ArrayList<Person>) dao.PersonList, money);
        }
    }

    public void copyNewFile() {
        String pathFileInput = Validation.checkInputPathFile();
        String pathFileOutput = Validation.checkInputPathFile();
        String content = getNewContent(pathFileInput);
        writeNewContent(pathFileOutput, content);
    }

    public ArrayList<Person> getListPerson(String pathFile) {
        ArrayList<Person> lp = new ArrayList<>();
        File file = new File(pathFile);

        if (!file.exists() || !file.isFile()) {
            System.err.println("Path doesn't exist");
            return null;
        }

        try (BufferedReader bufferReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferReader.readLine()) != null) {
                String[] infoPerson = line.split(";");
                lp.add(new Person(infoPerson[0], infoPerson[1], getSalary(infoPerson[2])));
            }
        } catch (IOException e) {
            System.err.println("Can't read file.");
        }

        return lp;
    }

    public double getSalary(String salary) {
        double salaryResult = 0;
        try {
            salaryResult = Double.parseDouble(salary);
        } catch (NumberFormatException e) {
            salaryResult = 0;
        }
        return salaryResult;
    }

    public void printListPerson(ArrayList<Person> lp, double money) {
        System.out.printf("%-20s%-20s%-20s\n", "Name", "Address", "Money");
        for (Person person : lp) {
            if (person.getMoney() >= money) {
                System.out.printf("%-20s%-20s%-20.1f\n", person.getName(),
                        person.getAddress(), person.getMoney());
            }
        }
        lp.sort(null);
        System.out.println("Max: " + lp.get(0).getName());
        System.out.println("Min: " + lp.get(lp.size() - 1).getName());
    }

    public String getNewContent(String pathFileInput) {
        StringBuilder content = new StringBuilder();
        File file = new File(pathFileInput);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(" ");
            }
        } catch (IOException ex) {
            System.err.println("Can't read file: " + ex.getMessage());
        }

        return content.toString();
    }

    public void writeNewContent(String pathFileOutput, String content) {
        try {
            File file = new File(pathFileOutput);
            if (!file.exists()) {
                file.createNewFile();
            }

            try (BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(file))) {
                System.out.println("Writing to: " + pathFileOutput);
                System.out.println("Content: " + content);
                bufferWriter.write(content);
                System.err.println("Write successful");
            }
        } catch (IOException ex) {
            System.err.println("Error writing to file: " + ex.getMessage());
        }
    }

}
