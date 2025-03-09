package edu.gac.mcs178.gack.domain;

import java.util.ArrayList;
import java.util.List;
import edu.gac.mcs178.gack.Utility;

public class Troll extends AutoPerson{

	public Troll(String name, Place place, int threshold) {
		super(name, place, threshold);
	}
	
	public void act() {
		List<Person> others = otherPeopleAtSamePlace();
		//Need a func for Troll looking for chocolate out in the open
		huntChocolate();
		if (!others.isEmpty()) {
			Person victim = others.get(Utility.randInt(others.size()));
			if (victim instanceof Witch) {
				super.act();
			}
			else {
				takeChocolate(victim);
			}			
		}
		else {
			super.act();
		}
	}

	private void takeChocolate(Person victim) {
		say("Hey " + victim + ", Do you have any chocolate on you?");
		//if victim owns chocolate take it
		List<Thing> victimPossessions = new ArrayList<Thing>(victim.getPossessions());
		for (Thing thing: victimPossessions) {
			if (thing instanceof Chocolate) {
				say("I smell chocolate on you, " + victim);
				this.take(thing);
				this.eat((Chocolate) thing);
				return;
			}
		}
		say("Drats doesn't look like you have any on you, " + victim + ".");
	}
	
	private void huntChocolate() {
		Place place = this.getPlace();
		say("Is there chocolate here???");
		List<Thing> placeContents = new ArrayList<Thing>(place.getContents());
		for(Thing thing: placeContents) {
			if ((thing instanceof Chocolate) && !thing.isOwned()){
				say("Oooooo Chocolate!!!");
				this.take(thing);
				this.eat((Chocolate) thing);
				return;
			}
		}
	}

}
