package ru.brightway.api.Entites;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "domain_groups")
@Data
@NoArgsConstructor
public class DomainGroup {
    @Id
    @Column(name = "Groupname", length = 256)
    private String groupName;

    @Lob
    @Column(name = "Groupdn")
    private String groupDN;

    @Column(name = "Grouptype", length = 50)
    private String groupType;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "member", length = 50)
    private String member;

    @Column(name = "member_type", length = 50)
    private String memberType;

    @Lob
    @Column(name = "member_dn")
    private String memberDn;

    @Column(name = "\"domain\"", length = 20)
    private String domain;

    @Column(name = "collectedtime")
    private Instant collectedtime;
}