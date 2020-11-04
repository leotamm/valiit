package ee.bcs.valiit.tasks;

import org.yaml.snakeyaml.emitter.ScalarAnalysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Lesson2 {

    public static void main(String[] args) {
        exercise6();

    }

    public static void exercise1() {                        // READY
        // TODO loo 10 elemendile täisarvude massiv
        // TODO loe sisse konsoolist 10 täisarvu
        // TODO trüki arvud välja vastupidises järiekorras

        Stack list = new Stack<>();
        Scanner sc = new Scanner(System.in);
        for (int count = 1; count < 11; count++) {
            System.out.println("Anna mulle number " + count + " palun:");
            int a = sc.nextInt();
            list.push(a);
        }
        System.out.println("\nSain kätte 10 numbrit, tagastan need tagurpidi:");
        for (int count = 1; count < 11; count++) {
            System.out.println(list.pop());
        }
    }

    public static void exercise2(int x) {                   // READY
        // TODO prindi välja x esimest paaris arvu
        // Näide:
        // Sisend 5
        // Väljund 2 4 6 8 10
        for (int i = 1; i <= x; i++) {
            System.out.println(2 * i);
        }

    }

    public static void exercise3(int x, int y) {            // READY
        // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
        // TODO näiteks x = 3 y = 3
        // TODO väljund
        // 1 2 3
        // 2 4 6
        // 3 6 9
        int[][] tabel = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                tabel[i][j] = (i + 1) * (j + 1);
                System.out.print(tabel[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void fibonacci(int n) {                   // READY
        // TODO
        // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
        // 0, 1, 1, 2, 3, 5, 8, 13, 21
        // Tagasta fibonacci jada n element

        int esimene = 0;
        int teine = 1;
        for (int x = 0; x < n; x++) {
            System.out.print(esimene + ", ");
            int fib = esimene + teine;
            esimene = teine;
            teine = fib;
        }
    }

    public static void exercise5(int i, int j) {            // READY

        //All integers will be less than 10,000 and greater than 0
        // https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=36

        int length = 0;
        int start = i;
        int stop = j;
        ArrayList lengthIndex = new ArrayList();
        int longest = 0;

        for (int x = start; x <= stop; x++) {
            int count = 0;
            int y = x;
            while (y > 1) {
                if (y % 2 != 0) {
                    y = 3 * y + 1;
                } else {
                    y = y / 2;
                }
                //System.out.println(y);
                count++;
                if (count > length) {
                    length = count;
                }
            }
            lengthIndex.add(length);

            int stop2 = lengthIndex.size();
            int indexValue = 0;

            for (int x2 = 0; x2 < stop2; x2++) {
                indexValue = (int) lengthIndex.get(x2);
                if (indexValue > longest) {
                    longest = indexValue;
                } else {
                    break;
                }
            }
        }
        System.out.println(i + "\t" + j + "\t" + longest);
    }

    public static void exercise6() {                        // IN PROGRESS
        /*
            Kirjutada Java programm, mis loeb failist visits.txt sisse looduspargi külastajad erinevatel jaanuari päevadel ning
            a) sorteerib külastuspäevad külastajate arvu järgi kasvavalt ning prindib tulemuse konsoolile;
            b) prindib konsoolile päeva, mil külastajaid oli kõige rohkem.
            Faili asukoht tuleb programmile ette anda käsurea parameetrina.
        */

        try {
            File inputFile = new File("visits.txt");
            Scanner fileScanner = new Scanner(inputFile);

            int itemCount = 0;
            int divideToTwo = 2;
            String[] lineItems;
            ArrayList dates = new ArrayList();
            ArrayList counts = new ArrayList();


            while (fileScanner.hasNextLine()) {                 // reads the visits.txt file
                String line = fileScanner.nextLine();
                itemCount++;
                lineItems = line.split(", ");             // splits each line to date and count

                for (String a : lineItems) {
                    if (divideToTwo % 2 != 0) {                 // creates separate count and data arraylists
                        counts.add(a);
                        System.out.println("Count " + a);
                        divideToTwo++;
                    } else {
                        dates.add(a);
                        System.out.println("Date " + a);
                        divideToTwo++;
                    }
                }
            }
            int minVisitors = 0;
            ArrayList countsCopy = counts;
            ArrayList visitorsByDayAscending = new ArrayList();

            for (int x = 0; x < itemCount; x++) {                     // loops through count array and writes a new

                int checkThisDay = Integer.parseInt("countsCopy.get(x)");                 // array
                if (checkThisDay > minVisitors) {
                    visitorsByDayAscending.add(checkThisDay);
                    System.out.println(checkThisDay);
                } else {

                }

            }

            System.out.println("\nCounted " + itemCount + " dates in file.");   // confirms that all file items are accounted for
            System.out.println("Index of string \"697\": " + counts.indexOf("697"));

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");

        }

    }

    public static void exercise7() {                        // READY
        // TODO arvuta kasutades BigDecimali 1.89 * ((394486820340 / 15 ) - 4 )
        BigDecimal a = new BigDecimal("1.89");
        BigDecimal b = new BigDecimal("394486820345");
        BigDecimal c = new BigDecimal("15");
        BigDecimal d = new BigDecimal("4");

        System.out.println(a.subtract(a.multiply(b.divide(c, 4, RoundingMode.HALF_UP))));
    }

    public static void exercise8() {                        // IN PROGRESS
        /*
        Failis nums.txt on üksteise all 150 60-kohalist numbrit.

        Kirjuta programm, mis loeks antud numbrid failist sisse ja liidaks need arvud kokku ning kuvaks ekraanil summa.
        Faili nimi tuleb programmile ette anda käsurea parameetrina.

        VASTUS:
        Õige summa: 77378062799264987173249634924670947389130820063105651135266574
         */

        Scanner scanner = new Scanner("nums.txt");
        BigDecimal sum = new BigDecimal(0);

        while (scanner.hasNextLine()) {
            sum = sum.add(scanner.nextBigDecimal());
        }
        System.out.println(sum);
    }

    public static void exercise9() {                        // TO DO
        /* TODO
        Sama mis eelmises ülesandes aga ära kasuta BigInt ega BigDecimal klassi
         */
    }

}
