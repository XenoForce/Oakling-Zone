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

import static mindustry.entities.part.DrawPart.PartProgress;


public class Smite_X extends ItemTurret {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Smite_X() {
		
		super("smite-x");
		
		localizedName = "Smite X";
		
		requirements( Category.turret,
			with(	Items.surgeAlloy, 400,
					Items.silicon, 800,
					Items.phaseFabric, 300 ));
		
		ammo(
		//this is really lazy
		Items.surgeAlloy, new BasicBulletType(7f, 250){{
			sprite = "large-orb";
			width = 17f;
			height = 21f;
			hitSize = 8f;
			
			shootEffect = new MultiEffect(
				Fx.shootTitan,
				Fx.colorSparkBig,
				
				new WaveEffect(){{
					colorFrom = colorTo = Pal.accent;
					lifetime = 12f;
					sizeTo = 20f;
					strokeFrom = 3f;
					strokeTo = 0.3f;
				}}
			);
			
			smokeEffect = Fx.shootSmokeSmite;
			ammoMultiplier = 1;
			pierceCap = 4;
			pierce = true;
			pierceBuilding = true;
			hitColor = backColor = trailColor = Pal.accent;
			frontColor = Color.white;
			trailWidth = 2.8f;
			trailLength = 9;
			hitEffect = Fx.hitBulletColor;
			buildingDamageMultiplier = 0.3f;
			
			despawnEffect = new MultiEffect(
				Fx.hitBulletColor,
				
				new WaveEffect(){{
					sizeTo = 30f;
					colorFrom = colorTo = Pal.accent;
					lifetime = 12f;
				}}
			);
			
			trailRotation = true;
			trailEffect = Fx.disperseTrail;
			trailInterval = 3f;
			
			intervalBullet = new LightningBulletType(){{
				damage = 30;
				collidesAir = false;
				ammoMultiplier = 1f;
				lightningColor = Pal.accent;
				lightningLength = 5;
				lightningLengthRand = 10;
				
				//for visual stats only.
				buildingDamageMultiplier = 0.25f;
				
				lightningType = new BulletType(0.0001f, 0f){{
					lifetime = Fx.lightning.lifetime;
					hitEffect = Fx.hitLancer;
					despawnEffect = Fx.none;
					status = StatusEffects.shocked;
					statusDuration = 10f;
					hittable = false;
					lightColor = Color.white;
					buildingDamageMultiplier = 0.25f;
				}};
			}};
			
			bulletInterval = 3f;
		}}
		);
		
		shoot = new ShootMulti(new ShootAlternate(){{
			spread = 3.3f * 1.9f;
			shots = barrels = 5;
		}}, new ShootHelix(){{
			scl = 4f;
			mag = 3f;
		}});
		
		shootSound = Sounds.shootSmite;
		minWarmup = 0.99f;
		coolantMultiplier = 6f;
		
		var haloProgress = PartProgress.warmup.delay(0.5f);
		float haloY = -15f, haloRotSpeed = 1f;
		
		shake = 2f;
		ammoPerShot = 2;
		
