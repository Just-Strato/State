import java.awt.event.MouseEvent;

public abstract class ControllerReleased extends ControllerState{

    public ControllerReleased(CadreCreationSegment cadreCreationSegment, ControllerState next, ControllerState previous) {
        super(cadreCreationSegment, next, previous);
    }

    public void treat(MouseEvent arg0) {
        if(arg0.getButton() == MouseEvent.BUTTON1) {
            treatReleased(arg0);
            cadreCreationSegment.currentControllerState = next;
        }
    }

    protected abstract void treatReleased(MouseEvent arg0);
}
