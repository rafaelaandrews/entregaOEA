package questao2;

import java.io.RandomAccessFile;
import registro.Registro;

public class GerarTerminaCom {

	public static void main(String args[]) throws Exception{

		RandomAccessFile arquivo1 = new RandomAccessFile("arq1D.dat", "rw");
		RandomAccessFile arquivo2 = new RandomAccessFile("arq2T.dat", "rw");
		Registro registro = new Registro();
			
		while(arquivo1.getFilePointer() < arquivo1.length()){
			registro.leRegistro(arquivo1);
			if(registro.terminaCom(registro.getEmail(), "gmail.com")){
				registro.escreveRegistro(arquivo2);
			}
		}

		arquivo1.close();
		arquivo2.close();

	}
}
