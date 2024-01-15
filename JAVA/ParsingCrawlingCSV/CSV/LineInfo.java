package ex03.csv;

import java.util.List;

public class LineInfo {
	private List<String> header;
	private List<String> info;
	
	public LineInfo() {
		super();
	}

	public LineInfo(List<String> header, List<String> info) {
		super();
		this.header = header;
		this.info = info;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < header.size(); i++) {
			sb.append(header.get(i) + ":" + info.get(i) + ", ");
		}
		return sb.toString();
	}

	public List<String> getHeader() {
		return header;
	}

	public void setHeader(List<String> header) {
		this.header = header;
	}

	public List<String> getInfo() {
		return info;
	}

	public void setInfo(List<String> info) {
		this.info = info;
	}
	
	public int getSize() {
		return header.size();
	}
	
	public String getData(String key) {
		int index = header.indexOf(key);
		if(index != -1) {
			return info.get(index);
		} else {
			return null;
		}
	}

}
