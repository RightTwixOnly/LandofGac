package edu.gac.mcs178.gack.domain;

import java.util.List;

import edu.gac.mcs178.gack.Utility;

public class Wizard extends AutoPerson {
	
	private Place chamber;
	
	public Wizard(String name, Place place, int threshold, Place chamber) {
		super(name, place, threshold);
		this.chamber = chamber;
	}
	
	@Override
	public void act() {
		List<Scroll> scrolls = Scroll.scrollsIn(getPlace());
		int scrollOrder = Utility.randInt(scrolls.size());
		if ((!scrolls.isEmpty()) && (!getPlace().equals(chamber))) {
			take(scrolls.get(scrollOrder));
			moveTo(chamber);
			lose(scrolls.get(scrollOrder));
		} else {
			super.act();
		}
	}
	
	public static void main(String[] args) {
		Place chamberOfWizards = new Place("Chamber of Wizards");
		Place karlsOffice = new Place("Karl's Office");
		new Wizard("Elvee", karlsOffice, 2, chamberOfWizards);
		
		karlsOffice.gain(new Scroll("Scroll of Enlightenment"));
		karlsOffice.gain(new Thing("Karl's phone"));
		
		System.out.println(karlsOffice.getContents());
		System.out.println(karlsOffice.getOccupants());
	}
}
