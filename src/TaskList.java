import java.util.ArrayList;
import java.util.logging.Level;


public class TaskList extends ArrayList<Task> implements Observable{
	// Fields
	private String name; 
	private ArrayList<Observer> observerList;
	
	// Constructors
	public TaskList() {
		super();
		this.name = "";
		this.observerList = new ArrayList<Observer>();
	}
	
	public TaskList(String name) {
		super();
		this.name = name;
		this.observerList = new ArrayList<Observer>();
	}
	
	@Override
	public boolean add(Task e) {
		super.add(e);
		notifyObservers();
		return true;
	}
	
	@Override
	public Task remove(int i) {
		if(isIndexInBound(i)) {
			Task deletedTask = super.remove(i);
			notifyObservers();
			return deletedTask;
		} else {
			return new Task();
		}
	}
	
	public void edit(int i, String newSpec) {
		if(isIndexInBound(i)) {
			this.get(i).setSpecification(newSpec);
			notifyObservers();
		}
	}
	
	private boolean isIndexInBound(int i) {
		return (i >= 0 && i < this.size()) ? true : false;
	}
	
	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void addObserver(Observer obj) {
		if(obj == null) {
			throw new NullPointerException();
		} else if(!observerList.contains(obj)) {
			observerList.add(obj);
		}
	}

	@Override
	public void notifyObservers() {
		for(Observer o : observerList) {
			o.update();
		}
	}

	
}
