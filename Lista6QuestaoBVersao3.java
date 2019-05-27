import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.PriorityQueue;

/* ESTA DANDO TLE */

public class Lista6QuestaoBVersao3 {
	
	public static int resposta;
	public static int contador;
	public static int B;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(br); 		// como o monitor pediu
		
		int T = in.nextInt();				// numero de casos testes
		int testcase = 1;					// colocar o Case #
		
		while (T>0) {
			int N, M; 					  
			N = in.nextInt();				// N number of locations,
			M = in.nextInt();				// M number of possible roads,
			B = in.nextInt();				// A cost of building an airport
			
			Grafo vertices1 = new Grafo(N);
			
			while (M>0) {
				int X, Y, C;
				X = in.nextInt();			// location 1
				Y = in.nextInt();			// location 2
				C = in.nextInt();			// costo of building a road between X and Y
				
				vertices1.add(X, Y, C);
				
				M--;
			}
			resposta = 0;
			contador = N;
			vertices1.Kruskal();
			
			System.out.println("Case #" + (testcase++) + ": " + (resposta+(B*contador) + " " + contador));
			
			T--;
		}

	}
	
	
	public static class Grafo {
		
		int n;							// numero de vertices
		PriorityQueue<Vertice> Q = new PriorityQueue<>();
		
		Grafo(int n) {
			this.n = n;
		}
		
		public void add(int x, int y, int w) {
			Q.add(new Vertice(x, y, w));
		}
		
		public void Kruskal() {

			int[] A = new int[n+1];
			for(int i = 0; i<=n; i++) {
				A[i] = i;
			}
			
			ArrayList<Vertice> krsk = new ArrayList<>();
			
			while(!Q.isEmpty()) {
				Vertice vertice = Q.remove();
				if(vertice.w<B) {
					int x = find(A, vertice.x);
					int y = find(A, vertice.y);
					if (x != y) {
						krsk.add(vertice);
						union(A, x, y);
						resposta = resposta + vertice.w;
						contador--;							// movi o contador e a resposta pra aqui
					}
				}
				
			}
			
		}
		
		public int find(int[] A, int curr) {			// mudei o find
			if(A[curr]==curr) { 
				return curr;
			}
			A[curr] = find(A, A[curr]);
			return A[curr];
		}
		
		public void union(int[] A, int a, int b) {
			int root1 = find(A, a);
			int root2 = find(A, b);
			A[root2] = root1;
		}

	}
	
	public static class Vertice implements Comparable<Vertice>{

	    int x, y, w;

	    public Vertice(int x, int y, int w) {
	        this.x = x;
	        this.y = y;
	        this.w = w;
	    }
	    
	    public int compareTo (Vertice vertice) {
			return w - vertice.w;
		}
	    
	}
	
}
