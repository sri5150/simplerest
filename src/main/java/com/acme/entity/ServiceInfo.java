package com.acme.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "services")
public class ServiceInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "service_id")
	@Getter @Setter private int serviceId;
	
	@OneToMany(mappedBy="serviceInfo")
    @JsonManagedReference
	@Getter @Setter private Set<EndPoint> endPoints;
	
	@Column(name = "description")
	@Getter @Setter private String description;
	
	@Column(name = "specification_name")
	@Getter @Setter private String specificationName;
	
	@Column(name = "specification_version")
	@Getter @Setter private String specificationVersion;
	
	@Column(name = "request_count")
	@Getter @Setter private int requestCount;
}