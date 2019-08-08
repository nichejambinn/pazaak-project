package ca.sheridancollege.project;

public class TableCard extends Card {

	private TableValue value;

	public TableValue getValue() {
		return this.value;
	}

	/**
	 *
	 * @param value
	 */
	public void setValue(TableValue value) {
		this.value = value;
	}

	/**
	 *
	 * @param value
	 */
	public TableCard(TableValue value) {
		this.value = value;
	}

	public String toString() {
		String top = " ____ \n";
		String sideTop;
		if (this.value.value == 10)
			sideTop = "|" + this.value.value + "  |\n";
		else
			sideTop = "|" + this.value.value + "   |\n";
		String sideMiddle = "|    |\n";
		String bottom = "|____|\n";
		return top+sideTop+sideMiddle+bottom;
	}

}