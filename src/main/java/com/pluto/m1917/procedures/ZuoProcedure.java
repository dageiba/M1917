package com.pluto.m1917.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Random;
import java.util.Map;
import java.util.Collection;

import com.pluto.m1917.item.LuckyBulletItem;
import com.pluto.m1917.M1917gunModElements;
import com.pluto.m1917.M1917gunMod;

@M1917gunModElements.ModElement.Tag
public class ZuoProcedure extends M1917gunModElements.ModElement {
	public ZuoProcedure(M1917gunModElements instance) {
		super(instance, 4);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				M1917gunMod.LOGGER.warn("Failed to load dependency entity for procedure Zuo!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				M1917gunMod.LOGGER.warn("Failed to load dependency itemstack for procedure Zuo!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double CD = 0;
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(LuckyBulletItem.block, (int) (1)))
				: false)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(LuckyBulletItem.block, (int) (1));
				_setstack.setCount((int) (-1));
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			if ((new Object() {
				boolean check(Entity _entity) {
					if (_entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == Effects.LUCK)
								return true;
						}
					}
					return false;
				}
			}.check(entity))) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 20);
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u8FD0\u949E\u8F66\u78BE\u8FC7\u4E86\u4F60\u7684\u8138"),
							(true));
				}
			}
			if ((new Object() {
				boolean check(Entity _entity) {
					if (_entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == Effects.SPEED)
								return true;
						}
					}
					return false;
				}
			}.check(entity))) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 20);
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u8FD0\u949E\u8F66\u78BE\u8FC7\u4E86\u4F60\u7684\u8138"),
							(true));
				}
			}
			if ((Math.random() >= 0.95)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 600, (int) 5));
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u5C1D\u8D77\u6765\u5C31\u50CF\u54C6\u5566A\u68A6"), (true));
				}
			}
			if ((Math.random() >= 0.75)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.UNLUCK, (int) 12000, (int) 2));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 10, (int) 1));
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u4F60\u771F\u201C\u8D70\u201D\u8FD0"), (true));
				}
			} else {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.LUCK, (int) 12000, (int) 2));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 10, (int) 1));
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u4F60\u771F\u8D70\u8FD0"), (true));
				}
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
