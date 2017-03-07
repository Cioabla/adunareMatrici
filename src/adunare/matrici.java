package adunare;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class matrici {
	static FileWriter fw;
	 static BufferedWriter bw;
	
	public static void main(String[] args) {
		int[][] matrice;
		int[][] matrice2;
		definireMatrici obiect = new definireMatrici();
		int dimensiuni = obiect.getDimensiuni();
		obiect.valoriMatrici();
		int bucl = obiect.buclareThr();
		matrice = obiect.iaMatrice();
		matrice2 = obiect.iaMatrice2();
		int bucleFinale;
		int numarBcl = -1;
		int contor = 0;
		String scriere = "";

		
		bucleFinale = dimensiuni / bucl;
		
		
		
		if(dimensiuni%bucl != 0){
			bucleFinale++;
		}
		
		int numarThreaduri = bucleFinale * dimensiuni;
		Thread[] threads = new Thread[numarThreaduri+6];

//		for(int i=0 ; i<dimensiuni+1 ;i++){
//			for(int j = 0 ; j<dimensiuni+1;j++){
//				System.out.println(matrice[i][j]);
//			}
//		}
			
			try {
				fw = new FileWriter("C:\\Users\\Rio\\Desktop\\work\\adunare\\rezultat.txt");
				bw = new BufferedWriter(fw);
				for(int i = 0;i<dimensiuni;i++){
					for(int j = 0 ; j<dimensiuni;j++){
						scriere = scriere+ "   " + matrice[i][j];
						
					}
					bw.write(scriere+"\n");
					scriere = "";
				}
				bw.write("\n\n\n");
				for(int i = 0;i<dimensiuni;i++){
					for(int j = 0 ; j<dimensiuni;j++){
						scriere = scriere+ "   " + matrice2[i][j];
						
					}
					bw.write(scriere+"\n");
					scriere = "";
				}
				bw.write("\n\n\n");
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			int buclareWhile = 1;
			int contorThreaduri = -1;
			int t11 = 0;
			int t22 = 0;
			int t33 = 0;
			int t44 = 0;
			int variabila1 = 0;
			int variabila2 = 0;
			int variabila3 = 0;
			int variabila4 = 0;
		
			while(buclareWhile != 0){

				
				if(t11 == 0){
					
					contorThreaduri++;
					numarBcl++;
					if(numarBcl > (bucleFinale-1 )){
						numarBcl = 0;
						contor++;
					}
					
					variabila1 = contorThreaduri;
					threads[contorThreaduri] = new adunare(dimensiuni,matrice,matrice2,bucl,bucleFinale , "Thread 1" , numarBcl, contor);
					threads[contorThreaduri].start();
					
					t11 = 1;
					
				}
				
				if(t22 == 0){
					
					contorThreaduri++;
					numarBcl++;
					if(numarBcl > (bucleFinale-1 )){
						numarBcl = 0;
						contor++;
					}
					variabila2 = contorThreaduri;
					threads[contorThreaduri] = new adunare(dimensiuni,matrice,matrice2,bucl,bucleFinale , "Thread 2",  numarBcl, contor);
					threads[contorThreaduri].start();
					try {
						threads[contorThreaduri].sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					t22 = 1;
				}
				
				if(t33 == 0){
					
					contorThreaduri++;
					numarBcl++;
					if(numarBcl > (bucleFinale-1 )){
						numarBcl = 0;
						contor++;
					}
					variabila3 = contorThreaduri;
					threads[contorThreaduri] = new adunare(dimensiuni,matrice,matrice2,bucl,bucleFinale , "Thread 3" ,  numarBcl, contor);
					threads[contorThreaduri].start();
					try {
						threads[contorThreaduri].sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					t33 = 1;
				}
				
				if(t44 == 0){
					
					contorThreaduri++;
					numarBcl++;
					if(numarBcl > (bucleFinale-1 )){
						numarBcl = 0;
						contor++;
					}
					variabila4 = contorThreaduri;
					threads[contorThreaduri] = new adunare(dimensiuni,matrice,matrice2,bucl,bucleFinale , "Thread 4" ,  numarBcl, contor);
					threads[contorThreaduri].start();
					try {
						threads[contorThreaduri].sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					t44 = 1;
				}
				
				if(threads[variabila1].isAlive() == false){
//					System.out.println(threads[variabila1].isAlive());
					t11 = 0;
					
				}
				if(threads[variabila2].isAlive() == false){
					t22 = 0;
				}
				if(threads[variabila3].isAlive() == false){
					t33 = 0;
				}
				if(threads[variabila4].isAlive() == false){
					t44 = 0;
				}
				if(contorThreaduri == numarThreaduri-1){
					buclareWhile = 0;
				}
				
			}
			
			System.out.println("done");
			
		
			
			
	}

}
