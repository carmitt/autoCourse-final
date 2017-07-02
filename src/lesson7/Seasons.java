package lesson7;

public enum Seasons {

	summer("hottt"), autoum("cold and hot"), spring("cold and hot"), winter("cold");

	public String text;

	@Override
	public String toString() {
		return text;
	}

	Seasons(String text) {
		this.text = text;
	}
}
