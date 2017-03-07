package adunare;

import java.util.Random;
import java.util.Scanner;

public class definireMatrici {
	int n;
	int m;
	Scanner sc = new Scanner(System.in);
	int[][] matrice ;
	int[][] matrice2 ;
	int numere;
	int lungime;
	
	
	public int getDimensiuni(){
		System.out.println("Dati lungimea matricilor");
		n = sc.nextInt();
		m = n;
		return m;
			
	}
	
	
	public void valoriMatrici(){
		matrice = new int[n][m];
		matrice2 = new int[n][m];
		Random rn = new Random();
		
		for(int i = 0 ; i<n;i++){
			for(int j = 0; j<m;j++){
				numere = rn.nextInt() % 101;
				matrice[i][j] = numere;
			}
		}
		
		for(int i = 0 ; i<n;i++){
			for(int j = 0; j<m;j++){
				numere = rn.nextInt() % 101;
				matrice2[i][j] = numere;
			}
		}		

	}
	
	public int buclareThr(){
		System.out.println("Dati lungimea in matrice pe care sa lucreze threadurile");
		lungime = sc.nextInt();
		return lungime;
		
	}
	
	public int[][] iaMatrice(){
//		int[][] matriceReturn ;
//		matriceReturn = matrice;
		return matrice;
	}
	
	public int[][] iaMatrice2(){
		return matrice2;
	}
	
}

