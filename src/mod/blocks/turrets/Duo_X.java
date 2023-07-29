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
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.graphics.*;
import mindustry.type.*;

import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

// import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;


public class Duo_X extends ItemTurret {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Duo_X() {
		
		super("duo-x");
		
		localizedName = "Duo X";
		
		requirements( Category.turret,
			with(	Items.copper, 35 ));
		
		ammo(
			Items.copper,  new BasicBulletType(2.5f, 9){{
				width = 7f;
				height = 9f;
				lifetime = 60f;
				ammoMultiplier = 2;
			}},
			
			Items.graphite, new BasicBulletType(3.5f, 18){{
				width = 9f;
				height = 12f;
				reloadMultiplier = 0.6f;
				ammoMultiplier = 4;
				lifetime = 60f;
			}},
			
			Items.silicon, new BasicBulletType(3f, 12){{
				width = 7f;
				height = 9f;
				homingPower = 0.1f;
				reloadMultiplier = 1.5f;
				ammoMultiplier = 5;
				lifetime = 60f;
			}}
		);
		
		shoot = new ShootAlternate(3.5f);
		
		shootY = 3f;
		reload = 20f;
		range = 110;
		shootCone = 15f;
		ammoUseEffect = Fx.casing1;
		health = 250;
		inaccuracy = 2f;
		rotateSpeed = 10f;
		coolant = consumeCoolant(0.1f);
		
		researchCostMultiplier = 0.05f;
		
		limitRange();
		
	} //Constructor
	
} //class
