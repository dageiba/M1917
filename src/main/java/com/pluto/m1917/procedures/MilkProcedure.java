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

import com.pluto.m1917.M1917gunModElements;
import com.pluto.m1917.M1917gunMod;

@M1917gunModElements.ModElement.Tag
public class MilkProcedure extends M1917gunModElements.ModElement {
	public MilkProcedure(M1917gunModElements instance) {
		super(instance, 20);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				M1917gunMod.LOGGER.warn("Failed to load dependency entity for procedure Milk!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).clearActivePotions();
		if ((Math.random() >= 0.75)) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
			entity.setMotionMultiplier(null, new Vector3d(0.25D, (double) 0.05F, 0.25D));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 800, (int) 1));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HUNGER, (int) 1200, (int) 1));
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent("\u5455\uFF01\u8FD9\u662F\u54C6\u5566A\u68A6\u7684\u9F3B\u5C4E\u2026\u2026"), (false));
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).giveExperiencePoints((int) (-10));
		} else {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).giveExperiencePoints((int) 5);
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent("\u4F60\u611F\u89C9\u6D51\u8EAB\u71E5\u70ED\uFF0C\u597D\u50CF\u662F\u88AB\u4E0B\u836F\u4E86"),
						(false));
			}
			entity.setFire((int) 3);
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HASTE, (int) 600, (int) 1));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 600, (int) 1));
		}
	}
}
