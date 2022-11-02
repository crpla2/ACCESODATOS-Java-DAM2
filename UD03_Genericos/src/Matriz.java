
public class Matriz<E> {
	private E[][] tabla;

	public Matriz(int filas, int columnas) {
		tabla = (E[][]) new Object[filas][columnas];
	}

	public void set(int fila, int columna, E elemento) {
		tabla[fila][columna] = elemento;

	}

	public E get(int fila, int columna) {
		return tabla[fila][columna];
	}

	public int columnas() {
		return tabla[0].length;
	}

	public int filass() {
		return tabla.length;
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[0].length; j++) {
				s += tabla[i][j] + "\t";
			}
			s += "\n";
		}
		return s;
	}
}
