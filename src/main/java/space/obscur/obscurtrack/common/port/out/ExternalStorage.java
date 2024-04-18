package space.obscur.obscurtrack.common.port.out;

import space.obscur.obscurtrack.common.itemsList.ItemsList;

import java.util.Optional;

public interface ExternalStorage <Entity, Id>{
    boolean push(Entity entity);
    boolean push(Id id, Entity entity);

    ItemsList<Entity> find();

    Optional<Entity> findOne(Id id);
}
