package com.zenit.peakclient.modules.render;

import com.zenit.peakclient.modules.Module;
import net.minecraft.client.MinecraftClient;

public class FullbrightModule extends Module {
    private double previousGamma = 1.0;
    
    public FullbrightModule() {
        super("Fullbright", "Makes everything fully lit", Category.RENDER);
    }
    
    @Override
    public void onEnable() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.options != null) {
            previousGamma = client.options.getGamma().getValue();
            client.options.getGamma().setValue(16.0);
        }
    }
    
    @Override
    public void onUpdate() {}
    
    @Override
    public void onDisable() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.options != null) {
            client.options.getGamma().setValue(previousGamma);
        }
    }
}
