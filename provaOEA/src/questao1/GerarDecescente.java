package questao1;

import java.io.RandomAccessFile;
import registro.Registro;

public class GerarDecescente {

	public static void main(String args[]) throws Exception{

		RandomAccessFile arquivo1 = new RandomAccessFile("arq1.dat", "r");
		RandomAccessFile arquivo2 = new RandomAccessFile("arq2.dat", "rw");

		Registro registro = new Registro();

		long linha = arquivo1.length() - 100;

		while(linha >= 0){
			arquivo1.seek(linha);
			registro.leRegistro(arquivo1);
			registro.escreveRegistro(arquivo2);

			linha = linha - 100;
		}

		arquivo1.close();
		arquivo2.close();
	}
}
