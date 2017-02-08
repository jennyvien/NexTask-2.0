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

public class NexTaskView {
	
	private final String APP_NAME = "NexTask.";
	private final int SPACING = 50;
	protected Shell shell;
	private Text inputField;
	private List taskList;
	private Button nexTaskButton;
	private int componentWidth = getWidth() - SPACING;
			
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
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shell.setSize(getWidth(), getHeight());
		shell.setText(APP_NAME);
		RowLayout rl_shell = new RowLayout(SWT.VERTICAL);
		rl_shell.fill = true;
		rl_shell.center = true;
		shell.setLayout(rl_shell);
		shell.setMaximized(false);
		
		nexTaskButton = new Button(shell, SWT.NONE);
		nexTaskButton.setFont(SWTResourceManager.getFont("Georgia", 40, SWT.NORMAL));
		nexTaskButton.setLayoutData(new RowData(componentWidth, (int)(getHeight() * .1)));
		nexTaskButton.setText(APP_NAME);
		
		taskList = new List(shell, SWT.BORDER);
		taskList.setLayoutData(new RowData(componentWidth, (int)(getHeight() * .75)));
		
		inputField = new Text(shell, SWT.BORDER);
		inputField.setTouchEnabled(true);
		inputField.setLayoutData(new RowData(componentWidth, (int)(getHeight() * .098) ));
		

	}
	
	public int getWidth() {
		return Toolkit.getDefaultToolkit().getScreenSize().width / 5;
	}
	
	public int getHeight() {				
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
	}
	
	
}
