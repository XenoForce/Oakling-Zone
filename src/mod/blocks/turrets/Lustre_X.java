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


public class Lustre_X extends ContinuousTurret {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Lustre_X() {
		
		super("lustre-x");
		
		localizedName = "Lustre X";
		
		requirements( Category.turret,
			with(	Items.silicon, 250,
					Items.graphite, 200 ));
		
		range = 130f;
		
		shootType = new PointLaserBulletType(){{
			damage = 180f;
			buildingDamageMultiplier = 0.3f;
			hitColor = Color.valueOf("fda981");
		}};
		
		drawer = new DrawTurret("reinforced-"){{
			var heatp = PartProgress.warmup.blend(p -> Mathf.absin(2f, 1f) * p.warmup, 0.2f);
			
			parts.add(new RegionPart("-blade"){{
				progress = PartProgress.warmup;
				heatProgress = PartProgress.warmup;
				heatColor = Color.valueOf("ff6214");
				mirror = true;
				under = true;
				moveX = 2f;
				moveRot = -7f;
				moves.add(new PartMove(PartProgress.warmup, 0f, -2f, 3f));
			}},
			new RegionPart("-inner"){{
				heatProgress = heatp;
				progress = PartProgress.warmup;
				heatColor = Color.valueOf("ff6214");
				mirror = true;
				under = false;
				moveX = 2f;
				moveY = -8f;
			}},
			new RegionPart("-mid"){{
				heatProgress = heatp;
				progress = PartProgress.warmup;
				heatColor = Color.valueOf("ff6214");
				moveY = -8f;
				mirror = false;
				under = true;
			}});
		}};
		
		shootSound = Sounds.none;
		loopSoundVolume = 1f;
		loopSound = Sounds.laserbeam;
		
		shootWarmupSpeed = 0.08f;
		shootCone = 360f;
		
		aimChangeSpeed = 0.9f;
		rotateSpeed = 0.9f;
		
		shootY = 0.5f;
		outlineColor = Pal.darkOutline;
		
		size = 4;
		
		// envEnabled |= Env.space;
		range = 250f;
		
		scaledHealth = 210;
		
		//TODO is this a good idea to begin with?
		unitSort = UnitSorts.strongest;
		
		// consumeLiquid(Liquids.nitrogen, 5f / 60f);
		
	} //Constructor
	
} //class
