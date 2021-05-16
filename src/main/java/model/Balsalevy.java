package model;

public class Balsalevy {

	private long id;
	private double tiheys;
	private double korkeus;
	private double leveys;
	private double paino;
	private double pituus;
	private String grain;

	
	public Balsalevy(long id, double tiheys, double korkeus, double leveys, double paino, double pituus, String grain) {
		this.id = id;
		this.tiheys = tiheys;
		this.korkeus = korkeus;
		this.leveys = leveys;
		this.paino = paino;
		this.pituus = pituus;
		this.grain = grain;
	}

	//käytetään tietokannasta poistossa, kun tarvitaan vain id:tä
	public Balsalevy(long id) {
		this(id, 0, 0, 0, 0, 0, "");
	}
	
	//käytetään uuden tuotteen lisäämiseen tietokantaan; tietokantaan id tulee taulun autoincrementistä.
	public Balsalevy(double tiheys, double korkeus, double leveys, double paino, double pituus, String grain) {
		this(0, tiheys, korkeus, leveys, paino, pituus, grain);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getTiheys() {
		return tiheys;
	}

	public void setTiheys(double tiheys) {
		this.tiheys = tiheys;
	}

	public double getKorkeus() {
		return korkeus;
	}

	public void setKorkeus(double korkeus) {
		this.korkeus = korkeus;
	}

	public double getLeveys() {
		return leveys;
	}

	public void setLeveys(double leveys) {
		this.leveys = leveys;
	}

	public double getPaino() {
		return paino;
	}

	public void setPaino(double paino) {
		this.paino = paino;
	}

	public double getPituus() {
		return pituus;
	}

	public void setPituus(double pituus) {
		this.pituus = pituus;
	}

	public String getGrain() {
		return grain;
	}

	public void setGrain(String grain) {
		this.grain = grain;
	}

}
