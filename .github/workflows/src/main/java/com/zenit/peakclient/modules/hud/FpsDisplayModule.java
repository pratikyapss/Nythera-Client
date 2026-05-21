package com.zenit.peakclient.modules.hud;

import com.zenit.peakclient.modules.Module;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;

public class FpsDisplayModule extends Module {
    public FpsDisplayModule() {
        super("FPS Display", "Shows current FPS", Category.HUD);
    }
    
    @Override
    public void onEnable() {
        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            if (!isEnabled()) return;
            MinecraftClient client = MinecraftClient.getInstance();
            int fps = client.getCurrentFps();
            String text = "FPS: " + fps;
            drawContext.drawText(client.textRenderer, text, 2, 2, 0xFFFFFF, true);
        });
    }
    
    @Override
    public void onUpdate() {}
    
    @Override
    public void onDisable() {}
}
