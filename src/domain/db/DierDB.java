package domain.db;

import java.util.ArrayList;

import domain.model.Dier;

public class DierDB {
	private ArrayList<Dier> dieren = new ArrayList<Dier>();

	public DierDB() {
		this.voegToe(new Dier("Lex", "hond", 2));
		this.voegToe(new Dier("Nijn", "kat", 5));
		this.voegToe(new Dier("Bruintje", "kip", 1));
	}

	public void voegToe(Dier dier) {
		//if (heeftDier(dier)) {
		//	throw new IllegalArgumentException("Er bestaat al een dier met deze naam.");
		//}
		dieren.add(dier);
		// uitbreiden exception als dier met die naam 2 keer mag niet geadd worden
	}
	
	private boolean heeftDier (Dier dier) {
		for (Dier d: dieren) {
			if (dier.getNaam().equals(d.getNaam())) {
				return true;
			}
		}
		return false;
	}
	
	public Dier zoek (String naam) {
		if (naam.isEmpty() || naam == null) {
			throw new IllegalArgumentException("Je moet een naam ingeven om een dier te kunnen zoeken.");
		}
		for (Dier dier: dieren) {
			if (dier.getNaam().equals(naam)) {
				return dier;
			}
		}
		throw new IllegalArgumentException("Het dier " + naam + " is niet gevonden.");
	}
	
	public void verwijder (String naam) {
		dieren.remove(new Dier(naam));
	}

	public ArrayList<Dier> getAlle() {
		return dieren;
	}

	public Dier getMeestHongerigeDier () {
		Dier meestHongerige = dieren.get(0);
		for (int i=1; i<dieren.size(); i++) {
			if (dieren.get(i).getVoedsel() > meestHongerige.getVoedsel())
				meestHongerige = dieren.get(i);
		}
		return meestHongerige;
	}

}
