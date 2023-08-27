package lk.himash.model;

import lk.himash.util.annotations.MaskData;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {

    private String id;
    private String name;
    private String age;
    private String address;
    @MaskData
    private String telNo;
    private String username;
    @MaskData
    private String password;
    private boolean status;

}
