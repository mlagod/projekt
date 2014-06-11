package all;


public class Elevator extends Thread {
	
	int rodzaj; // 1, 2 lub 3
	int minFloor;
	int maxFloor; // pietro ograniczajace gorne dla windy
	int aktualnePietro = 0;
	final int FULL = 5; // tyle osob pomiesci winda
	int ileOsob = 0;
	
	int kierunek; // 1 = winda jedzie w gore, -1 = winda jedzie w dol
	
	public Elevator(int id){
		rodzaj = id;

		
		if(id == 2){
			
			maxFloor = Start.liczbaPieter;
			minFloor = (Start.liczbaPieter/2)+1;
			
			
		}else if(id == 1){
			
			maxFloor = Start.liczbaPieter/2;
			minFloor = 0;
			
		}else if(id == 3){
			
			minFloor = 0;
			maxFloor = -2;
		}
	}

	
	public void run(){
		
		//ruchWindy();
	}
	
	public void ruchWindy(){
		
		while(true){
			
			if(rodzaj == 1){
				
				aktualnePietro = minFloor;
				
				
				for(int i = minFloor; i < maxFloor; i++){
					
					kierunek = 1;
					aktualnePietro = i;  // winda jest na pietrze
					
					if(aktualnePietro == maxFloor){
						kierunek = -1;
					}
				}
				
				for(int i = maxFloor; i > minFloor; i--){
					
					kierunek = -1;
					aktualnePietro = i;
				}
			
			}else if(rodzaj == 2){
				
				
			}
		}
	}
}
