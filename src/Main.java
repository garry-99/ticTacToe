import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    static boolean checkWinner(HashMap<Integer, Integer> m1) {
            // Winning conditions in Tic-Tac-Toe
            int[][] winConditions = {
                    {1, 2, 3}, {4, 5, 6}, {7, 8, 9},  // rows
                    {1, 4, 7}, {2, 5, 8}, {3, 6, 9},  // columns
                    {1, 5, 9}, {3, 5, 7}              // diagonals
            };

            for (int[] condition : winConditions) {
                int a = condition[0];
                int b = condition[1];
                int c = condition[2];

                // Check if all three positions are occupied by the same player
                if (m1.containsKey(a) && m1.containsKey(b) && m1.containsKey(c)) {
                    int valA = m1.get(a);
                    int valB = m1.get(b);
                    int valC = m1.get(c);

                    if (valA == valB && valB == valC) {
                        // We found a winner
                        System.out.println("Player " + (valA == 0 ? 'O' : 'X') + " wins!");
                        return true;
                    }
                }
            }
            return false;


    }
    public static void showGame(HashMap<Integer, Integer> m1){
        for(int i = 1 ; i <= 9 ; ++i ){
            Integer val = m1.getOrDefault(i , i);
            if(val == i )System.out.printf(i + " ");
            else if(val == 0)System.out.print("O ");
            else{
                System.out.print("x ");
            }
            if(i%3 == 0 )System.out.println();
        }
        for(int i = 0 ; i < 3 ; ++i ){
            System.out.println();
        }

    }
    public static void main(String[] args) {

        System.out.println("Lets start the gamne ");
        int place = 1;
        HashMap<Integer, Integer> m1 = new HashMap<>();

        Scanner s1 = new Scanner(System.in);

        int inputs = 0 ;
        int flag = -1 ;

        for(int i = 0 ; i < 9 ; ++i ){
            System.out.println("choose where u want your point");

            showGame(m1);

            int pl = s1.nextInt();
            while(m1.containsKey(pl)){
                System.out.println("Already Used Kindly provide new place ");
                pl = s1.nextInt();
            }
            m1.put(pl , flag);
            if(checkWinner(m1)) {
                break;
            }
            if(flag == -1 ){
                flag = 0 ;
            }
            else{
                flag = -1 ;
            }
        }
        showGame(m1);
    }
}