/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assignmentpart1;



import javax.swing.JOptionPane;
import java.util.regex.Pattern;

/**
 *
 * @author RC_Student_lab
 */
public class assignmentpart1{

    public static void main(String[] args) {

        // Get username
        String username = JOptionPane.showInputDialog("Enter your username (maximum 5 characters long):");

        if (username != null && username.length() <= 5) {
            JOptionPane.showMessageDialog(null, "Username successfully captured!");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username. Must be 5 characters or fewer.");
            return;
        }

        // Get password
        String password = JOptionPane.showInputDialog("Enter your password (must be 8 characters long, contain at least one uppercase letter, one number, and one special character):");

        if (isValidPassword(password)) {
            JOptionPane.showMessageDialog(null, "Password successfully captured!");
        } else {
            JOptionPane.showMessageDialog(null, "Password does not meet the criteria. Please try again.");
            return;
        }

        // Get phone number
        String phoneNumber = JOptionPane.showInputDialog("Enter your phone number with international code (e.g. +1234567890):");

        if (isValidPhoneNumber(phoneNumber)) {
            JOptionPane.showMessageDialog(null, "Account created successfully!\nPhone number: " + phoneNumber);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid phone number format.\nMake sure it starts with '+' and the number part is no longer than 10 digits.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        Pattern upperCasePattern = Pattern.compile("[A-Z]");
        Pattern digitPattern = Pattern.compile("[0-9]");
        Pattern specialCharPattern = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]");

        boolean hasUpperCase = upperCasePattern.matcher(password).find();
        boolean hasDigit = digitPattern.matcher(password).find();
        boolean hasSpecialChar = specialCharPattern.matcher(password).find();

        return hasUpperCase && hasDigit && hasSpecialChar;
    }

    public static boolean isValidPhoneNumber(String number) {
        if (number == null || !number.startsWith("+")) return false;

        String withoutPlus = number.substring(1);

               // south african Country code is assumed to be 1-3 digits
        for (int i = 1; i <= 3 && i < withoutPlus.length(); i++) {
            String phoneNumber = withoutPlus.substring(i);
            if (phoneNumber.matches("\\d{1,10}")) {
                return true;
            }
        }

        return false;
    }
}