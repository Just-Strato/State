import java.awt.event.MouseEvent;

public class ControllerSecondReleased extends ControllerReleased{

    public ControllerSecondReleased(CadreCreationSegment cadreCreationSegment, ControllerState next, ControllerState previous) {
        super(cadreCreationSegment, next, previous);
    }

    public void treat(MouseEvent arg0) {
        if (treatBack(arg0)) {
            cadreCreationSegment.currentControllerState = previous;
            cadreCreationSegment.resultat.setText(cadreCreationSegment.segment.toString());
        } else {
            treatReleased(arg0);
        }
    }

    @Override
    protected void treatReleased(MouseEvent arg0) {
        cadreCreationSegment.segment.setB(arg0.getX(), arg0.getY());
        cadreCreationSegment.resultat.setText(cadreCreationSegment.segment.toString());
        System.out.println("On a clické sur le bouton gauche !");
    }
}
