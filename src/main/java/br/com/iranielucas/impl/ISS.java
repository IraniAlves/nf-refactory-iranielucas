package br.com.iranielucas.impl;

import br.com.iranielucas.config.ApplicationConfiguration;
import br.com.iranielucas.iterf.Imposto;

public class ISS implements Imposto {
	Double iss = ApplicationConfiguration.getInstance().getISS();

	public Double getValor(Double fatura) {
		return fatura * iss;
	}

}
