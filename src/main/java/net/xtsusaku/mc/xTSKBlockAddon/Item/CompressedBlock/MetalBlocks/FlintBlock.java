package net.xtsusaku.mc.xTSKBlockAddon.Item.CompressedBlock.MetalBlocks;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import net.xtsusaku.mc.xTSKBlockAddon.Item.CompressedBlock.AbstractCompressedBlock;
import net.xtsusaku.mc.xTSKBlockAddon.xTSKBlockAddon;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class FlintBlock extends AbstractCompressedBlock {

    public FlintBlock(ItemGroup itemGroup) {
        super(itemGroup, new ItemStack(Material.FLINT), Material.COAL_BLOCK, Material.FLINT, "X_FLINT", "&fFlint Block");
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
