package registro;

import java.io.IOException;
import java.io.DataInput;
import java.io.DataOutput;
import java.nio.charset.Charset;

public class Registro{

	private String chave;
	private String nome;
	private String email;
	private String telefone;

	public void leRegistro(DataInput din) throws IOException{

		byte chave[] = new byte[8];
		byte nome[] = new byte[40];
		byte email[] = new byte[40];
		byte telefone[] = new byte[11];

		din.readFully(chave);
		din.readFully(nome);
		din.readFully(email);
		din.readFully(telefone);
		din.readByte();

		Charset enc = Charset.forName("ISO-8859-1");

		this.chave = new String(chave, enc);
		this.nome = new String(nome, enc);
		this.email = new String(email, enc);
		this.telefone = new String(telefone, enc);
	}

	public void escreveRegistro(DataOutput dou) throws IOException{

		Charset enc = Charset.forName("ISO-8859-1");
		dou.write(this.chave.getBytes(enc));
		dou.write(this.nome.getBytes(enc));
		dou.write(this.email.getBytes(enc));
		dou.write(this.telefone.getBytes(enc));
		dou.write("\n".getBytes(enc));

	}

	public String getChave(){
		return chave;
	}

	public String getNome(){
		return nome;
	}

	public String getEmail(){
		return email;
	}

	public String getTelefone(){
		return telefone;
	}

	public void setChave(String chave){
		this.chave = chave;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public void setTelefone(String telefone){
		this.telefone = telefone;
	}
	
	public boolean terminaCom(String email, String fim){
		if(email.contains(fim)){
			return true;
		}
		return false;
	}
}
