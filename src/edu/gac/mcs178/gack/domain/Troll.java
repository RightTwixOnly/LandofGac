package edu.gac.mcs178.gack.domain;

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
		//Need something to see if others have chocolate so he can hone in on them and take it from them
		if (!others.isEmpty()) {
			Person victim = others.get(Utility.randInt(others.size()));
			takeChocolate(victim);
		}
		else {
			super.act();
		}
	}

	private void takeChocolate(Person victim) {
		say("Hey " + victim + ", Do you have any chocolate on you?");
		//if victim owns chocolate take it
		
		//this.take(chocolate)
		//this.eat(chocolate)
	}
	
	private void huntChocolate() {
		//Place place = this.getPlace();
		say("Ooh Chocolate!");
		//See if place where Troll is at has unowned chocolate
		//If so eat it all
		//for chocolate in place
		//this.take(chocolate)
		//this.eat(chocolate)
	}

}
