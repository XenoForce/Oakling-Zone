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


public class Cyclone_X extends ItemTurret {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Cyclone_X() {
		
		super("cyclone-x");
		
		localizedName = "Cyclone X";
		
		requirements(Category.turret,
			with(	Items.copper, 200,
					Items.titanium, 125,
					Items.plastanium, 80 ));
		
		ammo(
			Items.metaglass, new FlakBulletType(4f, 6){{
				ammoMultiplier = 2f;
				shootEffect = Fx.shootSmall;
				reloadMultiplier = 0.8f;
				width = 6f;
				height = 8f;
				hitEffect = Fx.flakExplosion;
				splashDamage = 45f;
				splashDamageRadius = 25f;
				fragBullet = new BasicBulletType(3f, 12, "bullet"){{
					width = 5f;
					height = 12f;
					shrinkY = 1f;
					lifetime = 20f;
					backColor = Pal.gray;
					frontColor = Color.white;
					despawnEffect = Fx.none;
				}};
				fragBullets = 4;
				explodeRange = 20f;
				collidesGround = true;
			}},
			
			Items.blastCompound, new FlakBulletType(4f, 8){{
				shootEffect = Fx.shootBig;
				ammoMultiplier = 5f;
				splashDamage = 45f;
				splashDamageRadius = 60f;
				collidesGround = true;
				
				status = StatusEffects.blasted;
				statusDuration = 60f;
			}},
			
			Items.plastanium, new FlakBulletType(4f, 8){{
				ammoMultiplier = 4f;
				splashDamageRadius = 40f;
				splashDamage = 37.5f;
				fragBullet = new BasicBulletType(2.5f, 12, "bullet"){{
					width = 10f;
					height = 12f;
					shrinkY = 1f;
					lifetime = 15f;
					backColor = Pal.plastaniumBack;
					frontColor = Pal.plastaniumFront;
					despawnEffect = Fx.none;
				}};
				fragBullets = 6;
				hitEffect = Fx.plasticExplosion;
				frontColor = Pal.plastaniumFront;
				backColor = Pal.plastaniumBack;
				shootEffect = Fx.shootBig;
				collidesGround = true;
				explodeRange = 20f;
			}},
			
			Items.surgeAlloy, new FlakBulletType(4.5f, 13){{
				ammoMultiplier = 5f;
				splashDamage = 50f * 1.5f;
				splashDamageRadius = 38f;
				lightning = 2;
				lightningLength = 7;
				shootEffect = Fx.shootBig;
				collidesGround = true;
				explodeRange = 20f;
			}}
		);
		
		shootY = 8.75f;
		
		shoot = new ShootBarrel(){{
			barrels = new float[]{
			0f, 1f, 0f,
			3f, 0f, 0f,
			-3f, 0f, 0f,
			};
		}};
		
		reload = 8f;
		range = 200f;
		size = 3;
		recoil = 3f;
		rotateSpeed = 10f;
		inaccuracy = 10f;
		shootCone = 30f;
		shootSound = Sounds.shootSnap;
		coolant = consumeCoolant(0.3f);
		
		scaledHealth = 145;
		limitRange();
		
	} //Constructor
	
} //class
