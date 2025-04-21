package com.visuals.menu;

import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;

import java.lang.reflect.Field;

public class WelcomeScreen {

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onGuiOpen(GuiOpenEvent e) {
        if (e.gui instanceof GuiMainMenu) {
            try {
                Field splashField = GuiMainMenu.class.getDeclaredField("splashText");
                splashField.setAccessible(true);
                String[] splashes = {
                        "Zyphron is watching",
                        "Zyphron was here",
                        "Zyphron?",
                        "Zyphron never dies",
                        "Zyphron, made in German and C+!"
                };
                String randomSplash = splashes[(int)(Math.random() * splashes.length)];
                splashField.set(e.gui, randomSplash);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}