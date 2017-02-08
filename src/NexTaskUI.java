import javax.swing.*;
import javax.swing.event.*;

import java.awt.BorderLayout;
import java.awt.event.*;

public class NexTaskUI extends JFrame {
	// ... Constants
	private static final String ADD = "Add";
	// ... Components
	private JList list;
	private DefaultListModel listModel;
	private JTextField inputTextField;
	private JButton addButton;
	
	public NexTaskUI() {
		// ... Create the list and put into scroll pane.
		listModel = new DefaultListModel();
		listModel.addElement("TEMP1");
		listModel.addElement("TEMP2");
		listModel.addElement("TEMP3");	
		list = new JList(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.setVisibleRowCount(20);
		JScrollPane listScrollPane = new JScrollPane(list);
		
		addButton = new JButton(ADD);
		inputTextField = new JTextField(50);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.add(inputTextField);
		bottomPanel.add(addButton);
		
		this.add(listScrollPane, BorderLayout.CENTER);
		this.add(bottomPanel, BorderLayout.PAGE_END);
	}
	
	public void addListSelectionListener(ListSelectionListener listener) {
		list.addListSelectionListener(listener);
	}
	
	public void addAddButtonListener(ActionListener listener) {
		addButton.addActionListener(listener);
	}
	
}
