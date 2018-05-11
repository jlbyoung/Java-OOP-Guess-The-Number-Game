/*
Name : James Young
Student ID : 100273383
Course : CPSC 1181-001
Instructor : Gladys Monagan

Guess The Number program - Assignment 1
This program guesses the number the user has in thought by performing operations on the given result.
*/

import javax.swing.JOptionPane;

public class GuessTheNumber
{
	/* main method
	This method begins the program and contains the core logic behind the program.
	
	@param args Not used.
	*/
	public static void main(String[] args)
	{
		boolean repeat = false;
		int number;
		int difficulty;
		
		do
		{
			//Get the selected difficulty
			difficulty = getDifficulty();
			//Have the user think of a number
			userNumber();
			
			//User selects easy difficulty
			if(difficulty == 0)
			{
				easy();
			}
			//User selects medium difficulty
			else if(difficulty == 1)
			{
				medium();
			}
			//User selects hard difficulty
			else
			{
				hard();
			}
			
			//Prompts the user if the program is to be repeated
			repeat = repeatProgram();
		} while(repeat == true);
		
	}
	/* getDifficulty method
	This method has the user select a difficulty.
	
	Precondition : none
	
	return choice The index of the button selected.
	*/
	public static int getDifficulty()
	{
		String[] buttons = { "Easy", "Medium", "Hard" };
		int choice = JOptionPane.showOptionDialog(
				null,
				"Set the difficulty level (easy, medium, hard)",
				"Select Difficulty",
				0,
				JOptionPane.PLAIN_MESSAGE,
				null,
				buttons,
				buttons[2]);
		return choice;
	}
	
	/*userNumber method
	This method shows the user a dialog box for them to think of a number
	
	Precondition : none
	*/
	public static void userNumber()
	{
		JOptionPane.showMessageDialog(null, "Think of a number", "Step 1", JOptionPane.PLAIN_MESSAGE);
	}
	
	/*easy method
	This method leads the user thought of number and determines what the original number was.
	
	precondition : difficulty is set to 0(easy)
	*/
	public static void easy()
	{
		boolean check = false;
		String input;
		int number;
		
		JOptionPane.showMessageDialog(null, "Now multiply that number by 5", "Step 2", JOptionPane.PLAIN_MESSAGE);
		
		input = JOptionPane.showInputDialog(null, "Enter your calculation", "Step 3", JOptionPane.QUESTION_MESSAGE);
		//User presses cancel
		if(input == null)
		{
			JOptionPane.showMessageDialog(null, "You pressed cancel.", "Program message", JOptionPane.WARNING_MESSAGE);
		}
		//User presses OK without entering anything
		else if(input.equals(""))
		{
			JOptionPane.showMessageDialog(null, "You did not enter anything.", "Program message", JOptionPane.WARNING_MESSAGE);
		}
		
		else
		{
			//Checks if the number entered is a valid positive number
			check = isNumeric(input);
			if(check == true)
			{
				number = Integer.parseInt(input);
				
				JOptionPane.showMessageDialog(null, "My guess is : " + number/5, "Step 4", JOptionPane.PLAIN_MESSAGE);
			}
			//Any letters,  negative or decimal numbers will be rejected
			else
			{
				JOptionPane.showMessageDialog(null, "You have entered non-numeric data. Radius must be an integer number.", "Program error", JOptionPane.OK_OPTION);
			}
		}
		

	}
	
	public static void medium()
	{
		boolean check = false;
		String input;
		int number;
		
		JOptionPane.showMessageDialog(null, "Now multiply that number by 10", "Step 2", JOptionPane.PLAIN_MESSAGE);
		
		JOptionPane.showMessageDialog(null, "Now add 6", "Step 3", JOptionPane.PLAIN_MESSAGE);
		
		input = JOptionPane.showInputDialog(null, "Enter your calculation", "Step 4", JOptionPane.QUESTION_MESSAGE);
		
		if(input == null)
		{
			JOptionPane.showMessageDialog(null, "You pressed cancel.", "Program message", JOptionPane.WARNING_MESSAGE);
		}
		
		else if(input.equals(""))
		{
			JOptionPane.showMessageDialog(null, "You did not enter anything.", "Program message", JOptionPane.WARNING_MESSAGE);
		}
		
		else
		{
			check = isNumeric(input);
			if(check == true)
			{
				number = Integer.parseInt(input);
				number = (number - 6) /10;
				JOptionPane.showMessageDialog(null,	"My guess is : " + number,	"Step 5", JOptionPane.PLAIN_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "You have entered non-numeric data. Radius must be an integer number.", "Program error", JOptionPane.OK_OPTION);
			}
		}
	}
	
	public static void hard()
	{
		boolean check = false;
		String input;
		int number;
		
		JOptionPane.showMessageDialog(null, "Now multiply that number by 20", "Step 2", JOptionPane.PLAIN_MESSAGE);
		
		JOptionPane.showMessageDialog(null, "Now add 150", "Step 4", JOptionPane.PLAIN_MESSAGE);
		
		JOptionPane.showMessageDialog(null, "Now divide by 5", "Step 5", JOptionPane.PLAIN_MESSAGE);
		
		input = JOptionPane.showInputDialog(null, "Enter your calculation", "Step 6", JOptionPane.QUESTION_MESSAGE);
			
		if(input == null)
		{
			JOptionPane.showMessageDialog(null, "You pressed cancel.", "Program message", JOptionPane.WARNING_MESSAGE);
		}
		
		else if(input.equals(""))
		{
			JOptionPane.showMessageDialog(null, "You did not enter anything.", "Program message", JOptionPane.WARNING_MESSAGE);
		}
		
		else
		{
			check = isNumeric(input);
			if(check == true)
			{
				number = Integer.parseInt(input);
				number = ((number * 5) - 150) /20;
				JOptionPane.showMessageDialog(null, "My guess is : " + number, "Step 7", JOptionPane.PLAIN_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "You have entered non-numeric data. Radius must be an integer number.", "Program error", JOptionPane.OK_OPTION);
			}
		}
	}
	
	public static boolean isNumeric(String radius)
	{
		for(int i = 0; i < radius.length(); i++)
		{
			if(radius.charAt(i) < '0' || radius.charAt(i) > '9')
			{
				return false;
			}
		}
		return true;
	}
	
	public static boolean repeatProgram()
	{
		int option;
		option = JOptionPane.showConfirmDialog(null, "Would you like to repeat the program?", "Repeat Program", JOptionPane.YES_NO_OPTION);
		if(option == JOptionPane.NO_OPTION)
		{
			return false;
		}
		return true;
	}
}