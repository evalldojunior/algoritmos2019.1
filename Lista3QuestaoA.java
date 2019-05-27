import java.util.Scanner;

public class Lista3QuestaoA {   // SPOJ-HASHIT
	
	static String[] tabela = new String[101];			//a tabela tem 101 espaços como fala na questao, mod 101

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();					//numero de casos testes
		
		while(t>0) {
			reset();
			int n = in.nextInt();				//numero de operaçoes
			int contador = 0;
			in.nextLine();
			while(n>0) {
				String operation = in.next();
				String key = operation.substring(4);
				if(operation.charAt(0)=='A' && !key.equals("")){ 
					if(getIndex(key)==-1) {
					boolean k = inserir(key);
					if(k) {
						contador++;
					}		
					}
					
				} else if(operation.charAt(0)=='D' && !key.equals("")){
					if(getIndex(key)!=-1) {
					remover(key);
					contador--;
					}
				}
				n--;
			}
			
			//imprimindo resposta
			System.out.println(contador);
			for(int i=0; i<101; i++) {
				if(tabela[i]!="") {
					System.out.println(i + ":" + tabela[i]);
				}
			}
			t--;
		}

	}
	
	//get index
	static int getIndex(String key) {
		int index=0;
		for(int i=0; i<101; i++) {
			if(tabela[i].equals(key)) {
				index=i;
				return index;
			}
		}
		return -1;
	}
	
	//evitar problemas de nullPointer
	public static void reset() {
		for(int i=0; i<101; i++) {
			tabela[i]="";
		}
    }
	
	//função dada na questao para evitar colisoes
	public static int Collision(String key, int posicao){
		int resposta = Hash(key) + (posicao*posicao) + (23*posicao);		//funcao que tem na questao
		return resposta % 101;
	}
	
	//função dada na questao
	public static int Hash(String key) {
		int soma=0;
		for(int i=0; i<key.length(); ++i) {
			int temp = (int) key.charAt(i); 					//convertendo o ASCII para int
			soma = soma + temp*(i+1);							//i+1 porque começa multiplicando por 1 e nao por 0(que seria o valor de i)
		}
		int resultado = soma*19;
		return resultado % 101;
	}
	
	//ok
	public static boolean inserir(String key){
		for(int i=0; i<=19; i++) {
			if(tabela[Collision(key, i)]=="") {
				tabela[Collision(key, i)]=key;
				return true;
			}
		}
		return false;
	}
	//ok
	public static void remover(String key) {
		int temp = getIndex(key);
		if(temp!=-1) {
			tabela[temp]="";
		}
	}
}
