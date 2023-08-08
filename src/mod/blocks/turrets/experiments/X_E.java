package mod.blocks.turrets.experiments;

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


public class X_E extends PowerTurret {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public X_E() {
		
		super("x-e");
		
		localizedName = "X E Turret";
		
		requirements( Category.turret,
			with( Items.copper, 1 ));
		
		size = 2;
		
		range = 165f;
		
		// shoot.firstShotDelay = 40f;
		
		recoil = 1f;
		reload = 50f;
		shake  = 1f;
		
		shootEffect = Fx.none;
		smokeEffect = Fx.none;
		
		heatColor = Color.red;
		
		scaledHealth = 280;
		targetAir = false;
		moveWhileCharging = false;
		accurateDelay = false;
		shootSound = Sounds.blaster;
		
		// consumePower(6f);
		
		shootType = new BasicBulletType() {{
			damage   = 25;
			speed    = 2.5f;
			lifetime = 66;
			
			buildingDamageMultiplier = 0.75f;
			
			sprite = "missile";
			
			width  = 12f;
			height = 27f;
			
			frontColor = Color.white;
			backColor  = Color.red;
			
			trailLength = 8;
			trailWidth  = 1.8f;
			
			trailEffect   = Fx.missileTrail;
			despawnEffect = Fx.flakExplosionBig;
			hitEffect     = Fx.flakExplosionBig;
			
		}};
		
	} //Constructor
	
} //class
