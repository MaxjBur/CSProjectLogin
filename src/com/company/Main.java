package com.company;

import javax.swing.*;
import java.util.Scanner;
import java.sql.*;

import static javax.swing.text.StyleConstants.getComponent;

public class Main {
    public  static String DatabaseLocation = ("jdbc:ucanaccess://X://Users//MB211187//IdeaProjects//login//logintable.accdb");

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
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("Game");
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setupGame();
        gamePanel.startGameThread();
        System.out.println("Game");

        Movement mv = new Movement(getComponent());




    }

    public static void writeToDatabase(String username, String password) throws SQLException {
        //String DatabaseLocation = "jdbc:ucanaccess://X://Users//MB211187//IdeaProjects//login//logintable.accdb";

        try (Connection con = DriverManager.getConnection(DatabaseLocation)) {

            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "INSERT INTO userLogin (Username, Password, InGamePoints, TotalTimePlayed) VALUES (?,?,?,?)";
//            String sql = "INSERT INTO userLogin (Username, Password) VALUES (?,?)";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, 0);
            preparedStatement.setInt(4, 0);


            int row = preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error in thew SQL class: " + e);
        }
//        try (Connection con = DriverManager.getConnection(DatabaseLocation)) {
//
//            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//
//            String sql = "INSERT INTO SaveState (Username, InGamePoints, TotalTimePlayed, Username) VALUES (?,?)";
//
//            ResultSet rs = stmt.executeQuery(sql);
//            PreparedStatement preparedStatement = con.prepareStatement(sql);
//
//            while (rs.next()) {
//                if (username.equals(rs.getString("Username"))) {
//
//                    preparedStatement.setString(1,rs.getString("SavID") );
//                    preparedStatement.setString(2, "0");
//                    preparedStatement.setString(2, "0");
//                    preparedStatement.setString(4, username);
//
//                }
//            }
//
//
//
//            int row = preparedStatement.executeUpdate();
//
//        } catch (Exception e) {
//            System.out.println("Error in thew SQL class: " + e);
//        }

    }

    public static boolean checkLogin(String username, String password) {
        boolean valid = false;
        boolean usernamevalid = false;
        boolean passwordvalid = false;

        //String DatabaseLocation = "jdbc:ucanaccess://X://Users//MB211187//IdeaProjects//login//logintable.accdb";

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
