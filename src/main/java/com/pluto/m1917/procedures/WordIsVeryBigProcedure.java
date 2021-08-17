package com.pluto.m1917.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;

import java.util.Map;

import com.pluto.m1917.M1917gunModElements;
import com.pluto.m1917.M1917gunMod;

@M1917gunModElements.ModElement.Tag
public class WordIsVeryBigProcedure extends M1917gunModElements.ModElement {
	public WordIsVeryBigProcedure(M1917gunModElements instance) {
		super(instance, 27);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).getCooldownTracker().setCooldown(((itemstack)).getItem(), (int) 600);
		((itemstack)).shrink((int) 1);
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"tell @a[distance=..100] \u00A7c\u00A7l\u6211\u7684\u5F88\u5927\uFF0C\u8BF7\u5FCD\u4E00\u4E0B ");
			}
		}
	}
}
