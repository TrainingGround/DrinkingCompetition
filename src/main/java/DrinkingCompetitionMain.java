import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by roma on 14.02.17.
 */
public class DrinkingCompetitionMain {
    private static Integer[] enduranceArray;
    private static Integer[] subordinationArray;
    private static boolean inputIsAlright = true;
    public static void main(String[] args){
        inputArrayData();
        if (inputIsAlright){
            Company company = new Company(enduranceArray,
                    subordinationArray);
            company.makeTree();
            System.out.printf("%n Best team value: %d", company.getBestTeamValue());
            company.printDrinkingTeam();
        }
    }
    private static void inputArrayData(){
        System.out.printf("First, input an array of n integers that represent drinking capability. %n" +
                "Then input n-1 integers to create company subordination structure. %n");
        Scanner input = new Scanner(System.in);
        StringTokenizer token = new StringTokenizer(input.nextLine());
        enduranceArray = new Integer[token.countTokens()];
        for (int counter =0; counter<enduranceArray.length; counter++){
            try {
                enduranceArray[counter] = Integer.parseInt(token.nextToken());
            }catch (NumberFormatException e){
                e.printStackTrace();
            } catch (IllegalArgumentException e){
                e.printStackTrace();
            }
        }
        subordinationArray = new Integer[enduranceArray.length-1];
        token = new StringTokenizer(input.nextLine());
        for(int counter = 0; counter< enduranceArray.length-1; counter++){
            try{
                subordinationArray[counter] = Integer.parseInt(token.nextToken());
            }catch (NumberFormatException e){
                e.printStackTrace();
            } catch (IllegalArgumentException e){
                e.printStackTrace();
            }
        }
    }
}
