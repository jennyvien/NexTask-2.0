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
				if(!view.isEditMode()) {
					taskList.add(new Task(view.getText()));
				} else {
					taskList.edit(view.getItemInEdit(), view.getText());
					view.setEditMode(false);
				}
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
			int i = view.getItemInFocus();
			if(e.character == '\r') {
				view.editItem(i);
			} else if(e.character == SWT.DEL) {
				taskList.remove(i);
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {}
		
	}

}
