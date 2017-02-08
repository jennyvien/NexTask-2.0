/**
 * Contains main method for NexTask.
 * @author Jenny
 *
 */
public class NexTaskDriver {
	public static void main(String[] args) {
//		TaskList list = new TaskList();
//		
//		list.add(new Task("Test1"));
//		list.add(new Task("Test2"));
//		list.add(new Task("Test3"));
//		
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i));
//
//		}
//		
//		TaskListCollection taskListCollection = new TaskListCollection();
//		taskListCollection.put("Test", list);
		
		try {
			TaskList taskList = new TaskList("New List");
			NexTaskView window = new NexTaskView();
			NexTaskController controller = new NexTaskController(window, taskList);
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
