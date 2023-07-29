package mod.blocks.turrets;

import arc.*;
import arc.graphics.*;
import arc.math.*;
import arc.math.geom.*;
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


public class Titan_X extends ItemTurret {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Titan_X() {
		
		super("titan-x");
		
		localizedName = "Titan X";
		
		requirements( Category.turret,
			with(	Items.silicon, 300,
					Items.thorium, 400 ));
		
		ammo(
		//TODO 1 more ammo type, decide on base type
		Items.thorium, new ArtilleryBulletType(2.5f, 350, "shell"){{
			hitEffect = new MultiEffect(Fx.titanExplosion, Fx.titanSmoke);
			despawnEffect = Fx.none;
			knockback = 2f;
			lifetime = 140f;
			height = 19f;
			width = 17f;
			splashDamageRadius = 65f;
			splashDamage = 350f;
			scaledSplashDamage = true;
			backColor = hitColor = trailColor = Color.valueOf("ea8878").lerp(Pal.redLight, 0.5f);
			frontColor = Color.white;
			ammoMultiplier = 1f;
			hitSound = Sounds.titanExplosion;
			
			status = StatusEffects.blasted;
			
			trailLength = 32;
			trailWidth = 3.35f;
			trailSinScl = 2.5f;
			trailSinMag = 0.5f;
			trailEffect = Fx.none;
			despawnShake = 7f;
			
			shootEffect = Fx.shootTitan;
			smokeEffect = Fx.shootSmokeTitan;
			
			trailInterp = v -> Math.max(Mathf.slope(v), 0.8f);
			shrinkX = 0.2f;
			shrinkY = 0.1f;
			buildingDamageMultiplier = 0.3f;
		}}
		);
		
		shootSound = Sounds.mediumCannon;
		ammoPerShot = 4;
		maxAmmo = ammoPerShot * 3;
		targetAir = false;
		shake = 4f;
		recoil = 1f;
		reload = 60f * 2.3f;
		shootY = 7f;
		rotateSpeed = 1.4f;
		minWarmup = 0.85f;
		shootWarmupSpeed = 0.07f;
		
		coolant = consume(new ConsumeLiquid(Liquids.water, 30f / 60f));
		coolantMultiplier = 1.5f;
		
		drawer = new DrawTurret("reinforced-"){{
			parts.addAll(
			new RegionPart("-barrel"){{
				progress = PartProgress.recoil.curve(Interp.pow2In);
				moveY = -5f * 4f / 3f;
				heatColor = Color.valueOf("f03b0e");
				mirror = false;
			}},
			new RegionPart("-side"){{
				heatProgress = PartProgress.warmup;
				progress = PartProgress.warmup;
				mirror = true;
				moveX = 2f * 4f / 3f;
				moveY = -0.5f;
				moveRot = -40f;
				under = true;
				heatColor = Color.red.cpy();
			}});
		}};
		
		shootWarmupSpeed = 0.08f;
		outlineColor = Pal.darkOutline;
		
		// consumeLiquid(Liquids.hydrogen, 5f / 60f);
		
		scaledHealth = 250;
		range = 390f;
		
		size = 4;
		
	} //Constructor
	
} //class
