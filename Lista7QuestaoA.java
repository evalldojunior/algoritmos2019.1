import java.util.Scanner;

public class Lista7QuestaoA {   // UVA750

	public static int contador = 1;
	public static int a, b;
	public static int N = 8;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();			// numero de datasets
		
		while(n > 0) {
			in.nextLine();				// ler a blank line
			a = in.nextInt();			// row
			b = in.nextInt();			// column
			
			System.out.println("SOLN       COLUMN");
			System.out.println(" #      1 2 3 4 5 6 7 8");
			System.out.println();
			
			solve();
			
			contador = 1;
			if (--n != 0) {
				System.out.println();
			}
		}
		
	}
	
	static void solve() {
		int matrix[][] = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = 0;
			}
		}

		solveNQUtil(matrix, 0);
	}
		
	static void print(int matrix[][]) {
		String resposta = "";

		if (contador < 10) {
			System.out.print(" " + contador + "     ");
		} else {
			System.out.print(contador + "     ");
		}
		contador++;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[j][i] == 1) {
					resposta = resposta + " " + (j + 1);
				}
			}
		}
		
		System.out.println(resposta);
	}
		
	static boolean isSafe(int matrix[][], int row, int column) {

		for (int i = 0; i < column; i++) {
			if (matrix[row][i] == 1) {
				return false;
			}
		}

		for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
			if (matrix[i][j] == 1) {
				return false;
			}
		}

		for (int i = row, j = column; j >= 0 && i < N; i++, j--) {
			if (matrix[i][j] == 1) {
				return false;
			}
		}

		return true;

	}
	 
	static boolean solveNQUtil(int matrix[][], int column) {

		if (column == N && matrix[a - 1][b - 1] == 1) {
			print(matrix);
			return true;
		}

		boolean flag = false;
		for (int i = 0; i < N; i++) {
			if (isSafe(matrix, i, column)) {
				matrix[i][column] = 1;
				flag = solveNQUtil(matrix, column + 1) || flag;
				matrix[i][column] = 0; // backtrack
			}
		}
		return flag;
	}

	// codigo do backtracking baseado no do geeksforgeeks
}
