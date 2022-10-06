package Ejercicio13;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MiObjectOS extends ObjectOutputStream{

	public MiObjectOS(OutputStream out) throws IOException {
		super(out);
		// TODO Auto-generated constructor stub
	}
	
	protected void writeStreamHeader ()throws IOException{}

}
