package edu.gac.mcs178.gack.domain;

import edu.gac.mcs178.gack.Utility;

public class Chocolate extends Thing{

	public Chocolate(String chocolate) {
		super(chocolate);
	}
	
	public void beEaten() {
		Person owner = getOwner();
		if (owner == null) {
			Utility.displayMessage("No one has " + getName());
		}
		else {
			Place place = owner.getPlace();
			owner.say("Yummy " + getName() + "!");
			owner.lose(this);
			place.lose(this);
		}
	}

}
