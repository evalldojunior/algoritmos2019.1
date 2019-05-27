import java.util.Scanner;

public class Lista4QuestaoC {   // UVA11849
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n, m;
		n = in.nextInt();
		m = in.nextInt();
		while(n!=0 && m!=0) {
			AVL tree1 = new AVL();
			int resposta = 0;
			for(int i=0; i<n; i++) {
				int j1 = in.nextInt();
				tree1.rt = tree1.inserthelp(tree1.rt, j1);
			}
			for(int i=0; i<m; i++) {
				int j2 = in.nextInt();
				if (tree1.find(tree1.rt,  j2)) {
					resposta++;
				}
			}
			
			System.out.println(resposta);
			n = in.nextInt();
			m = in.nextInt();
		}

	}

	static public class AVL {
		
		class Node {
			int key, height;
			Node left, right;
		
			public Node(int item) {
				key = item;
				height = 1;
			}
		}
		
		Node rt;
		
		int getBalance(Node rt) {
			if (rt==null) {
				return 0;
			}
			return height(rt.left)-height(rt.right);
		}
		
		int height(Node rt) {
			if (rt==null) {
				return -1;
			}
			return rt.height;
		}
		
		int max(int a, int b) {
			if (a>b) {
				return a;
			} else {
				return b;
			}
		}
		
		Node leftRotate(Node rt) {
			Node r = rt.right;
			Node rl = r.left;
			r.left = rt;
			rt.right = rl;
			rt.height = max(height(rt.left), height(rt.right))+1;
			r.height = max(height(r.left), height(r.right)+1);
			return r;
		}
		
		Node rightRotate(Node rt) {
			Node l = rt.right;
			Node lr = l.left;
			l.left = rt;
			rt.right = lr;
			rt.height = max(height(rt.left), height(rt.right))+1;
			l.height = max(height(l.left), height(l.right)+1);
			return l;
		}
		
		Node inserthelp(Node rt, int k) {
			if (rt==null) {
				return new Node(k);
			}
			if (rt.key>k) {
				rt.left = inserthelp(rt.left, k);
			} else {
				rt.right = inserthelp(rt.right, k);
			}
			rt.height = 1 + max(height(rt.left), height(rt.right));
			int balance = getBalance(rt);
			if (balance>1 && k<rt.left.key) {
				return rightRotate(rt);
			}
			if (balance<-1 && k>= rt.right.key) {
				return leftRotate(rt);
			}
			if (balance>1 && k>=rt.left.key) {
				rt.left = leftRotate(rt.left);
				return rightRotate(rt);
			}
			if (balance<-1 && k<rt.right.key) {
				rt.right = rightRotate(rt.right);
				return leftRotate(rt);
			}
			return rt;
		}
		
		boolean find(Node rt, int key) {
			if (rt==null) {
				return false;
			}
			if (rt.key>key) {
				return find(rt.left, key);
			} else if (rt.key==key) {
				return true;
			} else {
				return find(rt.right, key);
			}
		}
	}
}
