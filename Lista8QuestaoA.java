import java.util.Scanner;

public class Lista8QuestaoA {   // UVA10130

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();				// numero de casos teste
		
		while(T>0) {
			int N = in.nextInt();			// numero de objetos
			int[][] PD = new int[1001][1001]; 	// array para a programacao dinamica
			int[] p = new int[1001];			// array para preços
			int[] w = new int[1001];			// array para pesos
			int resposta = 0;
			int soma = 0;
			
			for(int i=1; i<=N; i++) {
				int P = in.nextInt();		// price
				int W = in.nextInt();		// weight
				p[i] = P;
				w[i] = W;
			}

			int G = in.nextInt();		// numero de pessoas no grupo
			for(int i=0; i<G; i++) {
				int MW = in.nextInt();	// max weight
				soma = promocao(PD, N, MW, p, w);
				resposta = resposta + soma;
			}
			
			System.out.println(resposta);
			
			T--;
		}
		
	}
	
	// knapsack
	static int promocao(int[][] PD, int n, int mw, int[] p, int[] w) {
		for(int i = 0; i<=n; i++) {
			for(int j = 0; j<=mw; j++) {
				if(i==0 || j==0) {
					PD[i][j] = 0;
				} else if(w[i]<=j) {
					PD[i][j] = max(PD[i-1][j], p[i] + PD[i-1][j-w[i]]);
				} else {
					PD[i][j] = PD[i-1][j];						
				}
			}
		}
		return PD[n][mw];
	}

	// ok
	static int max(int x, int y) {
		int max;
		if (x > y) {
			max = x;
		} else {
			max = y;
		}
		return max;
	}

}
