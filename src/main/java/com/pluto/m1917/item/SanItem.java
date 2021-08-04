
package com.pluto.m1917.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

import com.pluto.m1917.procedures.JieProcedure;
import com.pluto.m1917.itemgroup.M1917ItemGroup;
import com.pluto.m1917.M1917gunModElements;

@M1917gunModElements.ModElement.Tag
public class SanItem extends M1917gunModElements.ModElement {
	@ObjectHolder("m1917gun:san")
	public static final Item block = null;
	public SanItem(M1917gunModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(M1917ItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC)
					.food((new Food.Builder()).hunger(4).saturation(0f).setAlwaysEdible().build()));
			setRegistryName("san");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 1;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.DRINK;
		}

		@Override
		public net.minecraft.util.SoundEvent getEatSound() {
			return net.minecraft.util.SoundEvents.ENTITY_GENERIC_DRINK;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("\u77AC\u95F4\u9A71\u6563buff"));
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				JieProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
