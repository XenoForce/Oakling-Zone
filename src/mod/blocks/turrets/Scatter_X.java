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


public class Scatter_X extends ItemTurret {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Scatter_X() {
		
		super("scatter-x");
		
		localizedName = "Scatter X";
		
		requirements( Category.turret,
			with(	Items.copper, 85,
					Items.lead, 45 ));
		
		ammo(
			Items.scrap, new FlakBulletType(4f, 3){{
				lifetime = 60f;
				ammoMultiplier = 5f;
				shootEffect = Fx.shootSmall;
				reloadMultiplier = 0.5f;
				width = 6f;
				height = 8f;
				hitEffect = Fx.flakExplosion;
				splashDamage = 22f * 1.5f;
				splashDamageRadius = 24f;
			}},
			
			Items.lead, new FlakBulletType(4.2f, 3){{
				lifetime = 60f;
				ammoMultiplier = 4f;
				shootEffect = Fx.shootSmall;
				width = 6f;
				height = 8f;
				hitEffect = Fx.flakExplosion;
				splashDamage = 27f * 1.5f;
				splashDamageRadius = 15f;
			}},
			
			Items.metaglass, new FlakBulletType(4f, 3){{
				lifetime = 60f;
				ammoMultiplier = 5f;
				shootEffect = Fx.shootSmall;
				reloadMultiplier = 0.8f;
				width = 6f;
				height = 8f;
				hitEffect = Fx.flakExplosion;
				splashDamage = 30f * 1.5f;
				splashDamageRadius = 20f;
				fragBullets = 6;
				
				fragBullet = new BasicBulletType(3f, 5){{
					width = 5f;
					height = 12f;
					shrinkY = 1f;
					lifetime = 20f;
					backColor = Pal.gray;
					frontColor = Color.white;
					despawnEffect = Fx.none;
					collidesGround = false;
				}};
			}}
		);
		
		reload = 18f;
		range = 220f;
		size = 2;
		targetGround = false;
		
		shoot.shotDelay = 5f;
		shoot.shots = 2;
		
		recoil = 2f;
		rotateSpeed = 15f;
		inaccuracy = 17f;
		shootCone = 35f;
		
		scaledHealth = 200;
		shootSound = Sounds.shootSnap;
		coolant = consumeCoolant(0.2f);
		researchCostMultiplier = 0.05f;
		
		limitRange(2);
		
	} //Constructor
	
} //class
