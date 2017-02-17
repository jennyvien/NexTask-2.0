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
	 * Listener for the list! It detects if a modification wants to made to the
	 * list. If the user wants to edit and item on the list, hit enter. If the
	 * user wants to delete an item from the list, hit delete. If the user wants
	 * to mark an item as complete on the list, hit the space bar.
	 */
	class ListKeyListener implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			int i = view.getItemInFocus();
			if (e.character == '\r') {
				view.startEditMode(i);
			} else if (e.character == SWT.DEL) {
				taskList.remove(i);
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}
	}

	/**
	 * Listener for text field. It detects if the enter key has been pressed. If
	 * so, it will add or edit a task accordingly.
	 */
	class TextFieldKeyListener implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.character == '\r') {
				if (!view.isEditMode()) {
					taskList.add(new Task(view.getText()));
				} else {
					taskList.edit(view.getItemInEdit(), view.getText());
					view.endEditMode();
				}
				view.clearText();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}
	}

}
