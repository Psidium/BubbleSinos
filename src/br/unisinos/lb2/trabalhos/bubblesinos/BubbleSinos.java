package br.unisinos.lb2.trabalhos.bubblesinos;

/**
 *
 * @author NOME DOS ALUNOS DO GRUPO
 */
public class BubbleSinos {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      BubbleMatrix matrix = new BubbleMatrix(3, 5);
      BubbleSinosFrame frame = new BubbleSinosFrame();
      frame.setMatrix(matrix);
      frame.setVisible(true);
   }
}
