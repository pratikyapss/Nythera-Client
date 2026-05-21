package com.zenit.peakclient.modules;

import com.zenit.peakclient.modules.render.*;
import com.zenit.peakclient.modules.movement.*;
import com.zenit.peakclient.modules.hud.*;
import com.zenit.peakclient.modules.cosmetic.*;
import com.zenit.peakclient.modules.utility.*;
import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private final List<Module> modules = new ArrayList<>();
    
    public void init() {
        // Render Modules
        modules.add(new FullbrightModule());
        modules.add(new ZoomModule());
        modules.add(new HitboxOverlayModule());
        modules.add(new NoHurtcamModule());
        modules.add(new CrosshairModule());
        modules.add(new MotionBlurModule());
        modules.add(new ChunkBordersModule());
        
        // Movement Modules
        modules.add(new ToggleSprintModule());
        modules.add(new FreelookModule());
        
        // HUD Modules
        modules.add(new FpsDisplayModule());
        modules.add(new CpsCounterModule());
        modules.add(new KeystrokesHudModule());
        modules.add(new CoordinatesModule());
        modules.add(new ArmorStatusModule());
        modules.add(new PotionEffectsModule());
        modules.add(new DirectionHudModule());
        modules.add(new ScoreboardTweaksModule());
        
        // Cosmetic Modules
        modules.add(new CapeModule());
        modules.add(new WingsModule());
        modules.add(new HatCosmeticsModule());
        modules.add(new ParticleTrailModule());
        
        // Utility Modules
        modules.add(new WaypointsModule());
        modules.add(new MinimapModule());
        modules.add(new AutoSprintModule());
        modules.add(new HitColorModule());
        modules.add(new BlockOverlayModule());
    }
    
    public List<Module> getModules() { return modules; }
    
    public Module getModule(String name) {
        return modules.stream()
            .filter(m -> m.getName().equalsIgnoreCase(name))
            .findFirst()
            .orElse(null);
    }
    
    public List<Module> getModulesInCategory(Module.Category category) {
        return modules.stream()
            .filter(m -> m.getCategory() == category)
            .toList();
    }
}
