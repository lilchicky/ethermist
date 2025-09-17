package com.gmail.thelilchicken01.ethermist.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record WandHandleEntry(String handle) {

    public static final Codec<WandHandleEntry> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.STRING.fieldOf("handle").forGetter(WandHandleEntry::handle)
            ).apply(instance, WandHandleEntry::new)
    );

    public static final StreamCodec<ByteBuf, WandHandleEntry> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, WandHandleEntry::handle,
            WandHandleEntry::new
    );

}
