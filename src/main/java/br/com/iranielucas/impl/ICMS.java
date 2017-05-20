package br.com.iranielucas.impl;

import br.com.iranielucas.config.ApplicationConfiguration;
import br.com.iranielucas.iterf.Imposto;

public class ICMS implements Imposto {
	Double icms = ApplicationConfiguration.getInstance().getICMS();

	public Double getValor(Double fatura) {
		return fatura * icms;
	}

}
