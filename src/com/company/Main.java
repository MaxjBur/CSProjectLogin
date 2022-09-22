package com.company;

import java.util.Scanner;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://X://Users//MB211187//IdeaProjects//login//logintable.accdb");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM userLogin");
        while (rs.next())
            System.out.println(rs.getString("Username") + " " + rs.getString("Password"));
        con.close();


        Scanner scanner = new Scanner(System.in);
        boolean startGame = false;
        while (startGame == false) {

            System.out.println("Would you like to create an account (1) or login (2) ");
            int menuChoice = scanner.nextInt();
            if (menuChoice == 2) {


                System.out.println("Please input your username");
                String username = scanner.next();
                System.out.println("Please input your password");
                String password = scanner.next();
                startGame=checkLogin(username, password);
            } else if (menuChoice == 1) {
                System.out.println("Please choose a new username");
                String username = scanner.next();
                System.out.println("Please choose a new password");
                String password = scanner.next();
                writeToDatabase(username, password);

            } else {

            }
        }
        System.out.println("MENU");
    }

    public static void writeToDatabase(String username, String password) throws SQLException {
        String DatabaseLocation = "jdbc:ucanaccess://X://Users//MB211187//IdeaProjects//login//logintable.accdb";

        try (Connection con = DriverManager.getConnection(DatabaseLocation)) {

            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "INSERT INTO userLogin (Username, Password) VALUES (?,?)";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            int row = preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error in thew SQL class: " + e);
        }

    }

    public static boolean checkLogin(String username, String password) {
        boolean valid = false;
        boolean usernamevalid = false;
        boolean passwordvalid = false;

        String DatabaseLocation = "jdbc:ucanaccess://X://Users//MB211187//IdeaProjects//login//logintable.accdb";

        try (Connection con = DriverManager.getConnection(DatabaseLocation)) {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "SELECT * FROM userLogin";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                if (username.equals(rs.getString("Username"))) {
                    usernamevalid = true;
                    System.out.println("utrue");
                }
            }

        } catch (Exception e) {
            System.out.println("Error in the SQL clase: " + e);
        }
        try (Connection con = DriverManager.getConnection(DatabaseLocation)) {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "SELECT * FROM userLogin";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                if (password.equals(rs.getString("Password"))) {
                    passwordvalid = true;
                    System.out.println("ptrue");
                }
            }

        } catch (Exception e) {
            System.out.println("Error in the SQL clase: " + e);
        }
        if ((usernamevalid) && (passwordvalid)){
            valid = true;


        }
        return valid;

    }

}
