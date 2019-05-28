import java.util.Scanner;

public class Lista1QuestaoA {   // CODEFORCES-26B

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String entrada = in.nextLine(); 		//receber a linha de entrada
		int tamanho = entrada.length();
		Pilha pilha = new Pilha(tamanho);
		int contador = 0;						//resposta
		
		for(int i = 0; i<tamanho; i++) {
			char prov = entrada.charAt(i);
			if(prov == '(') {
				pilha.adicionar(1);
			} else {
				if(pilha.isEmpty()) {
					pilha.adicionar(2);
				} else if(pilha.getTop()== 1) {
					pilha.remover();
					contador = contador+2;
				}
			}
		}
		
		System.out.println(contador);
	}
	
	//classe pilha
		static class Pilha {
			int top, capacidade;
			int pilha[];
			
			boolean isEmpty() {
				return (this.top<0);
			}
			
			public Pilha(int capacidade){
				this.capacidade = capacidade;
				pilha = new int[this.capacidade];
				this.top = -1; 
			}
			
			void adicionar(int add) {
				this.pilha[++top] = add;
			}
			
			int remover() {
				int remover = this.pilha[this.top--];
				return remover;
			}
			int getTop() {
				return this.pilha[this.top];
			}	
		}

}
