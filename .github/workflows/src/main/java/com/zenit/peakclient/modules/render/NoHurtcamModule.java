package com.zenit.peakclient.modules.render;

import com.zenit.peakclient.modules.Module;

public class NoHurtcamModule extends Module {
    public NoHurtcamModule() {
        super("No Hurtcam", "Removes damage camera shake", Category.RENDER);
    }
    
    @Override
    public void onEnable() {}
    
    @Override
    public void onUpdate() {}
    
    @Override
    public void onDisable() {}
}
