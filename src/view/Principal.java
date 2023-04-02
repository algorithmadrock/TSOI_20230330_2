/*
RESUMO      : Classe do site de compra, onde o caos irá se instaurar
PROGRAMADORA: Luiza Felix
DATA        : 02/04/2023
 */

package view;

import javax.swing.JOptionPane;

import controller.Fan;

public class Principal {

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Nesa simulação, 300 fãs tentarão comprar ingressos para o dia 26/04/2023 da JACKSON WANGS'S MAGICMAN TOUR em LA, que só tem 100 lugares disponíveis.\nPara iniciar esse cenário, confirme essa mensagem.");

		for (int i = 1; i<=300;i++) {
			Thread fan = new Fan(i);
			fan.start();
		}
	}

}
