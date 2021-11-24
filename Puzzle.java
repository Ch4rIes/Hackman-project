import java.util.ArrayList;

public class Puzzle {
    private String p;
    private ArrayList<String> guesses = new ArrayList<>();
    private boolean[] filled;
    // the filled array is an array that keep track of which index of the string is guessed right
    int cur_char = 0;
    public Puzzle(){
        p = "abcde";
        // p is the puzzle string
        filled = new boolean[p.length()];
        for(int i= 0 ; i < filled.length ; i++) filled[i] = false;
        // initially every index is set to default of false (not guessed
    }
    public String getWord(){
        return p;
        // return the word
    }
    public void show(){
        System.out.println("Puzzle: ");
        for(int i = 0 ; i < p.length() ; i++){
            if(!filled[i]){
                // if a particular index is not guessed yet, we print _
                System.out.print("_ ");
            }else{
                // if a particular index is guessed already we just print its corresponding character
                System.out.print(p.charAt(i) + " ");
            }
        }
        System.out.println();
        System.out.println("Guesses: ");
        // print out the guesses that users have made
        for(String temp : guesses) System.out.print(temp +", ");
        System.out.println();
    }
    public boolean makeGuess(String x){
        guesses.add(x);
        for(int i= 0 ; i < p.length() ; i++){
            if(filled[i] == false && Character.toString(p.charAt(i)).equals(x)){
                // check every index one by one. If the guess matches, then we set filled[i] to true
                filled[i] = true;
                cur_char++;
                return true;
            }
        }
        return false;
    }
    public boolean isUnsolved(){
        return cur_char < p.length();
    }
}
