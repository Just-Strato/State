package exostate.maquette;

import java.awt.*;

/**
 * Petit composant graphique utile pour afficher les coordonnees du pointeur de souris, par exemple.
 * 
 * Affiche un libelle puis deux coordonnees reelles libellees x et y (cf. maquette de l'appli)
 * 
 * */
public class ComposantCoordonnees extends Panel
{
Label labelTitre;
Label labelX, labelY;
TextField textFieldX, textFieldY;

public ComposantCoordonnees(String titre, double x, double y, boolean isEditable)
{
this.init( titre, Double.toString(x), Double.toString(y), isEditable);
}
 
public void setX(double x){this.textFieldX.setText(Double.toString(x));}
public void setY(double y){this.textFieldY.setText(Double.toString(y));}

public ComposantCoordonnees(String titre)
{
this.init( titre, "", "", false);
}

private void  init(String titre, String x, String y, boolean isEditable)
{
this.labelTitre = new Label(titre); this.add(this.labelTitre);
this.labelX = new Label("x"); this.add(this.labelX);
this.textFieldX = new TextField(x,5); this.add(this.textFieldX);
this.labelY = new Label("y"); this.add(this.labelY);
this.textFieldY = new TextField(y,5); this.add(this.textFieldY);
this.textFieldX.setEditable(isEditable);
this.textFieldY.setEditable(isEditable);
}

public void set(double x, double y)
{
this.setX(x);
this.setY(y);
}

}
