package com.pluto.m1917.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.Collection;

import com.pluto.m1917.M1917gunModElements;
import com.pluto.m1917.M1917gunMod;

@M1917gunModElements.ModElement.Tag
public class YouProcedure extends M1917gunModElements.ModElement {
	public YouProcedure(M1917gunModElements instance) {
		super(instance, 7);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				M1917gunMod.LOGGER.warn("Failed to load dependency entity for procedure You!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				M1917gunMod.LOGGER.warn("Failed to load dependency sourceentity for procedure You!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
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
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 21);
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u8FD0\u949E\u8F66\u5728\u4F60\u8138\u4E0A\u78BE\u8FC7"), (false));
			}
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("\u8FD0\u949E\u8F66\u5728\u4ED6\u8138\u4E0A\u78BE\u8FC7"),
						(false));
			}
		}
		if ((new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == Effects.UNLUCK)
							return true;
					}
				}
				return false;
			}
		}.check(entity))) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 21);
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u8FD0\u949E\u8F66\u5728\u4F60\u8138\u4E0A\u78BE\u8FC7"), (false));
			}
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("\u8FD0\u949E\u8F66\u5728\u4ED6\u8138\u4E0A\u78BE\u8FC7"),
						(false));
			}
		}
		if ((Math.random() >= 0.75)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.UNLUCK, (int) 12000, (int) 2, (false), (true)));
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 60, (int) 1));
			entity.setMotionMultiplier(null, new Vector3d(0.25D, (double) 0.05F, 0.25D));
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent("\u4F60\u771F\u201C\u8D70\u201D\u8FD0\uFF0C\u5C1D\u8D77\u6765\u5C31\u50CF\u54C6\u5566A\u68A6"),
						(true));
			}
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(
						new StringTextComponent("\u4ED6\u771F\u201C\u8D70\u201D\u8FD0\uFF0C\u5C1D\u8D77\u6765\u5C31\u50CF\u54C6\u5566A\u68A6"),
						(true));
			}
			if (entity instanceof PlayerEntity) {
				((PlayerEntity) entity).giveExperiencePoints((int) -10);
			}
		} else {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.LUCK, (int) 12000, (int) 2, (false), (true)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 10, (int) 1));
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u4F60\u771F\u8D70\u8FD0"), (true));
			}
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("\u4ED6\u771F\u8D70\u8FD0"), (true));
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).giveExperiencePoints((int) 5);
		}
	}
}
