import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;

/**
 * Controller modifies model and updates view.
 * 
 * @author Jenny
 *
 */

public class NexTaskController {

	private NexTaskView view;
	private TaskList taskList;

	NexTaskController(NexTaskView view, TaskList list) {
		this.view = view;
		this.taskList = list;
		this.view.addTextFieldKeyListener(new TextFieldKeyListener());
		this.view.addListKeyListener(new ListKeyListener());

	}

	/**
	 * Listener for text field. It detects if the enter key has been pressed. If
	 * so, it will add the new task to the list.
	 */
	class TextFieldKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.character == '\r') {
				String taskSpec = view.getText();
				taskList.add(new Task(taskSpec));
				view.clearText();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

	}

	class ListKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.character == '\r') {
				System.out.println("ENTER DETECTED");
			} else if(e.character == SWT.DEL) {
				System.out.println("DELETE DETECTED");
				int i = view.getItemInFocus();
				taskList.remove(i);
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {}
		
	}

}
