import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Toolkit;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import swing2swt.layout.BoxLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.KeyListener;

/**
 * NexTaskView is observing the model. If there are updates in the model, the
 * view will be updated accordingly. 
 * 
 * @author Jenny
 *
 */
public class NexTaskView implements Observer {

	private final String APP_NAME = "NexTask.";
	private final int SPACING = 50;
	protected Shell shell;
	private Text inputField;
	private List taskListView;
	private Button nexTaskButton;
	private int componentWidth = getWidth() - SPACING;
	private TaskList taskList;
	
	private boolean editMode;
	private int itemInEdit;

	public NexTaskView(TaskList list) {
		shell = new Shell();
		nexTaskButton = new Button(shell, SWT.NONE);
		taskListView = new List(shell, SWT.BORDER);
		inputField = new Text(shell, SWT.BORDER);

		this.taskList = list;
		this.taskList.addObserver(this);
		
		this.editMode = false;
		this.itemInEdit = -1;
	}

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shell.setSize(getWidth(), getHeight());
		shell.setText(APP_NAME);
		RowLayout rl_shell = new RowLayout(SWT.VERTICAL);
		rl_shell.fill = true;
		rl_shell.center = true;
		shell.setLayout(rl_shell);
		shell.setMaximized(false);

		nexTaskButton.setFont(SWTResourceManager.getFont("Georgia", 40, SWT.NORMAL));
		nexTaskButton.setLayoutData(new RowData(componentWidth, (int) (getHeight() * .1)));
		nexTaskButton.setText(APP_NAME);

		taskListView.setLayoutData(new RowData(componentWidth, (int) (getHeight() * .75)));

		inputField.setTouchEnabled(true);
		inputField.setLayoutData(new RowData(componentWidth, (int) (getHeight() * .098)));
	}
	
	public void setEditMode(boolean b) {
		this.editMode = b;
	}
	
	public boolean isEditMode() {
		return this.editMode;
	}

	// ... Helper methods to get the height and width of the components 
	public int getWidth() {
		return Toolkit.getDefaultToolkit().getScreenSize().width / 5;
	}

	public int getHeight() {
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
	}
	
	// ... Methods related to the text field
	public String getText() {
		return inputField.getText();
	}

	public void clearText() {
		inputField.setText("");
	}

	public void addTask(String str) {
		taskListView.add(str);
	}
	
	public void addTextFieldKeyListener(KeyListener listener) {
		inputField.addKeyListener(listener);
	}
	
	public int getItemInEdit() {
		return this.itemInEdit;
	}
	
	public void setItemInEdit(int i) {
		this.itemInEdit = i;
	}
	
	public void editItem(int i) {
		this.setEditMode(true);
		this.setItemInEdit(i);
		inputField.setText(taskListView.getItem(i));
		inputField.setFocus();
		inputField.setSelection(inputField.getText().length());
	}
	
	// ... Methods related to the list
	public void addListKeyListener(KeyListener listener) {
		taskListView.addKeyListener(listener);
	}
	
	public int getItemInFocus() {
		return taskListView.getFocusIndex();
	}
	
	@Override
	public void update() {
		taskListView.removeAll();
		for(int i = 0; i < taskList.size(); i++) {
			taskListView.add(taskList.get(i).toString());
		}
	}
	
	

}
