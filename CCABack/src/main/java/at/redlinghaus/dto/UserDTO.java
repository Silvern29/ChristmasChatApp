package at.redlinghaus.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String userName;
    private String password;
    private String email;

    public UserDTO(){}

    public UserDTO(String userName){
        this.userName = userName;
    }
}
