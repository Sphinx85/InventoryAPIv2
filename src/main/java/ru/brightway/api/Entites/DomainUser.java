package ru.brightway.api.Entites;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "domain_users")
@Data
@NoArgsConstructor
public class DomainUser {
    @Column(name = "samaccountname", length = 50)
    private String samAccountName;

    @Column(name = "firstname", nullable = false, length = 50)
    private String firstName;

    @Column(name = "lastname", nullable = false, length = 50)
    private String lastName;

    @Column(name = "displayname", nullable = false, length = 100)
    private String displayName;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "mail", length = 50)
    private String mail;

    @Id
    @Column(name = "sid", length = 50)
    private String sid;

    @Column(name = "GUID", length = 50)
    private String guid;

    @Lob
    @Column(name = "DN")
    private String dn;

    @Lob
    @Column(name = "memberof", nullable = false)
    private String memberOf;

    @Lob
    @Column(name = "parentcontainer")
    private String parentContainer;

    @Column(name = "telephone", nullable = false, length = 50)
    private String telephone;

    @Column(name = "accountisenabled")
    private Boolean accountIsEnabled;

    @Column(name = "exchange")
    private Boolean exchange;

    @Column(name = "Description", length = 200)
    private String description;

    @Lob
    @Column(name = "Manager")
    private String manager;

    @Lob
    @Column(name = "aliases")
    private String aliases;

    @Column(name = "Company", length = 100)
    private String company;

    @Column(name = "Department", length = 100)
    private String department;

    @Column(name = "Title", length = 100)
    private String title;

    @Column(name = "Lastlogontimestamp")
    private Instant lastLogonTimestamp;

    @Column(name = "\"domain\"", length = 20)
    private String domain;

    @Column(name = "whencreated")
    private Instant whenCreated;

    @Column(name = "collectedtime")
    private Instant collectedtime;



}