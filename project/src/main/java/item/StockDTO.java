package item;

public class StockDTO {
	private int XS, S, M, L, XL, XXL;

	public StockDTO(int XS, int S, int M, int L, int XL, int XXL) {
		this.XS = XS;
		this.S = S;
		this.M = M;
		this.L = L;
		this.XL = XL;
		this.XXL = XXL;
	}

	public int getXS() {
		return XS;
	}

	public void setXS(int xS) {
		XS = xS;
	}

	public int getS() {
		return S;
	}

	public void setS(int s) {
		S = s;
	}

	public int getM() {
		return M;
	}

	public void setM(int m) {
		M = m;
	}

	public int getL() {
		return L;
	}

	public void setL(int l) {
		L = l;
	}

	public int getXL() {
		return XL;
	}

	public void setXL(int xL) {
		XL = xL;
	}

	public int getXXL() {
		return XXL;
	}

	public void setXXL(int xXL) {
		XXL = xXL;
	}

}
