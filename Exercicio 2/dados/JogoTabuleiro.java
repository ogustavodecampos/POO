package dados;

public class JogoTabuleiro extends Jogo {

	private int numeroPecas;

	public JogoTabuleiro(String nome, int ano, double precoBase, int numeroPecas) {
		super(nome, ano, precoBase);
		this.numeroPecas = numeroPecas;
	}

	@Override
	public double calculaPrecoFinal() {
		return this.getPrecoBase() * (1 + 0.01 * numeroPecas);
	}
}

