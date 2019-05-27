import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Lista5QuestaoB {		// UVA12160
	
	public static int MOD = 10000;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int l, u, r;
		l = in.nextInt();
		u = in.nextInt();
		r = in.nextInt();
		int[] RV = new int[10];
		int testcases=0;
		
		while(l!=0 || u!=0 || r!=0) {
			
			for(int i=0; i<r; i++) {
				RV[i]= in.nextInt();
			}
			
			int[] array = new int[MOD];
			for(int i=0; i<array.length; i++) {
				array[i] = Integer.MAX_VALUE;
			}
			
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(l);
			array[l] = 0;
			
			while (!queue.isEmpty()) {
				
				if(array[u]!=Integer.MAX_VALUE) {
					break;
				}
				
				int j = queue.poll();
				
				for (int i=0; i<r; i++) {
					int temp = (j+RV[i])%MOD;
					if((array[j]+1)<array[temp]) {
						queue.add(temp);
						array[temp] = array[j]+1;
					}
				}
			}
			
			// imprimindo a resposta
			String resposta = "";
			if(array[u]!=Integer.MAX_VALUE) {
				resposta = Integer.toString(array[u]);
			} else {
				resposta = "Permanently Locked";
			}
			System.out.println("Case " + ++testcases + ": " + resposta);
			
			l = in.nextInt();			// lendo novamente a entrada para os proximos casos testes
			u = in.nextInt();			// 0 0 0 termina o programa
			r = in.nextInt();
		}
	}
}
