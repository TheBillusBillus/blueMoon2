package triangles;

public class Tri {
	public double sa;
	public double sb;
	public double sc;
	public double aa;
	public double ab;
	public double ac;

	public Tri(double a, double b, double c) {
		this.sa = a;
		this.sb = b;
		this.sc = c;
		this.aa = Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / 2 * b * c);
		this.ab = Math.acos((Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / 2 * a * c);
		this.ac = Math.acos((Math.pow(b, 2) + Math.pow(a, 2) - Math.pow(c, 2)) / 2 * b * a);
	}

	public double getSideA() {
		return this.sa;
	}

	public double getSideB() {
		return this.sb;
	}

	public double getSideC() {
		return this.sc;
	}

	public void changeA(double o) {
		this.sa = o;
	}

	public void changeB(double o) {
		this.sb = o;
	}

	public void changeC(double o) {
		this.sc = o;
	}

	public String toString() {
		return "Side A:" + sa + " | Side B: " + sb + " | Side C: " + sc + " || Angle A: " + aa + " | Angle B: " + ab
				+ " | Angle C: " + ac;
	}
}
