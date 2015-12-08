
/******************************************************************************
*
* Savion Sample
* Queue Class
* Description: 
* Handles all queue related actions: enqueue, dequeue, check if full/empty,
* print queue contents, and show all specific queue data
*
******************************************************************************/

class Queue
{
	private String[] queue;
	private int front;
	private int back;
	private int size;
	private int numEntries;
	
	public Queue(int arrSize)
	{
		if (arrSize < 0)
		{
			numEntries = 0;
		}
		else
		{
			size = arrSize;
		}
			
		queue = new String[arrSize];
		front = 0;
		back = 0;
		numEntries = 0;
	}
	
	/**
	 * Adds a string to the queue if there is space
	 * Note: position wraps back to 0 if the end of the queue is reached
	 * 
	 * @param s: the string that will be queued
	 */
	public void enqueue(String s)
	{
		if (!isFull())
		{
			numEntries++;
			queue[back] = s;
			back++;
			back = back % size;
		}
	}
	
	/**
	 * Removes a string from the queue if it is not already empty
	 * Note: position wraps back to 0 if the end of the queue is reached
	 */
	public String dequeue()
	{
		if (!isEmpty())
		{
			numEntries--;
			String temp = queue[front];
			front++;
			front = front % size;
			return temp;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Check to see if queue is full
	 * 
	 * @return: true if full, false otherwise
	 */
	public boolean isFull()
	{
		return numEntries >= size;
	}
	
	/**
	 * Check to see if queue is empty
	 * 
	 * @return: true if empty, false otherwise
	 */
	public boolean isEmpty()
	{
		return numEntries == 0;
	}
	
	/**
	 * Converts the queue to a string and returns it
	 * Note: position wraps back to 0 if the end of the queue is reached
	 */
	public String toString()
	{
		String queueAsString = "";
		
		int count = front;
		for (int i = 0; i < numEntries; i++)
		{
			count = count % size;
			queueAsString += queue[count] + " ";
			count++;
		}
		return queueAsString;
	}
	
	/**
	 * prints the queue from position 0 to length - 1, the position of the
	 * front and back of the queue, and the length of the queue.
	 * Note: the position of the front is inclusive, and exclusive for the back
	 */
	public String getDataAsString()
	{
		String dataAsString = "";
		
		for (int i = 0; i < size; i++)
		{
			dataAsString += queue[i] + " ";	
		}

		dataAsString += "\nFront: " + front + "\nBack: " + back +
						"\nLength of queue: " + numEntries;
		
		return dataAsString;
	}
	
}                   