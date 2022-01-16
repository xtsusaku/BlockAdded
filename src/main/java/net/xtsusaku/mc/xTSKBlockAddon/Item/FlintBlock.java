package net.xtsusaku.mc.xTSKBlockAddon.Item;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import net.xtsusaku.mc.xTSKBlockAddon.xTSKBlockAddon;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class FlintBlock {

    private static SlimefunItem sfItem;

    public FlintBlock(ItemGroup itemGroup) {
        sfItem = registerFlintBlock(itemGroup);
        registerFlint(itemGroup);
    }

    public static SlimefunItem sfItem() {
        return sfItem;
    }

    public SlimefunItem registerFlintBlock(ItemGroup itemGroup) {
        SlimefunItemStack SFItemStack = new SlimefunItemStack("X_FLINT_BLOCK", Material.COAL_BLOCK, "&fFlint Block");

        ItemStack[] recipe = {
                new ItemStack(Material.FLINT), new ItemStack(Material.FLINT), new ItemStack(Material.FLINT),
                new ItemStack(Material.FLINT), new ItemStack(Material.FLINT), new ItemStack(Material.FLINT),
                new ItemStack(Material.FLINT), new ItemStack(Material.FLINT), new ItemStack(Material.FLINT)};

        SlimefunItem item = new SlimefunItem(itemGroup, SFItemStack, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
        item.register(xTSKBlockAddon.getInstance());

        return item;
    }

    public void registerFlint(ItemGroup itemGroup) {
        SlimefunItemStack SFItemStack = new SlimefunItemStack("X_FLINT", Material.FLINT, "Reverse Flint");

        ItemStack[] recipe = {sfItem().getItem()};

        ItemStack result = new ItemStack(Material.FLINT);
        result.setAmount(9);

        SlimefunItem item = new SlimefunItem(itemGroup, SFItemStack, RecipeType.ENHANCED_CRAFTING_TABLE, recipe, result);
        item.setHidden(true);
        item.register(xTSKBlockAddon.getInstance());
    }

}
