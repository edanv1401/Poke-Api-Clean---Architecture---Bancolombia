package co.com.bancolombia.jpa.config;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DBSecret {
    private String url;
    private String username;
    private String password;

}
