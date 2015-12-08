import java.util.Scanner;

/******************************************************************************
*
* Name: Savion Sample
* Block: D
* Date: 12/5/15
*
* Description:
* A circular array based implementation of a queue of Strings with a menu-driven
* user interface. The user is offered options to do things to the queue:
* enqueue(add) a String into the queue, dequeue(remove) a String from the queue,
* check if the queue is full/empty, print the contents of the queue, and show
* all the specific data in the queue 
******************************************************************************/

public class QueueMain {
	
	private static final Scanner SC = new Scanner(System.in);
	private static final int SIZE = 4;

	public static void main(String[] args) {
		
		Queue q1 = new Queue(SIZE);
		
		displayMenu();
		String userInput = SC.nextLine();
		
		while (!userInput.equals("q"))
		{	
			System.out.println("User's input: " + userInput);
			processInput(q1, userInput);
			displayMenu();
			userInput = SC.nextLine();
		}
		System.out.println("End of program");
	}
	
	/**
	 * performs an action based on the user's input
	 * 
	 * @param queue: the entire queue
	 * @param userInput: the command the user entered
	 */
	private static void processInput(Queue queue, String userInput)
	{
		if (userInput.equals("e"))
		{	
			enqueueMain(queue);
		}
		else if(userInput.equals("d"))
		{
			dequeueMain(queue);
		}
		else if(userInput.equals("f"))
		{
			System.out.println(queue.isFull());
		}
		else if(userInput.equals("m"))
		{
			System.out.println(queue.isEmpty());
		}
		else if(userInput.equals("p"))
		{
			System.out.println(queue.toString());
		}
		else if(userInput.equals("s"))
		{
			System.out.println(queue.getDataAsString());
		}
		else
		{
			System.out.println("Command not recognized...please try again");
		}
	}
	
	/**
	 * enqueues the user-entered String if the queue is not already full
	 * 
	 * @param q1: the entire queue
	 */
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
	
	/**
	 * dequeues the user-entered String if the queue is not already empty
	 * 
	 * @param q1: the entire queue
	 */
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
	
	/**
	 * Displays all the valid options for commands
	 */
	private static void displayMenu()
	{
		System.out.println();
		
		System.out.println("Here are the commands:");
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
