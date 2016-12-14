/*
* @Author:        Alain Stulz
* @Matriculation: 16-119-414
*/

public class Queue {
    QueueObject first = null;

    /// Appends the given object to the end of the queue
    public void enqueue(Object object)  {
    	QueueObject newObject = new QueueObject(object);

    	if (first != null) {
    		// Append to end of list
    		last().setNext(newObject);
    		return;
    	}

    	first = newObject;
    }

    /// Pops and returns the first item in the queue
    public Object dequeue() throws EmptyQueueException {
    	if (first == null) {
    		throw new EmptyQueueException("The Queue is empty!");
    	}

    	Object value = first.value();
    	first = first.next();
    	return value;
    }

    public Boolean isEmpty() {
    	return first == null;
    }

    /// Gets the last/youngest item in the queue
    public QueueObject last() {
    	QueueObject last = first;
    	while (last.hasNext()) {
    		last = last.next();
    	}
    	return last;
    }
}

class QueueObject {
	private Object value = null;
	private QueueObject next = null;

	// Initializer
	public QueueObject(Object value) {
		this.value = value;
	}

	// item

	public Object value() {
		return this.value;
	}

	// next

	public void setNext(QueueObject next) {
		this.next = next;
	}

	public QueueObject next() {
		return next;
	}

	public Boolean hasNext() {
		return next != null;
	}
}