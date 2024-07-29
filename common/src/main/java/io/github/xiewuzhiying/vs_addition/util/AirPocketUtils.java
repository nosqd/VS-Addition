package io.github.xiewuzhiying.vs_addition.util;

import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.apache.commons.lang3.tuple.Pair;
import org.joml.primitives.AABBd;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.api.ships.datastructures.ShipConnDataAttachment;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class AirPocketUtils {
    public static void transformFromWorldToNearbyShipsInAirPocket(Level level, AABB aabb, Consumer<AABB> cb) {
        List<Pair<Ship, Boolean>> ships = new ArrayList<>();
        VSGameUtilsKt.transformFromWorldToNearbyShipsAndWorld(level, aabb, aabb1 -> {
            Ship ship = VSGameUtilsKt.getShipManagingPos(level, aabb1.getCenter());
            final ShipConnDataAttachment shipConnData;
            if(ship instanceof LoadedServerShip loadedServerShip) {
                shipConnData = loadedServerShip.getAttachment(ShipConnDataAttachment.class);
            } else {
                shipConnData = null;
            }
            ships.add(Pair.of(ship, shipConnData != null));
        });
        ships.sort(Comparator.comparingDouble(pair -> calculateAabbVolume(pair.getLeft().getShipAABB())));
        List<Ship> newShips = new ArrayList<>();
        for(Pair<Ship, Boolean> pair : ships) {
            newShips.add(pair.getLeft());
            boolean bl = pair.getRight();
            if(bl) break;
        }
        cb.accept(aabb);
        final AABBd tmpAABB = new AABBd();
        newShips.forEach(ship ->
                cb.accept(VectorConversionsMCKt.toMinecraft(VectorConversionsMCKt.set(tmpAABB, aabb).transform(ship.getWorldToShip())))
        );
    }

    public static int calculateAabbVolume(AABBic aabb) {
        int width = aabb.maxX() - aabb.minX();
        int height = aabb.maxY() - aabb.minY();
        int depth = aabb.maxZ() - aabb.minZ();
        return width * height * depth;
    }
}
