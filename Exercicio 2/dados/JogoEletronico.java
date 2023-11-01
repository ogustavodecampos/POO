package dados;

public class JogoEletronico extends Jogo {

	private String plataforma;
	private Categoria categoria;

	public JogoEletronico(String nome, int ano, double precoBase, String plataforma, Categoria categoria) {
		super(nome, ano, precoBase);
		this.plataforma = plataforma;
		this.categoria = categoria;
	}

	@Override
	public double calculaPrecoFinal() {
		switch (categoria) {
			case ACT:
				return this.getPrecoBase() * 1.1;
			case SIM:
				return this.getPrecoBase() * 1.3;
			case STR:
				return this.getPrecoBase() * 1.7;
			default:
				return this.getPrecoBase();
		}
	}


}
