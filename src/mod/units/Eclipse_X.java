package mod.units;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;

import mindustry.ai.*;
import mindustry.ai.types.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.type.unit.*;
import mindustry.type.weapons.*;
import mindustry.world.meta.*;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;


public class Eclipse_X extends UnitType {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Eclipse_X() {
		
		super("eclipse-x");
		
		localizedName = "Eclipse X";
		constructor = EntityMapping.map("eclipse");
		
		speed = 0.54f;
		accel = 0.04f;
		drag = 0.04f;
		rotateSpeed = 1f;
		flying = true;
		lowAltitude = true;
		health = 22000;
		engineOffset = 38;
		engineSize = 7.3f;
		hitSize = 58f;
		armor = 13f;
		targetFlags = new BlockFlag[]{BlockFlag.reactor, BlockFlag.battery, BlockFlag.core, null};
		ammoType = new ItemAmmoType(Items.thorium);
		
		BulletType fragBullet = new FlakBulletType(4f, 15){{
			shootEffect = Fx.shootBig;
			ammoMultiplier = 4f;
			splashDamage = 65f;
			splashDamageRadius = 25f;
			collidesGround = true;
			lifetime = 47f;
			
			status = StatusEffects.blasted;
			statusDuration = 60f;
		}};
		
		weapons.add(
		new Weapon("large-laser-mount"){{
			shake = 4f;
			shootY = 9f;
			x = 18f;
			y = 5f;
			rotateSpeed = 2f;
			reload = 45f;
			recoil = 4f;
			shootSound = Sounds.laser;
			shadow = 20f;
			rotate = true;
			
			bullet = new LaserBulletType(){{
				damage = 115f;
				sideAngle = 20f;
				sideWidth = 1.5f;
				sideLength = 80f;
				width = 25f;
				length = 230f;
				shootEffect = Fx.shockwave;
				colors = new Color[]{Color.valueOf("ec7458aa"), Color.valueOf("ff9c5a"), Color.white};
			}};
		}},
		new Weapon("large-artillery"){{
			x = 11f;
			y = 27f;
			rotateSpeed = 2f;
			reload = 9f;
			shootSound = Sounds.shoot;
			shadow = 7f;
			rotate = true;
			recoil = 0.5f;
			shootY = 7.25f;
			bullet = fragBullet;
		}},
		new Weapon("large-artillery"){{
			y = -13f;
			x = 20f;
			reload = 12f;
			ejectEffect = Fx.casing1;
			rotateSpeed = 7f;
			shake = 1f;
			shootSound = Sounds.shoot;
			rotate = true;
			shadow = 12f;
			shootY = 7.25f;
			bullet = fragBullet;
		}});
		
	} //Constructor
	
} //class
