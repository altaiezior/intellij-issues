package org.example;

import io.micronaut.serde.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;

@Singleton
@SuppressWarnings("unused")
@RequiredArgsConstructor(onConstructor_ = @Inject)
class MicronautGrpcCodec {
    private final ObjectMapper mapper;

    public <T> void writeValue(@Nullable T value, OutputStream out) throws IOException {
        mapper.writeValue(out, value);
    }

    @Nullable
    public <T> T readValue(InputStream in, Class<T> clazz) throws IOException {
        return mapper.readValue(in, clazz);
    }
}
