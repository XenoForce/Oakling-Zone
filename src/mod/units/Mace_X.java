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


public class Mace_X extends UnitType {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Mace_X() {
		
		super("mace-x");
		
		localizedName = "Mace X";
		constructor = EntityMapping.map("mace");
		
		speed = 0.9f;
		
		hitSize = 10f;
		
		health = 550;
		armor = 4f;
		
		ammoType = new ItemAmmoType(Items.coal);
		
		immunities.add(StatusEffects.burning);
		
		weapons.add(new Weapon("flamethrower"){{
			top = false;
			shootSound = Sounds.artillery;
			shootY = 2f;
			reload = 11f;
			recoil = 1f;
			ejectEffect = Fx.none;
			
			shoot.shots = 3;
			shoot.shotDelay = 3;
			
			bullet = new BasicBulletType( 4.9f, 150f ) {{
				ammoMultiplier = 3f;
				hitSize = 7f;
				lifetime = 95f;
				pierce = true;
				pierceBuilding = true;
				pierceCap = 2;
				statusDuration = 60f * 4;
				shootEffect = Fx.shootBig;
				hitEffect = Fx.hitFlameSmall;
				despawnEffect = Fx.none;
				status = StatusEffects.burning;
				keepVelocity = false;
				hittable = false;
			}};
		}});
		
	} //Constructor
	
} //class
