import exostate.maquette.Segment;

import java.awt.event.MouseEvent;

public abstract class ControllerState {
    public CadreCreationSegment cadreCreationSegment;
    public ControllerState next, previous;


    public ControllerState(CadreCreationSegment cadreCreationSegment, ControllerState next, ControllerState previous) {
        this.cadreCreationSegment = cadreCreationSegment;
        this.next = next;
        this.previous = previous;
    }

    public void mouseTyped(MouseEvent arg0) {
        treat(arg0);
    }

    public abstract void treat(MouseEvent arg0) ;

    public boolean treatBack(MouseEvent arg0) {
        if(arg0.getButton() == MouseEvent.BUTTON3) {
            cadreCreationSegment.segment = new Segment();
            return true;
        }
        return false;
    }
}
