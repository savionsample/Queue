
/******************************************************************************
*
* Savion Sample
* Queue Class
* Description: 
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
			arrSize = 0;
		}
		else
		{
			size = arrSize;
		}
			
		queue = new String[arrSize];
		front = -1;
		back = -1;
		numEntries = 0;
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
	 * Check to see if queue is full
	 * 
	 * @return: true if full, false otherwise
	 */
	public boolean isFull()
	{
		return numEntries >= size;
	}
	
	/**
	 * Adds a string to the queue if there is space
	 * 
	 * @param s: the string that will be queued
	 */
	public void enqueue(String s)
	{
		if (!isFull() && numEntries <= size)
		{
			back = (back + 1) % size;
			queue[back] = s;
		}
		numEntries++;
	}
	
	/**
	 * Removes a string from the queue if it is not already empty
	 */
	public String dequeue()
	{
		if (!isEmpty())
		{
			String temp = queue[front + 1];
			front++;
			numEntries--;
			return temp;
		}
		else
		{
			numEntries--;
			return null;
		}
	}
	
	/**
	 * Converts the queue to a string and returns it
	 */
/*	public String toString()
	{
		String queueAsString = "";
		for(int i = front; i >= 0; i--)
		{
			queueAsString = queueAsString + i + " : " + queue[i] + '\n';
		}
		return queueAsString;
	}*/
	
	public String toString()
	{
		String queueAsString = "";
		
		if (back > front)
		{
			for (int i = front + 1; i <= back; i++)
			{
				queueAsString += queue[i] + " ";
			}
		}
		else
		{
			String[] newArr = new String[size];
			rearrangeArrayAtBeginning(newArr);
			
			for (int i = 0; i < size; i++)
			{
				if (newArr[i] != null)
				{	
					queueAsString += queue[i] + " ";
				}
			}
		}
		return queueAsString;
	}
	
	/**
	 * prints the queue from position 0 to length - 1, the position of the
	 * front and back of the queue, and the length of the queue
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
	
	/**
	 * recreates a temporary queue without any wrapping
	 * 
	 * @param newArr: the temporary rearranged queue
	 */
	private void rearrangeArrayAtBeginning(String[] newArr)
	{
		int count = 0;
		int reset = front + 1;

		for (int i = 0; i < numEntries; i++)
		{
			newArr[count] = queue[reset];
			reset++;
			reset = reset % (size);
			count++;
		}
	}
}