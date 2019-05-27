import java.util.Scanner;

public class lista2QuestaoB {   // UVA11039

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int p = in.nextInt();					//casos a resolver
		
		while(p>0) {
			int f = in.nextInt();				//quantidade de pisos
			int[] array = new int[f];			//array pra colocar os pisos
			int contador = 0;
			
			for(int i=0; i<f; i++) {
				array[i]= in.nextInt();
			}
			
			QuickSort ordn = new QuickSort();
            ordn.QuickSort(array, 0, f-1);      //ordenar o array
			
            int flag = 0;
            if(array[0]<0){
            	flag=0;							//red
            	contador++;
            } else {
            	flag=1;							//blue
            	contador++;
            }
            for(int i=1; i<f; i++) {
				if(flag==0 && array[i]>0) {
					contador++;
					flag=1;
				} else {
					if(flag==1 && array[i]<0) {
					contador++;
					flag=0;
					}
				}
				
			}
            
            System.out.println(contador);
			p--;
		}

	}
	
	static class QuickSort {

        void QuickSort(int[] array, int l, int r){
            if(l<r){
                int p = Partition(array, l, r);
                QuickSort(array, l, p-1);
                QuickSort(array, p+1, r);
            }
        }
        
        // pequena mudança no codigo original para ordenar o array ignorando o sinal (-)
        // ou seja, usabdo o valor absoluto
        int Partition(int[] array, int l, int r){
            int p = Math.abs(array[l]);
            int s = l;
            for(int i = l+1; i<=r; i++){
                if(Math.abs(array[i])<p){
                    s++;
                    int prov = array[s];     //swap
                    array[s] = array[i];     //swap
                    array[i] = prov;         //swap
                }
            }
            int prov = array[l];     //swap
            array[l] = array[s];     //swap
            array[s] = prov;         //swap
            return s;
        }
    }

}
