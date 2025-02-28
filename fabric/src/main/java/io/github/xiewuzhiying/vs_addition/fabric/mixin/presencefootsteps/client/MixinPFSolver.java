package io.github.xiewuzhiying.vs_addition.fabric.mixin.presencefootsteps.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import eu.ha3.presencefootsteps.world.PFSolver;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;

import static io.github.xiewuzhiying.vs_addition.util.TransformUtilsKt.getPosStandingOnFromShips;

@Pseudo
@Mixin(PFSolver.class)
public abstract class MixinPFSolver {
    @WrapOperation(
            method = "findAssociation(Leu/ha3/presencefootsteps/world/AssociationPool;Lnet/minecraft/world/entity/LivingEntity;DZ)Leu/ha3/presencefootsteps/world/Association;",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/core/BlockPos;containing(DDD)Lnet/minecraft/core/BlockPos;"
            )
    )
    private BlockPos includeShips(double d, double e, double f, Operation<BlockPos> original, @Local(argsOnly = true) LivingEntity ply) {
        return getPosStandingOnFromShips(ply.level(), new Vector3d(d, e, f), 1);
    }
}
