package view;

import controller.ThreadFormula1;

public class Principal {

	public static void main(String[] args) {
		String vetEquipe[] = { "Ferrari", "McLaren", "Williams", "RedBull", "Mercedes", "Alpine", "AstronMartin" };
		for (int i = 0; i < 14; i++) {
			if (i <= 6) {
				String equipe = vetEquipe[i];
				Thread t = new ThreadFormula1(i, equipe);
				t.start();
			} else {
				String equipe = vetEquipe[i - 7];
				Thread t = new ThreadFormula1(i, equipe);
				t.start();
			}
		}
	}

}
