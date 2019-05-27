import java.util.Scanner;

public class Lista4QuestaoA {   // AIZU-ALDS1_9_C
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		MaxHeap pq = new MaxHeap(2000000);
		
		while (in.hasNext()) {
			String entrada = in.next();
			if (entrada.equals("end")) {
				break; //terminar o programa
			} else if (entrada.equals("insert")) {
				int k = in.nextInt(); // key
				pq.adicionar(k);
			} else if (entrada.equals("extract")) {
				System.out.println(pq.remover());
			}
		}
	}

	//classe heap - priority queue
	static class MaxHeap {
		static int[] heap;
		int maxsize;
		public static int size = 0;
		//ok
		public MaxHeap(int maxsize) {
			this.maxsize = maxsize;
			heap = new int[this.maxsize+1];
		}
		//ok
		static int parent(int i) {
			return i/2;
		}
		//ok
		static int leftChild(int i) {
			return (2*i);
		}
		//ok
		static int rightChild(int i) {
			return (2*i)+1;
		}
		//ok
		public void adicionar(int elemento) {
			int i = ++size;
			heap[i] = elemento;
			int index = parent(i); 
			while (i>1 && elemento>heap[index]) {
				heap[i] = heap[index];
				heap[index] = elemento;
				i = index;
				index = parent(i);
			}		
		}
		//ok
		public int remover() {
			int remover = heap[1];
			heap[1] = heap[size--];
			maxHeapify(1);
			return remover;
		}
		//ok
		static void maxHeapify(int i) {
			while (i<=size) {
				int maior = i;
				if (leftChild(i)<=size && heap[i]<heap[leftChild(i)]) {
					maior = leftChild(i);
				}
				if (rightChild(i)<=size && heap[maior]<heap[rightChild(i)]) {
					maior = rightChild(i);
				}
				if (maior!=i) {
					swap(i, maior);
					i = maior;
				} else {
					break;
				}
			}
		}
		//ok
		public static void swap(int primeiro, int segundo) {
			int temporario;
			temporario = heap[primeiro];
			heap[primeiro] = heap[segundo];
			heap[segundo] = temporario;
		}
		
	}
	
}
