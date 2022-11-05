package it.prova.gestionebigliettiweb.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;

import it.prova.gestionebigliettiweb.model.Biglietto;

public class UtilityBigliettoForm {

	public static Biglietto createBigliettoFromParams(String provenienza, String destinazione, String data,
			String prezzo) {

		Biglietto result = new Biglietto(provenienza, destinazione);

		if (NumberUtils.isCreatable(prezzo))
			result.setPrezzo(Integer.parseInt(prezzo));

		result.setData(parseDataFromString(data));

		return result;
	}

	public static Date parseDataFromString(String data) {
		if (StringUtils.isBlank(data))
			return null;
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(data);
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean validateBigliettoBean(Biglietto bigliettoToBeValidated) {
		if (StringUtils.isBlank(bigliettoToBeValidated.getProvenienza())
				|| StringUtils.isBlank(bigliettoToBeValidated.getDestinazione())
				|| bigliettoToBeValidated.getData() == null || bigliettoToBeValidated.getPrezzo() == null
				|| bigliettoToBeValidated.getPrezzo() < 1) {
			return false;
		}
		return true;
	}
}
