package model;

public class CalendrierAnnuel {
	Mois[] calendrier;
	
	CalendrierAnnuel() {
		calendrier = new Mois[12];
		
		calendrier[0] = new Mois("Janvier", 31);
		calendrier[1] = new Mois("Février", 28);
		calendrier[2] = new Mois("Mars", 31);
		calendrier[3] = new Mois("Avril", 30);
		calendrier[4] = new Mois("Mai", 31);
		calendrier[5] = new Mois("Juin", 30);
		calendrier[6] = new Mois("Juillet", 31);
		calendrier[7] = new Mois("Août", 31);
		calendrier[8] = new Mois("Septembre", 30);
		calendrier[9] = new Mois("Octobre", 31);
		calendrier[10] = new Mois("Novembre", 30);
		calendrier[11] = new Mois("Décembre", 31);
	}
	
	boolean estLibre(int jour, int mois) {
		return calendrier[mois-1].estLibre(jour);
	}
	
	boolean reserver(int jour, int mois) {
		try {
			calendrier[mois-1].reserver(jour);
			return true;
		} catch (IllegalStateException e) {
			return false;
		}
	}
	
	class Mois {
		String nom;
		boolean[] jours;
		
		Mois(String nom, int nbJours) {
			this.nom = nom;
			jours = new boolean[nbJours];
			for (int i = 0; i<nbJours; i++) {
				jours[i] = true;
			}
		}
		
		boolean estLibre(int jour) {
			return jours[jour-1];
		}
		
		void reserver(int jour) throws IllegalStateException {
			try {
				if (estLibre(jour)) {
					jours[jour-1] = false;
				} else {
					throw new IllegalStateException();
				}
			} catch (Exception e) {
				throw new IllegalStateException();
			}
			
		}
	}
}
