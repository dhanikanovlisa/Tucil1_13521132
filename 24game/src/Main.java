import java.util.*;
import java.io.*;
import java.util.List;
public class Main {
    
    public static void main(String[] args) throws Exception {

        boolean start = true;
        Scanner sc = new Scanner(System.in);
   
        while(start){

            //Menu
            System.out.println("Welcome");
            System.out.println("Menu");
            System.out.println("1. Input Number");
            System.out.println("2. Generate number");
            System.out.println("3. Exit");

            //Input Menu
            System.out.println("Your choice:");
            int menuChoice = sc.nextInt(); 
            int[] array = new int[4];

            if (menuChoice == 1){

                boolean startInput = true;
                boolean nextStage = true;
                while (startInput){
                    System.out.println("Please input 4 number ranging from 0-15:");

                    for(int i = 0; i < 4; i++){
                        array[i] = sc.nextInt();
                    }

                    /* Print number

                    for (int i = 0; i < 4; i++){
                        System.out.println(array[i]);
                    } 

                    */

                    //Check
                    boolean found = true;
                    int j = 0;
                    while(j < 4 && found){
                        if (array[j] <= 0 || array[j] > 15){
                            found = false;
                        } else {
                            j++;
                        }
                        
                    }
                    if (found){
                        startInput = false;
                    } else {
                        startInput = true;
                    }

                    
                }

                //System.out.println("kombinasi: \n");
                solution permutation = new solution();
                List<List<Integer>> coba = permutation.permute(array);
                //System.out.println(coba);
                int total = permutation.getSolutionTotal(coba);
                System.out.println("Total solusi: " + total);
                
                System.out.println("Do you want to keep it as a file?: y/n");
                String toFile = sc.nextLine();


            
                
            
            
               
            

            } else if (menuChoice == 2){

                //Generate random number
                Random rand = new Random();
                for (int i = 0; i < 4; i++){
                    int randomNum = rand.nextInt(14) + 1;
                    array[i] = randomNum;
                }

                System.out.println("Here are your numbers: ");
                for (int i = 0; i < 4; i++){
                    System.out.println(array[i]);
                }
            }

            else if(menuChoice == 3){
                start = false;
            }
        }
    }
}
