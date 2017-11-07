package com.pe.ripley.stf.message;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "version", "type", "source", "target", "opcode", "timestamp", "trace", "status", "data" })
public class Message {

	@JsonProperty("id")
	private String id;

	@JsonProperty("version")
	private String version;
	
	@JsonProperty("type")
	private String type;	

	@JsonProperty("source")
	private String source;

	@JsonProperty("target")
	private String target;

	@JsonProperty("opcode")
	private String opcode;

	@JsonProperty("timestamp")
	private String timestamp;

	@JsonProperty("trace")
	private String trace;
	
	@JsonProperty("status")
	private String status;	

	@JsonProperty("data")
	private List<Datum> data = null;

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("version")
	public String getVersion() {
		return version;
	}

	@JsonProperty("version")
	public void setVersion(String version) {
		this.version = version;
	}
	
	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}	

	@JsonProperty("source")
	public String getSource() {
		return source;
	}

	@JsonProperty("source")
	public void setSource(String source) {
		this.source = source;
	}

	@JsonProperty("target")
	public String getTarget() {
		return target;
	}

	@JsonProperty("target")
	public void setTarget(String target) {
		this.target = target;
	}

	@JsonProperty("opcode")
	public String getOpcode() {
		return opcode;
	}

	@JsonProperty("opcode")
	public void setOpcode(String opcode) {
		this.opcode = opcode;
	}

	@JsonProperty("timestamp")
	public String getTimestamp() {
		return timestamp;
	}

	@JsonProperty("timestamp")
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@JsonProperty("trace")
	public String getTrace() {
		return trace;
	}

	@JsonProperty("trace")
	public void setTrace(String trace) {
		this.trace = trace;
	}
	
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}
	

	@JsonProperty("data")
	public List<Datum> getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(List<Datum> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}