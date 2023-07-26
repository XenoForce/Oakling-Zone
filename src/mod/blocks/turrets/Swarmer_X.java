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


public class Swarmer_X extends ItemTurret {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Swarmer_X() {
		
		super("swarmer-x");
		
		localizedName = "Swarmer X";
		
		requirements( Category.turret,
			with(	Items.graphite, 35,
					Items.titanium, 35,
					Items.plastanium, 45,
					Items.silicon, 30 ));
		
		ammo(
			Items.blastCompound, new MissileBulletType(3.7f, 10){{
				width = 8f;
				height = 8f;
				shrinkY = 0f;
				splashDamageRadius = 30f;
				splashDamage = 30f * 1.5f;
				ammoMultiplier = 5f;
				hitEffect = Fx.blastExplosion;
				despawnEffect = Fx.blastExplosion;
				
				status = StatusEffects.blasted;
				statusDuration = 60f;
			}},
			
			Items.pyratite, new MissileBulletType(3.7f, 12){{
				frontColor = Pal.lightishOrange;
				backColor = Pal.lightOrange;
				width = 7f;
				height = 8f;
				shrinkY = 0f;
				homingPower = 0.08f;
				splashDamageRadius = 20f;
				splashDamage = 30f * 1.5f;
				makeFire = true;
				ammoMultiplier = 5f;
				hitEffect = Fx.blastExplosion;
				status = StatusEffects.burning;
			}},
			
			Items.surgeAlloy, new MissileBulletType(3.7f, 18){{
				width = 8f;
				height = 8f;
				shrinkY = 0f;
				splashDamageRadius = 25f;
				splashDamage = 25f * 1.4f;
				hitEffect = Fx.blastExplosion;
				despawnEffect = Fx.blastExplosion;
				ammoMultiplier = 4f;
				lightningDamage = 10;
				lightning = 2;
				lightningLength = 10;
			}}
		);
		
		shoot = new ShootAlternate(){{
			shots = 4;
			barrels = 3;
			spread = 3.5f;
			shotDelay = 5f;
		}};
		
		shootY = 7f;
		reload = 30f;
		inaccuracy = 10f;
		range = 240f;
		size = 2;
		scaledHealth = 300;
		shootSound = Sounds.missile;
		// envEnabled |= Env.space;
		
		limitRange(5f);
		coolant = consumeCoolant(0.3f);
		
	} //Constructor
	
} //class
