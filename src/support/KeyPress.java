package support;

public enum KeyPress {
	NONE(""), ZERO("0"), ONE("1"), TWO("2"), THREE("3"), FOUR("4"),
	FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"),
	ADD(" + "), SUBTRACT(" - "), MULTIPLY(" * "), DIVIDE(" / "),
	NEGATIVE("-");
	
	String display;
	
	KeyPress(String display){
		this.display = display;
	}
	
	@Override
	public String toString(){
		return display;
	}
}
