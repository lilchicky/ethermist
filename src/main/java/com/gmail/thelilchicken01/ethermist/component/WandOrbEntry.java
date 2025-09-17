package com.gmail.thelilchicken01.ethermist.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record WandOrbEntry(String orb) {

    public static final Codec<WandOrbEntry> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.STRING.fieldOf("orb").forGetter(WandOrbEntry::orb)
            ).apply(instance, WandOrbEntry::new)
    );

    public static final StreamCodec<ByteBuf, WandOrbEntry> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, WandOrbEntry::orb,
            WandOrbEntry::new
    );

}
