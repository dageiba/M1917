
package com.pluto.m1917.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import java.util.List;

import com.pluto.m1917.M1917gunModElements;

@M1917gunModElements.ModElement.Tag
public class MAirItem extends M1917gunModElements.ModElement {
	@ObjectHolder("m1917gun:m_air")
	public static final Item block = null;
	public MAirItem(M1917gunModElements instance) {
		super(instance, 9);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(null).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("m_air");
		}
		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("\u8FD9\u662F\u4E00\u4E2A\u5F39\u58F3"));
		}
	}
}
//这玩意啥都不是，对己的枪其实也算是远程的弓，为了让其有弓的感觉，所以还是整了个发射物，不过这个发射物是空气（
