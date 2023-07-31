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


public class Hail_X extends ItemTurret {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Hail_X() {
		
		super("hail-x");
		
		localizedName = "Hail X";
		
		requirements( Category.turret,
			with(	Items.copper, 40, 
					Items.graphite, 17 ));
		
		ammo(
			Items.graphite, new ArtilleryBulletType(3f, 20){{
				knockback = 0.8f;
				lifetime = 80f;
				width = height = 11f;
				collidesTiles = false;
				splashDamageRadius = 25f * 0.75f;
				splashDamage = 33f;
			}},
			
			Items.silicon, new ArtilleryBulletType(3f, 20){{
				knockback = 0.8f;
				lifetime = 80f;
				width = height = 11f;
				collidesTiles = false;
				splashDamageRadius = 25f * 0.75f;
				splashDamage = 33f;
				reloadMultiplier = 1.2f;
				ammoMultiplier = 3f;
				homingPower = 0.08f;
				homingRange = 50f;
			}},
			
			Items.pyratite, new ArtilleryBulletType(3f, 25){{
				hitEffect = Fx.blastExplosion;
				knockback = 0.8f;
				lifetime = 80f;
				width = height = 13f;
				collidesTiles = false;
				splashDamageRadius = 25f * 0.75f;
				splashDamage = 45f;
				status = StatusEffects.burning;
				statusDuration = 60f * 12f;
				frontColor = Pal.lightishOrange;
				backColor = Pal.lightOrange;
				makeFire = true;
				trailEffect = Fx.incendTrail;
				ammoMultiplier = 4f;
			}}
		);
		
		targetAir = false;
		reload = 60f;
		recoil = 2f;
		range = 235f;
		inaccuracy = 1f;
		shootCone = 10f;
		
		health = 260;
		
		shootSound = Sounds.bang;
		coolant = consumeCoolant(0.1f);
		limitRange(0f);
		
	} //Constructor
	
} //class
