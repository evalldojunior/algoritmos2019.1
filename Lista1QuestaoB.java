import java.util.Scanner;

public class Lista1QuestaoB {   // UVA10935

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int entrada = in.nextInt();
		while(entrada!= 0) {
			Fila fila = new Fila();
			int resp[] = new int[entrada];
			int x=0;
			
			for(int i=1; i<=entrada; i++) {
				fila.adicionar(i);
			}
			while(fila.size>=1) {
				resp[x]= fila.front();
				fila.remover();
				fila.adicionar(fila.front());
				fila.remover();
				x++;
			}
			
			if(x==0) {
				System.out.println("Discarded cards:");
			} else {
				System.out.print("Discarded cards: ");
			}
			for(int i=0; i<entrada-1; i++) {
				if(i==entrada-2) {
					System.out.println(resp[i]);
					break;
				}
				System.out.print(resp[i] + ", ");
			}
			
			System.out.println("Remaining card: "+fila.front());
			
			entrada = in.nextInt();
		}
		

	}
	
	// lista ligada
		static class Node{
			int elemento;
			Node next;
			
			public Node(int elemento) {
				this.elemento = elemento;
				this.next = null;
			}
		}
		
		static class Fila{
			Node rear, front;
			int size;
			
			public Fila() {
				this.rear = this.front = null;
				this.size = 0;
			}
			
			void limpar() {
				this.rear = null;
				this.front = null;
				this.size = 0;
			}
			
			void adicionar(int elemento) {
				Node temp = new Node(elemento);
				if(this.rear == null) {
					this.front = this.rear = temp;
					return;
				}
				this.rear.next = temp;
				this.rear = temp;
				this.size++;
			}
			
			Node remover() {
				if(this.front == null) {
					return null;
				}
				Node temp = this.front;
				this.front = this.front.next;
				
				if(this.front == null) {
					this.rear = null;
				}
				this.size--;
				return temp;
			}
			
			int front() {
				return this.front.elemento;
			}
			
			int rear() {
				return this.rear.elemento;
			}
			
			int size() {
				return this.size;
			}
			
		}

}
