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


public class Spectre_X extends ItemTurret {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Spectre_X() {
		
		super("spectre-x");
		
		localizedName = "Spectre X";
		
		requirements( Category.turret,
			with(	Items.copper, 550,
					Items.graphite, 300,
					Items.surgeAlloy, 250,
					Items.plastanium, 175,
					Items.thorium, 250 ));
		
		ammo(
			Items.graphite, new BasicBulletType(7.5f, 50){{
				hitSize = 4.8f;
				width = 15f;
				height = 21f;
				shootEffect = Fx.shootBig;
				ammoMultiplier = 4;
				reloadMultiplier = 1.7f;
				knockback = 0.3f;
			}},
			
			Items.thorium, new BasicBulletType(8f, 80){{
				hitSize = 5;
				width = 16f;
				height = 23f;
				shootEffect = Fx.shootBig;
				pierceCap = 2;
				pierceBuilding = true;
				knockback = 0.7f;
			}},
			
			Items.pyratite, new BasicBulletType(7f, 70){{
				hitSize = 5;
				width = 16f;
				height = 21f;
				frontColor = Pal.lightishOrange;
				backColor = Pal.lightOrange;
				status = StatusEffects.burning;
				hitEffect = new MultiEffect(Fx.hitBulletSmall, Fx.fireHit);
				shootEffect = Fx.shootBig;
				makeFire = true;
				pierceCap = 2;
				pierceBuilding = true;
				knockback = 0.6f;
				ammoMultiplier = 3;
				splashDamage = 20f;
				splashDamageRadius = 25f;
			}}
		);
		
		reload = 7f;
		recoilTime = reload * 2f;
		coolantMultiplier = 0.5f;
		ammoUseEffect = Fx.casing3;
		range = 260f;
		inaccuracy = 3f;
		recoil = 3f;
		shoot = new ShootAlternate(8f);
		shake = 2f;
		
		size = 4;
		
		shootCone = 24f;
		shootSound = Sounds.shootBig;
		
		scaledHealth = 160;
		
		coolant = consumeCoolant(1f);
		limitRange();
		
	} //Constructor
	
} //class
