package com.visuals.menu;

import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.lang.reflect.Field;

public class welcomescreen {
    private boolean splashTextChanged = false;

    @SubscribeEvent
    public void onGuiOpen(GuiOpenEvent event) {
        if (event.gui instanceof GuiMainMenu && !splashTextChanged) {
            GuiMainMenu menu = (GuiMainMenu) event.gui;
            System.out.println("Main menu detected, attempting to change splash text...");

            try {
                // basically the names for the text
                String[] possibleFieldNames = {
                        "splashText",
                        "field_73975_c",
                        "field_110353_x"
                };

                boolean success = false;
                for (String fieldName : possibleFieldNames) {
                    try {
                        Field splashTextField = GuiMainMenu.class.getDeclaredField(fieldName);
                        splashTextField.setAccessible(true);
                        splashTextField.set(menu, "Zyphron, made using german and c+");
                        System.out.println("Successfully changed splash text using field: " + fieldName);
                        success = true;
                        splashTextChanged = true;
                        break;
                    } catch (NoSuchFieldException e) {
                        System.out.println("Field not found: " + fieldName);
                    }
                }

                if (!success) {
                    System.out.println("Trying to find splash text field by searching...");
                    for (Field field : GuiMainMenu.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        if (field.getType() == String.class) {
                            Object value = field.get(menu);
                            if (value instanceof String) {
                                String stringValue = (String) value;
                                // Look for fields that might be the splash text
                                if (stringValue.contains("MINECRAFT") || stringValue.contains("Minecraft") ||
                                        stringValue.contains("minecraft.net")) {
                                    field.set(menu, "Welcome to your Doom!");
                                    System.out.println("Found and changed splash text field: " + field.getName());
                                    splashTextChanged = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Failed to change splash text:");
                e.printStackTrace();
            }
        }
    }
}

