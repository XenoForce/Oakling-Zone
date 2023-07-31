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


public class Arc_X extends PowerTurret {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Arc_X() {
		
		super("arc-x");
		
		localizedName = "Arc X";
		
		requirements( Category.turret,
			with(	Items.copper, 50,
					Items.lead, 50 ));
		
		shootType = new LightningBulletType(){{
			damage = 20;
			lightningLength = 25;
			collidesAir = false;
			ammoMultiplier = 1f;
			
			//for visual stats only.
			buildingDamageMultiplier = 0.25f;
			
			lightningType = new BulletType(0.0001f, 0f){{
				lifetime = Fx.lightning.lifetime;
				hitEffect = Fx.hitLancer;
				despawnEffect = Fx.none;
				status = StatusEffects.shocked;
				statusDuration = 10f;
				hittable = false;
				lightColor = Color.white;
				collidesAir = false;
				buildingDamageMultiplier = 0.25f;
			}};
		}};
		
		reload = 35f;
		shootCone = 40f;
		rotateSpeed = 8f;
		targetAir = false;
		range = 90f;
		shootEffect = Fx.lightningShoot;
		heatColor = Color.red;
		recoil = 1f;
		
		size = 1;
		
		health = 260;
		
		shootSound = Sounds.spark;
		consumePower(3.3f);
		coolant = consumeCoolant(0.1f);
		
	} //Constructor
	
} //class
