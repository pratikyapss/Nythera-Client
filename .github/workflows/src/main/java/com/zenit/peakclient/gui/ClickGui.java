package com.zenit.peakclient.gui;

import com.zenit.peakclient.PeakClient;
import com.zenit.peakclient.modules.Module;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import java.util.ArrayList;
import java.util.List;

public class ClickGui extends Screen {
    private List<ModuleButton> buttons = new ArrayList<>();
    private int scrollOffset = 0;
    
    public ClickGui() {
        super(Text.literal("Peak Client - Zenit"));
    }
    
    @Override
    protected void init() {
        int x = 10, y = 30, w = 140, h = 22;
        
        for (Module module : PeakClient.moduleManager.getModules()) {
            ModuleButton btn = new ModuleButton(x, y, w, h, module, button -> {
                module.toggle();
                ((ModuleButton) button).updateMessage();
            });
            addDrawableChild(btn);
            buttons.add(btn);
            
            y += h + 4;
            if (y + h > height - 10) {
                y = 30;
                x += w + 6;
            }
        }
    }
    
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        
        // Title
        context.drawCenteredTextWithShadow(
            textRenderer,
            "Peak Client v1.0.0 - Created by Zenit",
            width / 2,
            10,
            0xFFFFFF
        );
        
        // Subtitle
        context.drawCenteredTextWithShadow(
            textRenderer,
            "Right Shift to close | " + PeakClient.moduleManager.getModules().size() + " Modules",
            width / 2,
            22,
            0xAAAAAA
        );
        
        super.render(context, mouseX, mouseY, delta);
    }
    
    @Override
    public boolean shouldPause() { return false; }
    
    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (super.keyPressed(keyCode, scanCode, modifiers)) return true;
        
        // Close GUI when pressing Right Shift again
        if (client != null && client.options.useKey.matchesKey(keyCode, scanCode)) {
            this.close();
            return true;
        }
        return false;
    }
    
    private static class ModuleButton extends ButtonWidget {
        private final Module module;
        
        public ModuleButton(int x, int y, int w, int h, Module module, PressAction onPress) {
            super(x, y, w, h, Text.literal(""), onPress, DEFAULT_NARRATION_SUPPLIER);
            this.module = module;
            updateMessage();
        }
        
        public void updateMessage() {
            String status = module.isEnabled() ? "§aON" : "§cOFF";
            setMessage(Text.literal(module.getName() + ": " + status));
        }
    }
}
