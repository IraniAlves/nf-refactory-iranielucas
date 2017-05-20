package br.com.iranielucas.nf;

import br.com.iranielucas.dao.NFDao;
import br.com.iranielucas.email.EmissorEmail;
import br.com.iranielucas.entidade.Fatura;
import br.com.iranielucas.entidade.NotaFiscal;
import br.com.iranielucas.iterf.Imposto;

public class GeradorNotaFiscal {

	public void geraNota(Fatura fatura, Imposto imposto) {
		double valorImposto = 0;
		valorImposto = imposto.getValor(fatura.getV());
		NotaFiscal notaFiscal = new NotaFiscal(valorImposto, fatura.getV());
		gravarEEnviarPorEmail(notaFiscal, fatura);
	}

	private void gravarEEnviarPorEmail(NotaFiscal notaFiscal, Fatura fatura) {
		new NFDao().armazenarNoBanco(notaFiscal);
		new EmissorEmail().enviarEmail(fatura);
	}
}
