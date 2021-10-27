package id.dicka.app.bepattern.userservice.model.entity;

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
@Table(name = "menus")
public class Menu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "endpoint")
    private String endpoint;

    @Column(name = "icon")
    private String icon;

    @Column(name = "menu_level")
    private int menuLevel;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "deleted")
    private Integer deleted;

}
