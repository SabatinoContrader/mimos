package com.virtualpairprogrammers.dto;

import java.util.Date;

public class MisuraDTO {

		
		private int id_misura;
	    private int id_paziente;
	    private float pressione;
	    private int battiti;
	    private float temperatura;
	    private float glicemia;
	    private Date data;
	    

	    public MisuraDTO(){}
	    
	    public MisuraDTO(int id_misura, int id_paziente, float pressione, int battiti, float temperatura, float glicemia, Date data) {
	    this.id_misura = id_misura;
	    this.id_paziente = id_paziente;
	    this.pressione = pressione;
	    this.battiti = battiti;
	    this.temperatura = temperatura;
	    this.glicemia = glicemia;
	    this.data = data;
	    }

		public int getId_misura() {
			return id_misura;
		}

		public void setId_misura(int id_misura) {
			this.id_misura = id_misura;
		}

		public int getId_paziente() {
			return id_paziente;
		}

		public void setId_paziente(int id_paziente) {
			this.id_paziente = id_paziente;
		}

		public float getPressione() {
			return pressione;
		}

		public void setPressione(float pressione) {
			this.pressione = pressione;
		}

		public int getBattiti() {
			return battiti;
		}

		public void setBattiti(int battiti) {
			this.battiti = battiti;
		}

		public float getTemperatura() {
			return temperatura;
		}

		public void setTemperatura(float temperatura) {
			this.temperatura = temperatura;
		}

		public float getGlicemia() {
			return glicemia;
		}

		public void setGlicemia(float glicemia) {
			this.glicemia = glicemia;
		}

		public Date getData() {
			return data;
		}

		public void setData(Date data) {
			this.data = data;
		}
}
