import java.util.Scanner;

/******************************************************************************
*
* Name: Savion Sample
* Block: D
* Date: 10/5/15
*
* Description:
******************************************************************************/

public class QueueMain {
	
	private static final Scanner SC = new Scanner(System.in);
	private static final int SIZE = 3;

	public static void main(String[] args) {
		
		Queue q1 = new Queue(SIZE);
		
		displayMenu();
		String userInput = SC.nextLine();
		
		while (!userInput.equals("q"))
		{	
			processInput(q1, userInput);
			displayMenu();
			userInput = SC.nextLine();
		}
		System.out.println("End of program");
	}
	
	private static void processInput(Queue queue, String userInput)
	{
		if (userInput.equals("e"))
		{
			System.out.println("User's input: " + userInput);
			enqueueMain(queue);
		}
		else if(userInput.equals("d"))
		{
			System.out.println("User's input: " + userInput);
			dequeueMain(queue);
		}
		else if(userInput.equals("f"))
		{
			System.out.println("User's input: " + userInput);
			System.out.println(queue.isFull());
		}
		else if(userInput.equals("m"))
		{
			System.out.println("User's input: " + userInput);
			System.out.println(queue.isEmpty());
		}
		else if(userInput.equals("p"))
		{
			System.out.println("User's input: " + userInput);
			System.out.println(queue.toString());
		}
		else if(userInput.equals("s"))
		{
			System.out.println("User's input: " + userInput);
			System.out.println(queue.getDataAsString());
		}
	}
	
	private static void enqueueMain(Queue q1)
	{
		if (q1.isFull())
		{
			System.out.println("Enqueue onto q1 failed - queue full");
		}
		else
		{
			System.out.println("Please enter the word you want to queue");
			String userQueueWord = SC.nextLine();
			q1.enqueue(userQueueWord);
			System.out.println(userQueueWord + " enqueued onto q1");
		}
	}
	
	private static void dequeueMain(Queue q1)
	{
		if(q1.isEmpty())
		{
			System.out.println("Dequeue from q1 failed - queue empty");
		}
		else
		{
			System.out.println(q1.dequeue() + " dequeued from s1");
		}
	}
	
	private static void displayMenu()
	{
		System.out.println();
		
		System.out.println("The commands are:");
		System.out.println("e - enqueue");
		System.out.println("d - dequeue");
		System.out.println("f - check if full");
		System.out.println("m - check if empty");
		System.out.println("p - print from front of queue to back");
		System.out.println("s - show all data from index 0 to length - 1");
		System.out.println("q - quit");
		
		System.out.println("Please enter a command: ");
	}

}
