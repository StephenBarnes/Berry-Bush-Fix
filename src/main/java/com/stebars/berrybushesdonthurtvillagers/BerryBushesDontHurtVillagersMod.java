package com.stebars.berrybushesdonthurtvillagers;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;


@Mod(BerryBushesDontHurtVillagersMod.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BerryBushesDontHurtVillagersMod {
	public final static String MOD_ID = "berrybushesdonthurtvillagers";

	public BerryBushesDontHurtVillagersMod() {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
