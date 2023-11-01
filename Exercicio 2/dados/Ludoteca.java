package dados;

import java.util.Collection;
import java.util.ArrayList;

public class Ludoteca implements Iterador {

	private int contador;

	private Collection<Jogo> jogo;

	public Ludoteca() {
	contador = 0;
	jogo = new ArrayList<>();
	}

	public boolean addJogo(Jogo jogo) {
		String jogo = jogo.getNome();
		if(consultaPorNome(jogo) == null) {
			return jogo.add(jogo);
		}
		return false;
	}
	public Jogo consultaPorNome(String nome) {
		for (Jogo j : jogo) {
			if(j.getNome().equals(nome)) {
				return System.out.println("1:");
			}
		}
		return null;
	}

	public ArrayList<Jogo> consultaPorAno(int ano) {
		return null;
	}

	public void reset() {
		contador = 0;
	}

	public boolean hasNext() {
		if (contador == jogo.size()) {
			return false;
		} else {
			return true;
		}
	}
	public Object next() {
		return null;
	}


			/*
		String jogo = jogoEletronico.getNome();
		if(consultaJogoEletronico(jogo) == null) {
			return jogoEletronico.add(jogo);
		}
		return ("1:Erro-jogo com nome repetido" + nome)
			 */
	}

}
