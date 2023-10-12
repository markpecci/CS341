package pecci;

import java.util.ArrayList;
public class Counter {
	private int xfor, xwhile, xif, xotlines, xcomment;
	private ArrayList<String> headers;
	public Counter() {
		xfor = 0;
		xwhile = 0;
		xif = 0;
		xotlines = 0;
		xcomment = 0;
		headers = new ArrayList<String>();
	}
	public void addFor() {
		xfor++;
	}
	public void addWhile() {
		xwhile++;
	}
	public void addIf() {
		xif++;
	}
	public void addLine() {
		xotlines++;
	}
	public void addComment() {
		xcomment++;
	}
	public void addMethodHeader(String str) {
		headers.add(str);
	}
	public int getFor() {
		return xfor;
	}
	public int getWhile() {
		return xwhile;
	}
	public int getIf() {
		return xif;
	}
	public int getComment() {
		return xcomment;
	}
	public ArrayList<String> getMethodHeaders(){
		return headers;
	}
	public int getLines() {
		return xotlines;
	}
}
