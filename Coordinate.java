
public class Coordinate {

	private int x, y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String toString() {
		return "(" + String.valueOf(x) + ", " + String.valueOf(y) + ")";
	}
}
