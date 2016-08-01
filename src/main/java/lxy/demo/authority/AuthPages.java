package lxy.demo.authority;

public class AuthPages {

	private String PAGES;
	
	private int PAGESAUTH;

	public String getPAGES() {
		return PAGES;
	}

	public void setPAGES(String pAGES) {
		PAGES = pAGES;
	}

	public int getPAGESAUTH() {
		return PAGESAUTH;
	}

	public void setPAGESAUTH(int pAGESAUTH) {
		PAGESAUTH = pAGESAUTH;
	}

	@Override
	public String toString() {
		return "AuthPages [PAGES=" + PAGES + ", PAGESAUTH=" + PAGESAUTH + "]";
	}
	
}
