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


public class Afflict_X extends PowerTurret {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Afflict_X() {
		
		super("afflict-x");
		
		localizedName = "Afflict X";
		
		requirements( Category.turret, with(Items.surgeAlloy, 100 ,
											Items.silicon   , 200 ,
											Items.graphite  , 250 ));
		
		shootType = new BasicBulletType(){{
			
			shootEffect = new MultiEffect(Fx.shootTitan, new WaveEffect(){{
				colorTo    = Pal.surge;
				sizeTo     = 26f;
				lifetime   = 14f;
				strokeFrom = 4f;
			}});
			
			smokeEffect = Fx.shootSmokeTitan;
			hitColor    = Pal.surge;
			
			sprite = "large-orb";
			trailEffect = Fx.missileTrail;
			trailInterval = 3f;
			trailParam = 4f;
			pierceCap = 2;
			fragOnHit = false;
			speed = 5f;
			damage = 170f;
			lifetime = 80f;
			width = height = 16f;
			backColor = Pal.surge;
			frontColor = Color.white;
			shrinkX = shrinkY = 0f;
			trailColor = Pal.surge;
			trailLength = 12;
			trailWidth = 2.2f;
			
			despawnEffect = hitEffect = new ExplosionEffect(){{
				waveColor = Pal.surge;
				smokeColor = Color.gray;
				sparkColor = Pal.sap;
				waveStroke = 4f;
				waveRad = 40f;
			}};
			
			despawnSound = Sounds.dullExplosion;
			
			//TODO shoot sound
			shootSound = Sounds.cannon;
			
			fragBullet = intervalBullet = new BasicBulletType(3f, 30){{
				width = 9f;
				hitSize = 5f;
				height = 15f;
				pierce = true;
				lifetime = 35f;
				pierceBuilding = true;
				hitColor = backColor = trailColor = Pal.surge;
				frontColor = Color.white;
				trailWidth = 2.1f;
				trailLength = 5;
				
				hitEffect = despawnEffect = new WaveEffect(){{
					colorFrom = colorTo = Pal.surge;
					sizeTo = 4f;
					strokeFrom = 4f;
					lifetime = 10f;
				}};
				
				buildingDamageMultiplier = 0.3f;
				homingPower = 0.2f;
			}};
			
			bulletInterval = 3f;
			intervalRandomSpread = 20f;
			intervalBullets = 2;
			intervalAngle = 180f;
			intervalSpread = 300f;
			
			fragBullets = 20;
			fragVelocityMin = 0.5f;
			fragVelocityMax = 1.5f;
			fragLifeMin = 0.5f;
		}};
		
		drawer = new DrawTurret("reinforced-"){{
			parts.add(new RegionPart("-blade"){{
				progress = PartProgress.recoil;
				heatColor = Color.valueOf("ff6214");
				mirror = true;
				under = true;
				moveX = 2f;
				moveY = -1f;
				moveRot = -7f;
			}},
			new RegionPart("-blade-glow"){{
				progress = PartProgress.recoil;
				heatProgress = PartProgress.warmup;
				heatColor = Color.valueOf("ff6214");
				drawRegion = false;
				mirror = true;
				under = true;
				moveX = 2f;
				moveY = -1f;
				moveRot = -7f;
			}});
		}};
		
		consumePower(5f);
		heatRequirement = 10f;
		maxHeatEfficiency = 2f;
		
		inaccuracy = 1f;
		shake = 2f;
		shootY = 4;
		outlineColor = Pal.darkOutline;
		
		size = 4;
		
		// envEnabled |= Env.space;
		reload = 110f;
		cooldownTime = reload;
		recoil = 3f;
		range = 340;
		shootCone = 20f;
		scaledHealth = 220;
		rotateSpeed = 1.5f;
		researchCostMultiplier = 0.04f;
		
		limitRange(9f);
		
	} //Constructor
	
} //class
