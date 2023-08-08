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


public class X_A extends PowerTurret {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public X_A() {
		
		super("x-a");
		
		localizedName = "X A Turret";
		
		requirements( Category.turret,
			with( Items.copper, 1 ));
		
		size = 2;
		
		range = 165f;
		
		// shoot.firstShotDelay = 40f;
		
		recoil = 1f;
		reload = 40f;
		shake = 1f;
		
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
			
			width  = 8f;
			height = 14f;
			
			shrinkX = 0;
			shrinkY = 0;
			
			frontColor = Color.gray;
			backColor  = Color.black;
			
			trailLength = 10;
			trailWidth  = 1.8f;
			
			hitEffect = Fx.none;
			
			sprite = "missile-large";
		}};
		
	} //Constructor
	
} //class