		drawer = new DrawTurret("reinforced-"){{
			parts.addAll(
			new RegionPart("-mid"){{
				heatProgress = PartProgress.heat.blend(PartProgress.warmup, 0.5f);
				mirror = false;
			}},
			new RegionPart("-blade"){{
				progress = PartProgress.warmup;
				heatProgress = PartProgress.warmup;
				mirror = true;
				moveX = 5.5f;
				moves.add(new PartMove(PartProgress.recoil, 0f, -3f, 0f));
			}},
			new RegionPart("-front"){{
				progress = PartProgress.warmup;
				heatProgress = PartProgress.recoil;
				mirror = true;
				under = true;
				moveY = 4f;
				moveX = 6.5f;
				moves.add(new PartMove(PartProgress.recoil, 0f, -5.5f, 0f));
			}},
			new RegionPart("-back"){{
				progress = PartProgress.warmup;
				heatProgress = PartProgress.warmup;
				mirror = true;
				under = true;
				moveX = 5.5f;
			}},
			new ShapePart(){{
				progress = PartProgress.warmup.delay(0.2f);
				color = Pal.accent;
				circle = true;
				hollow = true;
				stroke = 0f;
				strokeTo = 2f;
				radius = 10f;
				layer = Layer.effect;
				y = haloY;
				rotateSpeed = haloRotSpeed;
			}},
			new ShapePart(){{
				progress = PartProgress.warmup.delay(0.2f);
				color = Pal.accent;
				circle = true;
				hollow = true;
				stroke = 0f;
				strokeTo = 1.6f;
				radius = 4f;
				layer = Layer.effect;
				y = haloY;
				rotateSpeed = haloRotSpeed;
			}},
			new HaloPart(){{
				progress = haloProgress;
				color = Pal.accent;
				layer = Layer.effect;
				y = haloY;
				
				haloRotation = 90f;
				shapes = 2;
				triLength = 0f;
				triLengthTo = 20f;
				haloRadius = 16f;
				tri = true;
				radius = 4f;
			}},
			new HaloPart(){{
				progress = haloProgress;
				color = Pal.accent;
				layer = Layer.effect;
				y = haloY;
				
				haloRotation = 90f;
				shapes = 2;
				triLength = 0f;
				triLengthTo = 5f;
				haloRadius = 16f;
				tri = true;
				radius = 4f;
				shapeRotation = 180f;
			}},
			new HaloPart(){{
				progress = haloProgress;
				color = Pal.accent;
				layer = Layer.effect;
				y = haloY;
				haloRotateSpeed = -haloRotSpeed;
				
				shapes = 4;
				triLength = 0f;
				triLengthTo = 5f;
				haloRotation = 45f;
				haloRadius = 16f;
				tri = true;
				radius = 8f;
			}},
			new HaloPart(){{
				progress = haloProgress;
				color = Pal.accent;
				layer = Layer.effect;
				y = haloY;
				haloRotateSpeed = -haloRotSpeed;
				
				shapes = 4;
				shapeRotation = 180f;
				triLength = 0f;
				triLengthTo = 2f;
				haloRotation = 45f;
				haloRadius = 16f;
				tri = true;
				radius = 8f;
			}},
			new HaloPart(){{
				progress = haloProgress;
				color = Pal.accent;
				layer = Layer.effect;
				y = haloY;
				haloRotateSpeed = haloRotSpeed;
				
				shapes = 4;
				triLength = 0f;
				triLengthTo = 3f;
				haloRotation = 45f;
				haloRadius = 10f;
				tri = true;
				radius = 6f;
			}}
			);
			
			for(int i = 0; i < 3; i++){
				int fi = i;
				parts.add(new RegionPart("-blade-bar"){{
					progress = PartProgress.warmup;
					heatProgress = PartProgress.warmup;
					mirror = true;
					under = true;
					outline = false;
					layerOffset = -0.3f;
					turretHeatLayer = Layer.turret - 0.2f;
					y = 44f / 4f - fi * 38f / 4f;
					moveX = 2f;
					
					color = Pal.accent;
				}});
			}
			
			for(int i = 0; i < 4; i++){
				int fi = i;
				parts.add(new RegionPart("-spine"){{
					progress = PartProgress.warmup.delay(fi / 5f);
					heatProgress = PartProgress.warmup;
					mirror = true;
					under = true;
					layerOffset = -0.3f;
					turretHeatLayer = Layer.turret - 0.2f;
					moveY = -22f / 4f - fi * 3f;
					moveX = 52f / 4f - fi * 1f + 2f;
					moveRot = -fi * 30f;
					
					color = Pal.accent;
					moves.add(new PartMove(PartProgress.recoil.delay(fi / 5f), 0f, 0f, 35f));
				}});
			}
		}};
		
		shootWarmupSpeed = 0.04f;
		shootY = 15f;
		outlineColor = Pal.darkOutline;
		
		size = 5;
		
		// envEnabled |= Env.space;
		warmupMaintainTime = 30f;
		reload = 100f;
		recoil = 2f;
		range = 300;
		shootCone = 30f;
		
		scaledHealth = 350;
		rotateSpeed = 1.5f;
		
		coolant = consume(new ConsumeLiquid(Liquids.water, 15f / 60f));
		limitRange();
		
		loopSound = Sounds.glow;
		loopSoundVolume = 0.8f;
		
	} //Constructor
	
} //class
