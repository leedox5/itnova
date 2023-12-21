package kr.co.itnova.hello;

public class EmstRf implements Comparable<EmstRf> {
	private String partNo;
	private String extrSeq;

	public EmstRf(String partNo, String extrSeq) {
		this.partNo = partNo;
		this.extrSeq = extrSeq;
	}
	
	public String getPartNo() {
		return partNo;
	}

	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

	@Override
	public int compareTo(EmstRf emstRf) {
		String s1 = this.extrSeq.replace("T", "");
		String s2 = emstRf.getExtrSeq().replace("T", "");
		int n1 = Integer.parseInt(s1);
		int n2 = Integer.parseInt(s2); 
		if(n1 < n2) {
			return -1 ;
		} else if(n1 == n2) {
			return 0;
		} else {
			return 1;
		}
	}

	public String getExtrSeq() {
		return extrSeq;
	}

	public void setExtrSeq(String extrSeq) {
		this.extrSeq = extrSeq;
	}

	public String show() {
		return this.partNo + ":" + this.extrSeq;
	}
	
}
