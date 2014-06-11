package all;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Start {

	public static int liczbaPasazerow;
	public static int liczbaPieter;
	public static int liczbaWind;
	
	static List<Elevator> listaWind = new ArrayList<Elevator>();
	static List<Thread> watkiWind = new ArrayList<Thread>();
	
	static List<JPanel> panel = new ArrayList<JPanel>();
	static List<JLabel> nazwy = new ArrayList<JLabel>();
	static List<JLabel> pietra = new ArrayList<JLabel>();
	
	static int licznikTekstow;


public void dzialaj(){
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Podaj liczbe pasazerow : ");
		liczbaPasazerow = s.nextInt();
		
		System.out.println("Podaj liczbe pieter : ");
		liczbaPieter = s.nextInt();
		
		System.out.println("Podaj liczbe wind (podzielna przez 3 stworzy tyle samo wind kazdego rodzaju) : ");
		liczbaWind = s.nextInt();

		// dodanie nazw do wind
				for(int i = 0; i < liczbaWind; i++){
					
					// tworzenie wind
					listaWind.add(new Elevator((i%3)+1));
					listaWind.get(i).setName("Winda " + ((i%3)+1) + "." + ((i+1)/4));
					// reprezetacja graficzna
					panel.add(new JPanel());
					
					pietra.add(new JLabel()); 
					licznikTekstow++;
					
					if(listaWind.get(i).rodzaj == 1){
					
						nazwy.add(new JLabel("Rodzaj " + listaWind.get(i).rodzaj));
						
						
						panel.get(i).setBackground(Color.red);
						panel.get(i).add(nazwy.get(i));
						panel.get(i).add(pietra.get(i));
						
						pietra.get(i).setText("      Winda jest na pietrze: ");
						
					}else if(listaWind.get(i).rodzaj == 2){
						
						nazwy.add(new JLabel("Rodzaj " + listaWind.get(i).rodzaj));
						
						panel.get(i).setBackground(Color.yellow);
						panel.get(i).add(nazwy.get(i));
						panel.get(i).add(pietra.get(i));
						
						pietra.get(i).setText("      Winda jest na pietrze: ");
						
					}else if(listaWind.get(i).rodzaj == 3){
						
						nazwy.add(new JLabel("Rodzaj " + listaWind.get(i).rodzaj));
						
						panel.get(i).setBackground(Color.green);
						panel.get(i).add(nazwy.get(i));
						panel.get(i).add(pietra.get(i));
						
						pietra.get(i).setText("      Winda jest na pietrze: ");
					}
				}
				
				for(int i = 0; i < liczbaWind; i++){
					
					watkiWind.add(new Thread(listaWind.get(i)));
				}
				
				for(int i = 0; i < liczbaWind; i++){
					watkiWind.get(i).start();
				}

}


}
