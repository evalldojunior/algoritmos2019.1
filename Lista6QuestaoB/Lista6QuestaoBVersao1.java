import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.PriorityQueue;

/* ESTA DANDO TLE*/

public class Lista6QuestaoBVersao1 {         //UVA11733
	
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
			contador = 0;
			vertices1.Kruskal();
			
			System.out.println("Case #" + (testcase++) + ": " + (resposta+(B*contador) + " " + contador));
			
			T--;
		}

	}
	
	
	public static class Grafo {
		
		int n;							// numero de vertices
		ArrayList<Vertice> vertices = new ArrayList<>();
		
		Grafo(int n) {
			this.n = n;
		}
		
		public void add(int x, int y, int w) {
			Vertice vertice = new Vertice(x, y, w);
			vertices.add(vertice);
		}
		
		public void Kruskal() {
			PriorityQueue<Vertice> Q = new PriorityQueue<>();
			for(int i = 0; i<vertices.size(); i++) {
				Q.add(vertices.get(i));
			}
			
			int[] A = new int[10001];
			for(int i = 0; i<n; i++) {
				A[i] = i;
			}
			
			ArrayList<Vertice> krsk = new ArrayList<>();
			
			int k = 0;
			while(k<n-1 && !Q.isEmpty()) {
				Vertice vertice = Q.remove();
				if(vertice.w<B) {
					int x = find(A, vertice.x);
					int y = find(A, vertice.y);
					if (x != y) {
						krsk.add(vertice);
						k++;
						union(A, x, y);
					}
				}
				
			}
			
			// achando a resposta da questao
			for(int i = 0; i<krsk.size(); i++) {
				resposta = resposta + krsk.get(i).w;
			}
			for(int i = 0; i<=n; i++) { //era i=1
				if(A[i]==i) {
					contador++;
				}
			}
			
		}
		
		public int find(int[] A, int curr) {
			if(A[curr]!=curr) { 
				return find(A, A[curr]);
			}
			return curr;
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
