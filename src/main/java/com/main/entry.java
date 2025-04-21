package com.main;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import com.visuals.menu.welcomescreen;

@Mod(modid = "zyphron", name = "Zyphron", version = "1.0")
public class entry {

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("Zyphron mod pre-initializing!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("Zyphron mod initializing!");
        MinecraftForge.EVENT_BUS.register(new welcomescreen());
        System.out.println("Registered welcome screen handler");
    }
}