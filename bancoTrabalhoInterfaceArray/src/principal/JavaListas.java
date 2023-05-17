package principal;

import java.util.ArrayList;
import java.util.List;

public class JavaListas {
	public static void main(String[] args) {
		/*
		//Listas
		List p = new ArrayList();	//dinâmica sequencial .add(object)
		List q = new LinkedList();	//lista encadeada -> liga a -> b
		List r = new Vector();		//vetor[0],[1],[2]...
		List s = new Stack();		//Pilha -> ideia lógica de pilha quem que tirar do topo para baixo
		*/
		
		List<Integer> intArrayList=new ArrayList<Integer>();
		intArrayList.add(15);
		intArrayList.add(30);
		
		//List<Integer> intStack = new Stack<Integer>();
		
		
		
		System.out.println("ArrayList:"+intArrayList);
		
		//System.out.println(intArrayList.get(1));
		//intArrayList.remove(1);
		//System.out.println("ArrayList:"+intArrayList);
		
		for(int i:intArrayList){
			System.out.println(i);
		}
		
					
	}
}
