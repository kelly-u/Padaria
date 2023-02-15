package br.recife.edu.ifpe.padaria.model.classes;

public class Fornada {

	private int codigo;
	private long horario;
	private int qntdPao;
	private String observacao;
	private Padeiro padeiro;
	private TipoPao tipoPao;
	
	public Fornada() {
		this.horario = System.currentTimeMillis();
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public long getHorario() {
		return horario;
	}
	public void setHorario(long l) {
		this.horario = l;
	}
	public int getQntdPao() {
		return qntdPao;
	}
	public void setQntdPao(int qntdPao) {
		this.qntdPao = qntdPao;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Padeiro getPadeiro() {
		return padeiro;
	}
	public void setPadeiro(Padeiro padeiro) {
		this.padeiro = padeiro;
	}
	public TipoPao getTipoPao() {
		return tipoPao;
	}
	public void setTipoPao(TipoPao tipoPao) {
		this.tipoPao = tipoPao;
	}

	
	
}
