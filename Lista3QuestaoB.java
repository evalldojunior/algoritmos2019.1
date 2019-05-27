import java.util.Scanner;

public class Lista3QuestaoB {   // UVA10282
	
	public static LinkedList[] tabela = new LinkedList[1000];
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String entrada = in.nextLine();
		while(entrada.length()!=0) {	
			String[] str = entrada.split(" ");
			String ingles = str[0];
			String foreign = str[1];
			inserir(foreign, ingles);
			entrada = in.nextLine();
		}
	
		while(in.hasNext()) {
			String message = in.nextLine();
			String resposta = procurar(message);
			if(resposta!="0") {								//get index e ve se tem na tabela ou nao 
				System.out.println(resposta);
			} else {
				System.out.println("eh");
			}
		}
	}
	
	static boolean inserir(String key1,String key2) {
		int posicao = Hash(key1);
		if(tabela[posicao]==null) {
			LinkedList node = new LinkedList();
			tabela[posicao] = node;
			node.push(key1, key2);
			return true;
		} else {
			tabela[posicao].push(key1, key2);
		}
		return true;
	}
	
	static public int Hash(String key) {
		int soma = 0;
		for(int i=0; i<key.length(); i++) {
			int temp = (int) key.charAt(i);
			soma = soma + temp;
		}
		return soma%1000;
	}
	
	static String procurar(String key) {
		int posicao = Hash(key);
		if(tabela[posicao]==null) {
			return "0";
		} 
		Node curr = tabela[posicao].head;
		while(curr!=null) {
			if(curr.key.equals(key)) {
				return curr.key2;
			}
			curr = curr.next;
		}
		return "0";
	}
	
	public static class Node{
		String key;
		String key2;
		Node next;
	
		Node(String key, String key2){
			this.key=key;
			this.key2=key2;
		}
	}
	
	public static class LinkedList{
		
		Node head;
		
		void push(String key, String key2) {
			Node node = new Node(key, key2);
			node.next = this.head;
			this.head = node;
		}
	}		
}
