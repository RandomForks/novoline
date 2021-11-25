package viaversion.viabackwards.api.entities.meta;

import net.yb;
import viaversion.viabackwards.api.exceptions.RemovedValueException;
import viaversion.viaversion.api.minecraft.metadata.Metadata;

public interface MetaHandler {
   Metadata a(yb var1) throws RemovedValueException;
}
