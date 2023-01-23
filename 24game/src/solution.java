import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;  
import java.io.IOException;


public class solution {
    
    char[] op = {'+', '-', '*', '/'};
    double result = 24;

    public double fOp(char op, double left, double right){
        double result = 0;
        if (op == '+'){
            result += left + right;
        } else if (op == '-'){
            result += left - right;
        } else if (op == '*'){
            result += left * right;
        } else if (op == '/'){
            result += left / right;
        }
        return result;
    }

    public List<List<Integer>> permute(int[] array) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        boolean freq[]=new boolean[array.length];
        recursion(array,ds,ans,freq);
        return ans;
    }
    public void recursion(int[] nums, List<Integer> ds,List<List<Integer>> ans,boolean freq[]){
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!freq[i]){
                freq[i]=true;
                ds.add(nums[i]);
                recursion(nums,ds,ans,freq);
                ds.remove(ds.size()-1);
                freq[i]=false;

            }
        }
    }

    public int getSolutionTotal(List<List<Integer>> num){

        
        int count = 0;
        for (int i = 0; i < num.size(); i++) {
            

                for(int a =0; a < 4; a++){
                    for(int b = 0; b < 4; b++){
                        for(int c = 0; c < 4; c++){
                            
                            if (fOp(op[c], fOp(op[b], fOp(op[a], num.get(i).get(0), num.get(i).get(1)), num.get(i).get(2)), num.get(i).get(3)) == result){
                                count++;
                                //(a op (b op c)) op d
                            }
                            if ( fOp(op[c], fOp(op[a], num.get(i).get(0), fOp(op[b], num.get(i).get(1), num.get(i).get(2))), num.get(i).get(3)) == result){
                                count++;
                            }
                            if ( fOp(op[b], fOp(op[a], num.get(i).get(0), num.get(i).get(1)), fOp(op[c], num.get(i).get(2), num.get(i).get(3))) == result){
                                count++;
                            }
                            if ( fOp(op[a], num.get(i).get(0), fOp(op[c], fOp(op[b], num.get(i).get(1), num.get(i).get(2)), num.get(i).get(3))) == result){
                                count++;
                            }
                            if ( fOp(op[a], num.get(i).get(0), fOp(op[b], num.get(i).get(1), fOp(op[c], num.get(i).get(2), num.get(i).get(3)))) == result){
                                count++;
                            }
                        }
                    }
                }
        }

        return count;   
    }

    public void printSolution(List<List<Integer>> num){

        System.out.println("----------------------------------------------");
        for (int i = 0; i < num.size(); i++) {
                for(int a =0; a < 4; a++){
                    for(int b = 0; b < 4; b++){
                        for(int c = 0; c < 4; c++){
                            
                            if (fOp(op[c], fOp(op[b], fOp(op[a], num.get(i).get(0), num.get(i).get(1)), num.get(i).get(2)), num.get(i).get(3)) == result){
                                System.out.println("( ( " + num.get(i).get(0) + " " + op[a] + " " + num.get(i).get(1) + " ) " + op[b] + " " + num.get(i).get(2) + " ) " + op[c] + " " +  num.get(i).get(3));
                                //(a op (b op c)) op d
                            }
                            if ( fOp(op[c], fOp(op[a], num.get(i).get(0), fOp(op[b], num.get(i).get(1), num.get(i).get(2))), num.get(i).get(3)) == result){
                                System.out.println("( " + num.get(i).get(0) + " " + op[a] + " ( " + num.get(i).get(1) + " " + op[b] + " " + num.get(i).get(2) + " ) ) " + op[c] + " " +  num.get(i).get(3));
                            }
                            if ( fOp(op[b], fOp(op[a], num.get(i).get(0), num.get(i).get(1)), fOp(op[c], num.get(i).get(2), num.get(i).get(3))) == result){
                                System.out.println("( " + num.get(i).get(0) + " " + op[a] + " " + num.get(i).get(1) + " ) " + op[b] + " ( " + num.get(i).get(2) + " " + op[c] + " " + num.get(i).get(3) + " )" );
                            }
                            if ( fOp(op[a], num.get(i).get(0), fOp(op[c], fOp(op[b], num.get(i).get(1), num.get(i).get(2)), num.get(i).get(3))) == result){
                                System.out.println( num.get(i).get(0) + " " + op[a] + " ( ( " + num.get(i).get(1) + " " + op[b] + " " + num.get(i).get(2) + " ) " + op[c] + " " + num.get(i).get(3) + " )");
                                
                            }
                            if ( fOp(op[a], num.get(i).get(0), fOp(op[b], num.get(i).get(1), fOp(op[c], num.get(i).get(2), num.get(i).get(3)))) == result){
                                System.out.println( num.get(i).get(0) + " " + op[a] + " ( " + num.get(i).get(1) + " " + op[b] + " ( " + num.get(i).get(2) + " " + op[c] + " " + num.get(i).get(3) + " ) )");
                            }
                        }
                    }
                }
            }
            System.out.println("----------------------------------------------");
        }
    

    public void writetoFile(List<List<Integer>> num, int[] array, String nameFile, double executionTime){

        int total = getSolutionTotal(num);
    
        try {
            
            FileWriter writeFile = new FileWriter(nameFile + ".txt");
            for(int idx = 0; idx < 4; idx++){
                writeFile.write(array[idx] + " ");
            }
            writeFile.write("\n");
            writeFile.write("Total Solution: " + total + "\n");
            writeFile.write("Execution Time: " + executionTime + "ms \n");

            for (int i = 0; i < num.size(); i++) {
                for(int a =0; a < 4; a++){
                    for(int b = 0; b < 4; b++){
                        for(int c = 0; c < 4; c++){
                            
                            if (fOp(op[c], fOp(op[b], fOp(op[a], num.get(i).get(0), num.get(i).get(1)), num.get(i).get(2)), num.get(i).get(3)) == result){
                                writeFile.write("( ( " + num.get(i).get(0) + " " + op[a] + " " + num.get(i).get(1) + " ) " + op[b] + " " + num.get(i).get(2) + " ) " + op[c] + " " +  num.get(i).get(3) + "\n");
                                //(a op (b op c)) op d
                            }
                            if ( fOp(op[c], fOp(op[a], num.get(i).get(0), fOp(op[b], num.get(i).get(1), num.get(i).get(2))), num.get(i).get(3)) == result){
                                writeFile.write("( " + num.get(i).get(0) + " " + op[a] + " ( " + num.get(i).get(1) + " " + op[b] + " " + num.get(i).get(2) + " ) ) " + op[c] + " " +  num.get(i).get(3) + "\n");
                            }
                            if ( fOp(op[b], fOp(op[a], num.get(i).get(0), num.get(i).get(1)), fOp(op[c], num.get(i).get(2), num.get(i).get(3))) == result){
                                writeFile.write("( " + num.get(i).get(0) + " " + op[a] + " " + num.get(i).get(1) + " ) " + op[b] + " ( " + num.get(i).get(2) + " " + op[c] + " " + num.get(i).get(3) + " )" + "\n");
                            }
                            if ( fOp(op[a], num.get(i).get(0), fOp(op[c], fOp(op[b], num.get(i).get(1), num.get(i).get(2)), num.get(i).get(3))) == result){
                                writeFile.write( num.get(i).get(0) + " " + op[a] + " ( ( " + num.get(i).get(1) + " " + op[b] + " " + num.get(i).get(2) + " ) " + op[c] + " " + num.get(i).get(3) + " )"+ "\n");
                                
                            }
                            if ( fOp(op[a], num.get(i).get(0), fOp(op[b], num.get(i).get(1), fOp(op[c], num.get(i).get(2), num.get(i).get(3)))) == result){
                                writeFile.write( num.get(i).get(0) + " " + op[a] + " ( " + num.get(i).get(1) + " " + op[b] + " ( " + num.get(i).get(2) + " " + op[c] + " " + num.get(i).get(3) + " ) )" + "\n");
                            }
                        }
                    }
                }
            }
            writeFile.close();


          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    
}    




