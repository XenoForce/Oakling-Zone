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
import mindustry.entities.pattern.*;
import mindustry.graphics.*;
import mindustry.type.*;

import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

// import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;


public class Breach_X extends ItemTurret {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Breach_X() {
		
		super("breach-x");
		
		localizedName = "Breach X";
		
		requirements(Category.turret,
			with(	Items.silicon, 150,
					Items.graphite, 250 ));
		
		Effect sfe = new MultiEffect(Fx.shootBigColor, Fx.colorSparkBig);
		
		ammo(
		Items.graphite, new BasicBulletType(7.5f, 85){{
			width = 12f;
			hitSize = 7f;
			height = 20f;
			shootEffect = sfe;
			smokeEffect = Fx.shootBigSmoke;
			ammoMultiplier = 1;
			pierceCap = 2;
			pierce = true;
			pierceBuilding = true;
			hitColor = backColor = trailColor = Pal.berylShot;
			frontColor = Color.white;
			trailWidth = 2.1f;
			trailLength = 10;
			hitEffect = despawnEffect = Fx.hitBulletColor;
			buildingDamageMultiplier = 0.3f;
		}},
		Items.silicon, new BasicBulletType(8f, 95){{
			width = 13f;
			height = 19f;
			hitSize = 7f;
			shootEffect = sfe;
			smokeEffect = Fx.shootBigSmoke;
			ammoMultiplier = 1;
			reloadMultiplier = 1f;
			pierceCap = 3;
			pierce = true;
			pierceBuilding = true;
			hitColor = backColor = trailColor = Pal.tungstenShot;
			frontColor = Color.white;
			trailWidth = 2.2f;
			trailLength = 11;
			hitEffect = despawnEffect = Fx.hitBulletColor;
			rangeChange = 40f;
			buildingDamageMultiplier = 0.3f;
		}}
		);
		
		coolantMultiplier = 6f;
		shootSound = Sounds.shootAlt;
		
		shake = 1f;
		ammoPerShot = 2;
		drawer = new DrawTurret("reinforced-");
		shootY = -2;
		outlineColor = Pal.darkOutline;
		size = 3;
		// envEnabled |= Env.space;
		reload = 40f;
		recoil = 2f;
		range = 190;
		shootCone = 3f;
		scaledHealth = 180;
		rotateSpeed = 1.5f;
		researchCostMultiplier = 0.05f;
		
		coolant = consume(new ConsumeLiquid(Liquids.water, 15f / 60f));
		limitRange();
		
	} //Constructor
	
} //class
