package mod.blocks.turrets;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;

import mindustry.world.blocks.defense.turrets.*;
import mindustry.entities.bullet.*;
import mindustry.graphics.*;
import mindustry.entities.*;
import mindustry.entities.pattern.*;
import mindustry.type.*;
import mindustry.world.meta.*;

// import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;


public class Foreshadow_X extends ItemTurret {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Foreshadow_X() {
		
		super("foreshadow-x");
		
		localizedName = "Foreshadow X";
		
		float brange = range = 500f;
		
		requirements( Category.turret,
		with( Items.copper, 1000,
		Items.metaglass, 600,
		Items.surgeAlloy, 300,
		Items.plastanium, 200,
		Items.silicon, 600 ));
		
		ammo(
			Items.surgeAlloy, new PointBulletType(){{
				shootEffect = Fx.instShoot;
				hitEffect = Fx.instHit;
				smokeEffect = Fx.smokeCloud;
				trailEffect = Fx.instTrail;
				despawnEffect = Fx.instBomb;
				trailSpacing = 20f;
				damage = 1350;
				buildingDamageMultiplier = 0.2f;
				speed = brange;
				hitShake = 6f;
				ammoMultiplier = 1f;
			}}
		);
		
		maxAmmo = 40;
		ammoPerShot = 5;
		rotateSpeed = 2f;
		reload = 200f;
		ammoUseEffect = Fx.casing3Double;
		recoil = 5f;
		cooldownTime = reload;
		shake = 4f;
		size = 4;
		shootCone = 2f;
		shootSound = Sounds.railgun;
		unitSort = UnitSorts.strongest;
		envEnabled |= Env.space;
		
		coolantMultiplier = 0.4f;
		scaledHealth = 150;
		
		coolant = consumeCoolant(1f);
		consumePower(10f);
		
	} //Constructor
	
} //class
