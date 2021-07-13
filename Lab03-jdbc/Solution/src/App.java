import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

import java.util.Scanner;

import java.util.List;
import java.util.ArrayList;

import java.net.URL;
import java.net.MalformedURLException;

import java.io.IOException;

import Model.Adult;

public class App {

    public static Adult convertToAdult(String data){
        String[] rawData = data.trim().split(",");

        return new Adult(
                    Double.parseDouble(rawData[0].trim()),
                    rawData[1],
                    Integer.parseInt(rawData[2].trim()), 
                    rawData[3], 
                    Integer.parseInt(rawData[4].trim()), 
                    rawData[5], 
                    rawData[6], 
                    rawData[7], 
                    rawData[8], 
                    rawData[9], 
                    Double.parseDouble(rawData[10].trim()), 
                    Double.parseDouble(rawData[11].trim()), 
                    Double.parseDouble(rawData[12].trim()), 
                    rawData[13], 
                    rawData[14] 
                );
    }

    private static void insertSQL(Connection con,List<Adult> adults) throws SQLException {
        Statement statement = con.createStatement();
        adults.forEach(elem -> {
            String sqlInsert = 
            "Insert Into adult(age,workclass,fnlwgt,education,education_num,marital_status,occupation,relationship,race,sex,capital_gain,capital_loss,hours_per_week,native_country,salary) " +
            "value (" +
                elem.getAge() + "," +
                "\'" + elem.getWorkclass() + "\'" + "," +
                elem.getFnlwgt() + "," +
                "\'" + elem.getEducation() + "\'" + "," +
                elem.getEducationNum() + "," +
                "\'" + elem.getMaterialStatus() + "\'" + "," +
                "\'" + elem.getOccupation() + "\'" + "," +
                "\'" + elem.getRelationship() + "\'" + "," +
                "\'" + elem.getRace() + "\'" + "," +
                "\'" + elem.getSex() + "\'" + "," +
                elem.getCapitalGain() + "," +
                elem.getCapitalLoss() + "," +
                elem.getHourPerWeek() + "," +
                "\'" + elem.getNativeCountry() + "\'" + "," +
                "\'" + elem.getSalary() + "\'" +
            ")";

            try{
                statement.executeUpdate(sqlInsert);
            }catch(SQLException e){
                e.printStackTrace();
            }
        });
    }

    public static List<Adult> readRawAdult() throws MalformedURLException,IOException {
        URL url = new URL("https://archive.ics.uci.edu/ml/machine-learning-databases/adult/adult.data"); 
        Scanner in = new Scanner(url.openStream());

        List<Adult> adult = new ArrayList<>();

        while(in.hasNextLine()){
            String data = in.nextLine();
            if(data.length() != 0){
                adult.add(convertToAdult(data));
            }
        }
        in.close();

        return adult;
    }

    public static void showRow(Connection con) throws SQLException {
        Statement statment = con.createStatement();
        ResultSet showRow = statment.executeQuery("Select count(*) As row_size from adult");
        showRow.next();
        System.out.println(showRow.getInt("row_size"));
    }

    public static void showContinuousValue(Connection con) throws SQLException{
        Statement statement = con.createStatement();
        ResultSet showData = statement.executeQuery("Select age,fnlwgt,education_num,capital_gain,capital_loss,hours_per_week From adult");
        while(showData.next()){
            System.out.print(showData.getDouble("age") + "\t");
            System.out.print(showData.getDouble("fnlwgt") + "\t");
            System.out.print(showData.getInt("education_num") + "\t");
            System.out.print(showData.getDouble("capital_gain") + "\t");
            System.out.print(showData.getDouble("capital_loss") + "\t");
            System.out.print(showData.getDouble("hours_per_week"));
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException,SQLException,MalformedURLException {
        final String jdbc = "jdbc:mysql://localhost/se212";
        final String user = "root";
        final String pass = "1590";
        Connection con = DriverManager.getConnection(jdbc, user, pass);

        //List<Adult> adults = readRawAdult();
        // insertSQL(con, adults);
        // showContinuousValue(con);
        showRow(con);
    }
}
