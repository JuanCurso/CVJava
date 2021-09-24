package programaciongenerica;

public class ArrayList {

	private Object[] miArray;
	private int i=0;
	
	public ArrayList (int n) {
		miArray = new Object[n];
	}
	
	public void add(Object o) {
		miArray[i]=o;
		i++;
	}
	
	public Object get(int n) {
		return miArray[n];
	}
	
}
