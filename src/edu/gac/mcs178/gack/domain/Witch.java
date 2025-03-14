package edu.gac.mcs178.gack.domain;

import java.util.ArrayList;
import java.util.List;

import edu.gac.mcs178.gack.Utility;

public class Witch extends AutoPerson {
	
	private Place pond;
	
	public Witch(String name, Place place, int threshold, Place pond) {
		super(name, place, threshold);
		this.pond = pond;
	}

	@Override
	public void act() {
		List<Person> others = otherPeopleAtSamePlace();
		if (!others.isEmpty()) {
			Person victim = others.get(Utility.randInt(others.size()));
			curse(victim);
		} else {
			super.act();
		}
	}

	public void curse(Person person) {
		if (person instanceof Troll) {
			return;
		}
		say("Hah hah hah, I'm going to turn you into a frog, " + person);
		List<Thing> targetPossessions = new ArrayList<Thing>(person.getPossessions());
		for (Thing thing: targetPossessions) {
			if (thing instanceof Chocolate) {
				say("Lucky " + person + ". I smell chocolate on you!");
				this.take(thing);
				this.eat((Chocolate) thing);
				return;
			}
		}
		//Need to add something to check if target owns thing of type Chocolate
		//for (Thing thing : targetPossessions) {} 
		turnIntoFrog(person);
		say("Hee hee " + person + " looks better in green!");
	}
	
	public void turnIntoFrog(Person person) {
		// need to copy person.getPossessions() in order to avoid a ConcurrentModificationException
		List<Thing> personsPossessions = new ArrayList<Thing>(person.getPossessions());
		for (Thing thing : personsPossessions) {
			person.lose(thing);
		}
		person.say("Ribbitt!");
		person.moveTo(pond);
	}
}
