package io.github.xiewuzhiying.vs_addition.mixin.valkyrienskies;

import com.bawnorton.mixinsquared.TargetHandler;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import io.github.xiewuzhiying.vs_addition.util.AirPocketUtils;
import net.minecraft.client.Camera;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.function.Consumer;

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
