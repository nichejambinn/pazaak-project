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
		// TODO - implement SideCard.SideCard
		super();
		this.value = value;
	}

	@Override
	public String toString() {
		// TODO - implement SideCard.toString
		return "SideCard value";
	}

}