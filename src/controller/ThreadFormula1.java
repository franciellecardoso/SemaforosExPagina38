package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadFormula1 extends Thread {

	private String equipe;
	private int id;
	private double voltaFinal;
	private Semaphore semaforo = new Semaphore(5);
	private static int Ferrari = 0;
	private static int McLaren = 0;
	private static int Williams = 0;
	private static int RedBull = 0;
	private static int Mercedes = 0;
	private static int Alpine = 0;
	private static int AstronMartin = 0;
	private static double[] vet = new double[14];
	private static int[] vetId = new int[14];
	private static String[] vetEquipe = new String[14];
	private static int permissao = 0;

	public ThreadFormula1(int id, String vetEquipe) {
		this.id = id;
		this.equipe = vetEquipe;
		this.voltaFinal = 0;
	}

	@Override
	public void run() {
		try {
			if (Ferrari == 0 & equipe.contains("Ferrari")) {
				semaforo.acquire();
				Ferrari = 1;
				Pista();
				Ferrari = 0;
			} else if (McLaren == 0 & equipe.contains("McLaren")) {
				semaforo.acquire();
				McLaren = 1;
				Pista();
				McLaren = 0;
			} else if (Williams == 0 & equipe.contains("Williams")) {
				semaforo.acquire();
				Williams = 1;
				Pista();
				Williams = 0;
			} else if (RedBull == 0 & equipe.contains("RedBull")) {
				semaforo.acquire();
				RedBull = 1;
				Pista();
				RedBull = 0;
			} else if (Ferrari == 0 & equipe.contains("Mercedes")) {
				semaforo.acquire();
				Mercedes = 1;
				Pista();
				Mercedes = 0;
			} else if (Alpine == 0 & equipe.contains("Alpine")) {
				semaforo.acquire();
				Alpine = 1;
				Pista();
				Alpine = 0;
			} else if (AstronMartin == 0 & equipe.contains("AstronMartin")) {
				semaforo.acquire();
				AstronMartin = 1;
				Pista();
				AstronMartin = 0;
			} else {
				sleep(3000);
				if (Ferrari == 0 & equipe.contains("Ferrari")) {
					semaforo.acquire();
					Ferrari = 1;
					Pista();
					Ferrari = 0;
				} else if (McLaren == 0 & equipe.contains("McLaren")) {
					semaforo.acquire();
					McLaren = 1;
					Pista();
					McLaren = 0;
				} else if (Williams == 0 & equipe.contains("Williams")) {
					semaforo.acquire();
					Williams = 1;
					Pista();
					Williams = 0;
				} else if (RedBull == 0 & equipe.contains("RedBull")) {
					semaforo.acquire();
					RedBull = 1;
					Pista();
					RedBull = 0;
				} else if (Ferrari == 0 & equipe.contains("Mercedes")) {
					semaforo.acquire();
					Mercedes = 1;
					Pista();
					Mercedes = 0;
				} else if (Alpine == 0 & equipe.contains("Alpine")) {
					semaforo.acquire();
					Alpine = 1;
					Pista();
					Alpine = 0;
				} else if (AstronMartin == 0 & equipe.contains("AstronMartin")) {
					semaforo.acquire();
					AstronMartin = 1;
					Pista();
					AstronMartin = 0;
				} else {
					System.out.println("Algo deu errado.");
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		try {
			sleep(5000);
			Random numero = new Random();
			sleep((long) (numero.nextInt(999) + 1));
			for (int i = 0; i < 13; i++) {
				for (int j = i + 1; j < 14; j++) {
					if (vet[i] > vet[j]) {
						double ajudante = vet[i];
						vet[i] = vet[j];
						vet[j] = ajudante;
						int ajudante2;
						ajudante2 = vetId[i];
						vetId[i] = vetId[j];
						vetId[j] = ajudante2;
						String ajudante3;
						ajudante3 = vetEquipe[i];
						vetEquipe[i] = vetEquipe[j];
						vetEquipe[j] = ajudante3;
					}
				}
			}
			sleep((long) (numero.nextInt(999) + 1));
			if (permissao == 0) {
				permissao++;
				System.out.println("O grid de largada é: ");
				for (int i = 0; i < 14; i++) {
					System.out.println("O carro #" + (vetId[i] + 1) + " da equipe " + vetEquipe[i] + " está na "
							+ (i + 1) + "a. posição de largada, com sua volta mais rápida feita em " + vet[i]
							+ " munutos;");
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void Pista() {
		Random numero = new Random();
		double tempoVolta = 1000000000;
		for (int volta = 0; volta < 3; volta++) {
			double velocidade = (3 + (numero.nextDouble() * (numero.nextInt(20) + 10)));
			System.out.println("O carro da " + equipe + " #" + (id + 1) + " completou a volta " + (volta + 1) + " em "
					+ velocidade + " minutos.");
			if (velocidade < tempoVolta) {
				tempoVolta = velocidade;
			}
		}
		voltaFinal = tempoVolta;
		vet[id] = voltaFinal;
		vetId[id] = id;
		vetEquipe[id] = equipe;
	}

}
