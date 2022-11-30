package ru.brightway.api.Entites;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "domain_computers")
@AllArgsConstructor
@NoArgsConstructor
public class DomainComputer {
    @Id
    @Lob
    @Column(name = "DN")
    private String dn;

    @Column(name = "Name", length = 50)
    private String name;

    @Lob
    @Column(name = "Description")
    private String description;

    @Lob
    @Column(name = "MemberOf")
    private String memberOf;

    @Lob
    @Column(name = "ParentContainer")
    private String parentContainer;

    @Column(name = "LastLogonTimestamp")
    private Instant lastLogonTimestamp;

    @Column(name = "ManagedBy", length = 200)
    private String managedBy;

    @Column(name = "\"domain\"", length = 50)
    private String domain;

    @Column(name = "ip", length = 50)
    private String ip;

    @Column(name = "os", length = 50)
    private String os;

    @Column(name = "build", length = 4)
    private String build;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "collectedtime")
    private Instant collectedtime;


}