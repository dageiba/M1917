package com.pluto.m1917.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.pluto.m1917.M1917gunModElements;
import com.pluto.m1917.M1917gunMod;

@M1917gunModElements.ModElement.Tag
public class SarilangProcedure extends M1917gunModElements.ModElement {
	public SarilangProcedure(M1917gunModElements instance) {
		super(instance, 32);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				M1917gunMod.LOGGER.warn("Failed to load dependency entity for procedure Sarilang!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				M1917gunMod.LOGGER.warn("Failed to load dependency sourceentity for procedure Sarilang!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if ((EntityTypeTags.getCollection().getTagByID(new ResourceLocation(("minecraft:villager").toLowerCase(java.util.Locale.ENGLISH)))
				.contains(entity.getType()))) {
			if (!entity.world.isRemote())
				entity.remove();
		}
		if ((EntityTypeTags.getCollection().getTagByID(new ResourceLocation(("minecraft:player").toLowerCase(java.util.Locale.ENGLISH)))
				.contains(entity.getType()))) {
			if (!entity.world.isRemote())
				entity.remove();
		}
		if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
			((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("\u8428\u65E5\u6717"), (true));
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u8428\u65E5\u6717"), (false));
		}
	}
}
