package br.unisinos.lb2.trabalhos.bubblesinos;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * ATENÇÃO!
 *
 * REQUISITO (OBRIGATÓRIO): - As assinaturas do métodos abaixo não podem ser
 * alteradas e nenhum método PUBLICO ou de pacote pode se criado.
 *
 * @author Cássia Canto Schuch, Gabriel Borges Fernandes
 */
public class BubbleMatrix {

	private int[][] matriz;
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
		matriz = new int[larg][alt];
		linhaDeBase = 0;
	}

	public int eliminaElementosConectados(int col, int lin) {
		// TODO: implementar método recursivo que elimina elementos conectados 
		// a partir posição inicial de parâmetro. O método deve contabilizar e 
		// retornar a quantidade total de elementos eliminados.
		// Dica  : não é possível eliminar elementos sem pelo menos mais um 
		//         conectado.
		// Dica 2: cuidar para a linhaBase seja a última de elementos, pode ser 
		//         necessário decrementar...

		int cor = matriz[col][lin];
		//testa a existencia dos vizinhos, quando existir salva o valor
		int vizinhoCima = 0;
		int vizinhoEsquerda = 0;
		int vizinhoBaixo = 0;
		int vizinhoDireita = 0;
		try {
			vizinhoCima = matriz[col][lin - 1];
		} catch (ArrayIndexOutOfBoundsException ex) {
		}
		try {
			vizinhoEsquerda = matriz[col - 1][lin];
		} catch (ArrayIndexOutOfBoundsException ex) {
		}
		try {
			vizinhoBaixo = matriz[col][lin + 1];
		} catch (ArrayIndexOutOfBoundsException ex) {
		}
		try {
			vizinhoDireita = matriz[col + 1][lin];
		} catch (ArrayIndexOutOfBoundsException ex) {
		}

		//se todos os 4 vizinhos forem diferentes, retorna zero
		if (cor != vizinhoCima
				&& cor != vizinhoEsquerda
				&& cor != vizinhoBaixo
				&& cor != vizinhoDireita) {
			return 0;
		}

		return eliminaElementosConectados(col, lin, matriz[col][lin]);
	}

    // Essa recursão segue um padrão +- assim:
    //                                      +-  * ponto ......
    //                                      +          
    //                                      +-  * ponto ......
    //                                      +         
    //            +-  * ponto --------------+-  * ponto ......
    //            +                         +        
    //            +-  * ponto  não é cor |  +-  * ponto ...... 
    //  * ponto --+                                 
    //            +-  * ponto --------------+-  * ponto ......
    //            +                         +      
    //            +-  * ponto  não é cor |  +-  * ponto ......
    //                                      +     
    //                                      +-  * ponto ......
    //                                      +    
    //                                      +-  * ponto ......
	private int eliminaElementosConectados(int col, int lin, int cor) {
		try {
            //se o ponto nao é da cor, não adiciona ponto e para a recursão
			if (matriz[col][lin] != cor) {
				return 0;
			}
		} catch (ArrayIndexOutOfBoundsException ar) {
            //do mesmo, se o ponto não existir, para a recursão
			return 0;
		}
        //zera o valor que havia lá
		matriz[col][lin] = 0;
        //testa todos os vizinhos, adicionando 1 na volta da stack
		return 1
				+ eliminaElementosConectados(col + 1, lin, cor)
				+ eliminaElementosConectados(col, lin + 1, cor)
				+ eliminaElementosConectados(col - 1, lin, cor)
				+ eliminaElementosConectados(col, lin - 1, cor);
	}

	public void adicionaLinhaDeElementosAleatorios() {
		// TODO: adicionar uma linha de elementos na primeira linha da matriz. 
		// Porém antes, deve desloca os já existentes "para baixo".

		for (int j = 0; j < matriz.length; j++) {
			for (int i = matriz[j].length - 1; i > 0; i--) {
				matriz[j][i] = matriz[j][i - 1];
			}
		}
        //substitui o que tiver na primeira linha com uma nova combinacao
		for (int i = 0; i < matriz.length; i++) {
			matriz[i][0] = (int) (Math.random() * BubbleSinosPanel.NUM_CORES) + 1;
		}

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

	public int adicionaElementoNaColuna(int col, int tipoElemento) {
		// TODO: considere a coluna em que o jogador optou. Deve-se deixar um elemento
		//       na primeira linha (de baixo para cima) que esteja vazia. Considere
		//       também que o jogo possui uma linhaBase (linha da última jogada).
		//       Deve retornar em qual linha foi adicionado elemento da coluna.
		//       Dica: cuide que, se o elemento foi adicionado após linhaBase!
        
        //gira pela coluna
		for (int i = matriz[col].length - 1; i >= 0; i--) {
            //procura um que tenha valor
			if (matriz[col][i] != 0) {
                //adiciona no anterior o quadrado
				matriz[col][i + 1] = tipoElemento;
				return i + 1;
			}
		}
        //se chegou aqui, é porque toda a coluna ta vazia, entao coloca na primeiro linha mesmo
                matriz[col][0] = tipoElemento;
		return 0;


        //CASSIA: QUE QUE O SOR QUER COM A LINHA DE BASE AQUI MDDSDOCEU
	}

        
	@Override
	public String toString() {
		// TODO: fazer algoritmo que imprime matriz no formatada com bordas 
		// formadas pelos caracteres: +, - e |
		String imp = "";
		for (int a = 0; a < matriz.length; a++) {
			imp += "+---";
		}
		imp += "+";

		imp += "\n";
		for (int j = 0; j < matriz[0].length; j++) {
			imp += "|";
			for (int i = 0; i < matriz.length; i++) {
				imp += " " + matriz[i][j] + " |";
			}
			imp += "\n";
			for (int a = 0; a < matriz.length; a++) {
				imp += "+---";
			}
			imp += "+";
			imp += "\n";
		}
		return imp;
	}
}
