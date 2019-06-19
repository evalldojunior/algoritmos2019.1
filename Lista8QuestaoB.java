import java.util.Scanner;

public class Lista8questaoB {   // UVA10405

	public static void main(String[] args) {
		Scanner in =  new Scanner(System.in);
		
		String a, b;
		int tamanho1, tamanho2;
		
		while(in.hasNext()) {
			
			int[][] PD = new int[1000][1000]; 	// array para a programacao dinamica
			
			a = in.nextLine();					// primeira string
			b = in.nextLine();					// segunda string
			
			tamanho1 = a.length();
			tamanho2 = b.length();
			
			char[] a1 = a.toCharArray();
			char[] b1 = b.toCharArray();
			
			int resposta = LCS(PD, a1, b1, tamanho1, tamanho2);
			
			System.out.println(resposta);
		}
	}
	
	// ok
	static int LCS(int[][] PD, char[] a1, char[] b1, int tamanho1, int tamanho2) {
		for(int i = 0; i<=tamanho1; i++) {
			for(int j = 0; j<=tamanho2; j++) {
				if(i==0 || j==0) {
					PD[i][j] = 0;
				} else if(a1[i-1]==b1[j-1]) {
					PD[i][j] = PD[i-1][j-1] + 1;
				} else {
					PD[i][j] = max(PD[i-1][j], PD[i][j-1]);
				}
			}
		}
		return PD[tamanho1][tamanho2];
	}
	
	// ok
	static int max(int x, int y) {
		int max;
	    if(x>y) {
	    	max = x;
	    } else {
	    	max = y;
	    }
	    return max;
	}
}
