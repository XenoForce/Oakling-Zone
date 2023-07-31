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


public class Ripple_X extends ItemTurret {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Ripple_X() {
		
		super("ripple-x");
		
		localizedName = "Ripple X";
		
		requirements( Category.turret,
			with(	Items.copper, 150,
					Items.graphite, 135,
					Items.titanium, 60 ));
		
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
			
			Items.pyratite, new ArtilleryBulletType(3f, 24){{
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
			}},
			
			Items.blastCompound, new ArtilleryBulletType(2f, 20, "shell"){{
				hitEffect = Fx.blastExplosion;
				knockback = 0.8f;
				lifetime = 80f;
				width = height = 14f;
				collidesTiles = false;
				ammoMultiplier = 4f;
				splashDamageRadius = 45f * 0.75f;
				splashDamage = 55f;
				backColor = Pal.missileYellowBack;
				frontColor = Pal.missileYellow;
				status = StatusEffects.blasted;
			}},
			
			Items.plastanium, new ArtilleryBulletType(3.4f, 20, "shell"){{
				hitEffect = Fx.plasticExplosion;
				knockback = 1f;
				lifetime = 80f;
				width = height = 13f;
				collidesTiles = false;
				splashDamageRadius = 35f * 0.75f;
				splashDamage = 45f;
				
				fragBullet = new BasicBulletType(2.5f, 10, "bullet"){{
					width = 10f;
					height = 12f;
					shrinkY = 1f;
					lifetime = 15f;
					backColor = Pal.plastaniumBack;
					frontColor = Pal.plastaniumFront;
					despawnEffect = Fx.none;
					collidesAir = false;
				}};
				
				fragBullets = 10;
				backColor = Pal.plastaniumBack;
				frontColor = Pal.plastaniumFront;
			}}
		);
		
		targetAir = false;
		
		size = 3;
		
		shoot.shots = 4;
		inaccuracy = 4f;
		reload = 60f;
		ammoEjectBack = 5f;
		ammoUseEffect = Fx.casing3Double;
		ammoPerShot = 2;
		velocityRnd = 0.2f;
		recoil = 6f;
		shake = 2f;
		range = 290f;
		minRange = 50f;
		coolant = consumeCoolant(0.3f);

		scaledHealth = 130;
		
		shootSound = Sounds.artillery;
		
	} //Constructor
	
} //class
