package enums;

public enum ByTypes {

	xpath("xpath"), id("id"), name("name"), className("class"), link("link");

	public String text;

	public String toString() {
		return this.text;
	}

	// Accepts the value of the enum
	ByTypes(String text) {
		this.text = text;
	}

}
