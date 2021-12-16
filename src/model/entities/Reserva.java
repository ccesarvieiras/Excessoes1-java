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

	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) {
		super();
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
				+ sdf.format(checkIn)  
				+ ", " 
				+ duracao() 
				+ " Noites";
	}
	
	

}
