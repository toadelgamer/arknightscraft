package net.akcraft.sound;

import net.akcraft.ArknightsCraft;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent OP_DEAD = registerSoundEvent("op_dead");
    public static final SoundEvent ENEMY_DEAD = registerSoundEvent("enemy_dead");

    public static final SoundEvent EUREKA_IDLE = registerSoundEvent("operator.u_official_idle");
    public static final SoundEvent EUREKA_HURT = registerSoundEvent("operator.u_official_hurt");

    public static final SoundEvent SCIENCE = registerSoundEvent("science");
    public static final RegistryKey<JukeboxSong> SCIENCE_KEY = RegistryKey.of(RegistryKeys.JUKEBOX_SONG,
            Identifier.of(ArknightsCraft.MOD_ID, "science"));

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(ArknightsCraft.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }


    public static void registerSounds(){
        ArknightsCraft.LOGGER.info("Registering sounds for " + ArknightsCraft.MOD_ID);
    }
}
