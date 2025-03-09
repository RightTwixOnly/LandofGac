package edu.gac.mcs178.gack.domain;

import java.util.ArrayList;
import java.util.List;

import edu.gac.mcs178.gack.Utility;
import edu.gac.mcs178.gack.domain.ScrollOfTeleportation;

public abstract class MagicScroll extends Scroll {
	
	private int n;

	public MagicScroll(String title, int n) {
		super(title);
		this.n = n;
	}

	public void beRead() {
		Person owner = getOwner();
		if (owner == null) {
			Utility.displayMessage("No one has " + getName());
		} else {
			this.doMagic();
			Place place = owner.getPlace();
			this.setName("Scroll of Teleportation");
			if (n == 1) {
				owner.lose(this);
				place.lose(this);
				
			}
			owner.say("I have read " + getName());
			n = n-1;
		}
	}
	
	
	public abstract void doMagic();
	
	public static List<MagicScroll> magicScrollsIn(Place place) {
		ArrayList<MagicScroll> magicScrollsIn = new ArrayList<MagicScroll>();
		for (Thing thing : place.getContents()) {
			if (thing instanceof MagicScroll) {
				magicScrollsIn.add((MagicScroll) thing);
			}
		}
		return magicScrollsIn;
	}
}
