package pecci;

public class Fraction {
	private Integer num;
	private Integer den;
	
public Fraction(String str) {
	String[] fraction = str.split("/");
	num = Integer.parseInt(fraction[0]);
	den = Integer.parseInt(fraction[1]);
	}

	
public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getDen() {
		return den;
	}

	public void setDen(Integer den) {
		this.den = den;
	}



public String toString() {
	return "" + num + "/" + den;
}

public void add(Fraction f) {
	Integer tempDen = getGCD(den, f.getDen());
	tempDen = (this.den * f.getDen()) / tempDen;
	
	Integer tempNum = num * tempDen / den + f.getNum() * tempDen / f.getDen();
	
	num = tempNum;
	den = tempDen;
	
	reduce();
			
}
public void reduce() {
	int gcd = getGCD(num, den);
	num = num / gcd;
	den = den / gcd;
}

public Integer getGCD(Integer x, Integer y) {
	if(x==0)
		return y;
	return getGCD(y % x, x);
}

}
