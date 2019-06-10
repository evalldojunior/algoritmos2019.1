import java.util.ArrayList;
import java.util.Scanner;

public class Lista7QuestaoB {		// UVA624

	public static int vM = 0;
	public static ArrayList<Integer> vetorResp, vetorFinal;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext()) {
			int N = in.nextInt();
			int nTracks = in.nextInt();
			int[] tracks = new int[nTracks];
			
			for(int i=0; i<nTracks; i++) {
				tracks[i] = in.nextInt();
			}
			
			vetorResp = new ArrayList();
			Backtracking(tracks, 0, 0, N);
			print(vetorFinal);
			
			// reset
			vM = 0;
			
		}
	}
	
	// codigo generico de backtracking para a questao 
	static void Backtracking(int[] tracks, int pos, int S, int N) {
		if (pos == tracks.length) {
			if (S<=N && S>vM) {
				vM = S;
				vetorFinal = (ArrayList<Integer>) vetorResp.clone();
			}
			return;
		}

		vetorResp.add(tracks[pos]);
		Backtracking(tracks, pos+1, S+tracks[pos], N);
		
		// backtrack
		int lastElement = vetorResp.size()-1;
		vetorResp.remove(lastElement);
		
		Backtracking(tracks, pos+1, S, N);
	}
	
	// ok
	static void print(ArrayList vetor) {
		String resposta = "";
		for (int i = 0; i < vetor.size(); i++) {
			resposta = resposta + vetor.get(i) + " ";
		}
		resposta = resposta + "sum:" + vM;
		System.out.println(resposta);
	}
}
