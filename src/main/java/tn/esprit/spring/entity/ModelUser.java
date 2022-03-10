package tn.esprit.spring.entity;

import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;


@Getter
@Setter
public class ModelUser implements Serializable {
    private String email;
    private String password;
}
