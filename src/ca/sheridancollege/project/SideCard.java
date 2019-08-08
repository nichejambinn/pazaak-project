package ca.sheridancollege.project;

public class SideCard extends Card {

	private SideValue value;

	public SideValue getValue() {
		return this.value;
	}

	/**
	 *
	 * @param value
	 */
	public void setValue(SideValue value) {
		this.value = value;
	}

	/**
	 *
	 * @param value
	 */
	public SideCard(SideValue value) {
		super();
		this.value = value;
	}

	@Override
	public String toString() {
		String top = " ____ \n";
		String sideTop;
		if (this.value.value > 0)
			sideTop = "|+" + this.value.value + "  |\n";
		else
			sideTop = "|" + this.value.value + "  |\n";
		String sideMiddle = "|    |\n";
		String bottom = "|____|\n";
		return top+sideTop+sideMiddle+bottom;
	}

}