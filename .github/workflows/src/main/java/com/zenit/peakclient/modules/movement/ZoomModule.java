package com.zenit.peakclient.modules.movement;

import com.zenit.peakclient.modules.Module;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class ZoomModule extends Module {
    private boolean zooming = false;
    private KeyBinding zoomKey;
    
    public ZoomModule() {
        super("Zoom", "Zoom in by holding C", Category.MOVEMENT);
    }
    
    @Override
    public void onEnable() {
        zoomKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.peakclient.zoom",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_C,
            "category.peakclient"
        ));
        
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (isEnabled()) {
                zooming = zoomKey.isPressed();
            }
        });
    }
    
    public boolean isZooming() { return zooming; }
    public double getZoomFov() { return 30.0; }
    
    @Override
    public void onUpdate() {}
    
    @Override
    public void onDisable() { zooming = false; }
}
