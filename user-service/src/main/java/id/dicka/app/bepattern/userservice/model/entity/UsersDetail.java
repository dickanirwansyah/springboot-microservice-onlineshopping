package id.dicka.app.bepattern.userservice.model.entity;

import id.dicka.app.bepattern.commonservice.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users_detail")
public class UsersDetail extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** join with table users **/
    @Column(name = "users_id")
    private Long usersId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "rt")
    private String rt;

    @Column(name = "rw")
    private String rw;

    @Column(name = "kota")
    private String kota;

    @Column(name = "kecamatan")
    private String kecamatan;

    @Column(name = "provinsi")
    private String provinsi;

    @Lob
    @Column(name = "avatar")
    private String avatar;

    @Column(name = "deleted")
    private Integer deleted;
}
