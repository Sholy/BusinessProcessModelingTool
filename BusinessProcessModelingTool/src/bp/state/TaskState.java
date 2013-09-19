package bp.state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import bp.gui.BPPanel;
import bp.model.data.Task;

public class TaskState extends BPState {

    public TaskState(BPPanel panel) {
        super(panel);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point position = e.getPoint();
        System.out.println(position);
        Task task = new Task("untitledTask");
        task.getTaskComponent().setX(position.x);
        task.getTaskComponent().setY(position.y);
        task.getTaskComponent().getHandlers().updateHandlers();
        
        getPanel().getProcess().getElements().add(task);
        getPanel().repaint();
    }

    @Override
    public void enteringState() {
        System.out.println("entering task state");
    }

    @Override
    public void exitingState() {
        System.out.println("exiting task state");
    }

}
