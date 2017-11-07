
package eft.restclient.lib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.json.JSONException;
import java.io.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "version", "type", "source", "target", "opcode", "timestamp", "trace", "status", "data" })
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;

	public static int MSG_VERSION = 0;
	public static int REQ_MESSAGE = 1;
	public static int RES_MESSAGE = 2;

	private int version;
	private int type;
	private String source;
	private String target;
	private String timestamp;
	private String opcode;
	private int status;
	private String trace;
	private String id;
	private HashMap<String, String> data;

	public Message() throws Exception {
		this.version = MSG_VERSION;
		this.type = REQ_MESSAGE;
		this.source = "";
		this.target = "";
		this.timestamp = newTimestamp();
		this.opcode = "";
		this.status = 0;
		this.id = newTraceNumber();
		this.trace = this.id;
		this.data = new HashMap<String, String>(17);
	}

	public Message(Message other) {
		this.version = other.version;
		this.type = other.type;
		this.trace = other.trace;
		this.source = other.source;
		this.target = other.target;
		this.timestamp = other.timestamp;
		this.opcode = other.opcode;
		this.status = other.status;
		this.data = other.data;
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getOpcode() {
		return opcode;
	}

	public void setOpcode(String opcode) {
		this.opcode = opcode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTrace() {
		return trace;
	}

	public void setTrace(String trace) {
		this.trace = trace;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setData(String index, String value) {
		this.data.put(index, value);
	}

	public String getData(String index) {

		Object value = this.data.get(index);
		if (value != null) {
			return (String) value;
		} else {
			return "";
		}
	}
	
	public HashMap<String, String> getData() {
		return data;
	}

	public void setData(HashMap<String, String> data) {
		this.data = data;
	}

	private String newTimestamp() {
		// rfc 3339 without timezone
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		// 20170716122554797
	}

	private static String newTraceNumber() throws Exception {
		return String.format("%18s", UniqueID.getInstance().generateLongId());
	}

	//
	// serializa el mensaje a una cadena de string
	//
	public String Marshal() {
		String head = "";
		head += String.format("%1d", MSG_VERSION);
		head += String.format("%1d", this.type);
		head += String.format("%6s", this.source);
		head += String.format("%6s", this.target);
		head += String.format("%17s", this.timestamp);
		head += String.format("%18s", this.trace);
		if (this.type == REQ_MESSAGE) {
			head += String.format("%9s", this.opcode);
		} else {
			head += String.format("%02d", this.status);
		}
		if (this.data.isEmpty()) {
			return head + "000||";
		}
		head += String.format("%03d", this.data.size());
		String keys = "";
		String vals = "";
		Iterator<String> keySetIterator = this.data.keySet().iterator();
		while (keySetIterator.hasNext()) {
			String key = keySetIterator.next();
			keys += key;
			vals += this.data.get(key) + "|";
		}
		return head + "|" + keys + "|" + vals;
	}

	//
	// deserializa una cadena de string produciendo un mensaje
	//
	public void Unmarshal(String raw) {
		int offset = 49;
		this.version = Integer.parseInt(raw.substring(0, 1));
		this.type = Integer.parseInt(raw.substring(1, 2));
		this.source = raw.substring(2, 8);
		this.target = raw.substring(8, 14);
		this.timestamp = raw.substring(14, 31);
		this.trace = raw.substring(31, 49);
		this.opcode = "";
		this.status = 0;
		this.data = new HashMap<String, String>(7);
		if (this.type == REQ_MESSAGE) {
			this.opcode = raw.substring(49, 58);
			offset = 58;
		} else {
			this.status = Integer.parseInt(raw.substring(49, 51));
			offset = 51;
		}
		int size = Integer.parseInt(raw.substring(offset, offset + 3));
		if (size > 0) {
			offset += 4;
			String keys = raw.substring(offset, 3 * size + offset);
			String[] vals = raw.substring(3 * size + offset + 1, raw.length() - 1).split("\\|", -1);
			for (int i = 0; i < size; i++) {
				this.data.put(keys.substring(i * 3, i * 3 + 3), vals[i]);
			}
		}
	}

	public String DataToString() {

		String vals = "";
		Map<String, String> map = new TreeMap<String, String>(this.data);

		Iterator<String> keySetIterator = map.keySet().iterator();
		while (keySetIterator.hasNext()) {

			String key = keySetIterator.next();
			vals += "(" + key + "," + this.data.get(key) + ")";
		}
		return vals;
	}

	@Override
	public String toString() {
		return "Message{" + "id=" + getId() + ", trace=" + getTrace() + ", source=" + getSource() + ", target=" + target
				+ ", timestamp=" + getTimestamp() + ", opcode=" + getOpcode() + ", status=" + getStatus() + ", data=[ "
				+ DataToString() + "] }";
	}

	public JSONObject toJson() throws JSONException {

		JSONObject obj = new JSONObject();
		obj.put("version", getVersion());
		obj.put("type", getType());
		obj.put("id", getId());
		obj.put("trace", getTrace());
		obj.put("source", getSource());
		obj.put("target", getTarget());
		obj.put("timestamp", getTimestamp());
		obj.put("opcode", getOpcode());
		obj.put("status", getStatus());

		obj.put("data", getData());

		return obj;
	}
	
	public Message(JSONObject obj) throws JSONException {
		this.version = obj.getInt("version");
		this.type = obj.getInt("type");
		this.trace = obj.getString("trace");
		this.source = obj.getString("source");
		this.target = obj.getString("target");
		this.timestamp = obj.getString("timestamp");
		
		if (this.type == 1 ) this.opcode = obj.getString("opcode");
		if (this.type == 2 ) this.status = obj.getInt("status");
		this.data = new HashMap<String, String>(17);

		JSONObject objList = obj.getJSONObject("data");
		String[] elementNames = JSONObject.getNames(objList);
		for (String elementName : elementNames)
		{
			this.data.put( elementName, objList.getString(elementName) );
		}	
	}

}
