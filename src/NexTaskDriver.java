/**
 * Contains main method for NexTask.
 * @author Jenny
 *
 */
public class NexTaskDriver {
	public static void main(String[] args) {
		try {
			TaskList taskList = new TaskList("New List");
			NexTaskView window = new NexTaskView(taskList);
			NexTaskController controller = new NexTaskController(window, taskList);
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
