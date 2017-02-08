import java.util.ArrayList;

public class TaskList extends ArrayList<Task>{
	// Fields
	private String name; 
	
	// Constructors
	public TaskList() {
		super();
		this.name = "";
	}
	
	public TaskList(String name) {
		super();
		this.name = name;
	}
	
	
	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
