import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Lista6QuestaoA {		// UVA10986
	
	public static int UN = 0;
	public static int VI = 1;
	public static int[] Mark;
	public static int resposta;
	public static int[] array;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(br); 		// como o monitor pediu
		
		int N = in.nextInt();				// numero de casos testes
		int testcase = 1;					// colocar o Case #
		
		while(N>0) {
			int n, m, S, T;
			n = in.nextInt();
			m = in.nextInt();
			S = in.nextInt();				// start
			T = in.nextInt();				// end
			
			
			ArrayList<Vertice>[] vertices = new ArrayList[n];
			Mark = new int[n];
			array = new int[n];

			for (int i = 0; i < n; i++) {
				vertices[i] = new ArrayList<Vertice>();
			}
				
			while(m>0) {
				int x, y, w;
				x = in.nextInt();
				y = in.nextInt();
				w = in.nextInt();			// latency
				
				vertices[x].add(new Vertice(x, y, w));
				vertices[y].add(new Vertice(y, x, w));
				
				m--;
			}
			
			Djikstra(vertices, S, T);
			
			if(resposta==Integer.MAX_VALUE) {
				System.out.println("Case #" + (testcase++) + ": unreachable");
			} else {
				System.out.println("Case #" + (testcase++) + ": " + resposta);
			}
			
			N--;
		}

	}
	
	public static void Djikstra(ArrayList<Vertice>[] vertices, int S, int T) {
		
		PriorityQueue<Vertice> Q = new PriorityQueue<>();
		Q.add(new Vertice(S, S,  0));
		
		for(int i=0; i<array.length; i++) {
			array[i] = Integer.MAX_VALUE;
			Mark[i] = UN;
		}
		
		array[S] = 0;
		
		while (!Q.isEmpty()) {
			Vertice v = Q.poll();
			if(v.y==T) {
				break;
			}
			Mark[v.y]=VI;
			if(vertices[v.y] != null) {
				for (int j=0; j<vertices[v.y].size(); j++) {
					Vertice s = vertices[v.y].get(j);
					if(Mark[s.y]!= VI && array[s.y] > array[s.x]+s.w) {
						array[s.y] = array[s.x]+s.w;
						Q.offer(new Vertice(s.x, s.y, array[s.y]));
					}	
				}
			}
		}
		resposta = array[T];
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
