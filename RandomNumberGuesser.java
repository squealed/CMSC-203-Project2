/**
* RandomNumberGuesser playing a high or low game with the user
*
* @author  Neil Walter
* @version 1.0
* @since   2020-09-27 
*/
import java.util.Scanner;

public class RandomNumberGuesser {
	//initilize main 
	public static void main(String args[]) {
	//create a new scanner
	Scanner sc = new Scanner(System.in);
	//create a new constructor
	RNG projectmain = new RNG();
	//generates random num
	int randNum = projectmain.rand();
	//sets high and low variables
	int highNum = 100, lowNum = 0;
	int countlocal =1;
	// loop to quit later
	boolean loop = true;
	do {
	// Enter first guess
	System.out.println("Enter your first guess: ");
	int guess = sc.nextInt();
	//print guess num
	System.out.println("Number of guesses is " + countlocal++);
	//prints if guess to high or low 
	if(guess > randNum){
		System.out.println("Your guess is too high");
		highNum = guess;
	}else {
		System.out.println("Your guess is too low");
		lowNum = guess;
	}
	// loops 10 times giving the user 10 trys 
	for(int i  = 0; i < 10; i++) {
	// prints what range to enter through
	System.out.println("Enter your next guess between "+ lowNum + " and " + highNum);
	int nextNum = sc.nextInt();
	// prints if guess is too high or too low
	if(nextNum > randNum){
		System.out.println("Your guess is too high");
	}else if(nextNum < randNum){
		System.out.println("Your guess is too low");
	}
	//prints number of guesses
	System.out.println("Number of guesses is " + countlocal++);
	boolean status = false;
	// checks if the number is in range
	status = projectmain.inputValidation(nextNum, lowNum, highNum);
	//fallback case if the number is out of range 
	if(status == false) {
		nextNum = sc.nextInt();
		System.out.println("Number of guesses is " + countlocal++);
		if(nextNum > randNum){
			System.out.println("Your guess is too high");
		}else if(nextNum < randNum){
			System.out.println("Your guess is too low");
		}
		//checks if the number was a high or a low and sets to the new high or new low 
	}
	//new high
	if(nextNum > randNum){
		highNum = nextNum;
	}else {
		//new low
		lowNum = nextNum;
	}
	//checks if the number has been guessed
	if(nextNum == randNum) {
		//end loop
		i=11;
		//congradulates user
		System.out.println("Congratulations, you guessed correctly");
		System.out.println("Try again? (yes or no)");
		// get next info
		String a = sc.next();
		//checks if want to loop again
		if(a.equals("yes")) {
			//reset all variables
			randNum = projectmain.rand();
			highNum = 100;
			lowNum = 0;
			projectmain.resetCount();
			countlocal = 0;
		}else {
			//exit otherwise
			loop = false;
			System.out.println("Thanks for playing....");
		}
		}
	}
	}while(loop == true);
	System.out.println("\nProgrammer: Neil Walter");
}
}