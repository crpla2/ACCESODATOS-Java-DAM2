package Ejercicio09;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class prueba {

	public static void main(String[] args) {
	
			File file= new File("Ficheros/Prueba.dat");
			
			try {
				RandomAccessFile raf= new RandomAccessFile(file, "rw");
				
				
				raf.writeDouble(22);
				raf.writeDouble(33);
				raf.seek(raf.length()-1);
				raf.writeDouble(22);
				raf.writeDouble(33);
				raf.seek(0);
		while(raf.getFilePointer()!=raf.length()) {
			
				System.out.print(raf.readDouble()+"-");
				
				System.out.print(raf.readDouble()+"  \n");
				
			}
				
			
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


