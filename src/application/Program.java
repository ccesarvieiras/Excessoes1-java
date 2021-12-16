package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.DomainExceptions;
import model.entities.Reserva;

public class Program {

	//https://github.com/ccesarvieiras/Excessoes1-java
	
	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			System.out.println("----- Vem Vindo a Reserva do Hotel -------");
			System.out.println("Digite o número do quarto selecionado: ");
			int numeroQuarto = sc.nextInt();

			System.out.println("Digite a Data de Chek-In: ");
			Date checkIn = sdf.parse(sc.next());

			System.out.println("Digite a Data de Chek-Out: ");
			Date checkOut = sdf.parse(sc.next());

			Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);

			System.out.println();
			System.out.println();
			System.out.println("Entre com as datas para atualização de reserva: ");
			System.out.println("Digite a Data de Chek-In: ");
			checkIn = sdf.parse(sc.next());

			System.out.println("Digite a Data de Chek-Out: ");
			checkOut = sdf.parse(sc.next());

			reserva.atualizarDatas(checkIn, checkOut);
			System.out.println("Reserva Atualizada: " + reserva);

			sc.close();
		}

		catch (ParseException e) {
			System.out.println("Data Inválida");
		}

		catch (DomainExceptions e) {
			System.out.println("Erro na reserva " + e.getMessage());
		}
		
		catch (RuntimeException e) {
			System.out.println("Erro Inesperado");
		}

	}
}
