package lottery;

import java.util.Random;
import java.util.Scanner;

public class LottoChecker {

	public static void main(String[] args) {
		
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		
		//Sprint 1
		
		int[] nums = new int[6];
		for(int i=0; i<nums.length; i++) {
			System.out.println("Enter number: "+(i+1));
			nums[i] = scan.nextInt();
		}
		
		
		int[] wins = new int[6];
		for(int i=0; i<wins.length; i++) {
			wins[i] = rand.nextInt(38)+1;
		}
		
		
		int winningBalls = 0;
		
		System.out.println("Lotto checker ...");
		System.out.printf("Your selection ... %d, %d, %d, %d, %d, %d\n",nums[0],nums[1],nums[2],nums[3],nums[4],nums[5]);
		System.out.printf("Winning balls ... %d, %d, %d, %d, %d, %d\n\n",wins[0],wins[1],wins[2],wins[3],wins[4],wins[5]);

		
		//Sprint 2
		// Check each number against winning balls using if else statements
		
		System.out.println("Checking for winners...");
		
		for(int i=0; i<nums.length; i++) {
			for(int j=0; j<wins.length; j++) {
				if(nums[i]==wins[j]) {
					//winner
					winningBalls++;
				}
			}
		}
		
		/*
		 * if(num1==win1 || num1==win2 || num1==win3 || num1==win4 || num1==win5 ||
		 * num1==win6) { System.out.println("Winner "+num1); winningBalls++; } else {
		 * System.out.println(num1+" not a winner..."); }
		 * 
		 * if(num2==win1 || num2==win2 || num2==win3 || num2==win4 || num2==win5 ||
		 * num2==win6) { System.out.println("Winner "+num2); winningBalls++; } else {
		 * System.out.println(num2+" not a winner..."); }
		 * 
		 * if(num3==win1 || num3==win2 || num3==win3 || num3==win4 || num3==win5 ||
		 * num3==win6) { System.out.println("Winner "+num3); winningBalls++; } else {
		 * System.out.println(num3+" not a winner..."); }
		 * 
		 * if(num4==win1 || num4==win2 || num4==win3 || num4==win4 || num4==win5 ||
		 * num4==win6) { System.out.println("Winner "+num4); winningBalls++; } else {
		 * System.out.println(num4+" not a winner..."); }
		 * 
		 * if(num5==win1 || num5==win2 || num5==win3 || num5==win4 || num5==win5 ||
		 * num5==win6) { System.out.println("Winner "+num5); winningBalls++; } else {
		 * System.out.println(num5+" not a winner..."); }
		 * 
		 * if(num6==win1 || num6==win2 || num6==win3 || num6==win4 || num6==win5 ||
		 * num6==win6) { System.out.println("Winner "+num6); winningBalls++; } else {
		 * System.out.println(num6+" not a winner..."); }
		 */
		
		
		System.out.println("\nResult:");
		switch(winningBalls) {
		
		case 0:
			System.out.println("0 No luck at all!");
			break;
		case 1:
		case 2:
			System.out.println("1 or 2 Not bad");
			break;
		case 3:
			System.out.println("Maybe a trip to the shops");
		break;
		case 4:
			System.out.println("Dont give up your job but maybe a holiday");
			break;
		case 5:
			System.out.println("Pay your uni fees");
			break;
		case 6:
			System.out.println("Tell the boss where to go");
			break;
			default:
				System.out.println("Error");
		}
		
		scan.close();
	}

}
