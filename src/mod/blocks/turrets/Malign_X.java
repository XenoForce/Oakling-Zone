package mod.blocks.turrets;

import arc.*;
import arc.graphics.*;
import arc.math.*;
import arc.math.geom.*;
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


public class Malign_X extends PowerTurret {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Malign_X() {
		
		super("malign-x");
		
		localizedName = "Malign X";
		
		requirements( Category.turret,
			with(	Items.silicon, 800,
					Items.graphite, 800,
					Items.phaseFabric, 300 ));
		
		var haloProgress = PartProgress.warmup;
		Color haloColor = Color.valueOf("d370d3"), heatCol = Color.purple;
		float haloY = -15f, haloRotSpeed = 1.5f;
		
		var circleProgress = PartProgress.warmup.delay(0.9f);
		var circleColor = haloColor;
		float circleY = 25f, circleRad = 11f, circleRotSpeed = 3.5f, circleStroke = 1.6f;
		
		shootSound = Sounds.malignShoot;
		loopSound = Sounds.spellLoop;
		loopSoundVolume = 1.3f;
		
		shootType = new FlakBulletType(8f, 70f){{
			sprite = "missile-large";
			
			lifetime = 45f;
			width = 12f;
			height = 22f;
			
			hitSize = 7f;
			shootEffect = Fx.shootSmokeSquareBig;
			smokeEffect = Fx.shootSmokeDisperse;
			ammoMultiplier = 1;
			hitColor = backColor = trailColor = lightningColor = circleColor;
			frontColor = Color.white;
			trailWidth = 3f;
			trailLength = 12;
			hitEffect = despawnEffect = Fx.hitBulletColor;
			buildingDamageMultiplier = 0.3f;
			
			trailEffect = Fx.colorSpark;
			trailRotation = true;
			trailInterval = 3f;
			lightning = 1;
			lightningCone = 15f;
			lightningLength = 20;
			lightningLengthRand = 30;
			lightningDamage = 20f;
			
			homingPower = 0.17f;
			homingDelay = 19f;
			homingRange = 160f;
			
			explodeRange = 160f;
			explodeDelay = 0f;
			
			flakInterval = 20f;
			despawnShake = 3f;
			
			fragBullet = new LaserBulletType(65f){{
				colors = new Color[]{haloColor.cpy().a(0.4f), haloColor, Color.white};
				buildingDamageMultiplier = 0.25f;
				width = 19f;
				hitEffect = Fx.hitLancer;
				sideAngle = 175f;
				sideWidth = 1f;
				sideLength = 40f;
				lifetime = 22f;
				drawSize = 400f;
				length = 180f;
				pierceCap = 2;
			}};
			
			fragSpread = fragRandomSpread = 0f;
			
			splashDamage = 0f;
			hitEffect = Fx.hitSquaresColor;
			collidesGround = true;
		}};
		
		size = 5;
		
