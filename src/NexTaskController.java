import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;

/**
 * Controller modifies model and updates view.
 * Controller processes
 * @author Jenny
 *
 */

public class NexTaskController {
	
	private NexTaskView view;
	private TaskList taskList;
	public void addTask(String str) {}
	public void deleteTask() {}
	public void editTask(int i, String str) {}
	
	NexTaskController(NexTaskView view, TaskList list) {
		this.view = view;
		this.taskList = list;
		this.view.addEnterKeyListener(new EnterKeyListener());
	}
	
	class EnterKeyListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.character == '\r') {
				System.out.println("hi");
				String taskSpec = view.getText();
				taskList.add(new Task(taskSpec));
				view.addTask(taskSpec);
				view.clearText();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
