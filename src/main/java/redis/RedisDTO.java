package redis;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RedisDTO  {

    private String id;
    private String email;
    private String role;

    @Builder
    public RedisDTO(String id, String email, String role) {
        this.id = id;
        this.email = email;
        this.role = role;
    }

    public RedisDTO() {
    }
}
