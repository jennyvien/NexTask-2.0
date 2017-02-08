/**
 * This class represents a task object. 
 * @author Jenny
 */
public class Task {
	// Fields
	private String specification;

	// Constructors
	public Task() {
		this.specification = "";
	}
	
	public Task(String specification) {
		this.specification = specification;
	}
	
	// Getters and Setters
	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}
	
	// Methods
	public String toString() {
		return this.specification;
	}
	
}
