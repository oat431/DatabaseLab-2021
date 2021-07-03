import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import java.net.URL;
import java.net.MalformedURLException;

import java.io.IOException;

import Model.Iris;

public class App {
    private static void showAllData(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet showData = stmt.executeQuery("SELECT * FROM iris");

        while (showData.next()) {
            System.out.print(showData.getInt("flowerID") + " ");
            System.out.print(showData.getDouble("s_length") + " ");
            System.out.print(showData.getDouble("s_width") + " ");
            System.out.print(showData.getDouble("p_length") + " ");
            System.out.print(showData.getDouble("p_width") + " ");
            System.out.println(showData.getString("flower_type"));
        }
    }

    private static void insertSQL(Connection con, List<Iris> iris) throws SQLException {
        Statement statment = con.createStatement();

        iris.forEach(elem -> {
            String sqlInsert = 
                "Insert Into Iris(s_length,s_width,p_length,p_width,flower_type) " + 
                "value("
                    + elem.getS_length() + "," 
                    + elem.getS_width() + "," 
                    + elem.getP_length() + "," 
                    + elem.getP_width()+ "," 
                    + "\"" + elem.getType() + "\"" +  
                ")";

            try {
                statment.executeUpdate(sqlInsert);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    }

    private static Iris convertToIris(String data) {
        String[] rawData = data.trim().split(",");
        return new Iris(
            Double.parseDouble(rawData[0]),
            Double.parseDouble(rawData[1]),
            Double.parseDouble(rawData[2]),
            Double.parseDouble(rawData[3]),
            rawData[4]
        );
    }

    public static List<Iris> readRawIris() throws MalformedURLException,IOException{
        URL url = new URL("https://archive.ics.uci.edu/ml/machine-learning-databases/iris/iris.data"); 
        Scanner in = new Scanner(url.openStream()); 

        List<Iris> iris = new ArrayList<>();
        while(in.hasNextLine()){
            String data = in.nextLine();
            if(data.length() != 0){
                iris.add(convertToIris(in.nextLine()));
            }
        }
        in.close();

        return iris;
    }

    public static void main(String[] args) throws MalformedURLException,IOException,SQLException {
        final String url = "jdbc:mysql://localhost/se212_iris";
        final String user = "root";
        final String pass = "1590";
        Connection con = DriverManager.getConnection(url, user, pass);
        
        List<Iris> flower = readRawIris();

        //insertSQL(con, flower);

        showAllData(con);
        System.out.println("Total number of flower : " + flower.size());
    }
}