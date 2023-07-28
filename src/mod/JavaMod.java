package mod;

import java.util.*;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;
import mindustry.ctype.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.type.unit.*;

import mod.blocks.turrets.*;
import mod.blocks.units.*;
import mod.units.*;


public class JavaMod extends Mod {
	
	//---------------------------------------------------------------//
	//  Constructor                                                  //
	//---------------------------------------------------------------//
	public JavaMod() {
		
		Log.info("Loaded Oakling-Zone (JavaMod class) constructor.");
		
		//listen for game load event
		Events.on( ClientLoadEvent.class, e -> {
			
			//Show dialog upon startup:
			Time.runTask(10f, () -> {
				// BaseDialog dialog = new BaseDialog("abc");
				// Note: Mod sprites are prefixed with the mod name.
			});
		});
	} //constructor
	
	
	//---------------------------------------------------------------//
	//  loadContent()                                                //
	//---------------------------------------------------------------//
	@Override
	public void loadContent() {
		
		Log.info("Loading content - (Oakling-Zone mod).");
		
		List<UnlockableContent> arrContent = new ArrayList<>();
		
		// Serpulo Turrets:
		
		arrContent.add( new Cyclone_X() );
		arrContent.add( new Foreshadow_X() );
		arrContent.add( new Fuse_X() );
		arrContent.add( new Lancer_X() );
		arrContent.add( new Segment_X() );
		arrContent.add( new Swarmer_X() );
		
		// Erekir Turrets:
		
		arrContent.add( new Afflict_X() );
		arrContent.add( new Breach_X() );
		arrContent.add( new Scathe_X() );
		arrContent.add( new Sublimate_X() );
		
		// Unit Factory:
		
		arrContent.add( new Unit_Factory_X() );
		
		// Serpulo Units:
		
		arrContent.add( X_Unit_Types.corvus_x );
		arrContent.add( X_Unit_Types.eclipse_x );
		arrContent.add( X_Unit_Types.reign_x );
		arrContent.add( X_Unit_Types.toxopid_x );
		
		// Erekir Units:
		
		arrContent.add( X_Unit_Types.collaris_x );
		arrContent.add( X_Unit_Types.conquer_x );
		arrContent.add( X_Unit_Types.disrupt_x );
		
		// - - - - - - - - - - - - - - - - - - - - - -
		
		for (UnlockableContent uc : arrContent) {
			uc.load();
			uc.unlock();
		} //for
		
	} //loadContent()
	
	
} //class
