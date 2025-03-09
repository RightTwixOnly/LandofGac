package edu.gac.mcs178.gack.domain;

import java.util.ArrayList;
import java.util.List;
import edu.gac.mcs178.gack.GackWorld;

import edu.gac.mcs178.gack.Utility;

public class ScrollOfTeleportation extends MagicScroll {

	private Place teleport;
	
	public ScrollOfTeleportation(String name, int n, Place teleport) {
		super(name, n);
		this.teleport = teleport;
		
	}
	
	public void doMagic() {
		Person owner = getOwner();
		owner.moveTo(teleport);
		
		
	}
	
}