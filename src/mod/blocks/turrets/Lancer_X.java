package mod.blocks.turrets;

import arc.*;
import arc.graphics.*;
import arc.util.*;

import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;

import mindustry.world.blocks.defense.turrets.*;
import mindustry.entities.bullet.*;
import mindustry.graphics.*;
import mindustry.entities.pattern.*;
import mindustry.type.*;
import mindustry.world.meta.*;
import mindustry.entities.effect.*;

// import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;


public class Lancer_X extends PowerTurret {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public Lancer_X() {
		
		super("lancer-x");
		
		localizedName = "Lancer X";
		
		requirements( Category.turret,
			with(	Items.copper, 60,
					Items.lead, 70,
					Items.silicon, 60,
					Items.titanium, 30 ));
		
		range = 165f;
		
		shoot.firstShotDelay = 40f;
		
		recoil = 2f;
		reload = 80f;
		shake = 2f;
		shootEffect = Fx.lancerLaserShoot;
		smokeEffect = Fx.none;
		heatColor = Color.red;
		size = 2;
		scaledHealth = 280;
		targetAir = false;
		moveWhileCharging = false;
		accurateDelay = false;
		shootSound = Sounds.laser;
		coolant = consumeCoolant(0.2f);
		
		consumePower(6f);
		
		shootType = new LaserBulletType(140){{
			colors = new Color[]{Pal.lancerLaser.cpy().a(0.4f), Pal.lancerLaser, Color.white};
			//TODO merge
			chargeEffect = new MultiEffect(Fx.lancerLaserCharge, Fx.lancerLaserChargeBegin);
			
			buildingDamageMultiplier = 0.25f;
			hitEffect = Fx.hitLancer;
			hitSize = 4;
			lifetime = 16f;
			drawSize = 400f;
			collidesAir = false;
			length = 173f;
			ammoMultiplier = 1f;
			pierceCap = 4;
		}};
		
	} //Constructor
	
} //class
