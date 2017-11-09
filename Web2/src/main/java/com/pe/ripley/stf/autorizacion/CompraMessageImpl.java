package com.pe.ripley.stf.autorizacion;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Path;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pe.ripley.stf.message.Datum;
import com.pe.ripley.stf.message.Message;
import com.pe.ripley.stf.service.ServiceMessage;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Path("/compras")
public class CompraMessageImpl implements ServiceMessage {

	private static Message msg;
	static {
		msg = new Message();
		msg.setId("0");
		msg.setOpcode("opcode");
		msg.setSource("source");
		msg.setTimestamp("01/01/2017");
		msg.setTarget("target");
		msg.setVersion("version");
		msg.setType("type");
		msg.setTrace("trace");

		List<Datum> ldatum = new ArrayList<Datum>();

		for (int i = 0; i < 5; i++) {

			Datum d = new Datum();
			d.setBit(String.valueOf(i));
			d.setValue("demo" + i);
			ldatum.add(d);

		}
		msg.setData(ldatum);

	}	
	
	@Override
	public Message Post(Message msg) {
		// TODO Auto-generated method stub
		return msg;
	}
}
