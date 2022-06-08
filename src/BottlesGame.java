import java.util.Scanner;

public class BottlesGame {

	public static void main(String[] args) {
		int bottles=21;
		int compAmount=0;
		boolean humanTurn;
		String input="";
		Scanner sc=new Scanner(System.in);
		
		System.out.println("There are "+bottles+" beer bottles...");
		System.out.println("Computer and yourself, there are 2 players");
		System.out.println("At a time, each one can pick up any no. of bottles between 1 and 4 (inclusive)");
		System.out.println("Would you like to play first?");
		
		input=sc.nextLine();
		if(input.toLowerCase().equals("yes") || input.toLowerCase().equals('y')) {
			humanTurn=true;
		} else {
			humanTurn=false;
		}
		
		while(bottles>0) {
			System.out.println("There are "+bottles+" bottles remaining");
			if(humanTurn) {
				if(bottles==1 ) {
					System.out.println("You will have to pick up the last bottle... you lose");
					bottles--;
					humanTurn=false;
				} 
				else {
					System.out.println("How many would you like to pick up?");
					input=sc.nextLine();
					while(Integer.parseInt(input)<1 || Integer.parseInt(input)>4) {
						System.out.println("Invalid amount, try again");
						input=sc.nextLine();
					}
					bottles=bottles-Integer.parseInt(input);
					humanTurn=false;
				}
			} 
			else {
				if(bottles==1 || bottles==7) {
					compAmount=1;
				} 
				else if(bottles<=5) {
					compAmount=bottles-1;
				} 
				else if(bottles%2==0){
					compAmount=2;
				} 
				else {
					compAmount=3;
				}
				System.out.println("Computer has picked "+compAmount);
				bottles=bottles-compAmount;
				humanTurn=true;
			}		
		}
		
		if(humanTurn=true) {
			System.out.println("Computer wins");
		} else {
			System.out.println("Human wins");
		}
			
		sc.close();	

	}

}
