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


public class Disrupt_X extends ErekirUnitType {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Disrupt_X() {
		
		super("disrupt-x");
		
		localizedName = "Disrupt X";
		constructor = EntityMapping.map("disrupt");
		
		aiController = FlyingFollowAI::new;
		// envDisabled = 0;
		
		lowAltitude = false;
		flying = true;
		drag = 0.07f;
		speed = 1f;
		rotateSpeed = 2f;
		accel = 0.1f;
		health = 12000f;
		armor = 7f;
		hitSize = 46f;
		payloadCapacity = Mathf.sqr(6f) * tilePayload;
		
		engineSize = 6f;
		engineOffset = 25.25f;
		
		float orbRad = 5f, partRad = 3f;
		int parts = 10;
		
		abilities.add(new SuppressionFieldAbility(){{
			orbRadius = orbRad;
			particleSize = partRad;
			y = 10f;
			particles = parts;
		}});
		
		for(int i : Mathf.signs){
			abilities.add(new SuppressionFieldAbility(){{
				orbRadius = orbRad;
				particleSize = partRad;
				y = -32f / 4f;
				x = 43f * i / 4f;
				particles = parts;
				//visual only, the middle one does the actual suppressing
				display = active = false;
			}});
		}
		
		weapons.add(new Weapon("disrupt-weapon"){{
			shootSound = Sounds.missileLarge;
			x = 78f / 4f;
			y = -10f / 4f;
			mirror = true;
			rotate = true;
			rotateSpeed = 0.4f;
			reload = 70f;
			layerOffset = -20f;
			recoil = 1f;
			rotationLimit = 22f;
			minWarmup = 0.95f;
			shootWarmupSpeed = 0.1f;
			shootY = 2f;
			shootCone = 40f;
			shoot.shots = 3;
			shoot.shotDelay = 5f;
			inaccuracy = 28f;
			
			parts.add(new RegionPart("-blade"){{
				heatProgress = PartProgress.warmup;
				progress = PartProgress.warmup.blend(PartProgress.reload, 0.15f);
				heatColor = Color.valueOf("9c50ff");
				x = 5 / 4f;
				y = 0f;
				moveRot = -33f;
				moveY = -1f;
				moveX = -1f;
				under = true;
				mirror = true;
			}});
			
			bullet = new BulletType(){{
				shootEffect = Fx.sparkShoot;
				smokeEffect = Fx.shootSmokeTitan;
				hitColor = Pal.suppress;
				shake = 1f;
				speed = 0f;
				keepVelocity = false;
				
				spawnUnit = new MissileUnitType("disrupt-missile"){{
					speed = 4.6f;
					maxRange = 5f;
					outlineColor = Pal.darkOutline;
					health = 70;
					homingDelay = 10f;
					lowAltitude = true;
					engineSize = 3f;
					engineColor = trailColor = Pal.sapBulletBack;
					engineLayer = Layer.effect;
					deathExplosionEffect = Fx.none;
					loopSoundVolume = 0.1f;
					
					parts.add(new ShapePart(){{
						layer = Layer.effect;
						circle = true;
						y = -0.25f;
						radius = 1.5f;
						color = Pal.suppress;
						colorTo = Color.white;
						progress = PartProgress.life.curve(Interp.pow5In);
					}});
					
					parts.add(new RegionPart("-fin"){{
						mirror = true;
						progress = PartProgress.life.mul(3f).curve(Interp.pow5In);
						moveRot = 32f;
						rotation = -6f;
						moveY = 1.5f;
						x = 3f / 4f;
						y = -6f / 4f;
					}});
					
					weapons.add(new Weapon(){{
						shootCone = 360f;
						mirror = false;
						reload = 1f;
						shootOnDeath = true;
						bullet = new ExplosionBulletType(140f, 25f){{
							suppressionRange = 140f;
							shootEffect = new ExplosionEffect(){{
								lifetime = 50f;
								waveStroke = 5f;
								waveLife = 8f;
								waveColor = Color.white;
								sparkColor = smokeColor = Pal.suppress;
								waveRad = 40f;
								smokeSize = 4f;
								smokes = 7;
								smokeSizeBase = 0f;
								sparks = 10;
								sparkRad = 40f;
								sparkLen = 6f;
								sparkStroke = 2f;
							}};
						}};
					}});
				}};
			}};
		}});
		
		setEnginesMirror(
			new UnitEngine(95 / 4f, -56 / 4f, 5f, 330f),
			new UnitEngine(89 / 4f, -95 / 4f, 4f, 315f)
		);
		
	} //Constructor
	
} //class
