package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static class Employee {
        private final String id_;
        private final String salary_;
        private final String name_;
        private final String gender_;
        private final String birthday_;
        private final String subdivision_;

        public Employee(String id, String name, String birthday, String gender, String subdivision, String salary) {
            id_ = id;
            name_ = name;
            birthday_ = birthday;
            gender_ = gender;
            salary_ = salary;
            subdivision_ = subdivision;
        }

        public String getId_() {
            return id_;
        }

        public String getSalary_() {
            return salary_;
        }

        public String getName_() {
            return name_;
        }

        public String getGender_() {
            return gender_;
        }

        public String getBirthday_() {
            return birthday_;
        }

        public String getSubdivision_() {
            return subdivision_;
        }
    }

    private static String getSplitter() {
        return ";";
    }

    public static void main(String[] args) {
        String csvFilePath = "foreign_names.csv";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csvFilePath));
            List<Employee> empList = new ArrayList<>();
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] employeeDetails = line.split(getSplitter());
                if (employeeDetails.length > 2) {
                    Employee tmp = new Employee(employeeDetails[0], employeeDetails[1],
                            employeeDetails[2], employeeDetails[3], employeeDetails[4], employeeDetails[5]);
                    empList.add(tmp);
                }
            }

            for (Employee tmp : empList) {
                System.out.println(tmp.getId_() + " " + tmp.getName_() + " " + tmp.getGender_()
                        + " " + tmp.getBirthday_() + " " + tmp.getSubdivision_() + " " + tmp.getSalary_());
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            try {
                assert br != null;
                br.close();
            } catch (IOException ie) {
                System.out.println("Error occurred while closing the BufferedReader");
                ie.printStackTrace();
            }
        }
    }
}