package com.dev.axolotl.zoo;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by xavierbauquet on 17/04/2016.
 */

public class User {

    @Getter @Setter private String email;
    @Getter @Setter private String firstName;
    @Getter @Setter private String lastName;
    @Getter @Setter private String pass;
    @Getter @Setter private String authority;

}
