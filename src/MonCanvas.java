

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;


/**
 * represente "la feuille de papier" sur laquelle les dessins sont effectues
 */
public class MonCanvas extends Canvas {
    CadreCreationSegment cadre;

    /**
     * @param cadre
     */
    public MonCanvas(CadreCreationSegment cadre) {
        this.cadre = cadre;
    }

    /* (non-Javadoc)
     * @see java.awt.Canvas#paint(java.awt.Graphics)
     */
    @Override
    public void paint(Graphics g) {
// e definir
// l'instruction suivante n'est qu'un exemple e remplacer par le code adequat
        this.cadre.segment.trace(g, Color.BLACK);
    }


}