		drawer = new DrawTurret("reinforced-"){{
			parts.addAll(
			
			//summoning circle
			new ShapePart(){{
				progress = circleProgress;
				color = circleColor;
				circle = true;
				hollow = true;
				stroke = 0f;
				strokeTo = circleStroke;
				radius = circleRad;
				layer = Layer.effect;
				y = circleY;
			}},
			
			new ShapePart(){{
				progress = circleProgress;
				rotateSpeed = -circleRotSpeed;
				color = circleColor;
				sides = 4;
				hollow = true;
				stroke = 0f;
				strokeTo = circleStroke;
				radius = circleRad - 1f;
				layer = Layer.effect;
				y = circleY;
			}},
			
			//outer squares
			
			new ShapePart(){{
				progress = circleProgress;
				rotateSpeed = -circleRotSpeed;
				color = circleColor;
				sides = 4;
				hollow = true;
				stroke = 0f;
				strokeTo = circleStroke;
				radius = circleRad - 1f;
				layer = Layer.effect;
				y = circleY;
			}},
			
			//inner square
			new ShapePart(){{
				progress = circleProgress;
				rotateSpeed = -circleRotSpeed/2f;
				color = circleColor;
				sides = 4;
				hollow = true;
				stroke = 0f;
				strokeTo = 2f;
				radius = 3f;
				layer = Layer.effect;
				y = circleY;
			}},
			
			//spikes on circle
			new HaloPart(){{
				progress = circleProgress;
				color = circleColor;
				tri = true;
				shapes = 3;
				triLength = 0f;
				triLengthTo = 5f;
				radius = 6f;
				haloRadius = circleRad;
				haloRotateSpeed = haloRotSpeed / 2f;
				shapeRotation = 180f;
				haloRotation = 180f;
				layer = Layer.effect;
				y = circleY;
			}},
			
			//actual turret
			new RegionPart("-mouth"){{
				heatColor = heatCol;
				heatProgress = PartProgress.warmup;
				
				moveY = -8f;
			}},
			new RegionPart("-end"){{
				moveY = 0f;
			}},
			new RegionPart("-front"){{
				heatColor = heatCol;
				heatProgress = PartProgress.warmup;
				
				mirror = true;
				moveRot = 33f;
				moveY = -4f;
				moveX = 10f;
			}},
			new RegionPart("-back"){{
				heatColor = heatCol;
				heatProgress = PartProgress.warmup;
				
				mirror = true;
				moveRot = 10f;
				moveX = 2f;
				moveY = 5f;
			}},
			new RegionPart("-mid"){{
				heatColor = heatCol;
				heatProgress = PartProgress.recoil;
				
				moveY = -9.5f;
			}},
			new ShapePart(){{
				progress = haloProgress;
				color = haloColor;
				circle = true;
				hollow = true;
				stroke = 0f;
				strokeTo = 2f;
				radius = 10f;
				layer = Layer.effect;
				y = haloY;
			}},
			new ShapePart(){{
				progress = haloProgress;
				color = haloColor;
				sides = 3;
				rotation = 90f;
				hollow = true;
				stroke = 0f;
				strokeTo = 2f;
				radius = 4f;
				layer = Layer.effect;
				y = haloY;
			}},
			new HaloPart(){{
				progress = haloProgress;
				color = haloColor;
				sides = 3;
				shapes = 3;
				hollow = true;
				stroke = 0f;
				strokeTo = 2f;
				radius = 3f;
				haloRadius = 10f + radius/2f;
				haloRotateSpeed = haloRotSpeed;
				layer = Layer.effect;
				y = haloY;
			}},
			new HaloPart(){{
				progress = haloProgress;
				color = haloColor;
				tri = true;
				shapes = 3;
				triLength = 0f;
				triLengthTo = 10f;
				radius = 6f;
				haloRadius = 16f;
				haloRotation = 180f;
				layer = Layer.effect;
				y = haloY;
			}},
			new HaloPart(){{
				progress = haloProgress;
				color = haloColor;
				tri = true;
				shapes = 3;
				triLength = 0f;
				triLengthTo = 3f;
				radius = 6f;
				haloRadius = 16f;
				shapeRotation = 180f;
				haloRotation = 180f;
				layer = Layer.effect;
				y = haloY;
			}},
			new HaloPart(){{
				progress = haloProgress;
				color = haloColor;
				sides = 3;
				tri = true;
				shapes = 3;
				triLength = 0f;
				triLengthTo = 10f;
				shapeRotation = 180f;
				radius = 6f;
				haloRadius = 16f;
				haloRotateSpeed = -haloRotSpeed;
				haloRotation = 180f / 3f;
				layer = Layer.effect;
				y = haloY;
			}},
			new HaloPart(){{
				progress = haloProgress;
				color = haloColor;
				sides = 3;
				tri = true;
				shapes = 3;
				triLength = 0f;
				triLengthTo = 4f;
				radius = 6f;
				haloRadius = 16f;
				haloRotateSpeed = -haloRotSpeed;
				haloRotation = 180f / 3f;
				layer = Layer.effect;
				y = haloY;
			}}
			);
			
			Color heatCol2 = heatCol.cpy().add(0.1f, 0.1f, 0.1f).mul(1.2f);
			
			for(int i = 1; i < 4; i++){
				int fi = i;
				parts.add(new RegionPart("-spine"){{
					outline = false;
					progress = PartProgress.warmup.delay(fi / 5f);
					heatProgress = PartProgress.warmup.add(p -> (Mathf.absin(3f, 0.2f) - 0.2f) * p.warmup);
					mirror = true;
					under = true;
					layerOffset = -0.3f;
					turretHeatLayer = Layer.turret - 0.2f;
					moveY = 9f;
					moveX = 1f + fi * 4f;
					moveRot = fi * 60f - 130f;
					
					color = Color.valueOf("bb68c3");
					heatColor = heatCol2;
					moves.add(new PartMove(PartProgress.recoil.delay(fi / 5f), 1f, 0f, 3f));
				}});
			}
		}};
		
		velocityRnd = 0.15f;
		heatRequirement = 90f;
		maxHeatEfficiency = 2f;
		warmupMaintainTime = 30f;
		
		// consumePower(10f);
		
		shoot = new ShootSummon(0f, 0f, circleRad, 48f);
		
		minWarmup = 0.96f;
		shootWarmupSpeed = 0.03f;
		
		shootY = circleY - 5f;
		
		outlineColor = Pal.darkOutline;
		
		// envEnabled |= Env.space;
		
		reload = 9f;
		range = 370;
		shootCone = 100f;
		
		scaledHealth = 370;
		rotateSpeed = 2f;
		recoil = 0.5f;
		recoilTime = 30f;
		shake = 3f;
		
	} //Constructor
	
} //class
