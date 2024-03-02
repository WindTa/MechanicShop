package mechanic_shop.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Result<T> {

    private ArrayList<String> messages = new ArrayList<>();
    private T payload;

    public boolean isSuccess() {
        return messages.size() == 0;
    }

    public List<String> getErrorMessages() {
        return new ArrayList<>(messages);
    }

    public void addErrorMessage(String message) {
        messages.add(message);
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result<?> result = (Result<?>) o;
        return Objects.equals(messages, result.messages) && Objects.equals(payload, result.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messages, payload);
    }
}
