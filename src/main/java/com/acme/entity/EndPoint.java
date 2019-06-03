package com.acme.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "endpoints")
public class EndPoint implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "endpoint_id")
	@Getter @Setter private int endPointId;

    @ManyToOne
    @JoinColumn(name="service_id", nullable=false)
    @JsonBackReference
    @Getter @Setter private ServiceInfo serviceInfo;
    
    public EndPoint() {}
	
	@Column(name = "url")
	@Getter @Setter private String url;
	
	@Enumerated(EnumType.STRING)
    @Column(length = 8, name="verb")
	@Getter @Setter private HttpVerb verb;
	
	@Column(name = "oauth2_supported")
	@Getter @Setter private boolean isOauth2Supported;
	
	@Column(name = "oauth1a_supported")
	@Getter @Setter private boolean isOauth1aSupported;
}