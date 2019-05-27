import java.util.Scanner;

public class Lista2QuestaoC {   // UVA11057

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            int n = in.nextInt();               //quantidade de livros a venda
            int[] array = new int[n];
            for(int i=0; i<n; i++){             //colocando os valores no array
                array[i] = in.nextInt();
            }
            int m = in.nextInt();               //soma dos dois livros

            QuickSort ordn = new QuickSort();
            ordn.QuickSort(array, 0, n-1);      //ordenar o array

            /* 
            encontrar a soma a partir dos valores centrais, ou seja, 
            tendo menos diferença entre eles, satisfazendo uma das
            condiçoes da questao
            */
            int resposta1=0;                      //posição do livro 1
            int resposta2=0;                      //posiçao do livro 2
            int k = n/2;  
            int flag = 0;
            
            do {
            	if(array[k]==m/2) {
            		break;
            	} else {
            		k--;
            	}
            } while (k>1);
            
            for(int i=k; i<n; i++){
                for(int j=i-1; j>=0; j--){
                    if(array[i]+array[j]==m){
                        resposta1=i;
                        resposta2=j;
                        flag=1;
                        break;
                    }
                }
                if(flag==1) {
                	break;
                }
            }

            System.out.println("Peter should buy books whose prices are " + array[resposta2] + " and " + array[resposta1] + ".");
            System.out.println();
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

        int Partition(int[] array, int l, int r){
            int p = array[l];
            int s = l;
            for(int i = l+1; i<=r; i++){
                if(array[i]<p){
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
