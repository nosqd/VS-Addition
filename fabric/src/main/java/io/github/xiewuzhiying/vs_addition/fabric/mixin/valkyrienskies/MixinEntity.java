package io.github.xiewuzhiying.vs_addition.fabric.mixin.valkyrienskies;

import com.bawnorton.mixinsquared.TargetHandler;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import io.github.xiewuzhiying.vs_addition.util.AirPocketUtils;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.function.Consumer;

@Mixin(value = Entity.class, priority = 1500)
public abstract class MixinEntity {
    @TargetHandler(
            mixin = "org.valkyrienskies.mod.fabric.mixin.feature.water_in_ships_entity.MixinEntity",
            name = "Lorg/valkyrienskies/mod/fabric/mixin/feature/water_in_ships_entity/MixinEntity;afterFluidStateUpdate(Lnet/minecraft/tags/TagKey;DLorg/spongepowered/asm/mixin/injection/callback/CallbackInfoReturnable;)V",
            prefix = "handler"
    )
    @WrapOperation(
            method = "@MixinSquared:Handler",
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/valkyrienskies/mod/common/VSGameUtilsKt;transformFromWorldToNearbyShipsAndWorld(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Consumer;)V"
            ),
            remap = false
    )
    private void custom(Level level, AABB aabb, Consumer<AABB> cb, Operation<Void> original) {
        AirPocketUtils.transformFromWorldToNearbyShipsInAirPocket(level, aabb, cb);
    }
}
