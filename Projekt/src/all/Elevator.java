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
			
			minFloor = -2;
			maxFloor = 0;
		}
	}

	
	public void run(){
		
		ruchWindy();
	}
	
	public synchronized void ruchWindy(){
		
		while(true){
			
			if(rodzaj == 1){
				
				aktualnePietro = minFloor;
				
				
				for(int i = minFloor; i < maxFloor; i++){
					
					kierunek = 1;
					aktualnePietro = i;  // winda jest na pietrze
					
					
					if(aktualnePietro == maxFloor){
						kierunek = -1;
					}
					
					// aktualizacja pietra napis
					for(int j = 0; j < Start.licznikTekstow; j++){
						if(j % 3 == 0){
						Start.pietra.get(j).setText("      Winda jest na pietrze: " + aktualnePietro);
						}
						
						spij();
					}
				}
				
				for(int i = maxFloor; i > minFloor; i--){
					
					kierunek = -1;
					aktualnePietro = i;
					
					if(i == minFloor){
						kierunek = 1;
					}
					
					for(int j = 0; j < Start.licznikTekstow; j++){
						if(j % 3 == 0){
						Start.pietra.get(j).setText("      Winda jest na pietrze: " + aktualnePietro);
						}
						spij();
					}
				}
			
			}else if(rodzaj == 2){
				
				aktualnePietro = 0;
				kierunek = 1;
				
				for(int j = 0; j < Start.licznikTekstow; j++){
					if(j % 3 == 1){
					Start.pietra.get(j).setText("      Winda jest na pietrze: " + aktualnePietro);
					}
					spij();
				}
				for(int i = minFloor; i < maxFloor; i++){
					
					kierunek = 1;
					aktualnePietro = i;
					
					if(aktualnePietro == maxFloor){
						
						kierunek = -1;
					}
					
					for(int j = 0; j < Start.licznikTekstow; j++){
						if(j % 3 == 1){
						Start.pietra.get(j).setText("      Winda jest na pietrze: " + aktualnePietro);
						}
						spij();
					}
				}
				
				for(int i = maxFloor; i >= minFloor; i--){
					
					kierunek = -1;
					aktualnePietro = i;
					
					for(int j = 0; j < Start.licznikTekstow; j++){
						if(j % 3 == 1){
						Start.pietra.get(j).setText("      Winda jest na pietrze: " + aktualnePietro);
						}
						spij();
					}
				}
				
				if(aktualnePietro == minFloor){   // nie wchodzi do tego ifa ?
					aktualnePietro = 0;
					kierunek = 1;
					
					
					
					for(int j = 0; j < Start.licznikTekstow; j++){
						if(j % 3 == 1){
						Start.pietra.get(j).setText("      Winda jest na pietrze: " + aktualnePietro);
						}
						spij();
					}
				}
			
			}else if(rodzaj == 3){
				
				aktualnePietro = 0;
				kierunek = -1;
				
				for(int i = 0; i > minFloor; i--){
					
					kierunek = -1;
					aktualnePietro = i;
					
					if(aktualnePietro == minFloor){
						
						kierunek = 1;
					}
					
					for(int j = 0; j < Start.licznikTekstow; j++){
						if(j % 3 == 2){
						Start.pietra.get(j).setText("      Winda jest na pietrze: " + aktualnePietro);
						}
					}
					spij();
				}
				
				for(int i = minFloor; i < maxFloor; i++){
					
					kierunek = 1;
					aktualnePietro = i;
					
					if(i == maxFloor){
						kierunek = -1;
					}
					
					for(int j = 0; j < Start.licznikTekstow; j++){
						if(j % 3 == 2){
						Start.pietra.get(j).setText("      Winda jest na pietrze: " + aktualnePietro);
						}
						spij();
					}
				}
			}
		}
	}
	
	private void spij(){
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
