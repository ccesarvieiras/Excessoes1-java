package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("----- Vem Vindo a Reserva do Hotel -------");
		System.out.println("Digite o número do quarto selecionado: ");
		int numeroQuarto = sc.nextInt();

		System.out.println("Digite a Data de Chek-In: ");
		Date checkIn = sdf.parse(sc.next());

		System.out.println("Digite a Data de Chek-Out: ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na Reserva, a data de Check-Out nao pode ser maior que a de Check-In");
		}

		else {
			Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);

			System.out.println("Entre com as datas para atualização de reserva: ");
			System.out.println("Digite a Data de Chek-In: ");
			checkIn = sdf.parse(sc.next());

			System.out.println("Digite a Data de Chek-Out: ");
			checkOut = sdf.parse(sc.next());

			Date agora = new Date();
			if (checkIn.before(agora) || checkOut.before(agora)) {
				System.out.println("Erro !! As datas devem ser datas futuras");
			} 
				else if (!checkOut.after(checkIn)) {
					System.out.println("Erro na Reserva, a data de Check-Out nao pode ser maior que a de Check-In");
				}
				else {	
				
				reserva.atualizarDatas(checkIn, checkOut);
				System.out.println("Reserva Atualizada: " + reserva);

				sc.close();
			}
		}
	}

}
