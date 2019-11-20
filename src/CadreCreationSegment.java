
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Composant responsable de la creation  interactive d'un segment. Dans cette version deux modes de creation sont disponibles.
 * Le 1er mode consiste e designer successivement, en cliquant e chaque fois le bouton gauche de souris,
 * les deux extremites du segment.
 * Le 2eme mode consiste e designer la 1ere extremite du segment en enfoneant le bouton gauche
 * puis e designer la 2eme extremite en relechant le bouton gauche.
 * L'utilisateur doit donc deplacer la souris avec le bouton gauche enfonce (dragging the mouse = litteralement : en traenant la souris)
 * e chaque instant de ce deplacement, l'appli trace le segment
 */
public class CadreCreationSegment extends Frame implements MouseListener, MouseMotionListener {

    public MonCanvas canvas; // pour dessiner dessus
    public exostate.maquette.Segment segment;     // le segment e creer

    /* les composants graphiques de l'appli */

    public TextField resultat, operationEnCours;
    Label labelPresentation, labelResultat, labelGuide;
    public exostate.maquette.ComposantCoordonnees composantCoordonnees;
    public Panel panelNord, panelSud, panelSudHaut, panelSudBas;


    /* les contreleurs d'etat : il en faut autant que d'etats dans le diagramme + le contreleur courant */

    ControllerFirstReleased controllerFirstReleased;
    ControllerSecondReleased controllerSecondReleased;

    ControllerState currentControllerState;

    /* e completer ...*/

    /**
     * @param arg0
     * @throws HeadlessException
     */
    public CadreCreationSegment(String arg0) throws HeadlessException {
        super(arg0);
        exostate.maquette.Outils.place(this, 0.25, 0.25, 0.6, 0.6); // positionne et dimensionne la fenetre this

        /* placement des composants GUI */


        this.setBackground(Color.LIGHT_GRAY);
        this.add(new Label(" "), BorderLayout.WEST);
        this.add(new Label(" "), BorderLayout.EAST);
        this.panelNord = new Panel();
        this.add(this.panelNord, BorderLayout.NORTH);
        this.labelPresentation = new Label("Creation interactive d'un segment");
        this.panelNord.add(this.labelPresentation);

        /* e present le composant pour afficher les coordonnees du pointeur de souris */

        this.composantCoordonnees = new exostate.maquette.ComposantCoordonnees("pointeur de souris");
        this.panelNord.add(this.composantCoordonnees);

        this.canvas = new MonCanvas(this);
        this.add(this.canvas, BorderLayout.CENTER);
        this.canvas.setBackground(Color.WHITE);

        /* installation du panneau sud */

        this.panelSud = new Panel();
        this.add(this.panelSud, BorderLayout.SOUTH);
        this.panelSud.setLayout(new GridLayout(3, 1));
        //this.panelSudHaut = new Panel(); this.panelSud.add(this.panelSudHaut);

        this.labelGuide = new Label("operation en cours :");
        this.panelSud.add(this.labelGuide);
        this.operationEnCours = new TextField("Ceci est une maquette de l'appli e concevoir. Partez de ce code source et modifiez le et completez le ...", 100);
        this.operationEnCours.setEditable(false);
        this.panelSud.add(this.operationEnCours);
        this.panelSudBas = new Panel();
        this.panelSud.add(this.panelSudBas);
        this.labelResultat = new Label("segment cree");
        this.panelSudBas.add(this.labelResultat);
        this.resultat = new TextField("", 16);
        this.resultat.setEditable(false);
        this.panelSudBas.add(this.resultat);

        /* installation du diagramme de transition d'etats */

        installeContreleurs();

        this.canvas.addMouseListener(this);
        this.canvas.addMouseMotionListener(this);

        /* cree le segment degenere [(0,0) (0,0)] */
        this.segment = new exostate.maquette.Segment();


        /* les 3 instructions suivantes constituent un exemple qui ne doit plus figurer dans l'appli definitive */

//    this.segment.setA(40, 30);
//    this.segment.setB(480,210);
//    this.resultat.setText(this.segment.toString());
    }

    /* installation du diagramme de transition d'etats : c-e-d met en place les contreleurs et les relie entre eux */
    private void installeContreleurs() {

        /* creation des contreleurs avec leur liens "successeurs" */
        controllerFirstReleased = new ControllerFirstReleased(this, null, null);
        controllerSecondReleased = new ControllerSecondReleased(this, new ControllerFirstReleased(this, null, null), null);
        /* ... */
        controllerFirstReleased.next = controllerSecondReleased;

        /* installation des liens "predecesseur" */
        controllerSecondReleased.previous = controllerFirstReleased;

        /* ... */

        currentControllerState = controllerFirstReleased;

    } //installeContreleurs


    /* (non-Javadoc)
     * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseDragged(MouseEvent arg0) {
        // e definir
        System.err.println("appel e mouseDragged(...)"); // instruction e eliminer  dans la version definitive de l'appli
        //currentControllerState.treat(arg0);
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseMoved(MouseEvent arg0) {
        // e definir
        // l'instruction suivante n'est qu'un exemple e remplacer par le code adequat
        this.composantCoordonnees.set(arg0.getX(), arg0.getY());
        //currentControllerState.treat(arg0);
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
     */
    @Override
    public void mousePressed(MouseEvent arg0) {
        // e definir
        System.err.println("appel e mousePressed(...)"); // instruction e eliminer  dans la version definitive de l'appli
       // currentControllerState.treat(arg0);
        currentControllerState.treat(arg0);
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseReleased(MouseEvent arg0) {
        // e definir
        System.err.println("appel e mouseReleased(...)"); // instruction e eliminer dans la version definitive de l'appli

    }


    /* -------------------- Il est inutile de gerer les evenements suivants -------------------------- */


    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseClicked(MouseEvent arg0) {/* rien e faire */}


    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseEntered(MouseEvent arg0) {/* rien e faire */}

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseExited(MouseEvent arg0) {/* rien e faire */}


}
