package note.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import java.util.Scanner;

import note.main.ClasaException;

import note.model.Corigent;
import note.model.Medie;

import note.controller.NoteController;
import note.model.Nota;

//functionalitati
//F01.	 adaugarea unei note la o anumita materie (nr. matricol, materie, nota acordata);
//F02.	 calcularea mediilor semestriale pentru fiecare elev (nume, nr. matricol),
//F03.	 afisarea elevilor coringenti, ordonati descrescator dupa numarul de materii la care nu au promovat ?i alfabetic dupa nume.


public class StartApp {

	/**
	 * @param args
	 * @throws ClasaException 
	 */
	public static void main(String[] args) throws ClasaException {
		// TODO Auto-generated method stub
		NoteController ctrl = new NoteController();
		List<Medie> medii = new LinkedList<Medie>();
		List<Corigent> corigenti = new ArrayList<Corigent>();
		ctrl.readElevi();
		ctrl.readNote();
		ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
		boolean gasit = false;
		Scanner scan = new Scanner(System.in);
		while(!gasit) {
			System.out.println("1. Adaugare Nota");
			System.out.println("2. Calculeaza medii");
			System.out.println("3. Elevi corigenti");
			System.out.println("4. Iesire");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
		    try {
				int option = Integer.parseInt(br.readLine());
				switch(option) {
				case 1: System.out.println("Adaugati numarul matricol pentru care vreti sa adaugati o nota:");
						String nrM = scan.nextLine();
						System.out.println("Adaugati materia la care vreti sa adaugati o nota: ");
						String materia= scan.nextLine();
						System.out.println("Adaugati nota: ");
					    String nota= scan.nextLine();
					    Nota n= new Nota(Double.parseDouble(nrM),materia,Double.parseDouble(nota));
					    ctrl.addNota(n);
						break;


				case 2: medii = ctrl.calculeazaMedii();
						for(Medie medie:medii)
							System.out.println(medie);
						break;
				case 3: corigenti = ctrl.getCorigenti();
						for(Corigent corigent:corigenti)
							System.out.println(corigent);
						break;
				case 4: gasit = true;
						break;
				default: System.out.println("Introduceti o optiune valida!");
				}
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
