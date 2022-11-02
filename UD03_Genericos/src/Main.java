
public class Main {

	public static void main(String[] args) {
		Matriz<Integer> m = new Matriz<Integer>(3,2);
		int num=1;
		for (int i=0;i<m.filass();i++) {
			for (int j=0; j<m.columnas();j++) {
				m.set(i, j, num++);
			}
		}
		System.out.println(m);
		System.out.println(m.get(0, 1));
	}

}
