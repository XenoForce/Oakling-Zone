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


public class Fortress_X extends UnitType {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Fortress_X() {
		
		super("fortress-x");
		
		localizedName = "Fortress X";
		constructor = EntityMapping.map("fortress");
		
		speed = 0.43f;
		
		hitSize = 13f;
		rotateSpeed = 3f;
		targetAir = false;
		
		health = 900;
		armor = 9f;
		
		mechFrontSway = 0.55f;
		ammoType = new ItemAmmoType(Items.graphite);
		
		weapons.add(new Weapon("artillery"){{
			top = false;
			y = 1f;
			x = 9f;
			reload = 60f;
			recoil = 4f;
			shake = 2f;
			ejectEffect = Fx.casing2;
			shootSound = Sounds.artillery;
			
			bullet = new ArtilleryBulletType(2f, 20, "shell"){{
				hitEffect = Fx.blastExplosion;
				knockback = 0.8f;
				lifetime = 120f;
				width = height = 14f;
				collides = true;
				collidesTiles = true;
				splashDamageRadius = 35f;
				splashDamage = 80f;
				backColor = Pal.bulletYellowBack;
				frontColor = Pal.bulletYellow;
			}};
		}});
		
	} //Constructor
	
} //class
