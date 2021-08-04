
package com.pluto.m1917.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

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

import com.pluto.m1917.procedures.MilkProcedure;
import com.pluto.m1917.itemgroup.M1917ItemGroup;
import com.pluto.m1917.M1917gunModElements;

@M1917gunModElements.ModElement.Tag
public class LuckyBoogerItem extends M1917gunModElements.ModElement {
	@ObjectHolder("m1917gun:lucky_booger")
	public static final Item block = null;
	public LuckyBoogerItem(M1917gunModElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(M1917ItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(2).saturation(0.3f).setAlwaysEdible().build()));
			setRegistryName("lucky_booger");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent(
					"\u53EF\u98DF\u7528\uFF0C\u4E5F\u53EF\u4F5C\u4E3Am1917\u7F8E\u56FD\u5236\u53F2\u5BC6\u65AF\u7EF4\u68EE\u7684\u5F39\u836F"));
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
				MilkProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
