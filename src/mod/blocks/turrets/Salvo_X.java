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


public class Salvo_X extends ItemTurret {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Salvo_X() {
		
		super("salvo-x");
		
		localizedName = "Salvo X";
		
		requirements( Category.turret,
			with(	Items.copper, 100,
					Items.graphite, 80,
					Items.titanium, 50 ));
		
		ammo(
			Items.copper,  new BasicBulletType(2.5f, 11){{
				width = 7f;
				height = 9f;
				lifetime = 60f;
				ammoMultiplier = 2;
			}},
			
			Items.graphite, new BasicBulletType(3.5f, 20){{
				width = 9f;
				height = 12f;
				reloadMultiplier = 0.6f;
				ammoMultiplier = 4;
				lifetime = 60f;
			}},
			
			Items.pyratite, new BasicBulletType(3.2f, 18){{
				width = 10f;
				height = 12f;
				frontColor = Pal.lightishOrange;
				backColor = Pal.lightOrange;
				status = StatusEffects.burning;
				hitEffect = new MultiEffect(Fx.hitBulletSmall, Fx.fireHit);
				
				ammoMultiplier = 5;
				
				splashDamage = 12f;
				splashDamageRadius = 22f;
				
				makeFire = true;
				lifetime = 60f;
			}},
			
			Items.silicon, new BasicBulletType(3f, 15, "bullet"){{
				width = 7f;
				height = 9f;
				homingPower = 0.1f;
				reloadMultiplier = 1.5f;
				ammoMultiplier = 5;
				lifetime = 60f;
			}},
			
			Items.thorium, new BasicBulletType(4f, 29, "bullet"){{
				width = 10f;
				height = 13f;
				shootEffect = Fx.shootBig;
				smokeEffect = Fx.shootBigSmoke;
				ammoMultiplier = 4;
				lifetime = 60f;
			}}
		);
		
		size = 2;
		range = 190f;
		reload = 31f;
		ammoEjectBack = 3f;
		recoil = 3f;
		shake = 1f;
		shoot.shots = 4;
		shoot.shotDelay = 3f;
		
		ammoUseEffect = Fx.casing2;
		scaledHealth = 240;
		shootSound = Sounds.shootBig;
		
		limitRange();
		coolant = consumeCoolant(0.2f);
		
	} //Constructor
	
} //class
