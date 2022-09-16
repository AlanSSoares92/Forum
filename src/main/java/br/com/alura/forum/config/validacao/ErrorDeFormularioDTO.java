package br.com.alura.forum.config.validacao;

public class ErrorDeFormularioDTO {
	
	private String campo;
	private String erro;
	
	
	public ErrorDeFormularioDTO(String campo, String erro) {
		super();
		this.campo = campo;
		this.erro = erro;
	}


	public String getCampo() {
		return campo;
	}


	public String getErro() {
		return erro;
	}
	
	

}
