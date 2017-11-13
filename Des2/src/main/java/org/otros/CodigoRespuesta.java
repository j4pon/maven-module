package org.otros;

import java.util.HashMap;

public class CodigoRespuesta {

	private HashMap<String, String> rpta;
	private String prueba;
	private CodigoRespuesta(){
		
		//this.rpta = new HashMap<String, String>(24);
		
		this.rpta.put("0", "Transaccion OK");
		this.rpta.put("2", "Monto de transaccion no especificado Campo 4");
		this.rpta.put("14", "Numero de tarjeta invalida");
		this.rpta.put("19", "Error");
		this.rpta.put("21", "Fecha de TRN original diferente a fecha de proceso. No se puede reversar la transacción");
		this.rpta.put("22", "Se detectó intento de fraude");
		this.rpta.put("30", "Sin cuenta de crédito");
		this.rpta.put("34", "Tarjeta Boletinada por robo");
		this.rpta.put("41", "Tarjeta Perdida");
		this.rpta.put("42", "");
		this.rpta.put("43", "Tarjeta robada");
		this.rpta.put("52", "");
		this.rpta.put("53", "Sin cuenta de ahorros");
		this.rpta.put("54", "Tarjeta expirada");
		this.rpta.put("55", "PIN Incorrecto");
		this.rpta.put("56", "No se encontro registro para actualizar estado a reversado");
		this.rpta.put("57", "Transacción no permitida");
		this.rpta.put("58", "Transacción no permitida para terminal");
		this.rpta.put("61", "Excede el límite de importe de retiro");
		this.rpta.put("62", "Tarjeta restringida");
		this.rpta.put("75", "Se ha superado el número permitido de intentos de igreso de PIN");
		this.rpta.put("85", "No hay razón para rechazar una solicitud de verificación de número de cuenta, verificación de dirección o verificación de CV");
		this.rpta.put("91", "No aplicable o disponible para esta transacción");
		
	}
	
	
	public void setrpta(String index, String value) {
		this.rpta.put(index, value);
	}

	public String getrpta(String index) {

		Object value = this.rpta.get(index);
		if (value != null) {
			return (String) value;
		} else {
			return "";
		}
	}	
	
}
