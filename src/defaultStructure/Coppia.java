package defaultStructure;

public class Coppia<K, V> {

	private K chiave;
	private V valore;
	private Coppia<K,V> succ;
	
	public Coppia(K chiave, V valore) {
		this.chiave = chiave;
		this.valore = valore;
		succ = null;
	}
	
	public K getChiave() {
		return chiave;
	}
	
	public V getValore() {
		return valore;
	}
	
	public void setSuccessivo(Coppia<K, V> succ) {
		this.succ = succ;
	}
	
	public Coppia<K, V> getSucc() {
		return succ;
	}
}
