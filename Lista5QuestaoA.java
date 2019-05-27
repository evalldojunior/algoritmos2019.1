import java.util.Scanner;
import java.util.ArrayList;

public class Lista5QuestaoA {   // UVA11504
	
	public static int UN = 0;
	public static int VI = 1;
	public static int resposta = 0;
	public static int[] Mark;
	public static ArrayList<Integer>[] vertices;
	public static int[] dfs;
	public static int d;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();			// numero de casos testes
		
		while(t>0) {
			int n = in.nextInt(); 		// numero de domino tiles
			int m = in.nextInt();		// numero de linhas seguintes
		
			vertices = new ArrayList[n+1];
			Mark = new int[n+1];
			dfs = new int[n+1];
			d = 0;
			
			for(int i=0; i<=n; i++) {
				vertices[i] = new ArrayList<Integer>();
			}
			
			while(m>0) {
				int x = in.nextInt();	// começo
				int y = in.nextInt();	// final
				vertices[x].add(y);
				
				m--;
			}
			
			dfs1();
			clear(n);					// um array de marcação novo
			dfs2();
			
			System.out.println(resposta);		
			resposta = 0;						// resposta zero pra os proximos casos testes
			
			t--;
		}
		
	}
	
	//ok
	public static void dfs(int k) {
		Mark[k] = VI;
		for (int i=0; i<vertices[k].size(); i++) {
			int s = vertices[k].get(i);
			if(Mark[s]==UN) {
				dfs(s);
			}	
		}
	}
	//ok
	public static void dfs1() {
		for (int i=1; i <=Mark.length-1; i++) {
			if (Mark[i]==UN) {
				Mark[i] = VI;
				dfs3(i);
			}
		}	
	}
	//ok
	public static void dfs2() {
		for (int i=Mark.length-2; i>=0; i--) {
			if (Mark[dfs[i]]==UN) {
				resposta++;
				dfs(dfs[i]);
			}
		}	
	}
	//ok
	public static void dfs3(int k) {
		for (int i=0; i<vertices[k].size(); i++) {
			int s = vertices[k].get(i);
			if (Mark[s] == UN) {
				Mark[s] = VI;
				dfs3(s);
			}
		}
		dfs[d++] = k;
	}
	//ok
	public static void clear(int n) {
		Mark = new int[n+1];
	}
}
