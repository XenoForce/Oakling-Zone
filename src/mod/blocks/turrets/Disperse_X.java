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


public class Disperse_X extends ItemTurret {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Disperse_X() {
		
		super("disperse-x");
		
		localizedName = "Disperse X";
		
		requirements( Category.turret,
			with(	Items.thorium, 50,
					Items.silicon, 200 ));
		
		ammo(Items.graphite, new BasicBulletType(){{
			damage = 65;
			speed = 8.5f;
			width = height = 16;
			shrinkY = 0.3f;
			backSprite = "large-bomb-back";
			sprite = "mine-bullet";
			velocityRnd = 0.11f;
			collidesGround = false;
			collidesTiles = false;
			shootEffect = Fx.shootBig2;
			smokeEffect = Fx.shootSmokeDisperse;
			frontColor = Color.white;
			backColor = trailColor = hitColor = Color.sky;
			trailChance = 0.44f;
			ammoMultiplier = 3f;
			
			lifetime = 34f;
			rotationOffset = 90f;
			trailRotation = true;
			trailEffect = Fx.disperseTrail;
			
			hitEffect = despawnEffect = Fx.hitBulletColor;
		}});
		
		reload = 9f;
		shootY = 15f;
		rotateSpeed = 5f;
		shootCone = 30f;
		consumeAmmoOnce = true;
		shootSound = Sounds.shootBig;
		
		drawer = new DrawTurret("reinforced-"){{
			parts.add(new RegionPart("-side"){{
				mirror = true;
				under = true;
				moveX = 1.75f;
				moveY = -0.5f;
			}},
			new RegionPart("-mid"){{
				under = true;
				moveY = -1.5f;
				progress = PartProgress.recoil;
				heatProgress = PartProgress.recoil.add(0.25f).min(PartProgress.warmup);
				heatColor = Color.sky.cpy().a(0.9f);
			}},
			new RegionPart("-blade"){{
				heatProgress = PartProgress.warmup;
				heatColor = Color.sky.cpy().a(0.9f);
				mirror = true;
				under = true;
				moveY = 1f;
				moveX = 1.5f;
				moveRot = 8;
			}});
		}};
		
		shoot = new ShootAlternate(){{
			spread = 4.7f;
			shots = 4;
			barrels = 4;
		}};
		
		targetGround = false;
		inaccuracy = 8f;
		shootWarmupSpeed = 0.08f;
		outlineColor = Pal.darkOutline;
		
		scaledHealth = 280;
		range = 310f;
		size = 4;
		
		coolant = consume(new ConsumeLiquid(Liquids.water, 20f / 60f));
		coolantMultiplier = 2.5f;
		
		limitRange(-5f);
		
	} //Constructor
	
} //class
