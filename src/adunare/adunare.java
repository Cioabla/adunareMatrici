package adunare;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class adunare extends Thread{

	int dimensiuni;
	int[][] matrice;
	int[][] matrice2;
	int[][] matriceFinala ;
	int bucl;
	int numarBcl ;
	int bucleFinale;
	int coloana;
	int linie;
	String g;
	int contor = 0;
	BufferedWriter bw2;
	FileWriter fw2;
	String scriere = "";
	int j;
	
	

	public adunare(int dimen , int[][] matr , int[][] matr2 , int buclaB , int bucleFinaleB , String a , int nrBucle2 , int contor2){
		
		dimensiuni = dimen;
		matrice = matr;
		matrice2 = matr2;
		bucl = buclaB;
		matriceFinala = new int[dimensiuni][dimensiuni];
		bucleFinale = bucleFinaleB;
		g=a;
		numarBcl = nrBucle2;
		contor = contor2;
	}
	
	
	
	
	
	public void run() {
			try {
				matrici obiect = new matrici();
				fw2 = obiect.fw;
				bw2 = obiect.bw;
//			System.out.println(numarBcl + " linie");
//			System.out.println(contor + " coloana");
//		System.out.println(bucl);
				linie = bucl*(numarBcl+1);
				if(linie>dimensiuni){
					linie=dimensiuni;
				}
				
				System.out.println(linie);
				
				for(j = bucl*numarBcl; j<linie;j++){
					
					matriceFinala[contor][j] = matrice[contor][j]+matrice2[contor][j];
					scriere = scriere+ "   " + matriceFinala[contor][j];
					
				}
				bw2.write(scriere+"\n");
				if (contor == (dimensiuni-1) && j == (dimensiuni)) {
					bw2.close();
					System.out.println(contor);
					System.out.println(linie);
					System.out.println("intrai aici");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	
			
		
		
	}
	

	
}

