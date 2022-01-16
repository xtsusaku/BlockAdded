package net.xtsusaku.mc.xTSKBlockAddon.Item.CompressedBlock.MetalBlocks;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import net.xtsusaku.mc.xTSKBlockAddon.Item.CompressedBlock.AbstractCompressedBlock;
import net.xtsusaku.mc.xTSKBlockAddon.xTSKBlockAddon;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class AluminumBlock extends AbstractCompressedBlock {

    public AluminumBlock(ItemGroup itemGroup) {
        super(itemGroup, SlimefunItems.ALUMINUM_INGOT.clone(), Material.IRON_BLOCK, Material.IRON_INGOT, "X_SF_ALUMINUM", "&bAluminum Block");
    }

    public SlimefunItem registerBlock(ItemGroup itemGroup) {
        SlimefunItemStack SFItemStack = new SlimefunItemStack(idPrefix + "_BLOCK", compressedMaterial, compressedName);

        ItemStack[] recipe = {
                singleItem, singleItem, singleItem,
                singleItem, singleItem, singleItem,
                singleItem, singleItem, singleItem};

        SlimefunItem item = new SlimefunItem(itemGroup, SFItemStack, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
        item.register(xTSKBlockAddon.getInstance());

        return item;
    }

    public SlimefunItem registerReverse(ItemGroup itemGroup) {
        SlimefunItemStack SFItemStack = new SlimefunItemStack(idPrefix + "_REVERSE", uncompressedMaterial, "&fReverse " + compressedName);

        ItemStack[] recipe = {sfItem().getItem()};

        ItemStack result = singleItem.clone();
        result.setAmount(9);

        SlimefunItem item = new SlimefunItem(itemGroup, SFItemStack, RecipeType.ENHANCED_CRAFTING_TABLE, recipe, result);
        item.setHidden(true);
        item.register(xTSKBlockAddon.getInstance());

        return item;
    }

}
