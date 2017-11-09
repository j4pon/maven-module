package com.pe.ripley.stf.message;

//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({ "bit", "value" })
public class Datum {

	//@JsonProperty("bit")
	private String bit;
	//@JsonProperty("value")
	private String value;

	//@JsonProperty("bit")
	public String getBit() {
		return bit;
	}

	//@JsonProperty("bit")
	public void setBit(String bit) {
		this.bit = bit;
	}

	//@JsonProperty("value")
	public String getValue() {
		return value;
	}

	//@JsonProperty("value")
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}