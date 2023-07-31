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


public class Meltdown_X extends LaserTurret {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Meltdown_X() {
		
		super("meltdown-x");
		
		localizedName = "Meltdown X";
		
		requirements( Category.turret,
			with(	Items.copper, 550,
					Items.lead, 350,
					Items.graphite, 300,
					Items.surgeAlloy, 325,
					Items.silicon, 325 ));
		
		shootEffect = Fx.shootBigSmoke2;
		shootCone = 40f;
		recoil = 4f;
		
		size = 4;
		
		shake = 2f;
		range = 195f;
		reload = 90f;
		firingMoveFract = 0.5f;
		shootDuration = 230f;
		shootSound = Sounds.laserbig;
		loopSound = Sounds.beam;
		loopSoundVolume = 2f;
		// envEnabled |= Env.space;
		
		shootType = new ContinuousLaserBulletType(78){{
			length = 200f;
			hitEffect = Fx.hitMeltdown;
			hitColor = Pal.meltdownHit;
			status = StatusEffects.melting;
			drawSize = 420f;
			
			incendChance = 0.4f;
			incendSpread = 5f;
			incendAmount = 1;
			ammoMultiplier = 1f;
		}};
		
		scaledHealth = 200;
		
		coolant = consumeCoolant(0.5f);
		consumePower(17f);
		
	} //Constructor
	
} //class
