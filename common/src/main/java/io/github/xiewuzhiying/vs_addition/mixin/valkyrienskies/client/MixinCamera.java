package io.github.xiewuzhiying.vs_addition.mixin.valkyrienskies.client;

import net.minecraft.client.Camera;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = Camera.class, priority = 1500)
public abstract class MixinCamera {
//    @TargetHandler(
//            mixin = "org.valkyrienskies.mod.mixin.feature.fluid_camera_fix.MixinCamera",
//            name = "getFluidInCamera"
//    )
//    @WrapOperation(
//            method = "@MixinSquared:Handler",
//            at = @At(
//                    value = "INVOKE",
//                    target = "Lorg/valkyrienskies/mod/common/VSGameUtilsKt;transformFromWorldToNearbyShipsAndWorld(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Consumer;)V"
//            )
//    )
//    private void custom(Level level, AABB aabb, Consumer<AABB> cb, Operation<Void> original) {
//        AirPocketUtils.transformFromWorldToNearbyShipsInAirPocket(level, aabb, cb);
//    }
}
