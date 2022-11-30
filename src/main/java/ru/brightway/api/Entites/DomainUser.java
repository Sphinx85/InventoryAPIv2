package ru.brightway.api.Entites;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "domain_users")
@AllArgsConstructor
@NoArgsConstructor
public class DomainUser {
    @Column(name = "SamAccountName", length = 50)
    private String samAccountName;

    @Column(name = "FirstName", nullable = false, length = 50)
    private String firstName;

    @Column(name = "LastName", nullable = false, length = 50)
    private String lastName;

    @Column(name = "DisplayName", nullable = false, length = 100)
    private String displayName;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "mail", length = 50)
    private String mail;

    @Id
    @Column(name = "Sid", length = 50)
    private String sid;

    @Column(name = "GUID", length = 50)
    private String guid;

    @Lob
    @Column(name = "DN")
    private String dn;

    @Lob
    @Column(name = "MemberOf", nullable = false)
    private String memberOf;

    @Lob
    @Column(name = "ParentContainer")
    private String parentContainer;

    @Column(name = "telephone", nullable = false, length = 50)
    private String telephone;

    @Column(name = "AccountIsEnabled")
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

    @Column(name = "LastLogonTimestamp")
    private Instant lastLogonTimestamp;

    @Column(name = "\"domain\"", length = 20)
    private String domain;

    @Column(name = "whenCreated")
    private Instant whenCreated;

    @Column(name = "collectedtime")
    private Instant collectedtime;

    }