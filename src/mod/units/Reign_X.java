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


public class Reign_X extends UnitType {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Reign_X() {
		
		super("reign-x");
		
		localizedName = "Reign X";
		constructor = EntityMapping.map("reign");
		
		speed = 0.35f;
		hitSize = 26f;
		rotateSpeed = 1.65f;
		health = 24000;
		armor = 14f;
		mechStepParticles = true;
		stepShake = 0.75f;
		drownTimeMultiplier = 6f;
		mechFrontSway = 1.9f;
		mechSideSway = 0.6f;
		ammoType = new ItemAmmoType(Items.thorium);
		
		weapons.add(
		new Weapon("reign-weapon"){{
			top = false;
			y = 1f;
			x = 21.5f;
			shootY = 11f;
			reload = 9f;
			recoil = 5f;
			shake = 2f;
			ejectEffect = Fx.casing4;
			shootSound = Sounds.bang;

			bullet = new BasicBulletType(13f, 80){{
				pierce = true;
				pierceCap = 10;
				width = 14f;
				height = 33f;
				lifetime = 15f;
				shootEffect = Fx.shootBig;
				fragVelocityMin = 0.4f;

				hitEffect = Fx.blastExplosion;
				splashDamage = 18f;
				splashDamageRadius = 13f;

				fragBullets = 3;
				fragLifeMin = 0f;
				fragRandomSpread = 30f;

				fragBullet = new BasicBulletType(9f, 20){{
					width = 10f;
					height = 10f;
					pierce = true;
					pierceBuilding = true;
					pierceCap = 3;

					lifetime = 20f;
					hitEffect = Fx.flakExplosion;
					splashDamage = 15f;
					splashDamageRadius = 10f;
				}};
			}};
		}}
		);
		
	} //Constructor
	
} //class
