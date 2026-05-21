package com.zenit.peakclient.modules;

public abstract class Module {
    private final String name;
    private final String description;
    private final Category category;
    private boolean enabled;
    private int keybind;
    
    public enum Category {
        RENDER("Render"),
        MOVEMENT("Movement"),
        HUD("HUD"),
        COSMETIC("Cosmetic"),
        UTILITY("Utility");
        
        public final String displayName;
        Category(String displayName) { this.displayName = displayName; }
    }
    
    public Module(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.enabled = false;
        this.keybind = -1;
    }
    
    public void enable() {
        enabled = true;
        onEnable();
    }
    
    public void disable() {
        enabled = false;
        onDisable();
    }
    
    public void toggle() {
        if (enabled) disable();
        else enable();
    }
    
    public abstract void onEnable();
    public abstract void onUpdate();
    public abstract void onDisable();
    
    // Getters/Setters
    public String getName() { return name; }
    public String getDescription() { return description; }
    public Category getCategory() { return category; }
    public boolean isEnabled() { return enabled; }
    public int getKeybind() { return keybind; }
    public void setKeybind(int keybind) { this.keybind = keybind; }
}
