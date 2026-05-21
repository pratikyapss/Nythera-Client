package com.zenit.peakclient.mixin;

import com.zenit.peakclient.PeakClient;
import com.zenit.peakclient.modules.movement.ZoomModule;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(GameRenderer.class)
public class ZoomMixin {
    @ModifyVariable(method = "getFov", at = @At("RETURN"), ordinal = 0)
    private double modifyFov(double originalFov) {
        ZoomModule zoom = (ZoomModule) PeakClient.moduleManager.getModule("Zoom");
        if (zoom != null && zoom.isEnabled() && zoom.isZooming()) {
            return zoom.getZoomFov();
        }
        return originalFov;
    }
}
