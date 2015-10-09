package br.unisinos.lb2.trabalhos.bubblesinos;

/**
 *
 * @author Gabriel Borges Fernandes
 * @author Cássia canto Schuch
 */
public class BubbleSinos {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		BubbleMatrix matrix = new BubbleMatrix(5, 8);
		BubbleSinosFrame frame = new BubbleSinosFrame();
		frame.setMatrix(matrix);
		frame.setVisible(true);
	}
}
