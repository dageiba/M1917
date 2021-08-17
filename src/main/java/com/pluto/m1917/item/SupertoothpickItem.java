
package com.pluto.m1917.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.util.ITooltipFlag;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

import com.pluto.m1917.procedures.WordIsVeryBigProcedure;
import com.pluto.m1917.M1917gunModElements;

@M1917gunModElements.ModElement.Tag
public class SupertoothpickItem extends M1917gunModElements.ModElement {
	@ObjectHolder("m1917gun:supertoothpick")
	public static final Item block = null;
	public SupertoothpickItem(M1917gunModElements instance) {
		super(instance, 33);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent(
						"\u53F3\u952E\u5411\u5168\u4F53\u4EBA\u5458\u64AD\u62A5\u201C\u6211\u7684\u5F88\u5927\uFF0C\u4F60\u5FCD\u4E00\u4E0B\u201D"));
				list.add(new StringTextComponent("\u00A74\u53EA\u80FD\u4F7F\u7528\u4E00\u6B21"));
				list.add(new StringTextComponent("\u00A77\u8D34\u5FC3\u7684\u793E\u6B7B\u5C0F\u52A9\u624B"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = retval.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("itemstack", itemstack);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					WordIsVeryBigProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("supertoothpick"));
	}
}
