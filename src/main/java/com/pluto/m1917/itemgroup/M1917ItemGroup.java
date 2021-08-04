
package com.pluto.m1917.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import com.pluto.m1917.item.TM1917GunItem;
import com.pluto.m1917.M1917gunModElements;

@M1917gunModElements.ModElement.Tag
public class M1917ItemGroup extends M1917gunModElements.ModElement {
	public M1917ItemGroup(M1917gunModElements instance) {
		super(instance, 27);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabm_1917") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(TM1917GunItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
