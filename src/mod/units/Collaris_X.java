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


public class Collaris_X extends ErekirUnitType {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Collaris_X() {
		
		super("collaris-x");
		
		localizedName = "Collaris X";
		constructor = EntityMapping.map("collaris");
		
		drag = 0.1f;
		speed = 1.1f;
		hitSize = 44f;
		health = 18000;
		armor = 9f;
		rotateSpeed = 1.6f;
		lockLegBase = true;
		legContinuousMove = true;
		legStraightness = 0.6f;
		baseLegStraightness = 0.5f;
		
		legCount = 8;
		legLength = 30f;
		legForwardScl = 2.1f;
		legMoveSpace = 1.05f;
		rippleScale = 1.2f;
		stepShake = 0.5f;
		legGroupSize = 2;
		legExtension = -6f;
		legBaseOffset = 19f;
		legStraightLength = 0.9f;
		legMaxLength = 1.2f;
		
		ammoType = new PowerAmmoType(2000);
		
		legSplashDamage = 32;
		legSplashRange = 32;
		drownTimeMultiplier = 2f;
		
		hovering = true;
		shadowElevation = 0.4f;
		groundLayer = Layer.legUnit;
		
		targetAir = false;
		
		weapons.add(new Weapon("collaris-weapon"){{
			shootSound = Sounds.pulseBlast;
			mirror = true;
			rotationLimit = 30f;
			rotateSpeed = 0.4f;
			rotate = true;
			
			x = 48 / 4f;
			y = -28f / 4f;
			shootY = 64f / 4f;
			recoil = 4f;
			reload = 130f;
			cooldownTime = reload * 1.2f;
			shake = 7f;
			layerOffset = 0.02f;
			shadow = 10f;
			
			shootStatus = StatusEffects.slow;
			shootStatusDuration = reload + 1f;
			
			shoot.shots = 1;
			heatColor = Color.red;
			
			for(int i = 0; i < 5; i++){
				int fi = i;
				parts.add(new RegionPart("-blade"){{
					under = true;
					layerOffset = -0.001f;
					heatColor = Pal.techBlue;
					heatProgress = PartProgress.heat.add(0.2f).min(PartProgress.warmup);
					progress = PartProgress.warmup.blend(PartProgress.reload, 0.1f);
					x = 13.5f / 4f;
					y = 10f / 4f - fi * 2f;
					moveY = 1f - fi * 1f;
					moveX = fi * 0.3f;
					moveRot = -45f - fi * 17f;
					
					moves.add( new PartMove(
									PartProgress.reload.inv().mul(1.8f).inv()
									.curve(fi / 5f, 0.2f), 0f, 0f, 36f));
				}});
			}
			
			bullet = new ArtilleryBulletType(5.5f, 300){{
				collidesTiles = collides = true;
				lifetime = 75f;
				shootEffect = Fx.shootBigColor;
				smokeEffect = Fx.shootSmokeSquareBig;
				frontColor = Color.white;
				trailEffect = new MultiEffect(Fx.artilleryTrail, Fx.artilleryTrailSmoke);
				hitSound = Sounds.none;
				width = 18f;
				height = 24f;
				
				lightColor = trailColor = hitColor = backColor = Pal.techBlue;
				lightRadius = 40f;
				lightOpacity = 0.7f;
				
				trailWidth = 4.5f;
				trailLength = 19;
				trailChance = -1f;
				
				despawnEffect = Fx.none;
				despawnSound = Sounds.dullExplosion;
				
				hitEffect = despawnEffect = new ExplosionEffect(){{
					lifetime = 34f;
					waveStroke = 4f;
					waveColor = sparkColor = trailColor;
					waveRad = 25f;
					smokeSize = 0f;
					smokeSizeBase = 0f;
					sparks = 10;
					sparkRad = 25f;
					sparkLen = 8f;
					sparkStroke = 3f;
				}};
				
				splashDamage = 90f;
				splashDamageRadius = 20f;
				
				fragBullets = 15;
				fragVelocityMin = 0.5f;
				fragRandomSpread = 130f;
				fragLifeMin = 0.3f;
				despawnShake = 5f;
				
				fragBullet = new BasicBulletType(5.5f, 55){{
					pierceCap = 2;
					pierceBuilding = true;
					
					homingPower = 0.09f;
					homingRange = 150f;
					
					lifetime = 50f;
					shootEffect = Fx.shootBigColor;
					smokeEffect = Fx.shootSmokeSquareBig;
					frontColor = Color.white;
					hitSound = Sounds.none;
					width = 12f;
					height = 20f;
					
					lightColor = trailColor = hitColor = backColor = Pal.techBlue;
					lightRadius = 40f;
					lightOpacity = 0.7f;
					
					trailWidth = 2.2f;
					trailLength = 7;
					trailChance = -1f;
					
					despawnEffect = Fx.none;
					splashDamage = 50f;
					splashDamageRadius = 30f;
					
					hitEffect = despawnEffect = new MultiEffect(new ExplosionEffect(){{
						lifetime = 30f;
						waveStroke = 2f;
						waveColor = sparkColor = trailColor;
						waveRad = 5f;
						smokeSize = 0f;
						smokeSizeBase = 0f;
						sparks = 5;
						sparkRad = 20f;
						sparkLen = 6f;
						sparkStroke = 2f;
					}}, Fx.blastExplosion);
				}};
			}};
		}});
		
	} //Constructor
	
} //class
