package domain.model;

public class Dier {
	private String naam;
	private String soort;
	private int voedsel;
	
	public Dier(String naam, String soort, int voedsel) {
		this.setNaam(naam);
		this.setSoort(soort);
		this.setVoedsel(voedsel);
	}
	
	public Dier (String naam) {
		this.setNaam(naam);
	}
	
	public Dier () {
		
	}
	
	public boolean equals (Object o) {
		if (o instanceof Dier) {
			return this.getNaam().equals(((Dier)o).getNaam());
		}
		return false;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		if (naam == null || naam.isEmpty()) {
			throw new IllegalArgumentException("Vul een naam in.");
		}
		this.naam = naam;
	}

	public String getSoort() {
		return soort;
	}

	public void setSoort(String soort) {
		if (soort == null || soort.isEmpty()) {
			throw new IllegalArgumentException("Vul een soort in.");
		}
		this.soort = soort;
	}

	public int getVoedsel() {
		return voedsel;
	}

	public void setVoedsel(int voedsel) {
		if (voedsel <= 0  || voedsel >10) {
			throw new IllegalArgumentException("Vul aantal maaltijden in (een getal tussen 0 en 9).");
		}
		this.voedsel = voedsel;
	}

}
