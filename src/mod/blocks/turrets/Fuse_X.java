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


public class Fuse_X extends ItemTurret {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Fuse_X() {
		
		super("fuse-x");
		
		localizedName = "Fuse X";
		
		requirements( Category.turret, 
			with( 	Items.copper, 225, 
					Items.graphite, 225, 
					Items.thorium, 100 ));
		
		reload = 35f;
		shake = 4f;
		range = 90f;
		recoil = 5f;
		
		shoot = new ShootSpread(3, 20f);
		
		shootCone = 30;
		size = 3;
		envEnabled |= Env.space;

		scaledHealth = 220;
		shootSound = Sounds.shotgun;
		coolant = consumeCoolant(0.3f);
		
		float brange = range + 10f;
		
		ammo(
			Items.titanium, new ShrapnelBulletType(){{
				length = brange;
				damage = 66f;
				ammoMultiplier = 4f;
				width = 17f;
				reloadMultiplier = 1.3f;
			}},
			
			Items.thorium, new ShrapnelBulletType(){{
				length = brange;
				damage = 105f;
				ammoMultiplier = 5f;
				toColor = Pal.thoriumPink;
				shootEffect = smokeEffect = Fx.thoriumShoot;
			}}
		);
		
	} //Constructor
	
} //class
