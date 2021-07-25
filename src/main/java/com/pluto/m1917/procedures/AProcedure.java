package com.pluto.m1917.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Random;
import java.util.Map;

import com.pluto.m1917.item.LuckyBulletItem;
import com.pluto.m1917.M1917gunModElements;
import com.pluto.m1917.M1917gunMod;

@M1917gunModElements.ModElement.Tag
public class AProcedure extends M1917gunModElements.ModElement {
	public AProcedure(M1917gunModElements instance) {
		super(instance, 9);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				M1917gunMod.LOGGER.warn("Failed to load dependency entity for procedure A!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				M1917gunMod.LOGGER.warn("Failed to load dependency itemstack for procedure A!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(LuckyBulletItem.block, (int) (1)))
				: false)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(LuckyBulletItem.block, (int) (1));
				_setstack.setCount((int) (-1));
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 21);
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u54E6\uFF0C\u771F\u5BF9\u4E0D\u4F4F\u4F60"), (true));
			}
			{
				ItemStack _ist = (itemstack);
				if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u4F60\u5B50\u5F39\u5462"), (true));
			}
		}
	}
}
