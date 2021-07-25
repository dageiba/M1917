package com.pluto.m1917.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.Collection;

import com.pluto.m1917.M1917gunModElements;
import com.pluto.m1917.M1917gunMod;

@M1917gunModElements.ModElement.Tag
public class YouProcedure extends M1917gunModElements.ModElement {
	public YouProcedure(M1917gunModElements instance) {
		super(instance, 5);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				M1917gunMod.LOGGER.warn("Failed to load dependency entity for procedure You!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
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
		}.check(((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null)))) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 20);
			if (((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null) instanceof PlayerEntity
					&& !((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null).world.isRemote()) {
				((PlayerEntity) ((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null))
						.sendStatusMessage(new StringTextComponent("\u8FD0\u949E\u8F66\u78BE\u8FC7\u4E86\u4F60\u7684\u8138"), (true));
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
		}.check(((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null)))) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 20);
			if (((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null) instanceof PlayerEntity
					&& !((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null).world.isRemote()) {
				((PlayerEntity) ((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null))
						.sendStatusMessage(new StringTextComponent("\u8FD0\u949E\u8F66\u78BE\u8FC7\u4E86\u4F60\u7684\u8138"), (true));
			}
		}
		if ((((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null) == entity)) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 90000);
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u771F\u662F\u4E2A\u4E0D\u9519\u7684\u4E3B\u610F"), (true));
			}
		}
		if ((Math.random() >= 0.75)) {
			if (((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null) instanceof LivingEntity)
				((LivingEntity) ((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null))
						.addPotionEffect(new EffectInstance(Effects.UNLUCK, (int) 12000, (int) 2));
			if (((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null) instanceof LivingEntity)
				((LivingEntity) ((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null))
						.addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 10, (int) 1));
			((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null).attackEntityFrom(DamageSource.GENERIC, (float) 1);
			if (((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null) instanceof PlayerEntity
					&& !((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null).world.isRemote()) {
				((PlayerEntity) ((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null)).sendStatusMessage(
						new StringTextComponent("\u4F60\u771F\u201C\u8D70\u201D\u8FD0\uFF0C\u5C1D\u8D77\u6765\u5C31\u50CF\u54C6\u5566A\u68A6"),
						(true));
			}
		} else {
			if (((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null) instanceof LivingEntity)
				((LivingEntity) ((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null))
						.addPotionEffect(new EffectInstance(Effects.LUCK, (int) 12000, (int) 2));
			if (((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null) instanceof LivingEntity)
				((LivingEntity) ((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null))
						.addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 10, (int) 1));
			if (((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null) instanceof PlayerEntity
					&& !((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null).world.isRemote()) {
				((PlayerEntity) ((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null))
						.sendStatusMessage(new StringTextComponent("\u4F60\u771F\u8D70\u8FD0"), (true));
			}
		}
	}
}
