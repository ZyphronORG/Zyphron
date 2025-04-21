package com.main;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.visuals.menu.WelcomeScreen;

@Mod(modid = "zyphron", name = "Zyphron", version = "1.0")
public class Zyphron {

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new WelcomeScreen());
    }
}