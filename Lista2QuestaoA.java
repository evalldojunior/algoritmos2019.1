import java.util.Scanner;

public class Lista2QuestaoA {   // CODEFORCES-1131C

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();                //total de crianças
        int[] array = new int[n];            //array com altura das crianças
    
        for(int i=0; i<n; i++){
            array[i] = in.nextInt();
        }
        
        QuickSort ordn = new QuickSort();
        ordn.QuickSort(array, 0, n-1);            //ordenar o array
        
        int[] resposta = new int[n];         //gerando o array resposta
        int esquerda = 0;
        int direita = n-1;
        for(int i=0; i<n; i++){
            if(i%2==0){
                resposta[esquerda]=array[i];
                esquerda++;
            } else {
                resposta[direita]=array[i];
                direita--;
            }
        }
        
        for(int i=0; i<n; i++){
            System.out.print(resposta[i]+ " ");
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
