/*
RESUMO      : Classe dos fãs do artista que acessam o site (simulação de suas ações como usuário)
PROGRAMADORA: Luiza Felix
DATA        : 02/04/2023
 */

package controller;

import java.util.concurrent.Semaphore;

public class Fan extends Thread {

	private static Semaphore valida = new Semaphore(1);
	private static int disponiveis = 100;
	private int id, ticket;

	public Fan(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		if ( login()) {
			if (compra()) {
				try {
					valida.acquire();
					if(validacao()) {
						System.out.println("Fan #ID"+ id + " recebeu a mensagem 'Compra de " + ticket + " ingresso(s) CONCUIDA COM SUCESSO!\nRestam " + disponiveis + " ingresso(s).");
					}
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					valida.release();
				}
			}
		}
		
	}

	private boolean login() {
		int tempo = (int) (Math.random() * 1951 + 50);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (tempo > 1000) {
			System.out.println("Fan #ID" + id + " recebeu a mensagem 'TIMEOUT! Nao foi possivel completar o LOGIN.");
			return false;
		} else {
			return true;
		}
	}

	private boolean compra() {
		int tempo = (int) (Math.random() * 2001 + 1000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (tempo > 2500) {
			System.out.println("Fan #ID" + id + " recebeu a mensagem 'TIMEOUT! Nao foi possivel completar a COMPRA.");
			return false;
		} else {
			ticket = (int) (Math.random() * 4 + 1);
			return true;
		}
	}

	private boolean validacao() {

		if (disponiveis >= ticket) {
			disponiveis -= ticket;
			return true;
		} else {
			System.out.println("Fan #ID" + id + " recebeu a mensagem 'ERRO! Nao ha INGRESSOS SUFICIENTES DISPONIVEIS. \n	SOLICITADOS: " + ticket + "	DISPONIVEIS: " + disponiveis);
			return false;
		}
	}
}
