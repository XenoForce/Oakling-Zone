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


public class Scorch_X extends ItemTurret {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Scorch_X() {
		
		super("scorch-x");
		
		localizedName = "Scorch X";
		
		requirements( Category.turret,
			with(	Items.copper, 25,
					Items.graphite, 22 ));
		
		ammo(
			Items.coal, new BulletType(3.35f, 17f){{
				ammoMultiplier = 3f;
				hitSize = 7f;
				lifetime = 18f;
				pierce = true;
				collidesAir = false;
				statusDuration = 60f * 4;
				shootEffect = Fx.shootSmallFlame;
				hitEffect = Fx.hitFlameSmall;
				despawnEffect = Fx.none;
				status = StatusEffects.burning;
				keepVelocity = false;
				hittable = false;
			}},
			
			Items.pyratite, new BulletType(4f, 60f){{
				ammoMultiplier = 6f;
				hitSize = 7f;
				lifetime = 18f;
				pierce = true;
				collidesAir = false;
				statusDuration = 60f * 10;
				shootEffect = Fx.shootPyraFlame;
				hitEffect = Fx.hitFlameSmall;
				despawnEffect = Fx.none;
				status = StatusEffects.burning;
				hittable = false;
			}}
		);
		
		recoil = 0f;
		reload = 6f;
		coolantMultiplier = 1.5f;
		range = 60f;
		shootCone = 50f;
		targetAir = false;
		ammoUseEffect = Fx.none;
		
		health = 400;
		
		shootSound = Sounds.flame;
		coolant = consumeCoolant(0.1f);
		
	} //Constructor
	
} //class
