package questao3;

import java.io.RandomAccessFile;
import registro.Registro;

public class GerarDuplicidade {
	
	public static void main(String args[]) throws Exception{

		RandomAccessFile arquivo1 = new RandomAccessFile("arq1D.dat", "r");
		RandomAccessFile arquivo2 = new RandomAccessFile("arq1.dat", "r");
		RandomAccessFile arquivo3 = new RandomAccessFile("arq3.dat", "rw");

		Registro registro1 = new Registro();
		Registro registro2 = new Registro();
			
		registro1.leRegistro(arquivo1);
		registro2.leRegistro(arquivo2);
			
		long inicio = 0;
		long meio;
		long fim = (arquivo2.length()/100) - 1;

		while(arquivo1.getFilePointer() < arquivo1.length()){

			while(inicio <= fim){

				meio = (inicio + fim)/2;
				arquivo2.seek(meio*100);
				registro2.leRegistro(arquivo2);

				String s = registro1.getChave().substring(0,registro1.getChave().indexOf(" "));
				String s2 = registro2.getChave().substring(0,registro2.getChave().indexOf(" "));

				int i = Integer.parseInt(s);
				int i2 = Integer.parseInt(s2);

				if(registro1.getChave().equals(registro2.getChave())){

					registro2.escreveRegistro(arquivo3);
					break;

				}else if(i < i2){
					fim = meio - 1;					

				}
				else{
					inicio = meio + 1;

				}
			}

			registro1.leRegistro(arquivo1);
			inicio = 0;
			fim = (arquivo2.length()/100) - 1;
				
		}

		arquivo1.close();
		arquivo2.close();
		arquivo3.close();
	}
	
}
