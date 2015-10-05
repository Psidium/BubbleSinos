package br.unisinos.lb2.trabalhos.bubblesinos;

/**
 * ATENÇÃO!
 *
 * REQUISITO (OBRIGATÓRIO): - As assinaturas do métodos abaixo não podem ser
 * alteradas e nenhum método PUBLICO ou de pacote pode se criado.
 *
 * @author NOME DOS ALUNOS DO GRUPO
 */
public class BubbleMatrix {

   private int matriz[][];
   private int largura;
   private int altura;
   private int linhaDeBase;

   public BubbleMatrix(int largura, int altura) {
      this.largura = largura;
      this.altura = altura;
      inicializaMatriz(largura, altura);
   }

   public int[][] getMatriz() {
      return matriz;
   }

   public void setMatriz(int[][] matriz) {
      this.matriz = matriz;
   }

   public int getLargura() {
      return largura;
   }

   public void setLargura(int largura) {
      this.largura = largura;
   }

   public int getAltura() {
      return altura;
   }

   public void setAltura(int altura) {
      this.altura = altura;
   }

   public int getLinhaDeBase() {
      return linhaDeBase;
   }

   public void setLinhaDeBase(int linhaDeBase) {
      this.linhaDeBase = linhaDeBase;
   }

   public void incrementaLinhaBase() {
      linhaDeBase++;
   }

   public void inicializaMatriz(int larg, int alt) {
      // TODO: inicializar / criar a matriz de elementos. Inicilizar linha de base, também.
       matriz = new int[alt][larg];
       linhaDeBase = 0;
       
        for (int j = 0; j < larg; j++)
            matriz[0][j] = (int) (Math.random() * BubbleSinosPanel.NUM_CORES)+1;
        
        System.out.println(matriz);
   }

   public int eliminaElementosConectados(int col, int lin) {
      // TODO: implementar método recursivo que elimina elementos conectados 
      // a partir posição inicial de parâmetro. O método deve contabilizar e 
      // retornar a quantidade total de elementos eliminados.
      // Dica  : não é possível eliminar elementos sem pelo menos mais um 
      //         conectado.
      // Dica 2: cuidar para a linhaBase seja a última de elementos, pode ser 
      //         necessário decrementar...
      return 0;
   }

   public void adicionaLinhaDeElementosAleatorios() {
      // TODO: adicionar uma linha de elementos na primeira linha da matriz. 
      // Porém antes, deve desloca os já existentes "para baixo".
//        if(linhaDeBase > 0){
//            int[][] temp = new int[this.altura][this.largura];
//
//            for (int i = 1; i < temp.length; i++)
//            {
//                for (int j = 0; j < temp[0].length; j++)
//                    temp[i][j] = this.matriz[i-1][j];
//            }
//
//            for (int j = 0; j < temp[0].length; j++)
//                temp[0][j] = (int) (Math.random() * BubbleSinosPanel.NUM_CORES)+1;
//
//            this.matriz = temp;
//            
//            this.incrementaLinhaBase();
//            
//            System.out.println(matriz);
//        }
   }

   // REMOVI ESTE MÉTODO PORQUE FICOU COMPLEXO PARA O TEMPO DISPONÍVEL. 
//   public void preencheEspacosDosElementosEliminados(int col, int lin) {
//      // TODO: preencher espaços deixados pela eliminação de elementos na matriz.
//      //       Regras:
//      //       1 - descer todos os elementos acima, na mesma coluna, até a 
//      //           linha de base;
//      //       2 - cada coluna com espaços vazios deve ser preenchida com números
//      //           aleatórios até encontrar um elemento preenchido ou a linha de 
//      //           base.
//   }

   public int getElemento(int x, int y) {
      return matriz[x][y];
   }

   public int adicionaElementoNaColuna(int col, int tipoElemento) throws ArrayIndexOutOfBoundsException{
      // TODO: considere a coluna em que o jogador optou. Deve-se deixar um elemento
      //       na primeira linha (de baixo para cima) que esteja vazia. Considere
      //       também que o jogo possui uma linhaBase (linha da última jogada).
      //       Deve retornar em qual linha foi adicionado elemento da coluna.
      //       Dica: cuide que, se o elemento foi adicionado após linhaBase!
        if (col > matriz[0].length)
            throw new ArrayIndexOutOfBoundsException();

        if(this.matriz[linhaDeBase][col-1]==0){
            this.matriz[linhaDeBase][col-1] = tipoElemento;
            return linhaDeBase;
        }
        else{
            this.matriz[linhaDeBase+1][col-1] = tipoElemento;
            incrementaLinhaBase();
            return linhaDeBase;
        }
   }
   

   @Override
   public String toString() {
      // TODO: fazer algoritmo que imprime matriz no formatada com bordas 
      // formadas pelos caracteres: +, - e |
       String imp = "";
        for (int a = 0; a < matriz[0].length; a++)
            imp +="+---";
        imp+="+";
        
        imp+="\n";
        for (int i = 0; i < matriz.length; i++){
            imp+="|";
            for (int j = 0; j < matriz[0].length; j++)
                imp+=" " + matriz[i][j] + " |";
            imp+="\n";
            for (int a = 0; a < matriz[0].length; a++)
                imp+="+---";
            imp+="+";
            imp+="\n";
        }
      return imp;
   }
}
