import java.util.Scanner;

public class Lista3QuestaoC {   // UVA536
	
public static int index;
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String preord = in.next();
            String inord = in.next();
            char[] pre = new char[26];
            char[] ino = new char[26];

            for(int i=0; i<preord.length(); i++){
                pre[i] = preord.charAt(i);
            }
            for(int i=0; i<inord.length(); i++){
                ino[i] = inord.charAt(i);
            }

            /**
             * a ideia é percorrer a o INO ate encontrar o elemento que ta na
             * primeira posição (index=0) do PRE, pois ele seria o root, apos encontrar, adiciona
             * como uma raiz e gera a arvore da esquerda com os elementos anteriores a ele,
             * e a arvore a direita com os elementos apos ele. para fazer isso, repete recursivamente 
             * os passos acima e tambem incrementando o index do PRE pois seria a raiz de 
             * cada subarvore
             */
            
            index = 0;
            Node root = Tree(pre, ino, 0, inord.length()-1);
            imprimir(root);
            System.out.println();
        }

    }
    
    static Node Tree(char[] pre, char[] ino, int preo, int inor){
        Node root = new Node(pre[index]);
        index++;
        if(preo<inor){
            int roott=preo;
            while(ino[roott]!=root.key && roott<=inor){ 
            	roott++;
            }
            if(preo<=roott-1){
                root.left = Tree(pre, ino, preo, roott-1);
            }
            if(roott+1<=inor){
                root.right = Tree(pre, ino, roott+1, inor);
            }
        }
        return root;
    }

    static void imprimir(Node post){
        if(post!=null){
            imprimir(post.left);
            imprimir(post.right);
            System.out.print(post.key);
        }
        
    }

    static class Node{
        char key;
        Node left, right;

        public Node(char key){
            this.key = key;
            left = null;
            right = null;
        }
    }
}
