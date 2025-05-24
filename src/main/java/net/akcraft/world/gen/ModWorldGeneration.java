package net.akcraft.world.gen;

public class ModWorldGeneration {

    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();
        ModEntitySpawns.addSpawns();
        // No shit. This actually worked out
    }
}
