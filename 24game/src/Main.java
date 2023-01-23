import java.util.*;
import java.util.List;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) throws Exception {

        boolean start = true;
        Scanner sc = new Scanner(System.in);

        while (start) {

            // Menu
            System.out.println("--------------------------------------------------------------");
            System.out.println("Welcome");
            System.out.println("Menu");
            System.out.println("1. Input Number");
            System.out.println("2. Generate number");
            System.out.println("3. Exit");
            System.out.println("--------------------------------------------------------------");

            // Input Menu
            System.out.print("Your choice: ");
            int menuChoice = sc.nextInt();
            sc.nextLine();
            int[] array = new int[4];

            try{

                if (menuChoice == 1) {

                    boolean startInput = true;
                    boolean outToFile = true;
                    while (startInput) {
                        System.out.println("Please input 4 number ranging from 0-15: ");
    
                        for (int i = 0; i < 4; i++) {
                            array[i] = sc.nextInt();
                        }
    
                        // Check
                        boolean found = true;
                        int j = 0;
                        while (j < 4 && found) {
                            if (array[j] <= 0 || array[j] > 15) {
                                found = false;
                            } else {
                                j++;
                            }
    
                        }
                        if (found) {
                            startInput = false;
                        } else {
                            startInput = true;
                        }
    
                    }
    
                    long startTime = System.nanoTime();
                    solution permutation = new solution();
                    List<List<Integer>> ans = permutation.permute(array);
                    int total = permutation.getSolutionTotal(ans);
                    System.out.println();
                    System.out.println("Total solusi: " + total);
                    permutation.printSolution(ans);
    
                    long stopTime = System.nanoTime();
                    double duration = (stopTime - startTime) / 100000;
    
                    System.out.println("Execution Time: " + duration + "ms");
                    System.out.println();
    
                    System.out.println("Do you want to keep it as a file?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    System.out.print("Insert number: ");
                    int toFile = sc.nextInt();
                    sc.nextLine();
    
                    while (outToFile) {
                        if (toFile == 1) {
                            System.out.println("Write name file: ");
                            String inputNameFile = sc.nextLine();
                            permutation.writetoFile(ans, array, inputNameFile, duration);
                            outToFile = false;
                        } else if (toFile == 2) {
                            outToFile = false;
                        }
                    }
    
                } else if (menuChoice == 2) {
    
                    // Generate random number
                    Random rand = new Random();
                    boolean outtoFileRandom = true;
                    for (int i = 0; i < 4; i++) {
                        int randomNum = rand.nextInt(14) + 1;
                        array[i] = randomNum;
                    }
    
                    System.out.println("Here are your numbers: ");
                    for (int i = 0; i < 4; i++) {
                        System.out.println(array[i]);
                    }
    
                    long startTimeRandom = System.nanoTime();
                    solution permutation = new solution();
                    List<List<Integer>> ansRandom = permutation.permute(array);
                    int totalRandom = permutation.getSolutionTotal(ansRandom);
                    System.out.println("Total solusi: " + totalRandom);
                    permutation.printSolution(ansRandom);
    
                    long stopTimeRandom = System.nanoTime();
                    double durationRandom = (stopTimeRandom - startTimeRandom) / 100000;
    
                    System.out.println("Execution Time: " + durationRandom + "ms");
                    System.out.println();
    
                    System.out.println("Do you want to keep it as a file?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    System.out.print("Insert number: ");
                    int toFile = sc.nextInt();
                    sc.nextLine();
    
                    while (outtoFileRandom) {
                        if (toFile == 1) {
                            System.out.println("Write name file: ");
                            String inputNameFileRandom = sc.nextLine();
                            permutation.writetoFile(ansRandom, array, inputNameFileRandom, durationRandom);
                            outtoFileRandom = false;
                        } else if (toFile == 2) {
                            outtoFileRandom = false;
                        }
                    }
                }
    
                else if (menuChoice == 3) {
                    start = false;
                }

            } catch (InputMismatchException e){
                System.out.println("Integers only, please."); 
            } 
        }
        sc.close();
    }
}
