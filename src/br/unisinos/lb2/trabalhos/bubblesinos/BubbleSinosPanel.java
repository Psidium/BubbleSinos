package br.unisinos.lb2.trabalhos.bubblesinos;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Gabriel Borges Fernandes
 * @author Cássia Canto Schuch
 */
public class BubbleSinosPanel extends javax.swing.JPanel {

//   private static Color cores[] = {Color.BLUE, Color.CYAN, Color.GREEN, Color.ORANGE, Color.YELLOW, Color.RED, Color.BLACK};
	private static Color cores[] = {Color.BLUE, Color.CYAN, Color.GREEN, Color.YELLOW, Color.RED};
	public static final int NUM_CORES = 5;
	private BubbleMatrix matrix;

	/**
	 * Creates new form BubbleSinosPanel
	 */
	public BubbleSinosPanel() {
		setBackground(Color.gray);
		initComponents();
		matrix = null;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      setLayout(null);
   }// </editor-fold>//GEN-END:initComponents
   // Variables declaration - do not modify//GEN-BEGIN:variables
   // End of variables declaration//GEN-END:variables

	public BubbleMatrix getMatrix() {
		return matrix;
	}

	public void setMatrix(BubbleMatrix matrix) {
		this.matrix = matrix;
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g); //To change body of generated methods, choose Tools | Templates.
		if (matrix == null) {
			return;
		}

		int w = this.getWidth() / matrix.getLargura();
		System.out.println("W: " + w);

		g.setColor(Color.BLACK);
		for (int y = 0; y < matrix.getAltura(); y++) {
			g.drawLine(0, y * w, getWidth() - 1, y * w);
		}
		for (int x = 0; x < matrix.getLargura(); x++) {
			g.drawLine(x * w, 0, x * w, getHeight() - 1);
		}

		for (int y = 0; y < matrix.getLinhaDeBase() + 1; y++) {
			int yy = y * w;
			for (int x = 0; x < matrix.getLargura(); x++) {
				int elemento = matrix.getElemento(x, y);
				if (elemento > 0) {
					g.setColor(getCorElemento(elemento));
					g.fill3DRect(x * w, yy, w, w, true);
				}
			}
		}
	}

	public static Color getCorElemento(int elemento) {
		return cores[elemento - 1];
	}
}
