package mod.blocks.turrets;

import arc.*;
import arc.graphics.*;
import arc.math.*;
import arc.util.*;

import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;

import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.unit.*;

import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

// import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;


public class Scathe_X extends ItemTurret {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Scathe_X() {
		
		super("scathe-x");
		
		localizedName = "Scathe X";
		
		requirements( Category.turret,
			with(	Items.silicon, 300,
					Items.graphite, 400 ));
		
		ammo(
		Items.graphite, new BasicBulletType(0f, 1){{
			shootEffect = Fx.shootBig;
			smokeEffect = Fx.shootSmokeMissile;
			ammoMultiplier = 1f;
			
			spawnUnit = new MissileUnitType("scathe-missile"){{
				speed = 4.6f;
				maxRange = 6f;
				lifetime = 60f * 5.5f;
				outlineColor = Pal.darkOutline;
				engineColor = trailColor = Pal.redLight;
				engineLayer = Layer.effect;
				engineSize = 3.1f;
				engineOffset = 10f;
				rotateSpeed = 0.25f;
				trailLength = 18;
				missileAccelTime = 50f;
				lowAltitude = true;
				loopSound = Sounds.missileTrail;
				loopSoundVolume = 0.6f;
				deathSound = Sounds.largeExplosion;
				targetAir = false;
				
				fogRadius = 6f;
				
				health = 190;
				
				weapons.add(new Weapon(){{
					shootCone = 360f;
					mirror = false;
					reload = 1f;
					deathExplosionEffect = Fx.massiveExplosion;
					shootOnDeath = true;
					shake = 10f;
					
					bullet = new ExplosionBulletType(600f, 65f){{
						hitColor = Pal.redLight;
						
						shootEffect = new MultiEffect(Fx.massiveExplosion, Fx.scatheExplosion, Fx.scatheLight, new WaveEffect(){{
							lifetime = 10f;
							strokeFrom = 4f;
							sizeTo = 130f;
						}});
						
						collidesAir = false;
						buildingDamageMultiplier = 0.3f;
						
						ammoMultiplier = 1f;
						fragLifeMin = 0.1f;
						fragBullets = 7;
						
						fragBullet = new ArtilleryBulletType(3.4f, 30){{
							buildingDamageMultiplier = 0.3f;
							drag = 0.02f;
							hitEffect = Fx.massiveExplosion;
							despawnEffect = Fx.scatheSlash;
							knockback = 0.8f;
							lifetime = 23f;
							width = height = 18f;
							collidesTiles = false;
							splashDamageRadius = 40f;
							splashDamage = 80f;
							backColor = trailColor = hitColor = Pal.redLight;
							frontColor = Color.white;
							smokeEffect = Fx.shootBigSmoke2;
							despawnShake = 7f;
							lightRadius = 30f;
							lightColor = Pal.redLight;
							lightOpacity = 0.5f;
							
							trailLength = 20;
							trailWidth = 3.5f;
							trailEffect = Fx.none;
						}};
					}};
				}});
				
				abilities.add(new MoveEffectAbility(){{
					effect = Fx.missileTrailSmoke;
					rotation = 180f;
					y = -9f;
					color = Color.grays(0.6f).lerp(Pal.redLight, 0.5f).a(0.4f);
					interval = 7f;
				}});
			}};
		}}
		);
		
		drawer = new DrawTurret("reinforced-"){{
			parts.add(
			new RegionPart("-blade"){{
				progress = PartProgress.warmup;
				heatProgress = PartProgress.warmup;
				heatColor = Color.red;
				moveRot = -22f;
				moveX = 0f;
				moveY = -5f;
				mirror = true;
				
				children.add(new RegionPart("-side"){{
					progress = PartProgress.warmup.delay(0.6f);
					heatProgress = PartProgress.recoil;
					heatColor = Color.red;
					mirror = true;
					under = false;
					moveY = -4f;
					moveX = 1f;
					
					moves.add(new PartMove(PartProgress.recoil, 1f, 6f, -40f));
				}});
			}},
			new RegionPart("-mid"){{
				progress = PartProgress.recoil;
				heatProgress = PartProgress.warmup.add(-0.2f).add(p -> Mathf.sin(9f, 0.2f) * p.warmup);
				mirror = false;
				under = true;
				moveY = -5f;
			}},
			new RegionPart("-missile"){{
				progress = PartProgress.reload.curve(Interp.pow2In);
				
				colorTo = new Color(1f, 1f, 1f, 0f);
				color = Color.white;
				mixColorTo = Pal.accent;
				mixColor = new Color(1f, 1f, 1f, 0f);
				outline = false;
				under = true;
				
				layerOffset = -0.01f;
				
				moves.add(new PartMove(PartProgress.warmup.inv(), 0f, -4f, 0f));
			}});
		}};
		
		recoil = 0.5f;
		
		coolantMultiplier = 6f;
		shootSound = Sounds.missileLaunch;
		
		minWarmup = 0.94f;
		shootWarmupSpeed = 0.03f;
		targetAir = false;
		
		shake = 6f;
		ammoPerShot = 30;
		maxAmmo = 30;
		shootY = -1;
		outlineColor = Pal.darkOutline;
		
		size = 4;
		
		// envEnabled |= Env.space;
		reload = 600f;
		range = 1350;
		shootCone = 1f;
		scaledHealth = 220;
		rotateSpeed = 0.9f;
		
		coolant = consume(new ConsumeLiquid(Liquids.water, 15f / 60f));
		limitRange();
		
	} //Constructor
	
} //class
