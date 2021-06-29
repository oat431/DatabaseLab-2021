import Model.ProblemInfo;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class DatabaseLab1 {
    private static int sumPRP;
    private static int sumERP;
    private static int index = 1;
    private static List<ProblemInfo> li = new ArrayList<>();
    private static List<ProblemInfo> prime = new ArrayList<>();

    private static ProblemInfo convertToProblemInfo(String rawData) {
        String[] data = rawData.trim().split(",");
        return new ProblemInfo(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]),
                Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]),
                Integer.parseInt(data[7]), Integer.parseInt(data[8]), Integer.parseInt(data[9]));
    }

    // number i
    private static void totalPRPandERP(List<ProblemInfo> li) {
        li.forEach(elem -> {
            sumERP += elem.getERP();
            sumPRP += elem.getPRP();
        });
        System.out.println("Sum of Published relative performance: " + sumPRP);
        System.out.println("Sum of Estimated relative performance: " + sumERP);
    }

    // number ii
    private static void totalVendor(List<ProblemInfo> li) {
        Set<String> vendorName = new HashSet<>();

        li.forEach(elem -> {
            vendorName.add(elem.getVendorName());
        });

        System.out.println("We have " + vendorName.size() + " vendor name");

        vendorName.forEach(name -> {
            System.out.println(index++ + ". " + name);
        });
    }

    // number iii
    private static void insertData(ProblemInfo data) {
        Stream<ProblemInfo> newLi = li.stream().sorted((a, b) -> a.getVendorName().compareTo(b.getVendorName()));
        
        newLi.forEach(name -> {
            if (name.getVendorName().equals("prime")) {
                li.remove(name);
                prime.add(name);
            }
        });

        prime.add(data);
        Stream<ProblemInfo> newPrime = prime.stream().sorted(Comparator.comparingInt(ProblemInfo::getCACH));
        newPrime.forEach(newElem -> li.add(newElem));

        li.stream()
            .sorted((a, b) -> a.getVendorName().compareTo(b.getVendorName()))
            .forEach(realData -> {
                System.out.println(realData.toString());
            });
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in1 = new Scanner(new File("./Data/machine 2.csv"));
        Scanner in2 = new Scanner(new File("./Data/machine.data"));

        while (in1.hasNextLine()) {
            li.add(convertToProblemInfo(in1.nextLine()));
        }

        while (in2.hasNextLine()) {
            li.add(convertToProblemInfo(in2.nextLine()));
        }

        in1.close();
        in2.close();

        totalPRPandERP(li);
        System.out.println("-----------------");

        totalVendor(li);
        System.out.println("-----allData-----");

        ProblemInfo test1 = new ProblemInfo("prime", "50-850-ii", 160, 2000, 8000, 32, 1, 13, 109, 54);
        insertData(test1);

    }
}