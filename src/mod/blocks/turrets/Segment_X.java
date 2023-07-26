package mod.blocks.turrets;

import arc.*;
import arc.graphics.*;
import arc.util.*;

import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;

import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.pattern.*;
import mindustry.graphics.*;
import mindustry.type.*;

import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

// import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;


public class Segment_X extends PointDefenseTurret {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Segment_X() {
		
		super("segment-x");
		
		localizedName = "Segment X";
		
		requirements( Category.turret,
			with(	Items.silicon, 130,
					Items.thorium, 80,
					Items.phaseFabric, 40,
					Items.titanium, 40 ));
		
		scaledHealth = 250;
		range = 180f;
		hasPower = true;
		consumePower(8f);
		
		size = 2;
		
		shootLength = 5f;
		bulletDamage = 30f;
		reload = 8f;
		// envEnabled |= Env.space;
		
	} //Constructor
	
} //class
