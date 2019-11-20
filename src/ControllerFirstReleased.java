import java.awt.event.MouseEvent;

public class ControllerFirstReleased extends ControllerReleased{

    public ControllerFirstReleased(CadreCreationSegment cadreCreationSegment, ControllerState next, ControllerState previous) {
        super(cadreCreationSegment, next, previous);
    }

    @Override
    protected void treatReleased(MouseEvent arg0) {
        cadreCreationSegment.segment.setA(arg0.getX(), arg0.getY());
        cadreCreationSegment.resultat.setText(cadreCreationSegment.segment.toString());
        System.out.println("On a clické sur le bouton gauche !");
    }
}
