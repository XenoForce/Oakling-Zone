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


public class Sublimate_X extends ContinuousLiquidTurret {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Sublimate_X() {
		
		super("sublimate-x");
		
		localizedName = "Sublimate X";
		
		requirements( Category.turret,
			with(	Items.graphite, 150,
					Items.silicon, 150 ));
		
		drawer = new DrawTurret("reinforced-"){{
			
			Color heatc = Color.valueOf("fa2859");
			heatColor = heatc;
			
			parts.addAll(
			new RegionPart("-back"){{
				progress = PartProgress.warmup;
				mirror = true;
				moveRot = 40f;
				x = 22 / 4f;
				y = -1f / 4f;
				moveY = 6f / 4f;
				under = true;
				heatColor = heatc;
			}},
			new RegionPart("-front"){{
				progress = PartProgress.warmup;
				mirror = true;
				moveRot = 40f;
				x = 20 / 4f;
				y = 17f / 4f;
				moveX = 1f;
				moveY = 1f;
				under = true;
				heatColor = heatc;
			}},
			new RegionPart("-nozzle"){{
				progress = PartProgress.warmup;
				mirror = true;
				moveX = 8f / 4f;
				heatColor = Color.valueOf("f03b0e");
			}});
		}};
		
		outlineColor = Pal.darkOutline;
		
		liquidConsumed = 10f / 60f;
		targetInterval = 5f;
		
		float r = range = 130f;
		
		loopSound = Sounds.torch;
		shootSound = Sounds.none;
		loopSoundVolume = 1f;
		
		//TODO balance, set up, where is liquid/sec displayed? status effects maybe?
		ammo(
		Liquids.slag, new ContinuousFlameBulletType(){{
			damage = 60f;
			length = r;
			knockback = 1f;
			pierceCap = 2;
			buildingDamageMultiplier = 0.3f;
			
			colors = new Color[]{	Color.valueOf("eb7abe").a(0.55f),
									Color.valueOf("e189f5").a(0.7f),
									Color.valueOf("907ef7").a(0.8f),
									Color.valueOf("91a4ff"),
									Color.white };
		}},
		
		Liquids.water, new ContinuousFlameBulletType(){{
			damage = 130f;
			rangeChange = 70f;
			length = r + rangeChange;
			knockback = 2f;
			pierceCap = 3;
			buildingDamageMultiplier = 0.3f;
			
			colors = new Color[]{	Color.valueOf("465ab8").a(0.55f),
									Color.valueOf("66a6d2").a(0.7f),
									Color.valueOf("89e8b6").a(0.8f),
									Color.valueOf("cafcbe"),
									Color.white };
			
			flareColor = Color.valueOf("89e8b6");
			lightColor = hitColor = flareColor;
		}}
		);
		
		scaledHealth = 210;
		shootY = 7f;
		
		size = 3;
		
		researchCost = with(	Items.graphite, 200,
								Items.silicon, 200 );
		
	} //Constructor
	
} //class
