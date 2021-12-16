package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer numeroQuarto;
	private Date checkIn, checkOut;

	public Reserva() {
		super();
	}

	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut)  {
		super();
		if (!checkOut.after(checkIn)) {
			throw new DomainExceptions("Erro na Reserva, a data de Check-Out nao pode ser maior que a de Check-In");
		}
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duracao() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); 
		
	}
	
	public void atualizarDatas(Date checkIn, Date chechOut) {
		Date agora = new Date();
		if (!checkOut.after(checkIn)) {
			throw new DomainExceptions("Erro na Reserva, a data de Check-Out nao pode ser maior que a de Check-In");
		}
		
		if (!checkIn.before(agora) || !checkOut.before(agora)) {
			throw new DomainExceptions ("Erro !! As datas devem ser datas futuras");
		} 

		this.checkIn = checkIn;
		this.checkOut = chechOut;
	}

	
	
	
	@Override
	public String toString() {
		return "Reserva: Número do Quarto: " 
				+ numeroQuarto 
				+ ", checkIn: " 
				+ sdf.format(checkIn) 
				+ ", CheckOut=" 
				+ sdf.format(checkOut)  
				+ ", " 
				+ duracao() 
				+ " Noites";
	}
	
	

}
