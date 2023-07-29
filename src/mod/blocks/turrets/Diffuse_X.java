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


public class Diffuse_X extends ItemTurret {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Diffuse_X() {
		
		super("diffuse-x");
		
		localizedName = "Diffuse X";
		
		requirements( Category.turret,
			with(	Items.silicon, 200,
					Items.graphite, 200 ));
		
		ammo(
		Items.graphite, new BasicBulletType(8f, 41){{
			knockback = 4f;
			width = 25f;
			hitSize = 7f;
			height = 20f;
			shootEffect = Fx.shootBigColor;
			smokeEffect = Fx.shootSmokeSquareSparse;
			ammoMultiplier = 1;
			hitColor = backColor = trailColor = Color.valueOf("ea8878");
			frontColor = Pal.redLight;
			trailWidth = 6f;
			trailLength = 3;
			hitEffect = despawnEffect = Fx.hitSquaresColor;
			buildingDamageMultiplier = 0.2f;
		}}
		);
		
		shoot = new ShootSpread(15, 4f);
		
		coolantMultiplier = 6f;
		inaccuracy = 0.2f;
		velocityRnd = 0.17f;
		shake = 1f;
		ammoPerShot = 3;
		maxAmmo = 30;
		consumeAmmoOnce = true;
		
		shootSound = Sounds.shootAltLong;
		
		drawer = new DrawTurret("reinforced-"){{
			parts.add(new RegionPart("-front"){{
				progress = PartProgress.warmup;
				moveRot = -10f;
				mirror = true;
				moves.add(new PartMove(PartProgress.recoil, 0f, -3f, -5f));
				heatColor = Color.red;
			}});
		}};
		
		shootY = 5f;
		outlineColor = Pal.darkOutline;
		size = 3;
		envEnabled |= Env.space;
		reload = 30f;
		recoil = 2f;
		range = 125;
		shootCone = 40f;
		scaledHealth = 210;
		rotateSpeed = 3f;
		
		coolant = consume(new ConsumeLiquid(Liquids.water, 15f / 60f));
		limitRange();
		
	} //Constructor
	
} //class
