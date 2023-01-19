package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Scanner;
import java.sql.*;

import static javax.swing.text.StyleConstants.getComponent;

public class Main extends javax.swing.JFrame implements MouseListener, MouseMotionListener {
    //public  static String DatabaseLocation = ("jdbc:ucanaccess://X://Users//MB211187//IdeaProjects//login//logintable.accdb");
    public  static String DatabaseLocation = ("jdbc:ucanaccess://C://Users//MaxJa//IdeaProjects//CSProjectLogin//logintable.accdb");
    public static String gameID;
    public static int playTime = 0;
    public static int gameIDint;

    JLabel label;
    Point startPoint;
    GamePanel gamePanel = new GamePanel();

    public static void main(String[] args) throws Exception {
       // Connection con = DriverManager.getConnection("jdbc:ucanaccess://X://Users//MB211187//IdeaProjects//login//logintable.accdb");
//        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//MaxJa//IdeaProjects//CSProjectLogin//logintable.accdb");
//        Statement stmt = con.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT * FROM userLogin");
//
//        while (rs.next())
//            System.out.println(rs.getString("Username") + " " + rs.getString("Password"));
//        con.close();



        Scanner scanner = new Scanner(System.in);
        boolean startGame = false;
        while (startGame == false) {
//            int npcMood = 1;
//
//            int npcID = 1;
//            int npcAge = 1;
//            int life = 5;
//            String nPCFirstName = "Max";
            //writeNPCToDatabase(nPCFirstName, npcMood,gameID, npcID,npcAge,life);
            //writeNPCToDatabase(nPCFirstName, npcMood,gameID, npcID,npcAge,life);
            writeGameToDatabase();
            Main.gameID = checkGameID();
            gameIDint = Integer.parseInt(gameID);
            System.out.println("A total time of "+sumOfTime()+" has been played on this device");

            System.out.println("Would you like to create an account (1) or login (2) ");
            int menuChoice = scanner.nextInt();
            if (menuChoice == 2) {


                System.out.println("Please input your username");
                String username = scanner.next();
                System.out.println("Please input your password");
                String password = scanner.next();


                String hashedPassword = String.valueOf(password.hashCode());
                System.out.println(hashedPassword);
                startGame=checkLogin(username, hashedPassword);
            } else if (menuChoice == 1) {
                System.out.println("Please choose a new username");
                String username = scanner.next();
                System.out.println("Please choose a new password");
                String password = scanner.next();
                password = scanner.next();
                System.out.println();
                String hashedPassword = String.valueOf(password.hashCode());
                System.out.println(hashedPassword);
                writeUserToDatabase(username, hashedPassword);

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







    }

    public void move() {
        Movement mv = new Movement(getComponents());

    }
    private void buttonActionPerformed(java.awt.event.ActionEvent evt){
        ImageIcon imageIcon = new ImageIcon("jdbc:ucanaccess://X://Users//MB211187//IdeaProjects//CSProjectLogin1//res//src//company//res//Walk 1 down.png");
        label =new JLabel(imageIcon);
        label.setVisible(true);
        label.addMouseListener(this);
        label.addMouseMotionListener(this);
        gamePanel.add(label);
        gamePanel.revalidate();
        gamePanel.repaint();
    }

    public static void writeUserToDatabase(String username, String password) throws SQLException {
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


    }
    public static void writeNPCToDatabase(String nPCfirstName, int GameID,  int nPCAge, int life, int nPCID) throws SQLException {
        //String DatabaseLocation = "jdbc:ucanaccess://X://Users//MB211187//IdeaProjects//login//logintable.accdb";

        try (Connection con = DriverManager.getConnection(DatabaseLocation)) {

            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "INSERT INTO GameNPCLink ( NPCFirstName, NPCMood, GameID, NPCID, NPCAge, Life) VALUES (?,?,?,?,?,?)";


            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, nPCfirstName);
            preparedStatement.setInt(2, 1);
            preparedStatement.setInt(3, gameIDint);
            preparedStatement.setInt(4, nPCID);
            preparedStatement.setInt(5, nPCAge);
            preparedStatement.setInt(6, life);


            int row = preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error in thew SQL class: " + e);
        }


    }
    public static void writeGameToDatabase() throws SQLException {
        //String DatabaseLocation = "jdbc:ucanaccess://X://Users//MB211187//IdeaProjects//login//logintable.accdb";

        try (Connection con = DriverManager.getConnection(DatabaseLocation)) {

            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "INSERT INTO Game ( Time, ObjectsPlaced, Currency) VALUES (?,?,?)";


            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, 1);
            preparedStatement.setInt(3, 10);



            int row = preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error in thew SQL class: " + e);
        }

    }
    public static String checkGameID() {
        String gameID= "";
        try (Connection con = DriverManager.getConnection(DatabaseLocation)) {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM Game ORDER BY GameID DESC LIMIT 1";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                gameID = rs.getString("GameID");
            }


        } catch (Exception e) {
            System.out.println("Error in the SQL clase: " + e);
        }
        return gameID;
    }
    public static void updateTime(){

        try (Connection con = DriverManager.getConnection(Main.DatabaseLocation)) {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "UPDATE Game SET Time = \""+(Main.playTime/60)+"\" WHERE GameID = \""+gameID+"\"";
            int rs = stmt.executeUpdate(sql);


        } catch (Exception e) {
            System.out.println("Error in the SQL clase: " + e);
        }

    }
    public static void deleteNPCObjectLink(){
        try (Connection con = DriverManager.getConnection(Main.DatabaseLocation)) {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "DELETE FROM";
            int rs = stmt.executeUpdate(sql);


        } catch (Exception e) {
            System.out.println("Error in the SQL clase: " + e);
        }

    }
    public static int sumOfTime(){
        int sum= 0;
        try (Connection con = DriverManager.getConnection(DatabaseLocation)) {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT SUM(Time) FROM Game";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                sum = rs.getInt(1);
            }



        } catch (Exception e) {
            System.out.println("Error in the SQL clase: " + e);
        }
        return sum;

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

            String sql = "SELECT * FROM userLogin WHERE Username = \""+username + "\"";


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

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        startPoint = SwingUtilities.convertPoint(label, mouseEvent.getPoint(), label.getParent());

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        startPoint = null;

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        Point location = SwingUtilities.convertPoint(label, mouseEvent.getPoint(), label.getParent());
        if(label.getParent().getBounds().contains(location)){
            Point newLocation = label.getLocation();
            newLocation.translate(location.x - startPoint.x,location.y-startPoint.y);
            newLocation.x = Math.max(newLocation.x, 0);
            newLocation.y = Math.max(newLocation.y, 0);
            newLocation.x = Math.min(newLocation.x,label.getParent().getWidth()-label.getWidth());
            newLocation.y = Math.min(newLocation.y,label.getParent().getHeight()-label.getHeight());
            label.setLocation(newLocation);
            startPoint = location;
        }

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
